package StarTrackAirlines.Aplicacao.CompanhiaAerea.Assentos;

public enum PrimeiraClasse {
    AIRBUS_A320(12),  EMBRAER_195(0),
    ATR_72(0), AIRBUS_A350(6), BOEING_787_DREAMLINER(8),
    BOEING_777(12);

    private final int num;
    PrimeiraClasse(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }

}
