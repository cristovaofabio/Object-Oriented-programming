import factoryMethod.FactoryMensagem;
import Singleton.Login;
import decorator.FuncionalidadeCOMPONENT;
import decorator.FuncionalidadeCONCRETCOMP;
import decorator.TelefoneDECORATOR;
import java.util.Scanner;
import menufacade.antesDeUsarFacad;
import Observer.contatoConcreto;
import Observer.usuarioConcreto;

public class TestantoSkype {

    public static void main(String[] args) {
        
        //Padrão Facade
        antesDeUsarFacad n = new antesDeUsarFacad();
        n.verificaco();
        
        int con=0;
        String global = "não";
        
        //Padrão Singleton
        Login login;
        login = new Login();
        
        Scanner resp;
        resp = new Scanner(System.in);

        String nome, senha;
        System.out.println("Digite nome e senha:");
        nome = resp.nextLine();
        senha = resp.nextLine();

        //Validando o Login
        while (login.validarLogin(nome, senha) && login.sair(global) == false) {
            System.out.println("Bem Vindo " + login.nome);
            if(con==0)
            {
                System.out.println("Deseja habilitar função de telefone? ");
            
                if (resp.next().equals("sim")) {
                    //Padrão Decorator
                    FuncionalidadeCOMPONENT funcionalidadeTelefone = new TelefoneDECORATOR(new FuncionalidadeCONCRETCOMP());
                    funcionalidadeTelefone.habilitar();
                    con++;
                }
            }
            
            System.out.println("Qual o meio de comunicação desejado: Texto ou Vídeo?");
            String auxResposta;
            auxResposta = resp.next();
            
            //Padrão Factory Method
            FactoryMensagem comunicacao = new FactoryMensagem();
            
            if(auxResposta.equals("Texto")){
                comunicacao.getMensagem("Texto"); 
            }
            
            else if(auxResposta.equals("Vídeo")){
                comunicacao.getMensagem("Vídeo");   
            }
            
            //Padrão Observer
            usuarioConcreto usuario = new usuarioConcreto();

            contatoConcreto Gabriel = new contatoConcreto(usuario);
            contatoConcreto Cristovao = new contatoConcreto(usuario);
            contatoConcreto Eliabe = new contatoConcreto(usuario);

            usuario.alterarStatus();
      
            System.out.println("Deseja sair ?");
            global = resp.next();
            if(global.equals("sim"))
                usuario.alterarStatus();

        }

    }

}
