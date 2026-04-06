package seccion5;

import java.util.ArrayList;

abstract class Envio {
    protected String origen;
    protected String destino;
    protected double peso;
    protected double distanciaKm;
    protected String estado = "Preparando";

    public Envio(String origen, String destino, double peso, double distanciaKm) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.distanciaKm = distanciaKm;
    }

    public abstract double calcularCosto();
    public abstract int calcularTiempoHoras();

    public String generarGuia() {
        return "Envío __ Origen: " + origen + "__Destino: " + destino +
                " Costo: $" + calcularCosto() +
                " Tiempo: " + calcularTiempoHoras() + "h" +
                " Estado: " + estado;
    }
}

class EnvioTerrestre extends Envio {

    public EnvioTerrestre(String origen, String destino, double peso, double distanciaKm) {
        super(origen, destino, peso, distanciaKm);
    }

    @Override
    public double calcularCosto() {
        return peso * distanciaKm * 0.02; // costo por kg*km
    }

    @Override
    public int calcularTiempoHoras() {
        return (int)(distanciaKm / 60); // velocidad promedio 60 km/h
    }
}

class EnvioAereo extends Envio {

    public EnvioAereo(String origen, String destino, double peso, double distanciaKm) {
        super(origen, destino, peso, distanciaKm);
    }

    @Override
    public double calcularCosto() {
        return peso * distanciaKm * 0.05; // costo por kg*km más caro
    }

    @Override
    public int calcularTiempoHoras() {
        return (int)(distanciaKm / 800); // velocidad promedio 800 km/h
    }
}

class EnvioMaritimo extends Envio {

    public EnvioMaritimo(String origen, String destino, double peso, double distanciaKm) {
        super(origen, destino, peso, distanciaKm);
    }

    @Override
    public double calcularCosto() {
        return peso * distanciaKm * 0.01; // más barato por kg*km
    }

    @Override
    public int calcularTiempoHoras() {
        return (int)(distanciaKm / 30); // velocidad promedio 30 km/h
    }
}

public class SistemaEnvios {
    public static void main(String[] args) {
        ArrayList<Envio> envios = new ArrayList<>();

        envios.add(new EnvioTerrestre("Lima", "Cusco", 100, 1100));
        envios.add(new EnvioAereo("Madrid", "Barcelona", 50, 620));
        envios.add(new EnvioMaritimo("Valparaíso", "Callao", 200, 3000));

        System.out.println("Generación de guías de envio");
        for (Envio e : envios) {
            System.out.println(e.generarGuia());
        }
    }
}