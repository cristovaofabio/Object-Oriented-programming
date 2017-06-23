/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadetarefa;

/**
 *
 * @author cristovao
 */
public class AgenciaFacade {
    private Companhia comp;
    private Hotel hotel;
    private Empresa emp;
    public AgenciaFacade(){
        this.comp = new Companhia();
        this.hotel = new Hotel();
        this.emp = new Empresa();
    }
    public void AcionarAgencia(){
        comp.mensagem();
        hotel.mensagem();
        emp.mensagem();
    }
}
