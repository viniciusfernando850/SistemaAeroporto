package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.Aeronave;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.Assento;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.CompanhiaAerea;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.Voo;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.BufferedWriter;

public class VoosRepository implements LoaderComOrigem<Map<String, Voo>, Set<Aeronave>>, Writer<CompanhiaAerea> {
    private final Path caminhoVoo = Paths.get("BaseArquivos/voos.csv");

    @Override
    public Map<String, Voo> carregarDados(Set<Aeronave> frota) throws IOException {
        Map<String, Voo> listagemVoos = new LinkedHashMap<>();

        List<String> linhas = Files.readAllLines(caminhoVoo);

        for (String linha : linhas) {
            if (linha == null || linha.trim().isEmpty())
                continue;

            String[] dados = linha.replace("\uFEFF", "").split(";");
            for (int i = 0; i < dados.length; i++)
                dados[i] = dados[i].trim();

            Voo voo = getVoo(frota, dados);

            if (voo.verificarDisponibilidadeData())
                listagemVoos.put(voo.getIdentificador(), voo);
            else
                deletarArquivoVoo(voo.getIdentificador());
        }

        return listagemVoos;
    }

    private Aeronave encontrarAeronave(Set<Aeronave> frota, String modeloAeronave) {
        Aeronave aeronaveVoo = null;

        for (Aeronave aeronave : frota) {
            if (modeloAeronave.equalsIgnoreCase(aeronave.getModelo())) {
                aeronaveVoo = aeronave;
                break;
            }
        }

        if (aeronaveVoo == null)
            throw new IllegalArgumentException("Sem aeronave!");

        return aeronaveVoo;
    }

    private DateTimeFormatter formatterData() {return DateTimeFormatter.ofPattern("dd/MM/yyyy");}

    public Voo getVoo(Set<Aeronave> frota, String[] dados) throws IOException {
        String identificador = dados[0];

        Aeronave aeronaveVoo = encontrarAeronave(frota, dados[1]);

        String origem = dados[2];
        String destino = dados[3];

        LocalDate data = LocalDate.parse(dados[4], formatterData());

        LocalTime partida = LocalTime.parse(dados[5]);
        LocalTime chegada = LocalTime.parse(dados[6]);

        Map<String, Assento> assentosVoo = configurarAssentos(identificador, aeronaveVoo);

        return new Voo(identificador, aeronaveVoo, assentosVoo, origem, destino, data, partida, chegada);
    }

    public Map<String, Assento> configurarAssentos(String identificador, Aeronave aeronaveVoo) throws IOException {
        Map<String, Assento> assentos = aeronaveVoo.gerarAssentos();
        Path caminhoLotacao = Paths.get("BaseArquivos", "LotacaoVoos", identificador + ".csv");

        try {
            List<String> assentosOcupados = Files.readAllLines(caminhoLotacao);

            for (String assentoOcupado : assentosOcupados) {
                if (assentoOcupado == null || assentoOcupado.trim().isEmpty())
                    continue;

                assentoOcupado = assentoOcupado.replace("\uFEFF", "").trim();

                if (assentos.containsKey(assentoOcupado))
                    assentos.get(assentoOcupado).setOcupado(true);
            }
        } catch (NoSuchFileException e) {
            try {
                Files.createDirectories(caminhoLotacao.getParent());
                Files.createFile(caminhoLotacao);
            } catch (IOException ex) {
                System.out.println("Ocorreu algum erro!");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro!");
        }

        return assentos;
    }

    public ArrayList<String[]> acessarDados() throws IOException {
        ArrayList<String[]> listagemDados = new ArrayList<>();

        List<String> linhas = Files.readAllLines(caminhoVoo);

        for (String linha : linhas) {
            String[] dados = linha.split(";");


            listagemDados.add(dados);

        }
        return listagemDados;
    }

    private ArrayList<String> salvarDadosEmLinha(CompanhiaAerea companhiaAerea) {
        ArrayList<String> linhas = new ArrayList<>();

        for (Voo voo : companhiaAerea.getListagemVoos().values()) {
            ArrayList<String> linha = new ArrayList<>();

            linha.add(voo.getIdentificador());
            linha.add(voo.getAeronave().getModelo());
            linha.add(voo.getOrigem());
            linha.add(voo.getDestino());
            linha.add(voo.getDataPartida().format(formatterData()));
            linha.add(voo.getHorarioPartida().toString());
            linha.add(voo.getHorarioChegada().toString());

            linhas.add(String.join(";", linha));
        }

        return linhas;
    }

    @Override
    public void salvarDados(CompanhiaAerea companhiaAerea) throws IOException {
        ArrayList<String> linhas = salvarDadosEmLinha(companhiaAerea);

        try (BufferedWriter bw = Files.newBufferedWriter(
                Path.of("BaseArquivos", "voos.csv"),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        }
    }

    private void deletarArquivoVoo(String identificador) throws IOException {
        Files.delete(Path.of("BaseArquivos", "LotacaoVoos", identificador + ".csv"));
    }

    public void main (String[] args) {
        Aeronave aeronave01 = new Aeronave("Airbus A320");

        HashSet<Aeronave> frota = new HashSet<>();
        frota.add(aeronave01);

        //HashMap<String, Voo> listagemVoos = null;

        try {
            Map<String, Voo> listagemVoos = carregarDados(frota);

            for (Voo voo : listagemVoos.values()) {
                System.out.println(voo.getOrigem());
            }

        } catch (IOException e) {
            e.getMessage();
        }

        /*for (Voo voo : listagemVoos.values()) {
            voo.showVoo();
        }*/
    }
}