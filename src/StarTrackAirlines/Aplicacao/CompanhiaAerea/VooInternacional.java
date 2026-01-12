package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class VooInternacional extends Voo implements CalculadoraTaxa {
    public VooInternacional(String identificador, Aeronave aeronave, Map<String, Assento> assentosVoo, String origem,
                            String destino, LocalDate data, LocalTime horarioSaida, LocalTime horarioChegada) {
        super(identificador, aeronave, assentosVoo, origem, destino, data, horarioSaida, horarioChegada);
    }

    private static final double TAXA_INTERNACIONAL = 0.30F;

    @Override
    public double calcularTaxa(double tarifaBase) {
        double taxaFinal;
        taxaFinal = tarifaBase * TAXA_INTERNACIONAL;
        return taxaFinal;
    }
}
