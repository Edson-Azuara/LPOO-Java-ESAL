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
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        mana -= 10;
        System.out.println("[" + nombre + "] invoca raíces del bosque y ataca con furia natural.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + VinculoConLaNaturaleza;
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException(
                "curarAliado",
                "No se puede curar a un personaje derrotado"
            );
        }
        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        aliado.puntosVida += poderCuracion;
        aliado.estaVivo = true;
        mana -= 10;
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
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
