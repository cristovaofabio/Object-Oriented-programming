
package adapter;

public class Adapter {

    public static void main(String[] args) {
        VGA cabo = new VGA();
        Conversor c = new Conversor(cabo);
        c.metodoHDMI();
    }
    
}
