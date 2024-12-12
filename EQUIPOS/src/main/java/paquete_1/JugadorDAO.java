package paquete_1;

import jakarta.persistence.EntityManager;

public class JugadorDAO extends DAOImpl<Jugador> {

    public JugadorDAO(EntityManager em) {
        super(Jugador.class, em);  // Llamada al constructor de la clase base
    }

    // Aquí puedes agregar métodos adicionales específicos para la entidad Jugador si es necesario
}
