/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight2;

import java.util.ArrayList;

/**
 *
 * @author cristovao
 */
public class FlyweightFactory {
    protected ArrayList<ConstrutorFlyweight> flyweights;
    public enum caracteres{
        bloco;
    }
    public FlyweightFactory(){
        flyweights = new ArrayList<ConstrutorFlyweight>();
        flyweights.add(new ConstrutorConcretFlyweight("bloco"));
    }
    public ConstrutorFlyweight getFlyweight(caracteres caract){
        switch(caract){
            case bloco:
                return flyweights.get(0);
            default:
               return flyweights.get(1);
        
        }
    }
}
