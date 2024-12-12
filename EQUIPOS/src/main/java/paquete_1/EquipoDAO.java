package paquete_1;
import jakarta.persistence.EntityManager;

public class EquipoDAO extends DAOImpl<Equipo> {

    public EquipoDAO(EntityManager em) {
        super(Equipo.class, em);
    }
}
