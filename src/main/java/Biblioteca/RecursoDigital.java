package Biblioteca;

import Exception.RecursoAntiguoException;

// Recurso digital: solo se consulta en sala, nunca se presta
public class RecursoDigital extends RecursoPro {

    private String urlAcceso;

    public RecursoDigital(String codigo, String titulo, int anioPublicacion, String urlAcceso) throws RecursoAntiguoException {
        super(codigo, titulo, anioPublicacion);
        this.urlAcceso = urlAcceso;
        // Los recursos digitales nunca están disponibles para préstamo
        setDisponible(false);
    }

    public String getUrlAcceso() { return urlAcceso; }

    @Override
    public String toString() {
        return "Digital | " + getTitulo() + " (" + getAnioPublicacion() + ") | URL: " + urlAcceso + " | Solo consulta en sala";
    }
}
