package Personajes;

public class Arquero extends Personaje {
    private int flechasDisponibles;
    private String tipoArco;
    private int precision;
    private String tipoflecha;

    public Arquero(String nombre, int nivel, int puntosVida, int flechasDisponibles, String tipoArco, int precision, String tipoflecha) {
        super(nombre, nivel, puntosVida);
        this.flechasDisponibles = flechasDisponibles;
        this.tipoArco = tipoArco;
        this.precision = precision;
        this.tipoflecha = tipoflecha;
    }

    public Arquero(String string, int i, int j, String string2, int k, int l) {
        super(string, i, j);
        this.flechasDisponibles = k;
        this.tipoArco = string2;
        this.precision = l;
        this.tipoflecha = "normal";
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

    public String getTipoflecha() {
        return tipoflecha;
    }

    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    @Override
    public void atacar() throws RpgException {

    if (!isEstaVivo()) {
        throw new PersonajeDerrotadoException(getNombre());
    }

    if (flechasDisponibles <= 0) {
        throw new RecursoInsuficienteException("flechas", flechasDisponibles);
    }

    flechasDisponibles--;
    System.out.println("[" + getNombre() + "] dispara una flecha. " +
                       "Flechas restantes: " + flechasDisponibles);
    }

    public String defender() {
        System.out.println("[" + getNombre() + "] se repliega para esquivar el ataque.");
        return "[" + getNombre() + "] se repliega para esquivar el ataque.";
    }

    @Override
    public String toString() {
        return super.toString() + " Arquero [flechasDisponibles=" + flechasDisponibles + ", tipoArco=" + tipoArco + ", precision=" + precision + ", tipoflecha=" + tipoflecha + "]";
    }
}