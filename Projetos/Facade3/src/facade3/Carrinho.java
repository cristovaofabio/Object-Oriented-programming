package facade3;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cristovao
 */
public class Carrinho {
    private List<Produto> myList;
    public Carrinho(){
        myList = new ArrayList<Produto>();
    }
    public Carrinho Create(){
        return new Carrinho();
    }
    public void adicionar(Produto p){
        System.out.println("Preço no metodo adicionar: "+p.getPreco());
        myList.add(p);
        System.out.println("Tamanho da lista no método adicionar: "+myList.size());
    }
    public double getTotal(){
        double soma=0;
        System.out.println("Tamanho da lista: "+this.myList.size());
        for(Produto produt:myList){
           System.out.println("Preço no getTotal: "+produt.getPreco());
            soma=soma+produt.getPreco();
        }
        return soma;
    }
}
