/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade3;

/**
 *
 * @author cristovao
 */
public class Cliente {
    private Cliente c;
    private Carrinho car = new Carrinho();
    private String nome;
    private int id;
    public Cliente Create(String nome,int id){
        this.c = new Cliente();
        c.nome=nome;
        c.id=id;
        return c;
    }
    public void adicionarCarrinho(Carrinho car){
        Carrinho cn = new Carrinho();
        car=cn.Create();
    }
    public Carrinho getCarrinho(){
        return car;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
