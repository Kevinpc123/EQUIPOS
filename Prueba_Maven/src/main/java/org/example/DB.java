package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB {
    private String url = "jdbc:mariadb://localhost:3306/mi_tienda";
    private String user = "alumno";
    private String password = "alumno";
    private Connection conexion = null;
    public  DB() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con éxito a la base de datos mi_tienda.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
