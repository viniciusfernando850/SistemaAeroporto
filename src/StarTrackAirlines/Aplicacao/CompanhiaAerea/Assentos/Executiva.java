package StarTrackAirlines.Aplicacao.CompanhiaAerea.Assentos;

public enum Executiva {
    AIRBUS_A320(14),  EMBRAER_195(12),
    ATR_72(8), AIRBUS_A350(36), BOEING_787_DREAMLINER(30),
    BOEING_777(38);

    private final int num;
    Executiva(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }
}
