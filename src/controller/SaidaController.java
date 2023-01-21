package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Produtos;
import model.bean.Saida;
import model.dao.SaidaDAO;

public class SaidaController {
  public boolean create(Produtos produtos,Cliente cliente, int parseInt ) {
        Saida saida = new Saida();
        saida.setProdutos(produtos);
        saida.setQtdsaida(parseInt);
        saida.setCliente(cliente);

        SaidaDAO  saidaDAO = new SaidaDAO();
        return saidaDAO.create(saida);
    }

    public ArrayList<Saida> read() {
        SaidaDAO saidaDAO = new SaidaDAO();
        return saidaDAO.read();
    }

    public boolean update(int idsaida, int qtdsaida, Produtos produtos, Cliente cliente) {
        Saida saida = new Saida();
        SaidaDAO saidaDAO = new SaidaDAO();

        saida.setIdsaida(idsaida);
        saida.setQtdsaida(qtdsaida);
        saida.setProdutos(produtos);
        saida.setCliente(cliente);

        return saidaDAO.update(saida);
    }

    public boolean delete(int idsaida) {
        Saida saida = new Saida();
        SaidaDAO saidaDAO = new SaidaDAO();

        saida.setIdsaida(idsaida);

       return saidaDAO.delete(saida);
    }

    
}
