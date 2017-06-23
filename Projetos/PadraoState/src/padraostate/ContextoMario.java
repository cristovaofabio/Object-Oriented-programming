package padraostate;

public class ContextoMario {
    private Estado estado;
    public void setEstado(Estado estado){
        this.estado=estado;
    }
    public void estadoAtual(){
        estado.estadoAtual();
    }
}
