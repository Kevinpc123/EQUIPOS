package paquete1;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dpto_id", nullable = false)
    private Departamento dpto;

    public Empleado(String empNuevo) {
    }

    public Empleado(String nombre, Integer edad, Departamento dpto) {
        this.nombre = nombre;
        this.edad = edad;
        this.dpto = dpto;
    }

    public Empleado() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Departamento getDpto() {
        return dpto;
    }

    public void setDpto(Departamento dpto) {
        this.dpto = dpto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dpto=" + dpto +
                '}';
    }
}