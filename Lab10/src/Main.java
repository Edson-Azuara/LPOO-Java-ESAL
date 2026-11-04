import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Personajes.*;

public class Main {
    public static void main(String[] args) {
        try {
            GestionGremio gremio = new GestionGremio();

            System.out.println("=== Gestión de roster ===");
            gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100));
            gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120));
            gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, "Hacha", 80));
            gremio.mostrarRoster();

            gremio.eliminarMiembro("Malachar");
            gremio.mostrarRoster();

            Personaje encontrado = gremio.buscarPorNombre("Legolas");
            if (encontrado != null) {
                System.out.println("Encontrado: " + encontrado.getNombre());
            }

            System.out.println("\n=== Cola de espera ===");
            gremio.encolarSolicitante("Gandalf");
            gremio.encolarSolicitante("Aragorn");
            gremio.encolarSolicitante("Gimli");
            gremio.mostrarCola();

            gremio.atenderSiguiente();
            gremio.mostrarCola();

            System.out.println("\n=== Inventario ===");
            gremio.agregarItem("Poción de vida", 5);
            gremio.agregarItem("Flecha élfica", 30);
            gremio.agregarItem("Poción de vida", 3);
            gremio.mostrarInventario();

            gremio.usarItem("Poción de vida");
            gremio.usarItem("Pergamino de fuego");
            gremio.mostrarInventario();

            System.out.println("\n=== Habilidades únicas ===");
            gremio.registrarHabilidad("Curación");
            gremio.registrarHabilidad("Magia oscura");
            gremio.registrarHabilidad("Curación");
            gremio.mostrarHabilidades();

            System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
            System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

            System.out.println("\n=== Resumen del gremio ===");
            gremio.mostrarRoster();
            gremio.mostrarCola();
            gremio.mostrarInventario();
            gremio.mostrarHabilidades();

            PersistenciaGremio persistencia = new PersistenciaGremio();

            System.out.println("\n=== Guardar roster ===");
            ArrayList<Personaje> roster = new ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100));
            roster.add(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            roster.add(new Guerrero("Thorin", 9, 400, "Hacha", 80));
            persistencia.guardarRoster(roster);

            System.out.println("\n=== Roster cargado desde archivo ===");
            ArrayList<String> lineasRoster = persistencia.cargarRoster();
            for (String linea : lineasRoster) {
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0] +
                                   " | Nivel: " + partes[1] +
                                   " | Vida: " + partes[2]);
            }

            System.out.println("\n=== Guardar y cargar inventario ===");
            HashMap<String, Integer> inventario = new HashMap<>();
            inventario.put("Poción de vida", 8);
            inventario.put("Flecha élfica", 30);
            inventario.put("Pergamino de fuego", 3);
            persistencia.guardarInventario(inventario);

            HashMap<String, Integer> inventarioCargado = persistencia.cargarInventario();
            System.out.println("\n=== Inventario cargado desde archivo ===");
            for (Map.Entry<String, Integer> entrada : inventarioCargado.entrySet()) {
                System.out.println(entrada.getKey() + " → " + entrada.getValue());
            }

            System.out.println("\n=== Escribir entradas en la bitácora ===");
            persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
            persistencia.agregarEntradaBitacora("Legolas sin flechas — no pudo atacar");
            persistencia.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");
            persistencia.mostrarBitacora();

            File carpeta = new File("datos_gremio");
            System.out.println("\n=== Archivos en datos_gremio/ ===");
            File[] archivos = carpeta.listFiles();
            if (archivos == null) {
                throw new IOException("No se pudieron listar los archivos de datos_gremio.");
            }
            for (File archivo : archivos) {
                System.out.println(archivo.getName() +
                                   " (" + archivo.length() + " bytes)");
            }
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
        try {
            ejecutarTorneo();
            demostrarContador();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La ejecución fue interrumpida.");
        }
    }

    private static void ejecutarTorneo() throws InterruptedException {
        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400, "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90);

        Thread h1 = new Thread(
                new CombateConcurrente("Campo-1", s1, m1, tabla));
        Thread h2 = new Thread(
                new CombateConcurrente("Campo-2", l1, t1, tabla));
        Thread h3 = new Thread(
                new CombateConcurrente("Campo-3", b1, k1, tabla));
        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal");

        h1.start();
        h2.start();
        h3.start();
        monitor.start();

        h1.join();
        h2.join();
        h3.join();
        monitor.join();

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();
    }

    private static void demostrarContador() throws InterruptedException {
        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementar();
                }
            });
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Sin sync  — esperado: 5000 | real: "
                + contador.getContador());

        contador.resetear();
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementarSeguro();
                }
            });
            hilos[i].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Con sync  — esperado: 5000 | real: "
                + contador.getContador());
    }
}
