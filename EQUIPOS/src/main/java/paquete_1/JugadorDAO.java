package paquete_1;
import jakarta.persistence.*;
import java.util.List;

public class JugadorDAO extends DAOImpl<Jugador> {

    public JugadorDAO(EntityManager em) {

        this.em=em;
    }
    @Override
public List<Jugador>obtenerTodos(){
        return em.createQuery("SELECT j FROM Jugador j",Jugador.class).getResultList();
}
@Override
public Jugador obtenerPorId(int id){
        return em.find(Jugador.class,id);
}
@Override
public void insertar(Jugador jugador){
        em.getTransaction().begin();
        em.persist(jugador);
        em.getTransaction().commit();
}
    @Override
public void actualizar(Jugador jugador){
        em.getTransaction().begin();
        em.persist(jugador);
        em.getTransaction().commit();
}
    @Override
public void eliminar(int id){
        Jugador jugador=obtenerPorId(id);
        if(jugador!=null){
            em.getTransaction().begin();
            em.persist(jugador);
            em.getTransaction().commit();
        }
}
}
