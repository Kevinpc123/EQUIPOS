package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static String url = "jdbc:mariadb://localhost:3306/db_exa_daw";
    private static String user = "alumno";
    private static String password = "alumno";
    private static Connection conexion = null;
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión establecida con éxito a la base de datos.");
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}
