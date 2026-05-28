package Biblioteca;

import Exception.RecursoAntiguoException;
import Exception.ArticuloYaPrestadoException

// Libro físico: tiene autor e ISBN, puede prestarse y devolverse
public class Libro extends RecursoPro {

    private String autor;
    private String isbn;
    private String usuarioPrestamo; // registra a quién está prestado

    public Libro(String codigo, String titulo, int anioPublicacion, String autor, String isbn) throws RecursoAntiguoException {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.isbn = isbn;
        this.usuarioPrestamo = null;
    }

    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public String getUsuarioPrestamo() { return usuarioPrestamo; }

    public void prestar(String usuario) throws ArticuloYaPrestadoException {
        if (!isDisponible()) {
            throw new ArticuloYaPrestadoException("El libro '" + getTitulo() + "' ya está prestado a " + usuarioPrestamo + ".");
        }
        this.usuarioPrestamo = usuario;
        setDisponible(false);
    }

    public void devolver() {
        this.usuarioPrestamo = null;
        setDisponible(true);
    }

    @Override
    public String toString() {
        return "Libro " + super.toString() + "Autor: " + autor + "ISBN: " + isbn +
                (usuarioPrestamo != null ? "Prestado a: " + usuarioPrestamo : "");
    }
}