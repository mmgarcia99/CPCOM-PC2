package controller;

import java.util.ArrayList;
import model.bean.Fornecedor;
import model.dao.FornecedorDAO;

public class FornecedorController {

      public boolean create(String nome, String telefone, String endereco, String cnpj, String email) {
          Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(nome);
        fornecedor.setTelefone(telefone);
        fornecedor.setEndereco(endereco);
        fornecedor.setCnpj(cnpj);
        fornecedor.setEmail(email);

          FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.create(fornecedor);
    }

    public ArrayList<Fornecedor> read() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.read();
    }

    public boolean update(int idfornecedor, String nome, String telefone, String endereco, String cnpj, String email) {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        fornecedor.setIdfornecedor(idfornecedor);
        fornecedor.setNome(nome);
        fornecedor.setTelefone(telefone);
        fornecedor.setEndereco(endereco);
        fornecedor.setCnpj(cnpj);
        fornecedor.setEmail(email);
        return fornecedorDAO.update(fornecedor);

    }

    public boolean delete(int idfornecedor) {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedor.setIdfornecedor(idfornecedor);
        fornecedorDAO.delete(fornecedor);
          return false;
    }
    
    public ArrayList<Fornecedor> getListaFornecedorNome(String nome){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.getListaFornecedorNome(nome);
      }
}
