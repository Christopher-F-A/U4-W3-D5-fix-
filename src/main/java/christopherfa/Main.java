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
        Libro l1 = new Libro();
        l1.setIsbn("ISBN-100");
        l1.setTitolo("Il Nome della Rosa");
        l1.setAutore("Umberto Eco");
        l1.setAnnoPubblicazione(1980);
        l1.setNumeroPagine(500);
        l1.setGenere("Giallo storico");
        dao.save(l1);

        Libro l2 = new Libro();
        l2.setIsbn("ISBN-101");
        l2.setTitolo("Il pendolo di Foucault");
        l2.setAutore("Umberto Eco");
        l2.setAnnoPubblicazione(1988);
        l2.setNumeroPagine(600);
        l2.setGenere("Romanzo");
        dao.save(l2);

        // Rivista

        Rivista r1 = new Rivista();
        r1.setIsbn("ISBN-REV-500");
        r1.setTitolo("Focus");
        r1.setAnnoPubblicazione(1980);
        r1.setNumeroPagine(50);
        r1.setPeriodicita(Periodicita.MENSILE);
        dao.save(r1);

        // Creazione Prestito
        Prestito p = new Prestito();
        p.setUtente(u);
        ElementoCatalogo l = null;
        p.setElementoPrestato(l);
        p.setDataInizioPrestito(LocalDate.now());
        dao.save(p);

        System.out.println("Salvataggio completato con successo!");

        // TEST
        System.out.println("--- TEST RICERCHE ---");

        // Ricerca per ISBN
        System.out.println("Ricerca ISBN ISBN-100:");
        ElementoCatalogo trovatoIsbn = dao.findByIsbn("ISBN-100");
        if (trovatoIsbn != null) System.out.println("Trovato: " + trovatoIsbn.getTitolo());

        // Ricerca per Anno (1980)
        System.out.println("\nRicerca elementi anno 1980:");
        List<ElementoCatalogo> perAnno = dao.findByAnno(1980);
        perAnno.forEach(e -> System.out.println("- " + e.getTitolo()));

        // Ricerca per Autore
        System.out.println("\nRicerca libri di Umberto Eco:");
        List<Libro> perAutore = dao.findByAutore("Umberto Eco");
        perAutore.forEach(libro -> System.out.println("- " + libro.getTitolo()));

    } catch (Exception e) {
        System.err.println("Errore: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
}