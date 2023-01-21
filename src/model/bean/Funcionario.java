package model.bean;

import java.util.Date;

public class Funcionario {

    private int idfuncionario;
    private String nome;
    private Date dataNasci;
    private String cargo;
    private String Endereco;
    private String email;
    private String login;
    private String senha;

    public Funcionario() {
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEndereço() {
        return Endereco;
    }

    public void setEndereço(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
