package christopherfa.dao;

import christopherfa.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class CatalogoDAO {
    private EntityManager em;

    public CatalogoDAO(EntityManager em) { this.em = em; }

    // Salva Libro, Rivista, Utente, Prestito
    public void save(Object entity) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(entity);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        }
    }

    public ElementoCatalogo findByIsbn(String isbn) {
        return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.isbn = :i", ElementoCatalogo.class)
                .setParameter("i", isbn)
                .getSingleResult();
    }

    // Ricerca per Autore
    public List<Libro> findByAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :a", Libro.class)
                .setParameter("a", autore)
                .getResultList();
    }
}