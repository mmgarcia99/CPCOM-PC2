package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Fornecedor;

public class FornecedorTableModel extends AbstractTableModel{

     
     private List<Fornecedor> listaFornecedor;
    private String [] colunas = {"Nome", "Telefone", "Endereço","CNPJ", "Email" };
 
    
    public FornecedorTableModel(){
        listaFornecedor = new ArrayList<>();
    }
    
    public FornecedorTableModel(List<Fornecedor> fornecedor){
        this();
        this.listaFornecedor.addAll(fornecedor);
    }
    @Override
    public int getRowCount() {
       return listaFornecedor.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Fornecedor fornecedor = listaFornecedor.get(linha);
        switch (coluna) {
            case 0:
                return fornecedor.getNome();
            case 1:
                return fornecedor.getTelefone();
            case 2:
                return fornecedor.getEndereco();
            case 3:
                return fornecedor.getCnpj();
            case 4:
                return fornecedor.getEmail();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    public Fornecedor getFornecedor(int linha){
        if(linha >= listaFornecedor.size()){
            return null;
        }
        return listaFornecedor.get(linha);
    }
    
    
}
