package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;

public class ClienteController {

    public boolean create(String nome, String telefone, String cpf, String endereco, String email) {
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);

        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.create(cliente);
    }

    public ArrayList<Cliente> read() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
    }

    public boolean update(int idcliente, String nome, String telefone, String cpf, String endereco, String email) {
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();

        cliente.setIdcliente(idcliente);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);

        return clienteDAO.update(cliente);

    }

    public boolean delete(int idcliente) {
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        cliente.setIdcliente(idcliente);
        clienteDAO.delete(cliente);
        return false;
    }

    public ArrayList<Cliente> getListaClientesNome(String nome) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getListaClientesNome(nome);
    }
}
