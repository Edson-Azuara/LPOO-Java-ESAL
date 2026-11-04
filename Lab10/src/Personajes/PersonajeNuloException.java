package Personajes;

public class PersonajeNuloException extends RpgException {

    public PersonajeNuloException(String metodo) {
        super("Se pasó un personaje nulo al método '" +
              metodo + "'. Esto es un error de programación.");
    }
}