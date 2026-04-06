package seccion7;

enum EstadoPedido {
    PENDIENTE("Esperando confirmación", "#FFA500"),
    CONFIRMADO("Pedido confirmado", "#2196F3"),
    EN_PREPARACION("En preparación", "#9C27B0"),
    ENVIADO("En camino", "#4CAF50"),
    ENTREGADO("Entregado", "#00BCD4"),
    CANCELADO("Cancelado", "#F44336");

    private String descripcion;
    private String color;

    EstadoPedido(String descripcion, String color) {
        this.descripcion = descripcion;
        this.color = color;
    }

    public String getDescripcion() { return descripcion; }
    public String getColor() { return color; }

    public boolean puedeTransicionarA(EstadoPedido nuevoEstado) {
        switch (this) {
            case PENDIENTE:
                return nuevoEstado == CONFIRMADO || nuevoEstado == CANCELADO;
            case CONFIRMADO:
                return nuevoEstado == EN_PREPARACION || nuevoEstado == CANCELADO;
            case EN_PREPARACION:
                return nuevoEstado == ENVIADO || nuevoEstado == CANCELADO;
            case ENVIADO:
                return nuevoEstado == ENTREGADO;
            case ENTREGADO:
                return false;
            case CANCELADO:
                return false;
            default:
                return false;
        }
    }
}

class Pedido {
    private String cliente;
    private EstadoPedido estado;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public boolean cambiarEstado(EstadoPedido nuevoEstado) {
        if (estado.puedeTransicionarA(nuevoEstado)) {
            estado = nuevoEstado;
            return true;
        }
        return false;
    }

    public EstadoPedido getEstado() { return estado; }
    public String getCliente() { return cliente; }
}

public class DemoPedido {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Ana");
        System.out.println(pedido1.getCliente() + " >>> " + pedido1.getEstado().getDescripcion());

        pedido1.cambiarEstado(EstadoPedido.CONFIRMADO);
        System.out.println(pedido1.getCliente() + " >>> " + pedido1.getEstado().getDescripcion());

        pedido1.cambiarEstado(EstadoPedido.ENVIADO);
        System.out.println(pedido1.getCliente() + " >>> " + pedido1.getEstado().getDescripcion());

        pedido1.cambiarEstado(EstadoPedido.EN_PREPARACION);
        pedido1.cambiarEstado(EstadoPedido.ENVIADO);
        pedido1.cambiarEstado(EstadoPedido.ENTREGADO);
        System.out.println(pedido1.getCliente() + " >>> " + pedido1.getEstado().getDescripcion());
    }
}