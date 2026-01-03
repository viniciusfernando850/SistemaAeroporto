package AirportSystem.Aplicacao.Aeroporto;

public class Voo {
    private CompanhiaAerea companhiaAerea;
    private final String identificador;
    private Aeronave modeloAviao;
    private String origem;
    private String destino;
    private StatusVoo status;


    public Voo( CompanhiaAerea companhiaAerea , String identificador , Aeronave modeloAviao , String origem, String destino,  StatusVoo status){

        this.companhiaAerea = companhiaAerea;
        this.identificador = identificador;
        this.modeloAviao = modeloAviao;
        this.origem = origem;
        this.destino = destino;
        this.status = status;

    }

    //get e set de companhiaAerea//
    public CompanhiaAerea getCompanhiaAerea(){
        return companhiaAerea;
}

    public void setCompanhiaAerea (CompanhiaAerea companhiaAerea){
        this.companhiaAerea = companhiaAerea;
    }

    // get e set de identificador//
    public String getIdentificador(){
        return identificador;
    }


    //get e set de modeloAviao//
    public Aeronave getModeloAviao(){
        return modeloAviao;
    }

    public void setModeloAviao (Aeronave modeloAviao){
        this.modeloAviao = modeloAviao;
    }
    // get e set de origem//
    public String getOrigem(){
        return origem;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }

    // get e set de destino//
    public String getDestino(){
        return destino;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }

    // get e set de status//
    public StatusVoo getStatus(){
        return status;
    }

    public void setStatus(StatusVoo status){
        this.status = status;
    }
}
