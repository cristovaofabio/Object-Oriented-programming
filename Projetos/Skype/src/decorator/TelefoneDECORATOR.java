/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author cristovao
 */
public class TelefoneDECORATOR extends FuncionalidadeDECORATOR{
    public TelefoneDECORATOR(FuncionalidadeCOMPONENT funcionalidadeDecorada){
        super(funcionalidadeDecorada);
    }
    @Override
    public void habilitar() {
        funcionalidadeDecorada.habilitar();
        habilitarTelefone();
    }

    private void habilitarTelefone() {
      System.out.println("Chamada de Skype para telefone -- Habilitada");
    }
    
}
