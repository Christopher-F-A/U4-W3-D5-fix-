package christopherfa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends ElementoCatalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {}

    public Periodicita getPeriodicita() { return periodicita; }
    public void setPeriodicita(Periodicita periodicita) { this.periodicita = periodicita; }
}