import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Oreja> orejas;


    public Almacen() {
        this.orejas = new ArrayList<>();
    }

    public synchronized void almacenar(Oreja oreja) {
        this.orejas.add(oreja);
        notify();
        //  System.out.println(granja.getIdGranja());

    }

    public int getNumeroOrejas() {
        return orejas.size();
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
