package AirportSystem.Aplicacao.Aeroporto;

import AirportSystem.Aplicacao.VendaPassagens.CalculadoraTaxa;

public class VooDomestico extends Voo implements CalculadoraTaxa {
    public VooDomestico(CompanhiaAerea companhiaAerea, String identificador, Aeronave modeloAviao,
                        String origem, String destino, StatusVoo status){
        super(companhiaAerea, identificador, modeloAviao, origem, destino, status);
    }

    private static final double TAXA_DOMESTICO = 0.20F;

    @Override
    public double calcularTaxa(double tarifaBase) {
        double taxaFinal;
        taxaFinal = tarifaBase * TAXA_DOMESTICO;
        return taxaFinal;
    }
}
