package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Saida;

public class SaidaTableModel extends AbstractTableModel {

    private List<Saida> listaSaida;
    private String[] colunas = {"Produto", "Quantidade", "Cliente"};

    public SaidaTableModel() {
        listaSaida = new ArrayList<>();
    }

    public SaidaTableModel(List<Saida> saida) {
        this();
        this.listaSaida.addAll(saida);
    }

    @Override
    public int getRowCount() {
        return listaSaida.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Saida saida = listaSaida.get(linha);
        switch (coluna) {
            case 0:
                return saida.getProdutos();
            case 1:
                return saida.getQtdsaida();
            case 2:
                return saida.getCliente();
            case 3:

                return "";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Saida getSaida(int linha) {
        if (linha >= listaSaida.size()) {
            return null;
        }
        return listaSaida.get(linha);
    }

}
