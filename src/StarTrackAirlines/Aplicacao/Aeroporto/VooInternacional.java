package AirportSystem.Aplicacao.Aeroporto;

import AirportSystem.Aplicacao.VendaPassagens.CalculadoraTaxa;

public class VooInternacional extends Voo implements CalculadoraTaxa {
    public VooInternacional(CompanhiaAerea companhiaAerea, String identificador, Aeronave modeloAviao,
                            String origem, String destino, StatusVoo status) {
        super(companhiaAerea, identificador, modeloAviao, origem, destino, status);
    }

    private static final double TAXA_INTERNACIONAL = 0.30F;

    @Override
    public double calcularTaxa(double tarifaBase) {
        double taxaFinal;
        taxaFinal = tarifaBase * TAXA_INTERNACIONAL;
        return taxaFinal;
    }
}
