package Animales;

public class Canario extends Animal {
	private String colorPlumaje;
	private boolean cantaEnJaula;

	public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) {
		super(nombre, edad, peso);
		this.colorPlumaje = colorPlumaje;
		this.cantaEnJaula = cantaEnJaula;
	}

	public void cantar() {
		System.out.println(getNombre() + " está cantando.");
	}

	public void volar() {
		System.out.println(getNombre() + " está volando.");
	}

	@Override
	public String toString() {
		return "Canario{" +
				"colorPlumaje='" + colorPlumaje + '\'' +
				", cantaEnJaula=" + cantaEnJaula +
				", nombre='" + getNombre() + '\'' +
				", edad=" + getEdad() +
				", peso=" + getPeso() +
				'}';
	}
}
