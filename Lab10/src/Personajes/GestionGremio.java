package Personajes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    @SuppressWarnings("unused")
    private java.util.LinkedList<String> colaTurnos;
    @SuppressWarnings("unused")
    private java.util.HashMap<String, Integer> inventario;
    @SuppressWarnings("unused")
    private java.util.HashSet<String> habilidades;

    public GestionGremio() {
        roster      = new ArrayList<>();
        colaTurnos  = new java.util.LinkedList<>();
        inventario  = new java.util.HashMap<>();
        habilidades = new java.util.HashSet<>();
    }

    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────

    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();   // forma segura de eliminar durante iteración
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {       // for-each
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                               " | Nivel: " + p.getNivel() +
                               " | Vida: " + p.getPuntosVida());
        }
    }


    // ──────────────────────────────────────────
// SECCIÓN 2 — LinkedList: cola de turnos
// ──────────────────────────────────────────

public void encolarSolicitante(String nombre) {
    colaTurnos.addLast(nombre);    // agrega al final
    System.out.println("[Cola] " + nombre +
                       " en posición " + colaTurnos.size());
}

public String atenderSiguiente() {
    if (colaTurnos.isEmpty()) {
        System.out.println("[Cola] No hay solicitantes en espera.");
        return null;
    }
    String atendido = colaTurnos.removeFirst();   // saca del frente
    System.out.println("[Cola] Atendiendo a: " + atendido);
    return atendido;
}

public void mostrarCola() {
    System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
    int pos = 1;
    for (String nombre : colaTurnos) {    // for-each sobre LinkedList
        System.out.println(pos++ + ". " + nombre);
    }
}

public void agregarItem(String item, int cantidad) {
    int cantidadActual = inventario.getOrDefault(item, 0);
    int nuevaCantidad = cantidadActual + cantidad;
    inventario.put(item, nuevaCantidad);
    System.out.println("[Inventario] " + item + ": " + nuevaCantidad);
}

public void usarItem(String item) {
    Integer cantidad = inventario.get(item);
    if (cantidad == null) {
        System.out.println("[Inventario] Error: no existe el item " + item + ".");
        return;
    }
    if (cantidad > 0) {
        int nuevaCantidad = cantidad - 1;
        if (nuevaCantidad == 0) {
            inventario.remove(item);
        } else {
            inventario.put(item, nuevaCantidad);
        }
        System.out.println("[Inventario] " + item + ": " + nuevaCantidad);
    }
}

public void mostrarInventario() {
    System.out.println("\n=== Inventario ===");
    for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}

public void registrarHabilidad(String habilidad) {
    if (habilidades.add(habilidad)) {
        System.out.println("[Habilidades] " + habilidad + " registrada.");
    } else {
        System.out.println("[Habilidades] " + habilidad + " ya estaba registrada.");
    }
}

public boolean tieneHabilidad(String habilidad) {
    return habilidades.contains(habilidad);
}

public void mostrarHabilidades() {
    System.out.println("\n=== Habilidades ===");
    for (String habilidad : habilidades) {
        System.out.println(habilidad);
    }
}

}

