package seccion2;

import java.util.ArrayList;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;
    private ArrayList<String> movimientos;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.movimientos = new ArrayList<>();
        movimientos.add("Saldo inicial: $" + saldoInicial);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            movimientos.add("Depósito: +$" + monto);
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            movimientos.add("Retiro: -$" + monto);
            return true;
        }
        return false;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (retirar(monto)) {
            destino.depositar(monto);
            movimientos.add("Transferencia a " + destino.getTitular() + ": -$" + monto);
            destino.getMovimientos().add("Transferencia de " + this.getTitular() + ": +$" + monto);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan", "001", 500);
        CuentaBancaria cuenta2 = new CuentaBancaria("Mervin", "002", 300);

        cuenta1.depositar(200);
        cuenta1.retirar(100);
        cuenta1.transferir(cuenta2, 150);

        System.out.println(" Movimientos de Juan");
        for (String m : cuenta1.getMovimientos()) {
            System.out.println(m);
        }

        System.out.println("\nMovimientos de Mervin");
        for (String m : cuenta2.getMovimientos()) {
            System.out.println(m);
        }

        System.out.println("\nSaldo Juan: $" + cuenta1.getSaldo());
        System.out.println("Saldo Mervin: $" + cuenta2.getSaldo());
    }
}