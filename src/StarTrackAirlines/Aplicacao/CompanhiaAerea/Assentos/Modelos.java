package StarTrackAirlines.Aplicacao.CompanhiaAerea.Assentos;

public enum Modelos {
    AIRBUS_A320("Airbus A320"), EMBRAER_195("Embraer 195"), ATR_72("ATR 72"),
    AIRBUS_A350("Airbus A350"), BOEING_787_DREAMLINER("Boeing 787 Dreamliner"),
    BOEING_777("Boeing 777");

    private final String nome;
    Modelos(String modelo){
        nome = modelo;
    }


    public String getNome(){
        return nome;
    }
}
