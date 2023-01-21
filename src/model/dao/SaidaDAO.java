package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Cliente;
import model.bean.Produtos;
import model.bean.Saida;

public class SaidaDAO {
     public boolean create(Saida saida) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO saida(idprodutos,qtdsaida ,idcliente ) VALUES(?, ?, ?)");
            stmt.setInt(1, saida.getProdutos().getIdproduto());
            stmt.setDouble(2, saida.getQtdsaida());
            stmt.setInt(3, saida.getCliente().getIdcliente());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Saida> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Saida> listaSaida = new ArrayList<>();

        String sql = "SELECT t1.idsaida, t1.qtdsaida, t2.idprodutos, t2.descricao, t3.idcliente, t3.nome FROM saida t1 LEFT JOIN produtos t2 on (t1.idsaida = t2.idprodutos) LEFT JOIN cliente t3 on (t1.idsaida = t3.idcliente)";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Saida sai = new Saida();
                sai.setIdsaida(rs.getInt("idsaida"));
                sai.setQtdsaida(rs.getInt("qtdsaida"));

                Produtos produtos = new Produtos();
                produtos.setIdproduto(rs.getInt("idprodutos"));
                produtos.setDescricao(rs.getString("descricao"));

                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));

                sai.setProdutos(produtos);
                sai.setCliente(cliente);
                
                listaSaida.add(sai);

            }

        } catch (SQLException ex) {
            System.err.println("Erro na saida dos produtos" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return listaSaida;
    }

    public boolean update(Saida saida) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE saida SET idproduto=?, qtdsaida=?, idcliente=? WHERE idsaida = ?");
            stmt.setInt(1, saida.getProdutos().getIdproduto());
            stmt.setDouble(2, saida.getQtdsaida());
            stmt.setInt(3, saida.getCliente().getIdcliente());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Saida saida) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM saida WHERE idsaida = ?");
            stmt.setInt(1, saida.getIdsaida());

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
