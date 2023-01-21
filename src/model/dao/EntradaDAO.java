package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Entrada;
import model.bean.Produtos;

public class EntradaDAO {

    public boolean create(Entrada entrada) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO entrada(idproduto,qtd ) VALUES(?, ?)");
            stmt.setInt(1, entrada.getProdutos().getIdproduto());
            stmt.setDouble(2, entrada.getQtdentrada());
           
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Entrada> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Entrada> listaEntrada = new ArrayList<>();

        String sql = "SELECT p.identrada, p.qtd AS qtd,p.idprodutos,c.idprodutos, c.descricao FROM entrada p JOIN produtos c ON c.idprodutos = p.idprodutos";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Entrada entra = new Entrada();
                entra.setIdentrada(rs.getInt("identrada"));
                entra.setQtdentrada(rs.getInt("qtd"));

                Produtos produtos = new Produtos();
                produtos.setIdproduto(rs.getInt("idprodutos"));
                produtos.setDescricao(rs.getString("descricao"));
                entra.setProdutos(produtos);
               

                listaEntrada.add(entra);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler os produtos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return listaEntrada;
    }

    public boolean update(Entrada entrada) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE entrada SET idprodutos=?, qtd=? WHERE identrada = ?");
            stmt.setInt(1, entrada.getProdutos().getIdproduto());
            stmt.setDouble(2, entrada.getQtdentrada());
            stmt.setInt(3, entrada.getIdentrada());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Entrada entrada) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM entrada WHERE identrada = ?");
            stmt.setInt(1, entrada.getIdentrada());

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
