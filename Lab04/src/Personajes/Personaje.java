package Personajes;
import Skills.Combatiente;

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
        System.out.println("El personaje " + nombre + " está atacando.");
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

        System.out.println("[" + nombre + "] recibe [" + danio + "] puntos de daño. Vida restante: [" + PuntosVida + "]");

        if (!estaVivo) {
            System.out.println("[" + nombre + "] ha sido derrotado.");
        }
    }

}
