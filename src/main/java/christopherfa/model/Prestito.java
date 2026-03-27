package christopherfa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private ElementoCatalogo elementoPrestato;

    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public void setDataInizioPrestito(LocalDate dataInizio) {
        this.dataInizioPrestito = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    // Costruttore vuoto e Getter/Setter
}