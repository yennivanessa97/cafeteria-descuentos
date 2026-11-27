package edu.iudigital.cafeteria.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String DRIVER_SQLITE = "org.sqlite.JDBC";

    public String probarConexion(String url, String usuario, String clave)
            throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_SQLITE);
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {
            return conexion.getMetaData().getDatabaseProductName() + " "
                    + conexion.getMetaData().getDatabaseProductVersion();
        }
    }
}
