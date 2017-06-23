package decorador2;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MensagemCOMPONENT mensagem1 = new CriptografadaCONCRETCOMP(new NormalCONCRETCOMP());
        mensagem1.escrever();
        MensagemCOMPONENT mensagem2 = new CriptografadaCONCRETCOMP(new AnexoCONCRETCOMP(new NormalCONCRETCOMP()));
        mensagem2.escrever();
    }
    
}
