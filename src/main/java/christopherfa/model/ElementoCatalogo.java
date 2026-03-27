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

    // Aggiungi Getter e Setter
}