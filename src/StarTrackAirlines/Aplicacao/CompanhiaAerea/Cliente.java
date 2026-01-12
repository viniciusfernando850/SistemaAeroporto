package StarTrackAirlines.Aplicacao.CompanhiaAerea;

public class Cliente {
    private String nome;
    private int idade;
    private String rg;
    private String passaporte;
    private boolean bagagens;
    /*
    IDEIA:
        Criar um atributo de tipo Lista em cliente para guardar o identificador de todas as passagens associadas à ele;
        Ao invés de colocar o metodo de mostrar as reservas realizadas em PassagemAerea, manter esse metodo em CLiente;
        Usando a lista, poderiamos chamar todas as passagens associadas com algo similar à:

        public void mostrarVoos(ArrayList<Voo> voos){
        for(Voo v : voos){
            System.out.println(v.getOrigem() + " ---> " + v.getDestino() + " Saída:" + v.getHorarioPartida() + " // Chegada:" + v.getHorarioChegada() + ".\nID: " + v.getIdentificador() + " Av:" + v.getModeloAviao());
        }
     */

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRg() {
        return rg;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public boolean getBagagens() {
        return bagagens;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void setBagagens(boolean bagagens) {
        this.bagagens = bagagens;
    }
}
