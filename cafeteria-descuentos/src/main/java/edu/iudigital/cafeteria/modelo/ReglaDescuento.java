package edu.iudigital.cafeteria.modelo;

@FunctionalInterface
public interface ReglaDescuento {

    double aplicar(double total);
}