package StarTrackAirlines.Aplicacao.Login;

public class Funcionario {
    private String usuario;
    private char[] senha;
    private Perfil perfil;

    public Funcionario(String usuario, char[] senha, Perfil perfil) {
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public char[] getSenha() {return senha;}
    public void setSenha(char[] senha) {this.senha = senha;}

    public Perfil getPerfil() {return perfil;}
    public void setPerfil(Perfil perfil) {this.perfil = perfil;}
}
