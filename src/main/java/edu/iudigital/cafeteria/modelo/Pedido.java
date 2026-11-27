package edu.iudigital.cafeteria.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final String numero;
    private final List<Producto> productos = new ArrayList<>();
    private final ReglaDescuento reglaDescuento;

    public Pedido(String numero, ReglaDescuento reglaDescuento) {
        this.numero = numero;
        this.reglaDescuento = reglaDescuento;
    }

    public String getNumero() {
        return numero;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.calcularPrecio();
        }
        return subtotal;
    }

    public double calcularTotal() {
        return reglaDescuento.aplicar(calcularSubtotal());
    }

    public double calcularDescuento() {
        return calcularSubtotal() - calcularTotal();
    }
}