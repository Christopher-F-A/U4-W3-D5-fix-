package christopherfa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    @Column(unique = true, nullable = false)
    private String numeroTessera;


}
