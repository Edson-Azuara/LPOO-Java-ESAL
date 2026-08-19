package Animales;

public class Gato extends Animal {
	private String color;
	private boolean esInterior;

	public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
		super(nombre, edad, peso);
		this.color = color;
		this.esInterior = esInterior;
	}

	public void maullar() {
		System.out.println(getNombre() + " dice: ¡Miau miau!");
	}

	public void arañar() {
		System.out.println(getNombre() + " está arañando.");
	}

	@Override
	public String toString() {
		return "Gato{" +
				"color='" + color + '\'' +
				", esInterior=" + esInterior +
				", nombre='" + getNombre() + '\'' +
				", edad=" + getEdad() +
				", peso=" + getPeso() +
				'}';
	}
}
