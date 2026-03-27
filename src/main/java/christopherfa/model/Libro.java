package christopherfa.model;

import jakarta.persistence.Entity;

@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro() {}

}