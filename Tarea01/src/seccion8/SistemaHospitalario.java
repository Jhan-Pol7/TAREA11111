package seccion8;

import java.util.ArrayList;

enum EstadoCita { PROGRAMADA, EN_CURSO, COMPLETADA, CANCELADA }
enum TipoSangre { A_POS, A_NEG, B_POS, B_NEG, AB_POS, AB_NEG, O_POS, O_NEG }
enum Departamento { URGENCIAS, PEDIATRIA, CARDIOLOGIA, RADIOLOGIA, ADMINISTRACION }

interface Notificable {
    void notificar(String mensaje);
    default String getCanal() { return "Sistema"; }
}

interface Evaluable {
    double evaluarDesempeno();
}
class Persona {
    private String nombre;
    private int edad;
    private TipoSangre tipoSangre;

    public Persona(String nombre, int edad, TipoSangre tipoSangre) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public TipoSangre getTipoSangre() { return tipoSangre; }
}

abstract class PersonalHospital extends Persona implements Notificable {
    protected double salario;
    protected Departamento departamento;

    public PersonalHospital(String nombre, int edad, TipoSangre tipo, double salario, Departamento dept) {
        super(nombre, edad, tipo);
        this.salario = salario;
        this.departamento = dept;
    }

    public abstract double calcularNomina();

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación a " + getNombre() + " via " + getCanal() + ": " + mensaje);
    }
}

class Doctor extends PersonalHospital implements Evaluable {
    private int pacientesAtendidos;

    public Doctor(String nombre, int edad, TipoSangre tipo, double salario, Departamento dept, int pacientes) {
        super(nombre, edad, tipo, salario, dept);
        this.pacientesAtendidos = pacientes;
    }

    @Override
    public double calcularNomina() { return salario * 1.3; }

    @Override
    public double evaluarDesempeno() { return pacientesAtendidos * 10.0; }
}

class Enfermera extends PersonalHospital {
    public Enfermera(String nombre, int edad, TipoSangre tipo, double salario, Departamento dept) {
        super(nombre, edad, tipo, salario, dept);
    }

    @Override
    public double calcularNomina() { return salario * 1.1; }
}

class Administrativo extends PersonalHospital {
    public Administrativo(String nombre, int edad, TipoSangre tipo, double salario) {
        super(nombre, edad, tipo, salario, Departamento.ADMINISTRACION);
    }

    @Override
    public double calcularNomina() { return salario; }
}

class Agenda {
    class Cita {
        private EstadoCita estado = EstadoCita.PROGRAMADA;
        private Doctor doctor;
        private Persona paciente;

        public Cita(Doctor doctor, Persona paciente) {
            this.doctor = doctor;
            this.paciente = paciente;
        }

        public void avanzarEstado(EstadoCita nuevoEstado) { estado = nuevoEstado; }
        public EstadoCita getEstado() { return estado; }
        public String infoCita() {
            return "Cita de " + paciente.getNombre() + " con Dr. " + doctor.getNombre() + " | Estado: " + estado;
        }
    }
}

public class SistemaHospitalario {
    public static void main(String[] args) {
        ArrayList<PersonalHospital> personal = new ArrayList<>();
        Doctor d1 = new Doctor("Dr. Piro", 45, TipoSangre.O_POS, 5000, Departamento.CARDIOLOGIA, 20);
        Enfermera e1 = new Enfermera("Enf. yemi", 30, TipoSangre.A_POS, 2500, Departamento.URGENCIAS);
        Administrativo a1 = new Administrativo("Admin. Lopez", 40, TipoSangre.B_NEG, 2000);

        personal.add(d1);
        personal.add(e1);
        personal.add(a1);

        System.out.println("Nómina del personal");
        for (PersonalHospital p : personal) {
            System.out.println(p.getNombre() + "Nomina: $" + p.calcularNomina());
            p.notificar("Revisar reportes semanales");
        }

        Agenda agenda = new Agenda();
        Agenda.Cita cita1 = agenda.new Cita(d1, e1);
        System.out.println("\n" + cita1.infoCita());
        cita1.avanzarEstado(EstadoCita.EN_CURSO);
        System.out.println(cita1.infoCita());
    }
}