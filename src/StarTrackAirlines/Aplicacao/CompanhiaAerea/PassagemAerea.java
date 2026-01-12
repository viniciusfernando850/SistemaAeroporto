package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.VendasController.Exception.VoosNaoEncontradosException;

import java.util.ArrayList;

public class PassagemAerea {
    private Cliente cliente;
    private Voo voo;
    private String reserva;
    private double valorFixo;
    private Assento assento;
    private String categoria;

    private static final double DESCONTO_INFANTIL = 0.5;
    private static final double TAXA_BAGAGEM = 200;

    // Pesquisar voos - 1º Fase
    public void mostrarVoos(ArrayList<Voo> voos){
        for(Voo v : voos){
            System.out.println(v.getOrigem() + " ---> " + v.getDestino() + " Saída:" + v.getHorarioPartida() + " // Chegada:" + v.getHorarioChegada() + ".\nID: " + v.getIdentificador() + " Av:" + v.getAeronave());
        }
    }

    public ArrayList<Voo> pesquisarVoos(CompanhiaAerea companhia, String destinoFiltrado) throws VoosNaoEncontradosException {
        ArrayList<Voo> voosEncontrados = new ArrayList<>();
        for(Voo v : companhia.getVoosDisponiveis()){
            if(v.getDestino().equalsIgnoreCase(destinoFiltrado)){
                //Não há no if um filtro para voos lotados pq não há identificador de lotação no projeto.
                voosEncontrados.add(v);
            }
        }

        //System.out.println("Nenhum voo encontrado para " + destinoFiltrado + ".");
        if(voosEncontrados.isEmpty())
            throw new VoosNaoEncontradosException("Nenhum voo encontrado para " + destinoFiltrado + ".");

        return voosEncontrados;
    }

    // Realizar venda - 2º Fase
        // Obs: laço para adicionar passagens
        // Obs: Tentar modularizar com um metodo para receber dados

    // Metodo ajuste de preço - 3º Fase
    public double valorFinal(){
    //CategoriaClasse tipo = new CategoriaClasse(120, this.categoria);
        return 0;
    }

    // Metodo para mostrar as reservas realizadas - 4º Fase

    //-------> OLHAR IDEIA NA CLASSE "Cliente" <-------


    public static double getDescontoInfantil() {
        return DESCONTO_INFANTIL;
    }

    public static double getTaxaBagagem() {
        return TAXA_BAGAGEM;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public String getReserva() {
        return reserva;
    }

    public double getValorFixo() {
        return valorFixo;
    }

    public Assento  getAssento() {
        return assento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
