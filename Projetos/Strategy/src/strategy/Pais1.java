package strategy;

public class Pais1 implements GuerraInterface{
     @Override
    public String declarar(String iniciar) {
        return "País 1 "+iniciar;
    }

    @Override
    public String encerrar(String concluir) {
        return "País 1 "+concluir;
    }

}
