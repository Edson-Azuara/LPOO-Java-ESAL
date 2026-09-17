package Personajes;
import Skills.Hechicero;

public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int poderOscuro;
    private int AlmasRecolectadas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int poderOscuro, int AlmasRecolectadas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderOscuro = poderOscuro;
        this.AlmasRecolectadas = AlmasRecolectadas;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] drena la esencia vital. Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + poderOscuro;
    }

    public void recolectarAlma() {
        AlmasRecolectadas++;
        System.out.println(nombre + " ha recolectado un alma. Total de almas: " + AlmasRecolectadas);
    }

    public void lanzarHechizoOscuro() {
        if (mana >= 20) { // Supongamos que lanzar un hechizo oscuro cuesta 20 de mana
            System.out.println(nombre + " lanza: ¡Maldición de decadencia! (maná: " + (mana - 20) + ")");
            mana -= 20;
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo oscuro.");
        }
    }

    public int getMana() {
        return mana;
    }

    public int getPoderOscuro() {
        return poderOscuro;
    }

    @Override
    public void lanzarHechizo() {
        lanzarHechizoOscuro();
    }

    @Override
    public int getVinculoConLaNaturaleza() {
        throw new UnsupportedOperationException("Unimplemented method 'getVinculoConLaNaturaleza'");
    }

}
