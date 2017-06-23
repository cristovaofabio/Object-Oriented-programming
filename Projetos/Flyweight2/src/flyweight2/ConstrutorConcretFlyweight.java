/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight2;

/**
 *
 * @author cristovao
 */
public class ConstrutorConcretFlyweight extends ConstrutorFlyweight{
    protected String caracter;
    @Override
    public void posicionarImagem(Coluna coluna, Linha linha) {
        System.out.println(this.caracter+" posicionado na linha "+linha.x+" e "
                + "na coluna "+coluna.y);
    }
    public ConstrutorConcretFlyweight(String caracter){
        this.caracter=caracter;
    }
}
