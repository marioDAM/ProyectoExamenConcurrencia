public class Granja extends Thread {
    private Almacen almacen;

    public int getIdGranja() {
        return idGranja;
    }

    private int idGranja;

    public Granja(String nombre, Almacen almacen) {
        super(nombre);
        this.almacen = almacen;
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 15; i++) {
                Oreja oreja = new Oreja();

                almacen.almacenar(oreja);
             //   System.out.println(this.getName() + " ha producido 1 orejas y las almacena");
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
