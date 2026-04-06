package seccion8;

class Pedido {
    private String cliente;
    private String producto;
    private int cantidad;
    private double descuento;
    private String direccion;
    private String notas;

    private Pedido(Builder b) {
        this.cliente = b.cliente;
        this.producto = b.producto;
        this.cantidad = b.cantidad;
        this.descuento = b.descuento;
        this.direccion = b.direccion;
        this.notas = b.notas;
    }

    public String infoPedido() {
        return "Pedido: " + producto + " x" + cantidad + "Cliente: " + cliente +
                "Descuento: " + descuento +
                (direccion != null ? "Dirección: " + direccion : "") +
                (notas != null ? "Notas: " + notas : "");
    }


    public static class Builder {
        private String cliente;
        private String producto;
        private int cantidad = 1;
        private double descuento = 0;
        private String direccion;
        private String notas;

        public Builder cliente(String c) { this.cliente = c; return this; }
        public Builder producto(String p) { this.producto = p; return this; }
        public Builder cantidad(int q) { this.cantidad = q; return this; }
        public Builder descuento(double d) { this.descuento = d; return this; }
        public Builder direccion(String d) { this.direccion = d; return this; }
        public Builder notas(String n) { this.notas = n; return this; }

        public Pedido build() {
            if (cliente == null || producto == null) {
                throw new IllegalStateException("Cliente y producto son requeridos");
            }
            return new Pedido(this);
        }
    }
}

public class PedidoBuilder {
    public static void main(String[] args) {
        Pedido p1 = new Pedido.Builder()
                .cliente("Ana")
                .producto("Laptop HP")
                .cantidad(2)
                .descuento(0.10)
                .direccion("Av. el triunfu")
                .notas("Entrega urgente")
                .build();

        Pedido p2 = new Pedido.Builder()
                .cliente("Yemi")
                .producto("Mouse")
                .build();
        System.out.println(p1.infoPedido());
        System.out.println(p2.infoPedido());
    }
}