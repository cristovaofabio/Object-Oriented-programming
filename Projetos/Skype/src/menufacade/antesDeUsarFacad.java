/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menufacade;

/**
 *
 * @author Eliabe
 */
public class antesDeUsarFacad {
    
    private conexaoServidor conS;
    private configuracaoLocais confL;
    private baixarDirvers driv;
    private VerificarErros erro;
    
    public antesDeUsarFacad(){
   
        this.conS = new conexaoServidor();
        this.confL = new configuracaoLocais();
        this.driv = new baixarDirvers();
        this.erro = new VerificarErros();       
    
    }
    
    public void verificaco(){
    
        System.out.println(this.conS.iniciar());
        System.out.println(this.confL.verifi());
        System.out.println(this.driv.verfica());
        System.out.println(this.erro.procurar());
        System.out.println();
            
    }    
}
