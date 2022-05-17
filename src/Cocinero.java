import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Thread {
    private Cocina cocina;

    private List<Oreja> orejas;
    private List<Oreja> orejasP;

    public Cocinero(String nombre, Cocina cocina) {
        super(nombre);
        this.cocina = cocina;
        this.orejas = new ArrayList<>();
        this.orejasP = new ArrayList<>();
    }

    public void prepararPlato() {
        System.out.println("Se ha preparado el plato de oreja ");
        orejas.clear();

    }

    public void run() {
        while (true) {
            Oreja oreja;
            try {
                boolean ingredientePreparados = false;

                while (!ingredientePreparados) {
                    oreja = cocina.obtenerOreja();
                        if (oreja.getTipo() == 1) {
                            this.orejas.add(oreja);
                        } else {
                            this.orejasP.add(oreja);
                        }
                        if (orejas.size() == 5) {
                            ingredientePreparados = true;
                        } else if (orejasP.size() == 5) {
                            ingredientePreparados = true;
                        }
                }
                if (orejas.size() == 5) {
                    prepararPlato();
                    System.out.println(this.getName() + " ha preparado un plato ");
                } else if (orejasP.size() == 5) {
                    prepararPlatoPimenton();
                    System.out.println(this.getName() + " ha preparado un plato con pimentón ");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void prepararPlatoPimenton() {
        System.out.println("Se ha preparado el plato de oreja con pimenton");
        orejasP.clear();
    }
}
