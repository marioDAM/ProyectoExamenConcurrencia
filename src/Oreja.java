import java.util.Random;

public class Oreja {
    private int tipo;
     private Random random = new Random();

    public int getTipo() {
        return tipo;
    }

    /**
     * 1 Es normal y 2  con pimenton
     */

    public Oreja() {
        this.tipo = random.nextInt(2) + 1;
    }
}
