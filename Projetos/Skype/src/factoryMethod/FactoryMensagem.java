/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethod;

/**
 *
 * @author cristovao
 */
public class FactoryMensagem extends CriarMensagem{

    @Override
    public Mensagem getMensagem(String tipoMensagem) {
        if(tipoMensagem.equals("Texto")){
            return new Texto();
        }
        else if(tipoMensagem.equals("Vídeo")){
            return new Video();
        }
        else{
            System.out.print("Tipo de dado não suportado");
            return null;
        }
    }
    
}
