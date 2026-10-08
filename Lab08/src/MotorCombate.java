import java.util.ArrayList;
import Personajes.*;

public class MotorCombate {

    private ArrayList<String> bitacora;

    public MotorCombate() {
        bitacora = new ArrayList<>();
    }

    public void ejecutarTurno(Personaje atacante, Personaje defensor) {
        try {
            if (atacante == null) throw new PersonajeNuloException("ejecutarTurno(atacante)");
            if (defensor == null) throw new PersonajeNuloException("ejecutarTurno(defensor)");

            System.out.println("\n--- Turno: " + atacante.getNombre() +
                               " vs " + defensor.getNombre() + " ---");
            atacante.atacar();
            int danio = atacante.calcularDanio();
            defensor.recibirDanio(danio);
            bitacora.add("OK | " + atacante.getNombre() +
                         " atacó a " + defensor.getNombre() +
                         " (daño: " + danio + ")");

        } catch (PersonajeDerrotadoException e) {
            bitacora.add("DERROTA | " + e.getNombrePersonaje() +
                         " no pudo actuar");
            System.out.println("⚠ " + e.getMessage());

        } catch (RecursoInsuficienteException e) {
            String nombreAtacante = atacante == null ? "desconocido" : atacante.getNombre();
            bitacora.add("SIN RECURSO | " + nombreAtacante +
                         " no pudo atacar");
            System.out.println("⚠ " + e.getMessage());

        } catch (RpgException e) {
            bitacora.add("ERROR RPG | " + e.getMessage());
            System.out.println("⚠ Error de juego: " + e.getMessage());

        } finally {
            System.out.println("[Bitácora] Turno registrado.");
        }
    }

    public void mostrarBitacora() {
        System.out.println("\n=== Bitácora de Combate ===");
        for (int i = 0; i < bitacora.size(); i++) {
            String registro = bitacora.get(i);
            String[] partes = registro.split(" \\|", 2);
            System.out.printf("%d. %-12s|%s%n", i + 1, partes[0], partes[1]);
        }
    }
}