import Animales.Canario;
import Animales.Gato;
import Animales.Perro;

public class App {
    public static void main(String[] args) throws Exception {
        Perro perro = new Perro("Firulais", 5, 20.0, "Labrador", true);
        perro.comer();
        perro.dormir();
        perro.ladrar();
        perro.buscarPelota();
        System.out.println(perro.toString());

        Gato gato = new Gato("Garfiel", 2, 4.0, "Naranja", true);
        gato.comer();
        gato.dormir();
        gato.maullar();
        gato.arañar();
        System.out.println(gato.toString());

        Canario canario = new Canario("Pauino", 2, 0.03, "Amarillo", true);
        canario.comer();
        canario.dormir();
        canario.cantar();
        canario.volar();
        System.out.println(canario.toString());
    }
}
