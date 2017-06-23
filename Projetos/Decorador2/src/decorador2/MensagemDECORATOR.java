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
public abstract class MensagemDECORATOR extends MensagemCOMPONENT{
    protected MensagemCOMPONENT mensagem;
    public MensagemDECORATOR(MensagemCOMPONENT mensagemDecorada){
        this.mensagem=mensagemDecorada;
    }
}
