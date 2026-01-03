package AirportSystem.Aplicacao.Aeroporto;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private static final String NOME = "StarTrack Airport";
    private ArrayList<CompanhiaAerea> companhiaAereas;
    private List<Voo> todosOsVoos;

    public Aeroporto() {
        this.companhiaAereas = new ArrayList<>();
        this.todosOsVoos = new ArrayList<>();
    }

    public List<CompanhiaAerea> getCompanhias(){
        return companhiaAereas;
    }

    public List<Voo> getTodosOsVoos(){
        return todosOsVoos;
    }

    public static String getNome(){
        return NOME;
    }

    public void adicionarCompanhia(CompanhiaAerea cia){
        this.companhiaAereas.add(cia);
    }

    //public void cadastrarVoo(Voo novoVoo){
    //    this.todosOsVoos.add(novoVoo);
    //}

    //public void removerVoo(String identificador){
    //todosOsVoos.removeIf(voo -> voo.getIdentificador().equals(identificador));
    //}
}
