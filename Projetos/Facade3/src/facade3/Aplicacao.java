package facade3;
/**
 *
 * @author cristovao
 */
public class Aplicacao {

    public static void main(String[] args) {
        Facade f = new Facade();
        f.registrar("Zé", 123);
        f.comprar(223, 123);
        f.comprar(342, 123);
        f.fecharCompra(123);
    }
    
}
