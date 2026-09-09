import Personajes.Arquero;
import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Mizraim", 5, 200, 85, "Cota de Malla", null);
        Mago mago = new Mago("Chavana07", 8, 120, 150, "Fuego");
        Arquero arquero = new Arquero("Raquel_67", 6, 150, "Arco Largo", 30, 95);

        System.out.println("=== RPG - Demostracion de Polimorfismo ===\n");
        System.out.println("-- calcularDanio() por tipo --");
        System.out.printf("%-12s (Guerrero) daño: %d <- fuerza(%d) * nivel(%d)%n", guerrero.getNombre(), guerrero.calcularDanio(), guerrero.getFuerza(), guerrero.getNivel());
        System.out.printf("%-12s (Mago)     daño: %d <- mana(%d) * nivel(%d)%n", mago.getNombre(), mago.calcularDanio(), mago.getMana(), mago.getNivel());
        System.out.printf("%-12s (Arquero)  daño: %d <- precision(%d) * flechas(%d)%n%n", arquero.getNombre(), arquero.calcularDanio(), arquero.getPrecision(), arquero.getFlechasDisponibles());

        System.out.println("-- Arreglo polimorfico --");
        Personaje[] equipo = { guerrero, mago, arquero };
        for (Personaje personaje : equipo) {
            personaje.atacar();
        }

        System.out.println("\n-- GestorBatalla --");
        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutarAtaque(guerrero);
        gestor.ejecutarAtaque(mago, arquero);
        gestor.ejecutarAtaque(equipo);

        System.out.println("\n-- Historial --");
        gestor.mostrarHistorial();

        System.out.println("\n-- instanceof --");
        for (Personaje personaje : equipo) {
            if (personaje instanceof Guerrero) {
                System.out.println(personaje.getNombre() + " es un Guerrero.");
            } else if (personaje instanceof Mago) {
                System.out.println(personaje.getNombre() + " es un Mago.");
            } else if (personaje instanceof Arquero) {
                System.out.println(personaje.getNombre() + " es un Arquero.");
            }
        }
    }
}
