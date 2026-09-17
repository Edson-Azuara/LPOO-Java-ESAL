package Personajes;
import Skills.Sanador;

public class Bardo extends Personaje implements Sanador<Personaje> {
    private int poderCuracion;
    public int carisma;
    private String instrumentoMusical;
    private String cancionFavorita;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, int carisma, String instrumentoMusical, String cancionFavorita) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.carisma = carisma;
        this.instrumentoMusical = instrumentoMusical;
        this.cancionFavorita = cancionFavorita;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] aturde con su laúd. Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return nivel * 15 + carisma;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.recibirDanio(-poderCuracion);
        System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String InstrumentoMusical() {
        return instrumentoMusical;
    }

    public String getCancionFavorita() {
        return cancionFavorita;
    }

}
