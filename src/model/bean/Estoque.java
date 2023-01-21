package model.bean;

public class Estoque {

    private int idestoque;
    private int qtdestoque;
    private Produtos produtos;
 

    public Estoque() {
    }

    public int getIdestoque() {
        return idestoque;
    }

    public void setIdestoque(int idestoque) {
        this.idestoque = idestoque;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

   

 
   

}
