package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Funcionario;

public class FuncionarioDAO {

    public boolean create(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(nome,cargo,endereco,email) VALUES(?, ?, ?,? )");
            stmt.setString(1, funcionario.getNome());           
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getEndereço());
            stmt.setString(4, funcionario.getEmail());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Funcionario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        String sql = "SELECT * FROM funcionario";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
                funcionario.setNome(rs.getString("nome"));               
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setEndereço(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                listaFuncionario.add(funcionario);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os funcionários" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return listaFuncionario;
    }

    public boolean update(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome=?, cargo=?, endereco=?, email=? WHERE idfuncionario = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getEndereço());
            stmt.setString(4, funcionario.getEmail());
            stmt.setInt(5, funcionario.getIdfuncionario());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE idfuncionario = ?");
            stmt.setInt(1, funcionario.getIdfuncionario());

            stmt.executeUpdate();

            System.out.println("DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            System.err.println("Erro ao DELETAR" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
        public ArrayList<Funcionario> getListaFuncionarioNome(String nome) {
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        ArrayList listaFuncionario = new ArrayList<>();
        try {
            stat = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ? ORDER by idfuncionario");
            stat.setString(1, "%" + nome + "%");
            rs = stat.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
                funcionario.setNome(rs.getString("nome"));               
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setEndereço(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                listaFuncionario.add(funcionario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler o Funcionario! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stat, rs);
        }

        return listaFuncionario;
    }
}
