/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author cristovao
 */
public class PainelConcreto implements Painel{
    
    @Override
    public void mudar(Caixa c) {
        mensagem(c.getNumero());
    }
    public void mensagem(int numero){
        System.out.println("Caixa disponível: "+numero);
    }
}
