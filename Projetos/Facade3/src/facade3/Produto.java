package facade3;

/**
 *
 * @author cristovao
 */
public class Produto {
    private String nome;
    private double preco;
    private int idProduto;
  
    public Produto Create(String nome, int id, double preco){
       
        Produto p = new Produto();
        p.nome=nome;
        p.idProduto=id;
        p.preco=preco;
        return p;
    }
    public double getPreco() {
        return this.preco;
    }

    public int getIdProduto() {
        
        return idProduto;
    }
    
}
