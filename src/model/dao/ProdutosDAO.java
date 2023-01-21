package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Fornecedor;
import model.bean.Produtos;

public class ProdutosDAO {

    public boolean create(Produtos produtos) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produtos(descricao, preco, idfornecedor) VALUES(?, ?, ?)");
            stmt.setString(1, produtos.getDescricao());
            stmt.setDouble(2, produtos.getPreco());
            stmt.setInt(3, produtos.getFornecedor().getIdfornecedor());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produtos> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produtos> listaProdutos = new ArrayList<>();

        String sql = "SELECT p.idprodutos, p.descricao AS descricao, p.preco,p.idfornecedor,c.idfornecedor, c.nome FROM produtos p JOIN fornecedor c ON c.idfornecedor = p.idfornecedor";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdproduto(rs.getInt("idprodutos"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));

                Fornecedor fornece = new Fornecedor();
                fornece.setIdfornecedor(rs.getInt("idfornecedor"));
                fornece.setNome(rs.getString("nome"));
                prod.setFornecedor(fornece);

                listaProdutos.add(prod);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os produtos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return listaProdutos;
    }

    public boolean update(Produtos produtos) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produtos SET descricao=?, preco=?, idfornecedor=? WHERE idprodutos = ?");
            stmt.setString(1, produtos.getDescricao());
            stmt.setDouble(2, produtos.getPreco());
            stmt.setInt(3, produtos.getFornecedor().getIdfornecedor());
            stmt.setInt(4, produtos.getIdproduto());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Produtos produtos) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE idprodutos = ?");
            stmt.setInt(1, produtos.getIdproduto());

            stmt.executeUpdate();

            System.out.println("DELETADO COM SUCESSO");
        } catch (SQLException ex) {
            System.err.println("Erro ao DELETAR" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public ArrayList<Produtos> getListaProdutosDescricao(int idprodutos) {
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        ArrayList listaProdutos = new ArrayList<>();
        try {
            stat = con.prepareStatement("SELECT * FROM produtos WHERE descricao LIKE ? ORDER by idprodutos");
                    //");
            stat.setInt(1,  idprodutos);
            rs = stat.executeQuery();

            while (rs.next()) {
                 Produtos prod = new Produtos();
                prod.setIdproduto(rs.getInt("idprodutos"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));

                Fornecedor fornece = new Fornecedor();
                fornece.setIdfornecedor(rs.getInt("idfornecedor"));
                fornece.setNome(rs.getString("nome"));
                prod.setFornecedor(fornece);
                listaProdutos.add(prod);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler o Produto! " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stat, rs);
        }

        return listaProdutos;
    }
}
