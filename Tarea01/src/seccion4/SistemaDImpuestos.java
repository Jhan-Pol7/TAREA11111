package seccion4;

import java.util.ArrayList;

class CalculadoraImpuesto {
    protected String pais;

    public CalculadoraImpuesto(String pais) {
        this.pais = pais;
    }

    public double calcularImpuesto(double monto) {
        return 0;
    }

    public String getDescripcion() {
        return "Calculadora de impuestos de " + pais;
    }
}

class ImpuestoMexico extends CalculadoraImpuesto {

    public ImpuestoMexico() {
        super("México");
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * 0.16;
    }

    @Override
    public String getDescripcion() {
        return "IVA México 16%";
    }
}

class ImpuestoEspana extends CalculadoraImpuesto {

    public ImpuestoEspana() {
        super("España");
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * 0.21;
    }

    @Override
    public String getDescripcion() {
        return "IVA España 21%";
    }
}

class ImpuestoUSA extends CalculadoraImpuesto {
    private double salesTax;

    public ImpuestoUSA(double salesTax) {
        super("USA");
        this.salesTax = salesTax;
    }

    @Override
    public double calcularImpuesto(double monto) {
        return monto * salesTax;
    }

    @Override
    public String getDescripcion() {
        return "Sales Tax USA " + (salesTax * 100) + "%";
    }
}

public class SistemaDImpuestos {
    public static void main(String[] args) {
        ArrayList<CalculadoraImpuesto> calculadoras = new ArrayList<>();

        calculadoras.add(new ImpuestoMexico());
        calculadoras.add(new ImpuestoEspana());
        calculadoras.add(new ImpuestoUSA(0.08)); // 8% Sales Tax

        double monto = 1000;

        System.out.println("Cálculo de impuestos");
        for (CalculadoraImpuesto c : calculadoras) {
            System.out.println(c.getDescripcion() + "_Monto: $" + monto + " _impuesto: $" + c.calcularImpuesto(monto));
        }
    }
}