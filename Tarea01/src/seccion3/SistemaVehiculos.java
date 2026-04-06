package seccion3;

import java.util.ArrayList;

class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int capacidad;
    protected double consumoKmLitro;

    public Vehiculo(String marca, String modelo, int capacidad, double consumoKmLitro) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.consumoKmLitro = consumoKmLitro;
    }

    public double costoViaje(double km, double precioLitro) {
        return (km / consumoKmLitro) * precioLitro;
    }

    public String descripcion() {
        return marca + " " + modelo + "Capacidad: " + capacidad;
    }
}

class Automovil extends Vehiculo {
    private int numPuertas;

    public Automovil(String marca, String modelo, int capacidad, double consumoKmLitro, int numPuertas) {
        super(marca, modelo, capacidad, consumoKmLitro);
        this.numPuertas = numPuertas;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + "Puertas: " + numPuertas;
    }
}

class Autobus extends Vehiculo {
    private int pisos;

    public Autobus(String marca, String modelo, int pisos, double consumoKmLitro) {
        super(marca, modelo, pisos * 40, consumoKmLitro); // cada piso = 40 pasajeros
        this.pisos = pisos;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + "Pisos: " + pisos;
    }
}

class Motocicleta extends Vehiculo {
    private int cilindrada;

    public Motocicleta(String marca, String modelo, int capacidad, double consumoKmLitro, int cilindrada) {
        super(marca, modelo, capacidad, consumoKmLitro);
        this.cilindrada = cilindrada;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + "Cilindrada: " + cilindrada + "c3";
    }
}

public class SistemaVehiculos {
    public static void main(String[] args) {
        ArrayList<Vehiculo> flota = new ArrayList<>();

        flota.add(new Automovil("Toyota", "Corolla", 5, 15, 4));
        flota.add(new Autobus("Mercedes", "Tourismo", 2, 5)); // 2 pisos
        flota.add(new Motocicleta("Honda", "CBR500", 2, 25, 500));

        double km = 120;
        double precioLitro = 5.0;

        System.out.println("Flota de vehículos");
        for (Vehiculo v : flota) {
            System.out.println(v.descripcion() + "Costo viaje " + km + " km: $" + v.costoViaje(km, precioLitro));
        }
    }
}