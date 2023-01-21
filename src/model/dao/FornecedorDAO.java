package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Fornecedor;

public class FornecedorDAO {

    public boolean create(Fornecedor fornecedor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO fornecedor(nome, telefone, endereco, cnpj, email) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setString(5, fornecedor.getEmail());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public ArrayList<Fornecedor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

        String sql = "SELECT * FROM fornecedor ORDER by idfornecedor";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornece = new Fornecedor();
                fornece.setIdfornecedor(rs.getInt("idfornecedor"));
                fornece.setNome(rs.getString("nome"));
                fornece.setTelefone(rs.getString("telefone"));
                fornece.setEndereco(rs.getString("endereco"));
                fornece.setCnpj(rs.getString("cnpj"));
                fornece.setEmail(rs.getString("email"));
                listaFornecedor.add(fornece);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os fornecedor" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt,rs);
        }
        return listaFornecedor;
    }

    public boolean update(Fornecedor fornecedor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fornecedor SET nome=?, telefone=?, endereco=?, cnpj=?, email=? WHERE idfornecedor = ?");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setInt(6, fornecedor.getIdfornecedor());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Fornecedor fornecedor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM fornecedor WHERE idfornecedor = ?");
            stmt.setInt(1, fornecedor.getIdfornecedor());

            stmt.executeUpdate();

            System.out.println("DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            System.err.println("Erro ao DELETAR" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public ArrayList<Fornecedor> getListaFornecedorNome(String nome) {
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        ArrayList listaFornecedor = new ArrayList<>();
        try {
            stat = con.prepareStatement("SELECT * FROM fornecedor WHERE nome LIKE ? ORDER by idfornecedor");
            stat.setString(1, "%" + nome + "%");
            rs = stat.executeQuery();

            while (rs.next()) {
                 Fornecedor fornece = new Fornecedor();
                fornece.setIdfornecedor(rs.getInt("idfornecedor"));
                fornece.setNome(rs.getString("nome"));
                fornece.setTelefone(rs.getString("telefone"));
                fornece.setEndereco(rs.getString("endereco"));
                fornece.setCnpj(rs.getString("cnpj"));
                fornece.setEmail(rs.getString("email"));
                listaFornecedor.add(fornece);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler o Fornecedor! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stat, rs);
        }

        return listaFornecedor;
    }
}
