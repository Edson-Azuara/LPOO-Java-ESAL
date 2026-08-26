package aereo;

import vehiculos.Vehiculo;

public class Avion extends Vehiculo {
    private int numMotores;
    private double altitudMaxima;

    public Avion(String marca, String modelo, int anio, double velocidadMax,
                 int numMotores, double altitudMaxima) {
        super(marca, modelo, anio, velocidadMax);
        this.numMotores = numMotores;
        this.altitudMaxima = altitudMaxima;
    }

    public int getNumMotores() {
        return numMotores;
    }

    public void setNumMotores(int numMotores) {
        this.numMotores = numMotores;
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima >= 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: la altitud máxima no puede ser negativa.");
        }
    }

    @Override
    public String toString() {
        return "Avion{" +
                "vehiculo=" + super.toString() +
                ", numMotores=" + numMotores +
                ", altitudMaxima=" + altitudMaxima +
                '}';
    }
}
