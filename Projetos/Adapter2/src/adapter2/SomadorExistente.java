/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter2;

import java.util.List;

/**
 *
 * @author cristovao
 */
public class SomadorExistente {
    public int somaLista(List<Integer> lista){
        int resultado=0;
        for(int i: lista) 
            resultado=resultado+i;
        return resultado;
    
    }
}
