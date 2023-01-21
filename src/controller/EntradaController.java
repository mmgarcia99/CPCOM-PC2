package controller;

import java.util.ArrayList;
import model.bean.Entrada;
import model.bean.Produtos;
import model.dao.EntradaDAO;

public class EntradaController {

    public boolean create(Produtos produtos, int qtdentrada) {
        Entrada entrada = new Entrada();
        entrada.setProdutos(produtos);
        entrada.setQtdentrada(qtdentrada);
        

        EntradaDAO entradaDAO = new EntradaDAO();
        return entradaDAO.create(entrada);
    }

    public ArrayList<Entrada> read() {
        EntradaDAO entradaDAO = new EntradaDAO();
        return entradaDAO.read();
    }

    public boolean update(int identrada, int qtdentrada, Produtos produtos) {
        Entrada entrada = new Entrada();
        EntradaDAO entradaDAO = new EntradaDAO();

        entrada.setIdentrada(identrada);
        entrada.setQtdentrada(qtdentrada);
        entrada.setProdutos(produtos);
       

        return entradaDAO.update(entrada);
    }

    public boolean delete(int identrada) {
        Entrada entrada = new Entrada();
        EntradaDAO entradaDAO = new EntradaDAO();

        entrada.setIdentrada(identrada);
        return entradaDAO.delete(entrada);
        
    }

}
