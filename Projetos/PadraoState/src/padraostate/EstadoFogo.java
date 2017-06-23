/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraostate;

/**
 *
 * @author cristovao
 */
public class EstadoFogo implements Estado{

    @Override
    public void estadoAtual() {
        System.out.println("Solta bolas de fogo\n");
    }
    
}
