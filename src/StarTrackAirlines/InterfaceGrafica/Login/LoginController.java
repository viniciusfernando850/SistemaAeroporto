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

    public void realizarLogin(String usuario, char[] senha, String tela) {
        boolean aprovado = autenticacao.validarLogin(usuario, senha);

        if (aprovado)
            if (tela.equals("vendas"))
                window.showVendas(tela);
            else if (tela.equals("operacional"))
                window.showOperacional(tela);
        else
            System.out.println("ERRO");
    }

}
