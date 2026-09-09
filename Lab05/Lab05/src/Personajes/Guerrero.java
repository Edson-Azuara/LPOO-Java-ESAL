package Personajes;

public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;
    private int nivel;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura, String nivelStr) {
        super(nombre, nivel, puntosVida, true);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.nivel = nivel;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + fuerza + " de daño!");
    }

    @Override
    public String defender() {
        System.out.println("[" + getNombre() + "] bloquea con su armadura de [" + armadura + "].");
        return "[" + getNombre() + "] bloquea con su armadura de [" + armadura + "].";
    }

    @Override
    public String toString() {
        return super.toString() + " Guerrero [fuerza=" + fuerza + ", armadura=" + armadura + "]";
    }

    public int calcularDanio() {
        return fuerza * nivel;
    }


    public void entrenar() {
        fuerza += 5;
        System.out.println("[" + getNombre() + "] ha entrenado y su fuerza ha aumentado a [" + fuerza + "].");
    }

    public void entrenar(int sesiones) {
        fuerza += 5 * sesiones;
        System.out.println("[" + getNombre() + "] ha entrenado durante [" + sesiones + "] sesiones y su fuerza ha aumentado a [" + fuerza + "].");
    }


    public void entrenar(int sesiones, boolean intensivo) {
        if (intensivo) {
            fuerza += 10 * sesiones;
            System.out.println("[" + getNombre() + "] ha entrenado intensivamente durante [" + sesiones + "] sesiones y su fuerza ha aumentado a [" + fuerza + "].");
        } else {
            entrenar(sesiones);
        }
    }



}
