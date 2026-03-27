import christopherfa.dao.CatalogoDAO;
import christopherfa.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    EntityManager em = emf.createEntityManager();
    CatalogoDAO dao = new CatalogoDAO(em);

    try {
        // Creazione Utente
        Utente u = new Utente();
        u.setNome("Aldo");
        u.setCognome("Baldo");
        u.setNumeroTessera("TESS-1"); // Valore univoco
        dao.save(u);

        // Creazione Libro
        Libro l = new Libro();
        l.setIsbn("ISBN-1"); // Valore univoco
        l.setTitolo("Il Nome della Rosa");
        l.setAutore("Umberto Eco");
        dao.save(l);

        // Creazione Prestito
        Prestito p = new Prestito();
        p.setUtente(u);
        p.setElementoPrestato(l);
        p.setDataInizioPrestito(LocalDate.now());
        dao.save(p);

        System.out.println("Salvataggio completato con successo!");

    } catch (Exception e) {
        System.err.println("Errore: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
}