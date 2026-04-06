package seccion3;

import java.util.ArrayList;

class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;

    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}

class EmpleadoFijo extends Empleado {
    private double bonificacion;

    public EmpleadoFijo(String nombre, String id, double salarioBase, double bonificacion) {
        super(nombre, id, salarioBase);
        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonificacion;
    }
}

class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double tarifaHora;

    public EmpleadoTemporal(String nombre, String id, double salarioBase, int horasTrabajadas, double tarifaHora) {
        super(nombre, id, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + horasTrabajadas * tarifaHora;
    }
}

class Gerente extends Empleado {
    private double bonoGerencial;
    private int empleadosACargo;

    public Gerente(String nombre, String id, double salarioBase, double bonoGerencial, int empleadosACargo) {
        super(nombre, id, salarioBase);
        this.bonoGerencial = bonoGerencial;
        this.empleadosACargo = empleadosACargo;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial + empleadosACargo * 50; // bono por empleados a cargo
    }
}

public class SistemaEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new EmpleadoFijo("Juan", "F001", 1000, 200));
        empleados.add(new EmpleadoTemporal("Ana", "T001", 500, 20, 15));
        empleados.add(new Gerente("Carlos", "G001", 2000, 500, 5));

        System.out.println("Nómina de empleados");
        for (Empleado e : empleados) {
            System.out.println("Nombre: " + e.getNombre() + "ID: " + e.getId() + "Salario: $" + e.calcularSalario());
        }
    }
}