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
public class Gerenciador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PainelConcreto p = new PainelConcreto();
        CaixaConcreta1 c1 = new CaixaConcreta1();
        CaixaConcreta2 c2 = new CaixaConcreta2();
        CaixaConcreta3 c3 = new CaixaConcreta3();
        
        c1.mudarPainel(p);
        c2.mudarPainel(p);
        c3.mudarPainel(p);
        
    }
    
}
