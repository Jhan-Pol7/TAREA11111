package seccion6;

import java.util.ArrayList;

interface Pagable {
    double calcularMonto();
    boolean procesarPago();
}

interface Imprimible {
    void imprimir();
    String formatear();
}

interface Exportable {
    String exportar(String formato);
    String getFormato();
}

class Factura implements Pagable, Imprimible, Exportable {
    private String numero;
    private double monto;
    private String cliente;

    public Factura(String numero, String cliente, double monto) {
        this.numero = numero;
        this.cliente = cliente;
        this.monto = monto;
    }


    @Override
    public double calcularMonto() {
        return monto;
    }

    @Override
    public boolean procesarPago() {
        System.out.println("Procesando pago de $" + monto + " para " + cliente);
        return true;
    }

    @Override
    public void imprimir() {
        System.out.println(formatear());
    }

    @Override
    public String formatear() {
        return "Factura numero " + numero + "_Cliente: " + cliente + "_Monto: $" + monto;
    }


    @Override
    public String exportar(String formato) {
        return "Exportando factura" + numero + " a formato: " + formato;
    }

    @Override
    public String getFormato() {
        return "PDF";
    }
}

public class SistemaPagos {
    public static void main(String[] args) {

        Factura f1 = new Factura("F001", "Cliente1", 1500);
        Factura f2 = new Factura("F002", "Cliente2", 2300);

        ArrayList<Pagable> pagos = new ArrayList<>();
        pagos.add(f1);
        pagos.add(f2);

        System.out.println("Procesando pagos:");
        for (Pagable p : pagos) p.procesarPago();

        ArrayList<Imprimible> impresiones = new ArrayList<>();
        impresiones.add(f1);
        impresiones.add(f2);

        System.out.println("\nImprimiendo facturas");
        for (Imprimible i : impresiones) i.imprimir();

        ArrayList<Exportable> exportaciones = new ArrayList<>();
        exportaciones.add(f1);
        exportaciones.add(f2);

        System.out.println("\nExportando facturas");
        for (Exportable e : exportaciones) {
            System.out.println(e.exportar(e.getFormato()));
        }
    }
}