package seccion4;

import java.util.ArrayList;

class Notificacion {
    protected String destinatario;
    protected String mensaje;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public void enviar() {
        System.out.println("Enviando notificación a " + destinatario + ": " + mensaje);
    }

    public String formatear() {
        return mensaje;
    }
}

class NotifEmail extends Notificacion {
    private String asunto;

    public NotifEmail(String destinatario, String mensaje, String asunto) {
        super(destinatario, mensaje);
        this.asunto = asunto;
    }

    @Override
    public void enviar() {
        System.out.println("GMAIL a " + destinatario + "Asunto: " + asunto + "Mensaje: " + formatear());
    }

    @Override
    public String formatear() {
        return mensaje.toUpperCase(); // ejemplo: los emails se envían en mayúsculas
    }
}

class NotifSMS extends Notificacion {
    private String numTelefono;

    public NotifSMS(String destinatario, String mensaje, String numTelefono) {
        super(destinatario, mensaje);
        this.numTelefono = numTelefono;
    }

    @Override
    public void enviar() {
        System.out.println("SMS a " + numTelefono + " Mensaje: " + formatear());
    }

    @Override
    public String formatear() {
        return mensaje.length() > 50 ? mensaje.substring(0, 50) + "....." : mensaje; // SMS corto
    }
}

class NotifPush extends Notificacion {
    private String icono;

    public NotifPush(String destinatario, String mensaje, String icono) {
        super(destinatario, mensaje);
        this.icono = icono;
    }

    @Override
    public void enviar() {
        System.out.println("PUSH a " + destinatario + "Icono: " + icono + "Mensaje: " + formatear());
    }

    @Override
    public String formatear() {
        return "[" + mensaje + "]";
    }
}

public class SistemaNotificaciones {
    public static void main(String[] args) {
        ArrayList<Notificacion> pendientes = new ArrayList<>();

        pendientes.add(new NotifEmail("juan@correo.com", "Reunión a las 3pm", "Recordatorio"));
        pendientes.add(new NotifSMS("987654321", "Tu código de verificación es 123456", "987654321"));
        pendientes.add(new NotifPush("Ana", "¡Oferta especial!", "campana"));

        System.out.println("Envío de notificaciones");
        for (Notificacion n : pendientes) {
            n.enviar();
        }
    }
}