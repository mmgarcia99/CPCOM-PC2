package model.bean;

public class Cadastro {

    private int idcadastro;
    private String usuario;
    private String senha;

    public Cadastro() {
    }

    public int getIdcadastro() {
        return idcadastro;
    }

    public void setIdcadastro(int idcadastro) {
        this.idcadastro = idcadastro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
