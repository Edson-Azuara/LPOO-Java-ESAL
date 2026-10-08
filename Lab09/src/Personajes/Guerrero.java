package Personajes;

public class Guerrero extends Personaje {
    private final String arma;
    private final int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
    }

    public String getArma() {
        return arma;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        System.out.println("[" + getNombre() + "] ataca con " + arma + ".");
    }

    @Override
    public int calcularDanio() {
        return fuerza;
    }

    @Override
    public String toString() {
        return super.toString() + " Guerrero [arma=" + arma + ", fuerza=" + fuerza + "]";
    }
}
