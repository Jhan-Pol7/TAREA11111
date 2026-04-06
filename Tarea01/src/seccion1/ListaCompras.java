package seccion1;

import java.util.ArrayList;
import java.util.Collections;

public class ListaCompras {
    private ArrayList<String> productos;

    public ListaCompras() {
        productos = new ArrayList<>();
    }
    public void agregarProducto(String producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
        }
    }
    public void eliminarProducto(String producto) {
        productos.remove(producto);
    }

    public boolean buscarProducto(String producto) {
        return productos.contains(producto);
    }

    public int contarProductos() {
        return productos.size();
    }

    public void ordenarAlfabeticamente() {
        Collections.sort(productos);
    }

    public ArrayList<String> getProductos() {
        return productos;
    }

    public static void main(String[] args) {
        ListaCompras lista = new ListaCompras();
        lista.agregarProducto("leche");
        lista.agregarProducto("pan");
        lista.agregarProducto("huevos");
        lista.agregarProducto("leche"); // duplicado ignorado
        lista.eliminarProducto("Pan");
        lista.ordenarAlfabeticamente();

        System.out.println("Lista de compras");
        System.out.println("Productos: " + lista.getProductos());
        System.out.println("Buscar Huevos: " + lista.buscarProducto("Huevos"));
        System.out.println("Cantidad de productos: " + lista.contarProductos());
    }
}