public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Almacen almacen = new Almacen();

        Cocina cocina = new Cocina();

        Granja granja1 = new Granja("Granja 1", almacen);
        Granja granja2 = new Granja("Granja 2", almacen);
        Granja granja3 = new Granja("Granja 3", almacen);


        granja1.start();
        granja2.start();
        granja3.start();

        Distribuidor distribuidor1 = new Distribuidor("Distribuidor 1", almacen, cocina);
        Distribuidor distribuidor2 = new Distribuidor("Distribuidor 2", almacen, cocina);


        distribuidor1.start();
        distribuidor2.start();

        Cocinero cocinero = new Cocinero("Cocinero 1", cocina);
        Cocinero cocinero2 = new Cocinero("Cocinero 2", cocina);

        cocinero2.start();
        cocinero.start();

        granja1.join();
        granja2.join();
        granja3.join();

        //System.out.println("Numero de orejas : "+ almacen.getNumeroOrejas());
    }
}
