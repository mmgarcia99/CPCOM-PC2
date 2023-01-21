package model.dao;

import connection.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cadastro;

public class CadastroDAO {
     public boolean create(Cadastro usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cadastro(usuario, senha) VALUES(?, ?)");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public boolean createSenhaCripto(Cadastro usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messaDigest[] = md.digest(usuario.getSenha().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : messaDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }

            String senhaHex = sb.toString();

            stmt = con.prepareStatement("INSERT INTO cadastro(usuario, senha) VALUES(?, ?)");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, senhaHex);

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
        return false;
    }
    
    public boolean verificaLogin(Cadastro usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            
              MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messaDigest[] = md.digest(usuario.getSenha().getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : messaDigest) {
                sb.append(String.format("%02X", 0xFF & b));
            }

            String senhaHex = sb.toString();
            
            stmt = con.prepareStatement("SELECT * FROM cadastro WHERE usuario = ? and senha = ?");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, senhaHex);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            System.err.println("erro ao salvar" + ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }   
}
