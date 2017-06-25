/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

import decorator.FuncionalidadeCOMPONENT;
import decorator.FuncionalidadeCONCRETCOMP;
import decorator.TelefoneDECORATOR;

/**
 *
 * @author cristovao
 */
public class Skype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Factory Method -- mensagem de vídeo ou texto
        FactoryMensagem factory = new FactoryMensagem();
        factory.getMensagem("Vídeo");
        
        //Decorator
        FuncionalidadeCOMPONENT funcionalidadeDecorada = new TelefoneDECORATOR(new FuncionalidadeCONCRETCOMP());
        funcionalidadeDecorada.habilitar();
    }
    
}
