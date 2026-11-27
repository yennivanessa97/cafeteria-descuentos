package edu.iudigital.cafeteria.modelo;

public class Comida extends Producto {

    private static final double RECARGO_CALENTADO = 1.5;

    private final boolean calentado;

    public Comida(String codigo, String nombre, double precioBase, boolean calentado) {
        super(codigo, nombre, precioBase);
        this.calentado = calentado;
    }

    @Override
    public double calcularPrecio() {
        return calentado ? getPrecioBase() + RECARGO_CALENTADO : getPrecioBase();
    }
}