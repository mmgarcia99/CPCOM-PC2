package controller;

import java.util.ArrayList;
import model.bean.Fornecedor;
import model.bean.Produtos;
import model.dao.ProdutosDAO;

public class ProdutosController {

    public boolean create(String descricao, double preco, Fornecedor fornecedor) {
        Produtos produtos = new Produtos();
        produtos.setDescricao(descricao);
        produtos.setPreco(preco);
        produtos.setFornecedor(fornecedor);

        ProdutosDAO produtosDAO = new ProdutosDAO();
        return produtosDAO.create(produtos);
    }

    public ArrayList<Produtos> read() {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        return produtosDAO.read();
    }

    public boolean update(int idprodutos, String descricao, double preco, Fornecedor fornecedor) {
        Produtos produtos = new Produtos();
        ProdutosDAO produtoDAO = new ProdutosDAO();

        produtos.setIdproduto(idprodutos);
        produtos.setDescricao(descricao);
        produtos.setPreco(preco);
        produtos.setFornecedor(fornecedor);

        return produtoDAO.update(produtos);
    }

    public boolean delete(int idprdotudos) {
        Produtos produtos = new Produtos();
        ProdutosDAO produtoDAO = new ProdutosDAO();

        produtos.setIdproduto(idprdotudos);
        return produtoDAO.delete(produtos);
    }
    
    
    public ArrayList<Produtos> getListaProdutosDescricao(int idprodutos){
        ProdutosDAO produtosDAO = new ProdutosDAO();
        return produtosDAO.getListaProdutosDescricao(idprodutos);
      }

  


    

}
