package AirportSystem.Aplicacao.SistemaGeral;

import AirportSystem.Aplicacao.Login.Autenticacao;
import AirportSystem.InterfaceGrafica.Login.LoginController;
import AirportSystem.InterfaceGrafica.Login.LoginView;
import AirportSystem.InterfaceGrafica.MainWindow;
import AirportSystem.InterfaceGrafica.SecaoOperacional;
import AirportSystem.InterfaceGrafica.SecaoVendas;

public class SistemaGeral {

    // Criar companhias
    // Criar Aeroporto

    public static void configurarInterfaceGrafica() {
        MainWindow window = new MainWindow();

        Autenticacao autenticacao = new Autenticacao();
        LoginController loginController = new LoginController(window, autenticacao);

        LoginView loginView = new LoginView(loginController);
        SecaoOperacional secaoOperacional = new SecaoOperacional();
        SecaoVendas secaoVendas = new SecaoVendas();


        window.adicionarTela(loginView, "login");
        window.adicionarTela(secaoOperacional, "operacional");
        window.adicionarTela(secaoVendas, "vendas");

        window.showLogin("login");
    }

    public static void main(String[] args) {
        configurarInterfaceGrafica();

    }
}

