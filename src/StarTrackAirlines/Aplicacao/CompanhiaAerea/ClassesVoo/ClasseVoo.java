package StarTrackAirlines.Aplicacao.CompanhiaAerea.ClassesVoo;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

import java.util.Objects;

public class ClasseVoo implements CalculadoraTaxa {
    public String categoria;

    private final int assentosOcupados;

    public ClasseVoo(int ocupados, String categoria){
        this.assentosOcupados = ocupados;
        this.categoria = categoria;
    }

    @Override
    public double calcularTaxa(double tarifaBase) {
        double precoFinal;
        if(Objects.equals(this.categoria, "economica")) {
            precoFinal = tarifaBase * (1 + (0.01 * assentosOcupados));
        }else if(Objects.equals(this.categoria, "executiva")) {
            precoFinal = (tarifaBase + 500) * (1 + (0.0125 * assentosOcupados));
        }else{
            precoFinal = (tarifaBase + 1000) * (1 + (0.015 * assentosOcupados));
        }
        return precoFinal;
    }

    void showPreco(){
        System.out.println(calcularTaxa(2000));
    }

    //teste do calculo da taxa
    void main(String[] args){
        Executiva test = new Executiva(299);
        test.showPreco();
    }





}
