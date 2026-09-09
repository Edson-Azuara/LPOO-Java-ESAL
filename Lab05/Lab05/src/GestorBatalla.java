import Personajes.Personaje;
import java.util.ArrayList;
import java.util.List;


public class GestorBatalla {
    private final List<String> historial = new ArrayList<>();

    public void ejecutarAtaqueM1(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        String evento = "[" + atacante.getNombre() + "] ataca a [" + defensor.getNombre() + "] causando [" + danio + "] de daño.";
        System.out.println(evento);
    }

    public void ejecutarAtaqueM2(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        String evento = "[" + atacante.getNombre() + "] ataca a [" + defensor.getNombre() + "] causando [" + danio + "] de daño.";
        System.out.println(evento);
    }

    public void ejecutarAtaque(Personaje[] equipo) {
        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < equipo.length; i++) {
            if (i > 0) {
                nombres.append(", ");
            }
            nombres.append(equipo[i].getNombre());
        }
        System.out.println("[BATALLA] Equipo completo ataca -> " + equipo.length + " personajes");
        historial.add("Ataque en equipo: " + nombres);
    }

    public void mostrarHistorialEventos(Personaje[] equipo) {
        System.out.println("Historial de eventos:");
        for (int i = 0; i < equipo.length; i++) {
            Personaje atacante = equipo[i];
            Personaje defensor = equipo[(i + 1) % equipo.length]; // El siguiente personaje es el defensor
            int danio = atacante.calcularDanio();
            String evento = "[" + atacante.getNombre() + "] ataca a [" + defensor.getNombre() + "] causando [" + danio + "] de daño.";
            System.out.println(evento);
        }
    }

    public void limpiarHistorialEventos() {
        System.out.println("Historial de eventos limpiado. Iniciando nueva batalla.");
    }

    public void mostrarHistorial() {
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void ejecutarAtaque(Personaje p2, Personaje p3) {
        int danio = p2.calcularDanio();
        System.out.println("[BATALLA] " + p2.getNombre() + " ataca a " + p3.getNombre() + " -> daño: " + danio);
        p3.recibirDanio(danio);
        historial.add(p2.getNombre() + " atacó a " + p3.getNombre() + " (daño: " + danio + ")"
                + (p3.isEstaVivo() ? "" : " - " + p3.getNombre() + " derrotado"));
    }

    public void ejecutarAtaque(Personaje p1) {
        int danio = p1.calcularDanio();
        System.out.println("[BATALLA] " + p1.getNombre() + " ataca solo -> daño: " + danio);
        historial.add(p1.getNombre() + " atacó solo (daño: " + danio + ")");
    }
}


