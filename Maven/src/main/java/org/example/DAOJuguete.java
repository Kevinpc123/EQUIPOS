package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOJuguete {
    private Connection conexion;

    public DAOJuguete() {
        conexion = DB.getConexion();
    }

    public List<Juguete> getAllJuguetes() throws SQLException {
        List<Juguete> juguetes = new ArrayList<>();
        String query = "SELECT * FROM juguetes ORDER BY id";  // Orden por ID (puedes cambiar el criterio de orden)
        PreparedStatement sentencia = conexion.prepareStatement(query);
        ResultSet resultados = sentencia.executeQuery();
        while (resultados.next()) {
            int id = resultados.getInt("id");
            String nombre = resultados.getString("nombre");
            Juguete juguete = new Juguete(id, nombre);
            juguetes.add(juguete);
        }
        resultados.close();
        sentencia.close();
        return juguetes;
    }

    public void ascenderJuguete(int id) throws SQLException {
        String query = "UPDATE juguetes SET id = id - 1 WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(query)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }

    public void descenderJuguete(int id) throws SQLException {
        String query = "UPDATE juguetes SET id = id + 1 WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(query)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }

    public Juguete getJugueteById(int id) throws SQLException {
        Juguete juguete = null;
        String query = "SELECT * FROM juguetes WHERE id = ?";
        PreparedStatement sentencia = conexion.prepareStatement(query);
        sentencia.setInt(1, id);
        ResultSet resultados = sentencia.executeQuery();
        if (resultados.next()) {
            String nombre = resultados.getString("nombre");
            juguete = new Juguete(id, nombre);
        }
        resultados.close();
        sentencia.close();
        return juguete;
    }

    public void insertarJuguete(Juguete juguete) throws SQLException {
        String query = "INSERT INTO juguetes (id, nombre) VALUES (?, ?)";
        try (PreparedStatement sentencia = conexion.prepareStatement(query)) {
            sentencia.setInt(1, juguete.getId());
            sentencia.setString(2, juguete.getNombre());
            sentencia.executeUpdate();
        }
    }

    public void actualizarJuguete(Juguete juguete) throws SQLException {
        String query = "UPDATE juguetes SET nombre = ? WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(query)) {
            sentencia.setString(1, juguete.getNombre());
            sentencia.setInt(2, juguete.getId());
            sentencia.executeUpdate();
        }
    }

    public void eliminarJuguete(int id) throws SQLException {
        String query = "DELETE FROM juguetes WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(query)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }
}
