package AirportSystem.InterfaceGrafica.Login;

import AirportSystem.Aplicacao.Login.Autenticacao;
import AirportSystem.InterfaceGrafica.MainWindow;

public class LoginController {
    private final MainWindow window;
    private final Autenticacao autenticacao;

    public LoginController(MainWindow window, Autenticacao autenticacao) {
        this.window = window;
        this.autenticacao = autenticacao;
    }

    public void realizarLogin(String usuario, char[] senha) {
        boolean aprovado = autenticacao.validarLogin(usuario, senha);

        if (aprovado)
            window.showVendas("vendas");
        else
            System.out.println("ERRO");
    }

}
