import Personajes.AccionInvalidaException;
import Personajes.Arquero;
import Personajes.Druida;
import Personajes.Nigromante;
import Personajes.Personaje;
import Personajes.RpgException;

public class Main {
    public static void main(String[] args) {
        MotorCombate motor = new MotorCombate();
        System.out.println("=== RPG — Sistema con Manejo de Excepciones ===");
        Druida druida = new Druida("Sylva", 10, 120, 30, 0, 40);
        Nigromante nigromante = new Nigromante("Malachar", 5, 240, 30, 15, 2);

        motor.ejecutarTurno(druida, nigromante);

        Druida druidaDerrotada = new Druida("Sylva", 10, 0, 30, 0, 40);
        motor.ejecutarTurno(druidaDerrotada, nigromante);

        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);

        System.out.println("\n-- Intento de curar aliado derrotado --");
        Druida sanadora = new Druida("Mira", 4, 100, 20, 30, 8);
        Personaje aliadoDerrotado = new Nigromante("Sombra", 3, 0, 20, 10, 0);
        try {
            sanadora.curarAliado(aliadoDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();
    }
}
