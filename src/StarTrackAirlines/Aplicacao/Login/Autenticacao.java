package StarTrackAirlines.Aplicacao.Login;

import StarTrackAirlines.Aplicacao.Login.Exceptions.DadosInvalidosException;
import StarTrackAirlines.Aplicacao.ManipulacaoArquivos.FuncionariosRepository;

import java.io.IOException;
import java.util.Arrays;

public class Autenticacao {
    private final FuncionariosRepository repository;

    public Autenticacao() {
        this.repository = new FuncionariosRepository();
    }

    public Funcionario validarLogin(String usuario, char[] senha) throws DadosInvalidosException, IOException {

        if (usuario.isEmpty() || senha.length == 0) {
            throw new DadosInvalidosException("Usuário e/ou senha inválidos!");
        } else {
            Funcionario funcionario = repository.carregarDados(usuario);

            if (funcionario == null || !Arrays.equals(funcionario.getSenha(), senha))
                throw new DadosInvalidosException("Usuário e/ou senha inválidos!");

            return funcionario;
        }
    }
}
