package Personajes;

public class Mago extends Personaje {
    private int mana;
    private String escuelaMagia;
    private int nivel;

    public Mago(String nombre, int nivel, int puntosVida, int mana, String escuelaMagia) {
        super(nombre, nivel, puntosVida, true);
        this.mana = mana;
        this.escuelaMagia = escuelaMagia;
        this.nivel = nivel;
    }

    public int getMana() {
        return mana;
    }

    public String getEscuelaMagia() {
        return escuelaMagia;
    }

    public int getNivel() {
        return nivel;
    }
    
    public int calcularDanio() {
        return mana * nivel;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza una bola de fuego causando " + mana + " de daño mágico!");
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
