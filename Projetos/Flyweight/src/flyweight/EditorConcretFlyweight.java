package flyweight;

public class EditorConcretFlyweight extends EditorFlyweight{
    protected char caracter;
    @Override
    public void posicionarLetra(Coluna coluna, Linha linha) {
        System.out.println("Caracter "+this.caracter+" posicionado na linha "+linha.x+" e "
                + "na coluna "+coluna.y);
    }
    public EditorConcretFlyweight(char caracter){
        this.caracter=caracter;
    }
    
}
