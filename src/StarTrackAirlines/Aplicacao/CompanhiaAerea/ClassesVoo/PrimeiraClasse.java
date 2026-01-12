package StarTrackAirlines.Aplicacao.CompanhiaAerea.ClassesVoo;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

public class PrimeiraClasse implements CalculadoraTaxa {

    private final int assentosOcupados;

    public PrimeiraClasse(int ocupados){
        this.assentosOcupados = ocupados;
    }

    @Override
    public double calcularTaxa(double tarifaBase) {
        double precoFinal;
        precoFinal = tarifaBase * (1 + (0.01 * assentosOcupados));
        return precoFinal;
    }

    public void show(){
        System.out.println(calcularTaxa(3000));
    }

    //teste do calculo da taxa
    public static void main(String[] args){
        PrimeiraClasse test = new PrimeiraClasse(299);
        test.show();
    }
}
