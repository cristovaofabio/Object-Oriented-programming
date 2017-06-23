/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author cristovao
 */
public class Context {
    protected GuerraInterface pais;
    public Context(String inimigo,int i){
        if(i==1){
                pais = new Pais2();
            }
        else if(i==2){
                pais = new Pais1();
            }
        if(inimigo.equals("Nuclear")){
            System.out.println(pais.declarar("Recuar tropas"));
            System.out.println(pais.encerrar("Desarmar inimigo"));
        }
        if(inimigo.equals("Grande Exercito")){
            System.out.println(pais.declarar("Atacar pelo Norte"));
            System.out.println(pais.encerrar("Dividir benefícios. Dividir custo de reconstrução"));
        }
        if(inimigo.equals("Frágil")){
            System.out.println(pais.declarar("Plantar evidências falsas. Lançar bombas. Derrubar governo"));
            System.out.println(pais.encerrar("Estabelecar governo. Amigo"));
        }   
    }
    
}
