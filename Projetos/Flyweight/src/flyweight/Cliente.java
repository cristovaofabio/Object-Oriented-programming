package flyweight;

import flyweight.FlyweightFactory.caracteres;

/**
 *
 * @author cristovao
 */
public class Cliente {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyweight(caracteres.a).posicionarLetra(new Coluna(0), new Linha(0));
        factory.getFlyweight(caracteres.b).posicionarLetra(new Coluna(1), new Linha(4));
        factory.getFlyweight(caracteres.c).posicionarLetra(new Coluna(2), new Linha(3));
        factory.getFlyweight(caracteres.d).posicionarLetra(new Coluna(3), new Linha(2));
    }
    
}
