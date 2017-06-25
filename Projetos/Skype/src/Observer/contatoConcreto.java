/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Observer.usuarioConcreto;

/**
 *
 * @author Eliabe
 */
public class contatoConcreto implements contato {

    private usuarioConcreto user;

    public contatoConcreto(usuarioConcreto u) {
        this.user = u;
        this.user.adicionarUsuario(this);
    }

    @Override
    public void atualizar(usuario u) {
        if (u == this.user) {

            if (this.user.getStatusUsuario()) {
                System.out.println("Online");
            } else {
                System.out.println("Offline");
            }
        }
    }

}
