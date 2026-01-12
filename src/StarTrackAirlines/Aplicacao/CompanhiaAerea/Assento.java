package StarTrackAirlines.Aplicacao.CompanhiaAerea;

public class Assento {
    private String codigoAssento;
    private int numeroAssento;
    private boolean ocupado;
    //private ClasseVoo classeAssento;

    public Assento(int numeroAssento, boolean ocupado) {
        this.numeroAssento = numeroAssento;
        this.ocupado = ocupado;
        this.codigoAssento = this.numeroAssento + "A";
    }

    public int getNumeroAssento() {return this.numeroAssento;}
    public void setNumeroAssento(int numeroAssento) {this.numeroAssento = numeroAssento;}

    public boolean getOcupado() {return this.ocupado;}
    public void setOcupado(boolean ocupado) {this.ocupado = ocupado;}

    public String getCodigoAssento() {return this.codigoAssento;}
    public void setCodigoAssento(String codigoAssento) {this.codigoAssento = codigoAssento;}

}