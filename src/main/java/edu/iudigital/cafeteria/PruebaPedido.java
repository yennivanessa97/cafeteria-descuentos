package edu.iudigital.cafeteria;

import edu.iudigital.cafeteria.modelo.Bebida;
import edu.iudigital.cafeteria.modelo.Comida;
import edu.iudigital.cafeteria.modelo.Pedido;
import edu.iudigital.cafeteria.modelo.ReglaDescuento;
import edu.iudigital.cafeteria.modelo.Tamanio;

public class PruebaPedido {

    public static void main(String[] args) {
        ReglaDescuento descuento15 = total -> total > 10 ? total * 0.85 : total;

        Pedido pedido = new Pedido("P-001", descuento15);
        pedido.agregarProducto(new Bebida("B1", "Cafe", 3.0, Tamanio.GRANDE));
        pedido.agregarProducto(new Comida("C1", "Sandwich", 6.0, true));

        System.out.println("Subtotal:  " + pedido.calcularSubtotal());
        System.out.println("Descuento: " + pedido.calcularDescuento());
        System.out.println("Total:     " + pedido.calcularTotal());
    }
}