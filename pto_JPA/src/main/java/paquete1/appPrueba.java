package paquete1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class appPrueba {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("paquete1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Departamento dpto = em.find(Departamento.class, 1 );
        Empleado emp=new Empleado("empNuevo");
        tx.begin();
        em.persist(emp);
        tx.commit();
        System.out.println(em.find(Empleado.class, emp.getId()));
    }
}
