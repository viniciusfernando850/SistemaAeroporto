package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.VendasController.CalculadoraTaxa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class VooDomestico extends Voo implements CalculadoraTaxa {
    public VooDomestico(String identificador, Aeronave aeronave, Map<String, Assento> assentosVoo, String origem,
                        String destino, LocalDate data, LocalTime horarioSaida, LocalTime horarioChegada) {
        super(identificador, aeronave, assentosVoo, origem, destino, data, horarioSaida, horarioChegada);
    }

    private static final double TAXA_DOMESTICO = 0.20F;

    @Override
    public double calcularTaxa(double tarifaBase) {
        double taxaFinal;
        taxaFinal = tarifaBase * TAXA_DOMESTICO;
        return taxaFinal;
    }
    }
