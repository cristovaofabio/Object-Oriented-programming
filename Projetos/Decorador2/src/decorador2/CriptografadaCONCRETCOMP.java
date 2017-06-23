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
public class CriptografadaCONCRETCOMP extends MensagemDECORATOR{
    
    public CriptografadaCONCRETCOMP(MensagemCOMPONENT mensag) {
        super(mensag);
    }

    @Override
    public void escrever() {
        mensagem.escrever();
        MostrarMensagem();
    }
    private void MostrarMensagem(){
        System.out.println(" criptografada");
    }
    
}
