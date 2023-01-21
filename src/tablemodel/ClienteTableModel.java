package tablemodel;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.bean.Cliente;

public class ClienteTableModel extends AbstractTableModel{

    private List<Cliente> listaCliente;
    private String [] colunas = {"Nome", "Telefone", "CPF", "Endereço", "Email" };
 
    
    public ClienteTableModel(){
        listaCliente = new ArrayList<>();
    }
    
    public ClienteTableModel(List<Cliente> cliente){
        this();
        this.listaCliente.addAll(cliente);
    }
    @Override
    public int getRowCount() {
       return listaCliente.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
      Cliente cliente = listaCliente.get(linha);
        switch (coluna) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getTelefone();
            case 2:
                return cliente.getCpf();
            case 3:
                return cliente.getEndereco();
            case 4:
                return cliente.getEmail();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    public Cliente getCliente(int linha){
        if(linha >= listaCliente.size()){
            return null;
        }
        return listaCliente.get(linha);
    }
    
}
