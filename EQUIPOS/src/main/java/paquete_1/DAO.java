package paquete_1;
import java.util.List;

public interface DAO<T> {
    void insertar(T entity);
    void actualizar(T entity);
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
    List<T> ordenarPorNombre();
}
