package strategy;

public class Pais2 implements GuerraInterface{

    @Override
    public String declarar(String iniciar) {
        return "País 2 "+iniciar;
    }

    @Override
    public String encerrar(String concluir) {
        return "País 2 "+concluir;
    }
    
}
