package flyweight2;

import flyweight2.FlyweightFactory.caracteres;

/**
 *
 * @author cristovao
 */
public class Cliente {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyweight(caracteres.bloco).posicionarImagem(new Coluna(0), new Linha(0));
        factory.getFlyweight(caracteres.bloco).posicionarImagem(new Coluna(1), new Linha(4));
        factory.getFlyweight(caracteres.bloco).posicionarImagem(new Coluna(2), new Linha(3));
        factory.getFlyweight(caracteres.bloco).posicionarImagem(new Coluna(3), new Linha(2));
    }
    
}
