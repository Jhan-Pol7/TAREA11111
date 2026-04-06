package seccion5;

abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public String descripcion() {
        return color + " Area: " + calcularArea() + "Perimetro: " + calcularPerimetro();
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Rectangulo extends Figura {
    private double ancho, alto;

    public Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }
}

class Triangulo extends Figura {
    private double lado1, lado2, lado3;

    public Triangulo(String color, double lado1, double lado2, double lado3) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}

public class SistemaFiguras {
    public static void main(String[] args) {

        Figura c = new Circulo("Rojo", 5);
        Figura r = new Rectangulo("Azul", 4, 6);
        Figura t = new Triangulo("Verde", 3, 4, 5);

        Figura[] figuras = {c, r, t};

        System.out.println("Figuras geometricas");
        for (Figura f : figuras) {
            System.out.println(f.descripcion());
        }
    }
}