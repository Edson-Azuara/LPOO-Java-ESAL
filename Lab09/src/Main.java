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
    }
}
