package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Estoque;

public class EstoqueTableModel extends AbstractTableModel {

    private List<Estoque> listaEstoque;
    private String[] colunas = {"Produto", "Quantidade"};

    public EstoqueTableModel() {
        listaEstoque = new ArrayList<>();
    }

    public EstoqueTableModel(List<Estoque> estoque) {
        this();
        this.listaEstoque.addAll(estoque);
    }

    @Override
    public int getRowCount() {
        return listaEstoque.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Estoque estoque = listaEstoque.get(linha);
        switch (coluna) {
            case 0:
                return estoque.getProdutos();
            case 1:
                return estoque.getQtdestoque();

            case 2:
                return "";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Estoque getEstoque(int linha) {
        if (linha >= listaEstoque.size()) {
            return null;
        }
        return listaEstoque.get(linha);
    }

}
