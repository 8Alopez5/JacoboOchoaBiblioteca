package Biblioteca;

import Exception.RecursoAntiguoException;
import Exception.ArticuloYaPrestadoException;

// Revista física: tiene número de edición y editorial, puede prestarse y devolverse
public class Revista extends RecursoPro{

    private int numeroEdicion;
    private String editorial;
    private String usuarioPrestamo; // registra a quién está prestada

    public Revista(String codigo, String titulo, int anioPublicacion, int numeroEdicion, String editorial) throws RecursoAntiguoException {
        super(codigo, titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.editorial = editorial;
        this.usuarioPrestamo = null;
    }

    public int getNumeroEdicion() { return numeroEdicion; }
    public String getEditorial() { return editorial; }
    public String getUsuarioPrestamo() { return usuarioPrestamo; }

    public void prestar(String usuario) throws ArticuloYaPrestadoException {
        if (!isDisponible()) {
            throw new ArticuloYaPrestadoException("La revista '" + getTitulo() + "' ya está prestada a " + usuarioPrestamo + ".");
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
        return "Revista | " + super.toString() + " | Edicion: " + numeroEdicion + " | Editorial: " + editorial +
                (usuarioPrestamo != null ? " | Prestada a: " + usuarioPrestamo : "");
    }
}