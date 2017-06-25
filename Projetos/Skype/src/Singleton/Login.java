
package Singleton;


public class Login {
    public String nome, senha;
    private SessaoUsuario_Singleton session;
    
    public Login(){
        this.nome = "Gabriel";
        this.senha = "poo2";
    }
   
       
    public boolean validarLogin(String name, String sen){
        
        if(name.equals(nome) && sen.equals(senha)){
            session.getSession();
            return true;
        }
        else{
            
            System.out.println("Usuário e/ou senha inválidos , Tente Novamente! ");
            return false;
        }    
    }
    
    /*
    public boolean verficarResposta(String resposta) {
        if(resposta.equals("sim"))
            return true;
        else
            return false;
    }*/
    
    
    public boolean sair(String confirma)
    {
        if(confirma.equals("sim")){
            session = null;
            return true;
        }
        else
            return false;
        
        
    }
    
}    
    

