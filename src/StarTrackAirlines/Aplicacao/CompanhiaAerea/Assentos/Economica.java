package StarTrackAirlines.Aplicacao.CompanhiaAerea.Assentos;

public enum Economica {
    AIRBUS_A320(180),  EMBRAER_195(136),
    ATR_72(72), AIRBUS_A350(281), BOEING_787_DREAMLINER(213),
    BOEING_777(314);

    private final int num;
    Economica(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }
}
