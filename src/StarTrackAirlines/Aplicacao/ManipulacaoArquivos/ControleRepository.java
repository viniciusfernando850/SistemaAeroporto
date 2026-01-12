package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ControleRepository implements Loader<ArrayList<String[]>> {
    private final Path caminho = Paths.get("/BaseArquivos/destinos.csv");

    public ArrayList<String[]> carregarDados() throws IOException {
        ArrayList<String[]> listagemLocais = new ArrayList<>();

        List<String> linhas = Files.readAllLines(caminho);

        for (String linha : linhas) {
            String[] dados = linha.split(";");


            listagemLocais.add(dados);

        }
        return listagemLocais;
    }


    // só dados :) noss n funcionou maravilha. Acho que foi...
    //chato viu
}
