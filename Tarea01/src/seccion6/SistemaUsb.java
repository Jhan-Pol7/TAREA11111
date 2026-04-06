package seccion6;

import java.util.ArrayList;

interface Conectable {
    void conectar();
    void desconectar();
    boolean estaConectado();
    String getNombreDispositivo();
}
class Teclado implements Conectable {
    private boolean conectado = false;
    private String nombre;

    public Teclado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void conectar() { conectado = true; }

    @Override
    public void desconectar() { conectado = false; }

    @Override
    public boolean estaConectado() { return conectado; }

    @Override
    public String getNombreDispositivo() { return "Teclado: " + nombre; }
}

class Mouse implements Conectable {
    private boolean conectado = false;
    private String nombre;

    public Mouse(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void conectar() { conectado = true; }

    @Override
    public void desconectar() { conectado = false; }

    @Override
    public boolean estaConectado() { return conectado; }

    @Override
    public String getNombreDispositivo() { return "Mouse: " + nombre; }
}

class Impresora implements Conectable {
    private boolean conectado = false;
    private String nombre;

    public Impresora(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void conectar() { conectado = true; }

    @Override
    public void desconectar() { conectado = false; }

    @Override
    public boolean estaConectado() { return conectado; }

    @Override
    public String getNombreDispositivo() { return "Impresora: " + nombre; }
}

class MemoriaUSB implements Conectable {
    private boolean conectado = false;
    private String nombre;

    public MemoriaUSB(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void conectar() { conectado = true; }

    @Override
    public void desconectar() { conectado = false; }

    @Override
    public boolean estaConectado() { return conectado; }

    @Override
    public String getNombreDispositivo() { return "USB: " + nombre; }
}

class Computadora {
    private ArrayList<Conectable> perifericos = new ArrayList<>();

    public void agregarDispositivo(Conectable dispositivo) {
        perifericos.add(dispositivo);
    }

    public void mostrarEstado() {
        System.out.println("Estado de los periféricos");
        for (Conectable c : perifericos) {
            System.out.println(c.getNombreDispositivo() + "Conectado: " + c.estaConectado());
        }
    }

    public void conectarTodos() {
        for (Conectable c : perifericos) c.conectar();
    }

    public void desconectarTodos() {
        for (Conectable c : perifericos) c.desconectar();
    }
}

public class SistemaUSB {
    public static void main(String[] args) {
        Computadora pc = new Computadora();

        Teclado t1 = new Teclado("Teclado1");
        Mouse m1 = new Mouse("Mouse1");
        Impresora i1 = new Impresora("Impresora1");
        MemoriaUSB usb1 = new MemoriaUSB("USB1");

        pc.agregarDispositivo(t1);
        pc.agregarDispositivo(m1);
        pc.agregarDispositivo(i1);
        pc.agregarDispositivo(usb1);

        System.out.println("Inicialmente:");
        pc.mostrarEstado();

        System.out.println("\nConectando todos los dispositivos....");
        pc.conectarTodos();
        pc.mostrarEstado();

        System.out.println("\nDesconectando todos los dispositivos.....");
        pc.desconectarTodos();
        pc.mostrarEstado();
    }
}