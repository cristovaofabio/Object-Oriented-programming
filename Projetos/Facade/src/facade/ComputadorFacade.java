/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author cristovao
 */
public class ComputadorFacade {
    private Processador psd;
    private Memoria mr;
    private DiscoRigido dr;
    public ComputadorFacade(){
        this.psd = new Processador();
        this.mr = new Memoria();
        this.dr = new DiscoRigido();
    }
    public void ligarComputador(){
        psd.iniciar();
        String info = dr.ler(100, 5000);
        System.out.println(info);
        mr.carrega();
    }
}
