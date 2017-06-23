/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author cristovao
 */
public class Conversor implements HDMI{
    VGA cabo;
    
    public Conversor(VGA cabo){
        this.cabo=cabo;
    }

    @Override
    public void metodoHDMI() {
        cabo.methodoVGA();
    }
    
}
