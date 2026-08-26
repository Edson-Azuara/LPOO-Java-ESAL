package vehiculos;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMax = velocidadMax;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: el año debe estar entre 1885 y 2100.");
        }
    }

    public void setVelocidadMax(double velocidadMax) {
        if (velocidadMax > 0) {
            this.velocidadMax = velocidadMax;
        } else {
            System.out.println("Error: la velocidad máxima debe ser mayor que 0.");
        }
    }

    public void describir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", velocidadMax=" + velocidadMax +
                '}';
    }
}
