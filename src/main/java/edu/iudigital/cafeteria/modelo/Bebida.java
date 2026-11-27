package edu.iudigital.cafeteria.modelo;

public class Bebida extends Producto {

    private final Tamanio tamanio;

    public Bebida(String codigo, String nombre, double precioBase, Tamanio tamanio) {
        super(codigo, nombre, precioBase);
        this.tamanio = tamanio;
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase() * tamanio.getFactor();
    }
}