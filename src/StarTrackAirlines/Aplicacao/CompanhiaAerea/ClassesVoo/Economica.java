package StarTrackAirlines.Aplicacao.CompanhiaAerea.ClassesVoo;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

public class Economica implements CalculadoraTaxa {

    private final int assentosOcupados;

    public Economica(int ocupados){
        this.assentosOcupados = ocupados;
    }

    @Override
    public double calcularTaxa(double tarifaBase) {
        double precoFinal;
        precoFinal = tarifaBase * (1 + (0.01 * assentosOcupados));
        return precoFinal;
    }

    public void show(){
        System.out.println(calcularTaxa(1200));
    }

    //teste do calculo da taxa
    public static void main(String[] args){
        Economica test = new Economica(299);
        test.show();
    }
}