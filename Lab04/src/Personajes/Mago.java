package Personajes;

public class Mago extends Personaje {
    private int mana;
    private String escuelaMagia;

    public Mago(String nombre, int nivel, int puntosVida, int mana, String escuelaMagia) {
        super(nombre, nivel, puntosVida, true);
        this.mana = mana;
        this.escuelaMagia = escuelaMagia;
    }

    public int getMana() {
        return mana;
    }

    public String getEscuelaMagia() {
        return escuelaMagia;
    }
    
    @Override
    public void atacar() {
        super.atacar();
        System.out.println("[" + getNombre() + "] lanza un hechizo de " + escuelaMagia + " causando [" + mana + "] de daño!");
    }

    @Override
    public String defender() {
        System.out.println("[" + getNombre() + "] se protege con un escudo mágico de " + escuelaMagia + ".");
        return "[" + getNombre() + "] se protege con un escudo mágico de " + escuelaMagia + ".";
    }

    
    @Override
    public String toString() {
        return super.toString() + " Mago [mana=" + mana + ", escuelaMagia=" + escuelaMagia + "]";
    }




}
