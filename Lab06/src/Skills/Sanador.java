package Skills;

public interface Sanador<Personaje> {
    void curarAliado(Personaje aliado);
    int getPoderCuracion();
}
