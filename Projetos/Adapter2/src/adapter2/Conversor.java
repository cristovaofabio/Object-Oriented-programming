/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conversor implements SomadorEsperado{
    public int soma;
    SomadorExistente se;
    
    public Conversor(SomadorExistente se){
        this.se=se;
    }
    @Override
    public int somaVetor(int[] vetor) {
        ArrayList <Integer> list = new ArrayList<Integer>();
        for (int count: vetor){
            System.out.println(count);
            list.add(count);
        }
       this.soma=se.somaLista(list);
       return soma;
    }
    
}
