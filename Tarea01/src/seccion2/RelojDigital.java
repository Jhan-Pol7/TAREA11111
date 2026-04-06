package seccion2;

public class RelojDigital {
    private int horas;
    private int minutos;
    private int segundos;
    private int alarmaH = -1;
    private int alarmaM = -1;

    public RelojDigital(int horas, int minutos, int segundos) {
        this.horas = horas % 24;
        this.minutos = minutos % 60;
        this.segundos = segundos % 60;
    }

    public void avanzarSegundo() {
        segundos++;
        if (segundos >= 60) {
            segundos = 0;
            minutos++;
        }
        if (minutos >= 60) {
            minutos = 0;
            horas++;
        }
        if (horas >= 24) {
            horas = 0;
        }
    }

    public String mostrarFormato24h() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public String mostrarFormato12h() {
        String ampm = horas >= 12 ? "PM" : "AM";
        int h = horas % 12;
        if (h == 0) h = 12;
        return String.format("%d:%02d:%02d %s", h, minutos, segundos, ampm);
    }

    public void configurarAlarma(int h, int m) {
        if (h >= 0 && h < 24 && m >= 0 && m < 60) {
            alarmaH = h;
            alarmaM = m;
        }
    }

    public boolean verificarAlarma() {
        return (horas == alarmaH && minutos == alarmaM && segundos == 0);
    }

    public static void main(String[] args) throws InterruptedException {
        RelojDigital reloj = new RelojDigital(23, 59, 55);
        reloj.configurarAlarma(0, 0);

        System.out.println("Reloj Digital");
        for (int i = 0; i < 10; i++) {
            System.out.println("Formato  de 24h: " + reloj.mostrarFormato24h());
            System.out.println("Formato de 12h: " + reloj.mostrarFormato12h());
            if (reloj.verificarAlarma()) {
                System.out.println("¡Alarma!!!! Son las " + reloj.mostrarFormato24h());
            }
            reloj.avanzarSegundo();
            Thread.sleep(1000);
        }
    }
}