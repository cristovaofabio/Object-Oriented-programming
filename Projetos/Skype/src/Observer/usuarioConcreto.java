/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Eliabe
 */
public class usuarioConcreto implements usuario {

    private boolean alertaUsuario = false;
    private ArrayList observeContatos = new ArrayList();

    public void alterarStatus() {
        if (this.alertaUsuario) {
            this.alertaUsuario = false;
        } else {
            this.alertaUsuario = true;
        }
        notificacaoContatos();
    }

    public boolean getStatusUsuario(){
        return this.alertaUsuario;    
    }
    
    public void notificacaoContatos(){
    
        Iterator i = this.observeContatos.iterator();
        while(i.hasNext()){
            contato o = (contato) i.next();
            o.atualizar(this);
        }
    }
    
    @Override
    public void adicionarUsuario(contato o) {
        this.observeContatos.add(o);
    }

    @Override
    public void removerObeservador(contato o) {
        this.observeContatos.remove(o);
    }

}
