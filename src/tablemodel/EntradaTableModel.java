package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Entrada;

public class EntradaTableModel extends AbstractTableModel {

    private List<Entrada> listaEntrada;
    private String[] colunas = {"Produto", "Quantidade"};

    public EntradaTableModel() {
        listaEntrada = new ArrayList<>();
    }

    public EntradaTableModel(List<Entrada> entrada) {
        this();
        this.listaEntrada.addAll(entrada);
    }

    @Override
    public int getRowCount() {
        return listaEntrada.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Entrada entrada = listaEntrada.get(linha);
        switch (coluna) {
            case 0:
                return entrada.getProdutos();
            case 1:
                return entrada.getQtdentrada();

            case 2:

                return "";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Entrada getEntrada(int linha) {
        if (linha >= listaEntrada.size()) {
            return null;
        }
        return listaEntrada.get(linha);
    }

}
