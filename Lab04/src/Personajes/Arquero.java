package Personajes;

public class Arquero extends Personaje {
    private int flechasDisponibles;
    private String tipoArco;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida, int flechasDisponibles, String tipoArco, int precision) {
        super(nombre, nivel, puntosVida, false);
        this.flechasDisponibles = flechasDisponibles;
        this.tipoArco = tipoArco;
        this.precision = precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public void atacar() {
        if (flechasDisponibles > 0) {
            super.atacar();
            System.out.println("[" + getNombre() + "] dispara una flecha con su " + tipoArco + " causando [" + precision + "] de daño!");
            flechasDisponibles--;
        } else {
            System.out.println("[" + getNombre() + "] no tiene flechas disponibles para atacar.");
        }
    }

    @Override
    public String defender() {
        System.out.println("[" + getNombre() + "] se repliega para esquivar el ataque.");
        return "[" + getNombre() + "] se repliega para esquivar el ataque.";
    }

    @Override
    public String toString() {
        return super.toString() + " Arquero [flechasDisponibles=" + flechasDisponibles + ", tipoArco=" + tipoArco + ", precision=" + precision + "]";
    }


}
