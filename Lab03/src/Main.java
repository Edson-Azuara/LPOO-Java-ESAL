import aereo.Avion;
import maritimo.Barco;
import vehiculos.Automovil;

public class Main {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2018, 950.0, 2, 12500.0);
        Barco barco = new Barco("Yamaha", "242X", 2020, 65.0, "Fibra de vidrio", 2500.0);

        System.out.println("Información inicial:");
        System.out.println(auto.toString());
        System.out.println(avion.toString());
        System.out.println(barco.toString());

        System.out.println("\nPruebas con valores incorrectos:");
        auto.setAnio(1800);
        auto.setNumPuertas(10);

        auto.setAnio(2024);
        auto.setNumPuertas(5);

        System.out.println("\nInformación con valores corregidos:");
        System.out.println(auto.toString());
        System.out.println(avion.toString());
        System.out.println(barco.toString());
    }
}
