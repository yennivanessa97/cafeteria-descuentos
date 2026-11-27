package edu.iudigital.cafeteria.ui;

import edu.iudigital.cafeteria.datos.ConexionBD;
import edu.iudigital.cafeteria.modelo.Comida;
import edu.iudigital.cafeteria.modelo.Pedido;
import edu.iudigital.cafeteria.modelo.ReglaDescuento;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.SQLException;

public class VentanaDescuentos extends JFrame {

    private static final String URL_BD = "jdbc:sqlite:cafeteria.db";

    private final JTextField campoMonto = new JTextField(10);
    private final JButton botonCalcular = new JButton("Calcular");
    private final JTextArea areaResultado = new JTextArea();
    private final ConexionBD conexionBD = new ConexionBD();
    private final ReglaDescuento reglaDescuento = total -> total > 10 ? total * 0.85 : total;

    public VentanaDescuentos() {
        super("Cafetería - Descuentos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(construirPanelSuperior(), BorderLayout.NORTH);
        add(construirPanelCentral(), BorderLayout.CENTER);
        setSize(480, 320);
        setLocationRelativeTo(null);
        verificarConexionInicial();
    }

    private JPanel construirPanelSuperior() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Monto del pedido:"));
        panel.add(campoMonto);
        panel.add(botonCalcular);
        botonCalcular.addActionListener(evento -> calcularDescuento());
        return panel;
    }

    private JScrollPane construirPanelCentral() {
        areaResultado.setEditable(false);
        return new JScrollPane(areaResultado);
    }

    private void verificarConexionInicial() {
        try {
            String motor = conexionBD.probarConexion(URL_BD, "", "");
            mostrarResultado("Base de datos conectada: " + motor, new Color(0, 128, 0));
        } catch (ClassNotFoundException e) {
            mostrarResultado("Falta el driver de SQLite en el proyecto.", Color.RED);
        } catch (SQLException e) {
            mostrarResultado("No se pudo conectar: " + e.getMessage(), Color.RED);
        }
    }

    private void calcularDescuento() {
        double monto;
        try {
            monto = Double.parseDouble(campoMonto.getText().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            mostrarResultado("Escribe un monto válido, por ejemplo 12.5", Color.RED);
            return;
        }
        if (monto <= 0) {
            mostrarResultado("El monto debe ser mayor que cero.", Color.RED);
            return;
        }

        Pedido pedido = new Pedido("P-001", reglaDescuento);
        pedido.agregarProducto(new Comida("C-0", "Consumo", monto, false));

        mostrarResultado(String.format("Subtotal:  %.2f%nDescuento: %.2f%nTotal:     %.2f",
                        pedido.calcularSubtotal(), pedido.calcularDescuento(), pedido.calcularTotal()),
                Color.BLACK);
    }

    private void mostrarResultado(String mensaje, Color color) {
        areaResultado.setForeground(color);
        areaResultado.setText(mensaje);
    }
}