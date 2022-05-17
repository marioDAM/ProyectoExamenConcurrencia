import java.util.ArrayList;
import java.util.List;

public class Cocina {
    List<Oreja> orejas;

    public Cocina() {
        this.orejas = new ArrayList<Oreja>();
    }

    public synchronized void mandarOreja(Oreja oreja) {
        orejas.add(oreja);
        notify();
    }

    public synchronized Oreja obtenerOreja() throws InterruptedException {
        Oreja oreja = null;
        while (orejas.isEmpty()) {
            wait();
        }
        oreja = this.orejas.remove(0);
        return oreja;
    }
}
