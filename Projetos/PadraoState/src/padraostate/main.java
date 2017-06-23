package padraostate;

public class main {

    public static void main(String[] args) {
        ContextoMario cm = new ContextoMario();
        System.out.println("Pegar Cogumelo: \n");
        cm.setEstado(new EstadoGrande());
        cm.estadoAtual();
        cm.setEstado(new Estado1000());
        cm.estadoAtual();
        System.out.println("Pegar Flor: \n");
        cm.setEstado(new EstadoGrande());
        cm.estadoAtual();
        cm.setEstado(new EstadoFogo());
        cm.estadoAtual();
         cm.setEstado(new Estado1000());
        cm.estadoAtual();
        System.out.println("Pegar pena: \n");
        cm.setEstado(new EstadoGrande());
        cm.estadoAtual();
        cm.setEstado(new EstadoCapa());
        cm.estadoAtual();
        cm.setEstado(new Estado1000());
        cm.estadoAtual();
         System.out.println("Levar dano: \n");
        cm.setEstado(new EstadoGrande());
        cm.estadoAtual();
        cm.setEstado(new EstadoPequeno());
        cm.estadoAtual();
        cm.setEstado(new EstadoMorto());
        cm.estadoAtual();
            
    }
    
}
