package Singleton;





public class SessaoUsuario_Singleton {
    
    private static SessaoUsuario_Singleton session = null;
            
    private SessaoUsuario_Singleton()
    {}
    
     
    public static SessaoUsuario_Singleton getSession(){
        if (session == null){
            session = new SessaoUsuario_Singleton();
        }
        return session;
    }
    
}
