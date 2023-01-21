package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;

public class ClienteDAO {

    public boolean create(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente( nome, telefone, cpf, endereco, email)VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getEmail());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public ArrayList<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> listaCliente = new ArrayList<>();

        String sql = "SELECT * FROM cliente ORDER by idcliente";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente clien = new Cliente();
                clien.setIdcliente(rs.getInt("idcliente"));
                clien.setNome(rs.getString("nome"));
                clien.setTelefone(rs.getString("telefone"));
                clien.setCpf(rs.getString("cpf"));
                clien.setEndereco(rs.getString("endereco"));
                clien.setEmail(rs.getString("email"));
                listaCliente.add(clien);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os clientes" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaCliente;
    }

    public boolean update(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome=?, telefone=?, cpf=?, endereco=?, email=? WHERE idcliente = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getIdcliente());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
            stmt.setInt(1, cliente.getIdcliente());

            stmt.executeUpdate();

            System.out.println("DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            System.err.println("Erro ao DELETAR" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Cliente> getListaClientesNome(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        ArrayList listaCliente = new ArrayList<>();
        try {
            stat = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ORDER by idcliente ");
            stat.setString(1, "%" + nome + "%");
            rs = stat.executeQuery();

            while (rs.next()) {
                Cliente clien = new Cliente();
                clien.setIdcliente(rs.getInt("idcliente"));
                clien.setNome(rs.getString("nome"));
                clien.setTelefone(rs.getString("telefone"));
                clien.setCpf(rs.getString("cpf"));
                clien.setEndereco(rs.getString("endereco"));
                clien.setEmail(rs.getString("email"));
                listaCliente.add(clien);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler o Cliente! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stat, rs);
        }

        return listaCliente;
    }
}
    
            
      
    
    
     