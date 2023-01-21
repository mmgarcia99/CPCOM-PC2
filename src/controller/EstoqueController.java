package controller;

import java.util.ArrayList;
import model.bean.Estoque;
import model.bean.Produtos;
import model.dao.EstoqueDAO;

public class EstoqueController {

    public boolean create(Produtos produtos, int qtd_estoque) {
        Estoque estoque = new Estoque();
        estoque.setProdutos(produtos);
        estoque.setQtdestoque(qtd_estoque);

        EstoqueDAO estoqueDAO = new EstoqueDAO();
        return estoqueDAO.create(estoque);
    }

    public ArrayList<Estoque> read() {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        return estoqueDAO.read();
    }

    public boolean update(int idestoque, int qtd_estoque, Produtos produtos) {
        Estoque estoque = new Estoque();
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        estoque.setIdestoque(idestoque);
        estoque.setQtdestoque(qtd_estoque);
        estoque.setProdutos(produtos);

        return estoqueDAO.update(estoque);
    }

    public void delete(int idestoque) {
        Estoque estoque = new Estoque();
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        estoque.setIdestoque(idestoque);

        estoqueDAO.delete(estoque);
    }

}
