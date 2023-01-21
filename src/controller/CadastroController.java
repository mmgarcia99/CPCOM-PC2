package controller;

import model.bean.Cadastro;
import model.dao.CadastroDAO;

public class CadastroController {
    public boolean create(String usuario, String senha) {
        Cadastro user = new Cadastro();

        user.setUsuario(usuario);
        user.setSenha(senha);

        CadastroDAO cadastroDAO = new CadastroDAO();
        return cadastroDAO.create(user);
    }
    
    public boolean verificaLogin(String usuario, String senha){
        CadastroDAO cadastroDAO = new CadastroDAO();
        Cadastro user = new Cadastro();
       user.setUsuario(usuario);
        user.setSenha(senha);
        
        return cadastroDAO.verificaLogin(user);
    }
    
     public boolean createSenhaCripto(String usuario, String senha) {
         Cadastro user = new Cadastro();

        user.setUsuario(usuario);
        user.setSenha(senha);

        CadastroDAO cadastroDAO = new CadastroDAO();
        return cadastroDAO.createSenhaCripto(user);
    }

}
