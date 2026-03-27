package christopherfa.model;

import jakarta.persistence.Entity;

@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro() {}

    public void setAutore(String autore) { this.autore = autore; }
    public void setGenere(String genere) { this.genere = genere; }

    public String getAutore() { return autore; }
}