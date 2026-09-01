import Personajes.Arquero;
import Personajes.Guerrero;
import Personajes.Mago;

public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Mizraim", 7, 100, 20, "Hierro");
        Mago mago = new Mago("Gandalf", 10, 80, 30, "Fuego");
        Arquero arquero = new Arquero("Raquel", 9, 100, 64, "Arco Largo", 25);

        guerrero.atacar();
        guerrero.defender();

        mago.atacar();
        mago.defender();

        arquero.atacar();
        arquero.defender();

        guerrero.recibirDanio(50);
        mago.recibirDanio(80);
        guerrero.recibirDanio(50);

        while (guerrero.isEstaVivo() && mago.isEstaVivo() && arquero.isEstaVivo()) {
            guerrero.atacar();
            mago.recibirDanio(guerrero.getNivel() * 5);

            if (!mago.isEstaVivo()) {
                break;
            }

            mago.atacar();
            guerrero.recibirDanio(mago.getMana() * 3);

            if (!guerrero.isEstaVivo()) {
                break;
            }

            arquero.atacar();
            guerrero.recibirDanio(arquero.getPrecision() * 2);

            if (!guerrero.isEstaVivo()) {
                break;
            }
        }

        if (guerrero.isEstaVivo()) {
            System.out.println("El ganador es: " + guerrero.getNombre());
        } else if (mago.isEstaVivo()) {
            System.out.println("El ganador es: " + mago.getNombre());
        } else if (arquero.isEstaVivo()) {
            System.out.println("El ganador es: " + arquero.getNombre());
        } else {
            System.out.println("Todos los personajes han sido derrotados.");
        }

        System.out.println(guerrero.toString());
        System.out.println(mago.toString());
        System.out.println(arquero.toString());
    }

    public static void mostrarTablaEstados(Guerrero guerrero, Mago mago, Arquero arquero) {
        System.out.println("Tabla de Estados Finales:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-10s %-10s %-15s %-10s%n", "Nombre", "Nivel", "Puntos de Vida", "Estado");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-10s %-10d %-15d %-10s%n", guerrero.getNombre(), guerrero.getNivel(), guerrero.getPuntosVida(), guerrero.isEstaVivo() ? "Vivo" : "Derrotado");
        System.out.printf("%-10s %-10d %-15d %-10s%n", mago.getNombre(), mago.getNivel(), mago.getPuntosVida(), mago.isEstaVivo() ? "Vivo" : "Derrotado");
        System.out.printf("%-10s %-10d %-15d %-10s%n", arquero.getNombre(), arquero.getNivel(), arquero.getPuntosVida(), arquero.isEstaVivo() ? "Vivo" : "Derrotado");
        System.out.println("-------------------------------------------------");
    }

}

