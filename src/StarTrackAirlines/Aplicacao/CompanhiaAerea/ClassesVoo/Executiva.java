package StarTrackAirlines.Aplicacao.CompanhiaAerea.ClassesVoo;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

public class Executiva implements CalculadoraTaxa {

    //esse número tem que ser acessado do total das aeronaves
    private final int assentosOcupados;

    public Executiva(int ocupados){
        this.assentosOcupados = ocupados;
    }

    @Override
    public double calcularTaxa(double tarifaBase) {
        double precoFinal;
        precoFinal = tarifaBase * (1 + (0.01 * assentosOcupados));
        return precoFinal;
    }

    public void showPreco(){
        System.out.println(calcularTaxa(2000));
    }

    //teste do calculo da taxa
    public static void main(String[] args){
        Executiva test = new Executiva(299);
        test.showPreco();
    }
}