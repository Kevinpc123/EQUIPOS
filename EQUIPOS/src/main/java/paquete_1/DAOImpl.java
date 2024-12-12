package paquete_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public abstract class DAOImpl<T> {
    private final Class<T> entityClass;
    protected EntityManager em;

    public DAOImpl(Class<T> entityClass, EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }

    // Método para insertar una entidad
    public void insertar(T entidad) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entidad);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // Método para obtener todos los registros de la entidad
    public List<T> obtenerTodos() {
        return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    // Método para obtener una entidad por su ID
    public T obtenerPorId(Object id) {
        return em.find(entityClass, id);
    }

    // Método para actualizar una entidad
    public void actualizar(T entidad) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entidad);  // merge sirve para actualizar si la entidad ya existe
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // Método para eliminar una entidad
    public void eliminar(Object id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T entidad = em.find(entityClass, id);
            if (entidad != null) {
                em.remove(entidad);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}
