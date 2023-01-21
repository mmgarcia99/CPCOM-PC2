package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Estoque;
import model.bean.Produtos;

public class EstoqueDAO {

    public boolean create(Estoque estoque) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoque(idprodutos ,qtd_estoque ) VALUES(?, ?)");
            stmt.setInt(1, estoque.getProdutos().getIdproduto());
            stmt.setInt(2, estoque.getQtdestoque());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Estoque> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Estoque> listaEstoque = new ArrayList<>();

        String sql = "";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setIdestoque(rs.getInt("idestoque"));
                estoque.setQtdestoque(rs.getInt("qtd_estoque"));

                Produtos produtos = new Produtos();
                produtos.setIdproduto(rs.getInt("idproduto"));
                produtos.setDescricao(rs.getString("descricao"));

                
                listaEstoque.add(estoque);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os produtos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return listaEstoque;
    }

    public boolean update(Estoque estoque) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET idproduto=?, qtd_estoque=? WHERE idestoque = ?");
            stmt.setInt(1, estoque.getProdutos().getIdproduto());
            stmt.setDouble(2, estoque.getQtdestoque());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Estoque estoque) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE idestoque = ?");
            stmt.setInt(1, estoque.getIdestoque());

            stmt.executeUpdate();

            System.out.println("DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            System.err.println("Erro ao DELETAR" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

}
