package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import StarTrackAirlines.Aplicacao.Login.Funcionario;
import StarTrackAirlines.Aplicacao.Login.Perfil;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FuncionariosRepository implements LoaderComOrigem<Funcionario, String> {
    private final Path caminho = Paths.get("BaseArquivos/funcionarios.csv");

    public Funcionario carregarDados(String usuario) throws IOException {
        List<String> linhas = Files.readAllLines(caminho);

        for (String linha : linhas) {
            String[] dados = linha.split(";");

            if (dados[2].equals(usuario)) {
                Perfil perfil = Perfil.valueOf(dados[1]);
                return new Funcionario(dados[2], dados[3].toCharArray(), perfil);
            }
        }

        return null;
    }
}
