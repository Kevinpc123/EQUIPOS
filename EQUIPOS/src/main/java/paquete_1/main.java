package paquete_1;
import jakarta.persistence.*;

import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_equipos");
        EntityManager em = emf.createEntityManager();

        // Crear DAO para la entidad Jugador
        JugadorDAO jugadorDAO = new JugadorDAO(em);

        // Crear un nuevo jugador
        Jugador jugador = new Jugador();
        jugador.setNombre("Lionel Messi");
        jugador.setEstatura(1.70f);
        jugador.setPeso(72.0f);

        // Crear un equipo para el jugador
        Equipo equipo = em.find(Equipo.class, 1);  // Obtiene el equipo con ID 1
        jugador.setEquipo(equipo);

        // Insertar el jugador
        jugadorDAO.insertar(jugador);

        // Obtener todos los jugadores
        List<Jugador> jugadores = jugadorDAO.obtenerTodos();
        jugadores.forEach(j -> System.out.println(j.getNombre()));

        // Cerrar el EntityManager y la fábrica
        em.close();
        emf.close();
    }
}
