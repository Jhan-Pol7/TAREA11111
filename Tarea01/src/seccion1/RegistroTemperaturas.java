package seccion1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util

public class RegistroTemperaturas {
    private ArrayList<Double> temperaturas;

    public RegistroTemperaturas(ArrayList<Double> temps) {
        this.temperaturas = temps;
    }

    public double promedio() {
        return temperaturas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double maximo() {
        return Collections.max(temperaturas);
    }

    public double minimo() {
        return Collections.min(temperaturas);
    }

    public long contarDiasSobre30() {
        return temperaturas.stream().filter(t -> t > 30).count();
    }

    public String tendencia() {
        if (temperaturas.size() < 2) return "Sin tendencia";
        return temperaturas.get(temperaturas.size() - 1) > temperaturas.get(0) ? "Subiendo" : "Bajando";
    }

    public static void main(String[] args) {
        ArrayList<Double> temps = new ArrayList<>(Arrays.asList(28.5, 31.2, 29.8, 33.1, 30.5, 27.9, 35.0));
        RegistroTemperaturas registro = new RegistroTemperaturas(temps);

        System.out.println("Registro de temperaturas semanales");
        System.out.println("Temperaturas : " + temps);
        System.out.println("Promedio: " + registro.promedio());
        System.out.println("Máximo: " + registro.maximo());
        System.out.println("Mínimo: " + registro.minimo());
        System.out.println("Días sobre 30°C: " + registro.contarDiasSobre30());
        System.out.println("Tendencia: " + registro.tendencia());
    }
}