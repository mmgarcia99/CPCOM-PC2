package model.bean;

public class Saida {

    private int idsaida;
    private int qtdsaida;
    private Produtos produtos;
    private Cliente cliente;

    public Saida() {
    }

    public int getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(int idsaida) {
        this.idsaida = idsaida;
    }

    public int getQtdsaida() {
        return qtdsaida;
    }

    public void setQtdsaida(int qtdsaida) {
        this.qtdsaida = qtdsaida;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
