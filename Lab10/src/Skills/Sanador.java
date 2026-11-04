package Skills;

import Personajes.Personaje;
import Personajes.RpgException;

public interface Sanador<Personaje> {
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();
}
