/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter2;

/**
 *
 * @author cristovao
 */
public class Adapter {

    public static void main(String[] args) {
        SomadorExistente somador = new SomadorExistente();
        Conversor con = new Conversor(somador);
        Cliente c  = new Cliente(con);
        c.executar();
    }
    
}
