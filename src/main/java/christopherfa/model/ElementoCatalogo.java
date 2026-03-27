package christopherfa.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElementoCatalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    private String titolo;
    private Integer annoPubblicazione;
    private Integer numeroPagine;

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setAnnoPubblicazione(Integer anno) { this.annoPubblicazione = anno; }
    public void setNumeroPagine(Integer pagine) { this.numeroPagine = pagine; }

    public String getTitolo() { return titolo; }
}