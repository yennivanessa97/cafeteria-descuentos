package edu.iudigital.cafeteria.modelo;

public abstract class Producto {

    private final String codigo;
    private final String nombre;
    private final double precioBase;

    protected Producto(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public abstract double calcularPrecio();
}