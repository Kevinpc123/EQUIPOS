package paquete_1;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String estadio;
    @OneToMany(mappedBy="equipo",cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Jugador> jugadores;

    //getter y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    //tostring

    @java.lang.Override
    public java.lang.String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }
}
