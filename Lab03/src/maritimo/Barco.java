package maritimo;

import vehiculos.Vehiculo;

public class Barco extends Vehiculo {
    private String tipoCasco;
    private double tonelajeMaximo;

    public Barco(String marca, String modelo, int anio, double velocidadMax,
                 String tipoCasco, double tonelajeMaximo) {
        super(marca, modelo, anio, velocidadMax);
        this.tipoCasco = tipoCasco;
        this.tonelajeMaximo = tonelajeMaximo;
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public void setTipoCasco(String tipoCasco) {
        this.tipoCasco = tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo >= 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: el tonelaje máximo no puede ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "Barco{" +
                "vehiculo=" + super.toString() +
                ", tipoCasco='" + tipoCasco + '\'' +
                ", tonelajeMaximo=" + tonelajeMaximo +
                '}';
    }
}
