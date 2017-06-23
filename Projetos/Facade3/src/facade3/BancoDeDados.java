package facade3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristovao
 */
public class BancoDeDados {
    private List<Cliente> myList= new ArrayList();
    private List<Produto> myListProduto= new ArrayList();
    public void AdicionarCliente(Cliente e){
        myList.add(e);
    }
    public void AdicionarProduto(Produto e){
        myListProduto.add(e);
    }
    public Cliente selectCliente(int id){
        System.out.println("Tamanho da lista do BD: "+this.myList.size());
        for(Cliente cli:myList){
            if(cli.getId()==id){
                return cli;
            }
        }
        return null;
    }
    public Produto selectProduto(int id){
        for(Produto pro:myListProduto){
            if(pro.getIdProduto()==id){
                return pro;
            }
        }
        return null;
    }
    public void processarPagamento(Cliente c, double valor){
        System.out.println("O cliente "+c.getNome()+" vai pagar "+valor+"reais");
        
    }
}
