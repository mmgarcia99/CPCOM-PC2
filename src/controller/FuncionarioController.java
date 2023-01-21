package controller;

import java.util.ArrayList;
import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

public class FuncionarioController {

    public boolean create(String nome, String cargo, String endereco, String email) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        
        funcionario.setCargo(cargo);
        funcionario.setEndereço(endereco);
        funcionario.setEmail(email);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.create(funcionario);
    }

    public ArrayList<Funcionario> read() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.read();
    }

    public boolean update(int idfuncionario, String nome, String cargo, String endereco, String email) {
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario.setIdfuncionario(idfuncionario);
        funcionario.setNome(nome);      
        funcionario.setCargo(cargo);
        funcionario.setEndereço(endereco);
        funcionario.setEmail(email);

        return funcionarioDAO.update(funcionario);

    }

    public boolean delete(int idfuncionario) {
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario.setIdfuncionario(idfuncionario);
        funcionarioDAO.delete(funcionario);
        return false;
    }

public ArrayList<Funcionario> getListaFuncionarioNome(String nome){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.getListaFuncionarioNome(nome);
      }
   
}
