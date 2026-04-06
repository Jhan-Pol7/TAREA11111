package seccion7;

enum Operacion {
    SUMA("+") {
        @Override
        public double calcular(double a, double b) { return a + b; }
    },
    RESTA("-") {
        @Override
        public double calcular(double a, double b) { return a - b; }
    },
    MULTIPLICACION("*") {
        @Override
        public double calcular(double a, double b) { return a * b; }
    },
    DIVISION("/") {
        @Override
        public double calcular(double a, double b) {
            if (b == 0) throw new ArithmeticException("División por cero");
            return a / b;
        }
    };

    private String simbolo;
    Operacion(String s) { this.simbolo = s; }
    public String getSimbolo() { return simbolo; }
    public abstract double calcular(double a, double b);
}

class CalculadoraConEnum {
    public double operar(double a, double b, Operacion op) {
        return op.calcular(a, b);
    }
}

public class CalculadoraConEnumDemo {
    public static void main(String[] args) {
        CalculadoraConEnum calc = new CalculadoraConEnum();

        double x = 10, y = 5;

        System.out.println("SUMA: " + calc.operar(x, y, Operacion.SUMA));
        System.out.println("RESTA: " + calc.operar(x, y, Operacion.RESTA));
        System.out.println("MULTIPLICACION: " + calc.operar(x, y, Operacion.MULTIPLICACION));
        System.out.println("DIVISION: " + calc.operar(x, y, Operacion.DIVISION));

        try {
            System.out.println("DIVISION por cero: " + calc.operar(x, 0, Operacion.DIVISION));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}