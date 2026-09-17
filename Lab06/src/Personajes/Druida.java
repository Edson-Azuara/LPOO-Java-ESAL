package Personajes;
import Skills.Hechicero;
import Skills.Sanador;

public class Druida extends Personaje implements Hechicero, Sanador<Personaje>{
    private int mana;
    private int poderCuracion;
    private int VinculoConLaNaturaleza; 
    
    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, int VinculoConLaNaturaleza) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.VinculoConLaNaturaleza = VinculoConLaNaturaleza;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] invoca raíces del bosque. Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + VinculoConLaNaturaleza;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (mana >= 10) { // Supongamos que curar cuesta 10 de mana
            aliado.recibirDanio(-poderCuracion);
            mana -= 10;
            System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
        } else {
            System.out.println(nombre + " no tiene suficiente mana para curar.");
        }
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    @Override
    public void lanzarHechizo() {
        if (mana >= 20) {
            System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + (mana - 20) + ")");
            mana -= 20;
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo.");
        }
    }

    @Override
    public int getMana() {
        return mana;
    }
    
    public int getVinculoConLaNaturaleza() {
        return VinculoConLaNaturaleza;
    }

}
