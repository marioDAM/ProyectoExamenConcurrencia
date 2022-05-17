public class Distribuidor extends Thread {

    private Almacen almacen;

    private Cocina cocina;

    public Distribuidor(String nombre,Almacen almacen, Cocina cocina) {
        super(nombre);
        this.cocina = cocina;
        this.almacen = almacen;

    }

    public void run() {
        while (true) {
            //Saca 10 orejas cada 10 seg y lo manda a la cocina
            for (int i = 0; i < 10; i++) {
                Oreja oreja ;
                try {
                    oreja = almacen.obtenerOreja();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cocina.mandarOreja(oreja);
            }
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName()+" ha llevado a la cocina sus 10 orejas");
        }
    }
}
