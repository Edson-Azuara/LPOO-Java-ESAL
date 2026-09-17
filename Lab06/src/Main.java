import Personajes.Bardo;
import Personajes.Druida;
import Personajes.Nigromante;
import Personajes.Personaje;
import Skills.Hechicero;
import Skills.Sanador;

public class Main {
    //new personaje() sintaxis error on token "new"

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        Druida sylva = new Druida("Sylva", 7, 150, 200, 120, 100);
        Nigromante melchor = new Nigromante("Melchor", 14, 400, 240, 270, 30);
        Bardo Fridmann = new Bardo("Fridmann", 4, 100, 40, 10, "laúd", "Melodía de la vida");
        Personaje[] equipo = {
            sylva,
            melchor,
            Fridmann
        };

        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");
        System.out.println("-- Error esperado (línea comentada) --");
        System.out.println("// new Personaje(...) → cannot instantiate abstract class\n");

        System.out.println("-- Ataques y daño --");
        for (Personaje personaje : equipo) {
            personaje.atacar();
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje personaje : equipo) {
            if (personaje instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        melchor.recibirDanio(300);
        System.out.println(melchor.getNombre() + " recibe 300 de daño. Vida: " + melchor.getPuntosVida());
        for (Personaje personaje : equipo) {
            if (personaje instanceof Sanador s) {
                s.curarAliado(melchor);
            }
        }

        System.out.println("\n-- Estado final --");
        for (Personaje personaje : equipo) {
            System.out.printf("Nombre: %-8s | Nivel: %d | Vida: %d | Vivo: %s%n",
                    personaje.getNombre(), personaje.getNivel(), personaje.getPuntosVida(),
                    personaje.isEstaVivo() ? "Sí" : "No");
        }
    }

    
    // Crea ojeto tipo Driuda
    public static void main1(String[] args) {
        Druida druida = new Druida("Elrond", 5, 100, 50, 20, 10);
        Bardo bardo = new Bardo("Luthien", 4, 80, 15, 8, "lira", "Canción de la Luna");

        // Mostrar información del druida
        System.out.println("Druida: " + druida.getNombre());
        System.out.println("Nivel: " + druida.getNivel());
        System.out.println("Puntos de Vida: " + druida.getPuntosVida());
        System.out.println("Mana: " + druida.getMana());
        System.out.println("Poder de Curación: " + druida.getPoderCuracion());
        System.out.println("Vínculo con la Naturaleza: " + druida.getVinculoConLaNaturaleza());

        // Mostrar información del bardo
        System.out.println("\nBardo: " + bardo.getNombre());
        System.out.println("Nivel: " + bardo.getNivel());
        System.out.println("Puntos de Vida: " + bardo.getPuntosVida());
        System.out.println("Poder de Curación: " + bardo.getPoderCuracion());
        System.out.println("Instrumento Musical: " + bardo.InstrumentoMusical());
        System.out.println("Canción Favorita: " + bardo.getCancionFavorita());

        // Ejemplo de ataque y curación
        druida.atacar();
        bardo.atacar();

        // Curar al bardo usando el druida
        druida.curarAliado(bardo);
    }


    // Crea objeto tipo Nigromante
    public static void main2(String[] args) {
        Nigromante nigromante = new Nigromante("Morgath", 6, 90, 60, 25, 30);
        System.out.println("Nigromante: " + nigromante.getNombre());
        System.out.println("Nivel: " + nigromante.getNivel());
        System.out.println("Puntos de Vida: " + nigromante.getPuntosVida());
        System.out.println("Mana: " + nigromante.getMana());
        System.out.println("Poder Oscuro: " + nigromante.getPoderOscuro());

        // Ejemplo de ataque y curación
        nigromante.atacar();

        // Curar al nigromante usando el druida
        Druida druida = new Druida("Elrond", 5, 100, 50, 20, 10);
        druida.curarAliado(nigromante);
    }


    // Crea objeto tipo Bardo
    public static void main3(String[] args) {
        Bardo bardo = new Bardo("Luthien", 4, 80, 15, 8, "lira", "Canción de la Luna");
        System.out.println("Bardo: " + bardo.getNombre());
        System.out.println("Nivel: " + bardo.getNivel());
        System.out.println("Puntos de Vida: " + bardo.getPuntosVida());
        System.out.println("Poder de Curación: " + bardo.getPoderCuracion());
        System.out.println("Instrumento Musical: " + bardo.InstrumentoMusical());
        System.out.println("Canción Favorita: " + bardo.getCancionFavorita());

        // Ejemplo de ataque y curación
        bardo.atacar();

        // Curar al bardo usando el druida
        Druida druida = new Druida("Elrond", 5, 100, 50, 20, 10);
        druida.curarAliado(bardo);
    }

    
}
