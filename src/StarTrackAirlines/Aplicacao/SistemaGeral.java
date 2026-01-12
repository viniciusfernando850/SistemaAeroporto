package StarTrackAirlines.Aplicacao;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.*;
import StarTrackAirlines.Controllers.VoosController.*;
import StarTrackAirlines.Controllers.VoosController.Exception.*;
import StarTrackAirlines.Controllers.LoginController.LoginController;
import StarTrackAirlines.InterfaceGrafica.*;
import StarTrackAirlines.InterfaceGrafica.Login.*;
import StarTrackAirlines.InterfaceGrafica.SecaoCheckin.*;
import StarTrackAirlines.InterfaceGrafica.SecaoOperacional.*;
import StarTrackAirlines.InterfaceGrafica.SecaoVendas.*;
import StarTrackAirlines.Aplicacao.Login.Autenticacao;
import StarTrackAirlines.Aplicacao.ManipulacaoArquivos.VoosRepository;

import java.io.IOException;
import java.util.*;

public class SistemaGeral {
    private static final VoosRepository voosRepository = new VoosRepository();

    public static Set<Aeronave> configurarFrota() {
        Aeronave aeronave01 = new Aeronave("Airbus A320");
        Aeronave aeronave02 = new Aeronave("Airbus A350");
        Aeronave aeronave03 = new Aeronave("ATR 72");
        Aeronave aeronave04 = new Aeronave("Boeing 787 Dreamliner");
        Aeronave aeronave05 = new Aeronave("Boeing 777");

        Set<Aeronave> frota = new HashSet<>();
        frota.add(aeronave01);
        frota.add(aeronave02);
        frota.add(aeronave03);
        frota.add(aeronave04);
        frota.add(aeronave05);

        return frota;
    }

    public static Map<String, Voo> configurarListagemVoos(Set<Aeronave> frota) throws IOException {
        return voosRepository.carregarDados(frota);
    }

    public static void configurarInterfaceGrafica() {
        MainWindow window = new MainWindow();

        Autenticacao autenticacao = new Autenticacao();

        LoginView loginView = new LoginView();
        SecaoOperacional secaoOperacional = new SecaoOperacional();
        SecaoVendas secaoVendas = new SecaoVendas();
        SecaoCheckin secaoCheckin = new SecaoCheckin();

        LoginController loginController = new LoginController(window, loginView, autenticacao);

        window.adicionarTela(loginView, "login");
        window.adicionarTela(secaoOperacional, "operacional");
        window.adicionarTela(secaoVendas, "vendas");
        window.adicionarTela(secaoCheckin, "checkin");

        window.abrirLogin("login");
    }

    public static void main(String[] args) {
        Set<Aeronave> frota = configurarFrota();

        try {
            Map<String, Voo> listagemVoos = configurarListagemVoos(frota);
            CompanhiaAerea companhiaAerea = new CompanhiaAerea("Star Track Airlines", frota, listagemVoos);
            voosRepository.salvarDados(companhiaAerea);

            configurarInterfaceGrafica();

            /*teste controle
            cadastrar -> SUCESSO T1,SUCESSO T2
            modificar -> SUCESSO T1, T2
            deletar -> SUCESSO T1,
            C exception ->
            M exception ->
            D exception ->
            */
            VooController controle = new VooController(companhiaAerea);
            /*try{
                controle.cadastrarVoo();
            }catch(DadosInvalidosException | AeronaveIndisponivelException e){
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }*/

            for(Voo v : listagemVoos.values()){
                v.showVoo();
            }
        } catch (IOException e) {
            e.getMessage();
        }


    }
}

