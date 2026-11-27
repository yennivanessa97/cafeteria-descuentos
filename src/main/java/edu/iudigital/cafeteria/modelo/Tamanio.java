package edu.iudigital.cafeteria.modelo;

public enum Tamanio {
    PEQUENO(1.0),
    MEDIANO(1.2),
    GRANDE(1.5);

    private final double factor;

    Tamanio(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}