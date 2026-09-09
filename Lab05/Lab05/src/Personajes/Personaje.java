package Personajes;

public class Personaje implements Skills.Combatiente {
    private String nombre;
    private int nivel;
    private int PuntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int PuntosVida, boolean estaVivo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.PuntosVida = PuntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return PuntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
        }

    @Override
    public String defender() {
        return "El personaje " + nombre + " está defendiendo.";
        }

    public void recibirDanio(int danio) {
        PuntosVida -= danio;

        if (PuntosVida <= 0) {
            PuntosVida = 0;
            estaVivo = false;
        }

        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + PuntosVida);

        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public int calcularDanio() {
        throw new UnsupportedOperationException("Unimplemented method 'calcularDanio'");
    }





    public void mostrarestado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + PuntosVida);
        System.out.println("Estado: " + (estaVivo ? "Vivo" : "Derrotado"));
    }

    public void mostrarestado(boolean detallado) {
        if (detallado) {
            System.out.println("Nombre: " + nombre);
            System.out.println("Nivel: " + nivel);
            System.out.println("Puntos de Vida: " + PuntosVida);
            System.out.println("Estado: " + (estaVivo ? "Vivo" : "Derrotado"));
        } else {
            System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Estado: " + (estaVivo ? "Vivo" : "Derrotado"));
        }
    }


    public void mostrarEstado(String formato) {
        if (formato.equalsIgnoreCase("detallado")) {
            mostrarestado(true);
        } else if (formato.equalsIgnoreCase("resumido")) {
            mostrarestado(false);
        } else {
            System.out.println("Formato no reconocido. Mostrando estado resumido por defecto.");
            mostrarestado(false);
        }
    }


    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", nivel=" + nivel + ", PuntosVida=" + PuntosVida + ", estaVivo=" + estaVivo + "]";
    }




}
