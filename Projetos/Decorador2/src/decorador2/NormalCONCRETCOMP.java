/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorador2;

/**
 *
 * @author cristovao
 */
public class NormalCONCRETCOMP extends MensagemCOMPONENT{

    @Override
    public void escrever() {
        System.out.println("Mensagem normal");
    }
    
}
