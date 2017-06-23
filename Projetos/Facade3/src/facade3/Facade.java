package facade3;

/**
 *
 * @author cristovao
 */
public class Facade {
    private BancoDeDados BD;
    private Cliente clie;
    private Produto prod,prod2;
    private Carrinho car;
    public void registrar(String nome,int id){
        Cliente p = new Cliente();
        clie=p.Create(nome, id);
        clie.adicionarCarrinho(car);
        this.car = clie.getCarrinho();
        BD = new BancoDeDados();
        BD.AdicionarCliente(clie);
    }
    public void comprar(int idProduto, int idCliente){
        //System.out.println("id produto no facade: "+idProduto);
        Produto p = new Produto();
        if(idProduto==223){
            prod = p.Create("Feijão", idProduto, 5.3);
           // System.out.println("Preco no FACADE: "+prod.getPreco());
            car.adicionar(prod);
            BD.AdicionarProduto(prod);
        }
        else if(idProduto==342){
            prod2 = p.Create("Arroz", idProduto, 4.6);
            // System.out.println("Preco no FACADE: "+prod.getPreco());
            car.adicionar(prod2);
            BD.AdicionarProduto(prod2);
        }
        
    }
    public void fecharCompra(int id){
        Cliente c = BD.selectCliente(id);
        double valor = c.getCarrinho().getTotal();
        BD.processarPagamento(c, valor);
    }
}
