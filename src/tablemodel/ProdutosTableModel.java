package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Produtos;

public class ProdutosTableModel extends AbstractTableModel{

    private List<Produtos> listaProdutos;
    private String[] colunas = {"Descrição", "Valor", "Fornecedor" };

    public ProdutosTableModel() {
        listaProdutos = new ArrayList<>();
    }

    public ProdutosTableModel(List<Produtos> produtos) {
        this();
        this.listaProdutos.addAll(produtos);
    }
    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public Object getValueAt(int linha, int coluna) {
        Produtos produtos = listaProdutos.get(linha);
        switch (coluna) {
            case 0:
                return produtos.getDescricao();
            case 1:
                return produtos.getPreco();
            case 2:
                return produtos.getFornecedor();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Produtos getProdutos(int linha) {
        if (linha >= listaProdutos.size()) {
            return null;
        }
        return listaProdutos.get(linha);
    }

}
