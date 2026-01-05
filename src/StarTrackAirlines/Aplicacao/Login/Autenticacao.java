package AirportSystem.Aplicacao.Login;

import AirportSystem.ManipulacaoArquivos.FuncionariosRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Autenticacao {
    private final FuncionariosRepository repository;

    public Autenticacao() {
        this.repository = new FuncionariosRepository();
    }

    public boolean validarLogin(String usuario, char[] senha) {
        Path caminho = Paths.get("BaseArquivos/funcionarios.csv");
        boolean aprovado = false;

        try {
            List<String> linhas = repository.carregar(caminho);
            String password = new String(senha);

            for (String linha : linhas) {
                String[] dados = linha.split(";");

                if (dados[2].equals(usuario) && dados[3].equals(password)) {
                    aprovado = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return aprovado;
    }

}
