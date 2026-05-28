package Biblioteca;

import Exception.RecursoAntiguoException;

// Clase abstracta base: todos los recursos comparten código, título, año y disponibilidad
public class RecursoPro {

    private String codigo;
    private String titulo;
    private int añoPublicacion;
    private boolean disponible;

    public RecursoPro(String codigo, String titulo, int anioPublicacion) throws RecursoAntiguoException {
        // Ningún recurso anterior a 1923 puede registrarse como prestable
        if (anioPublicacion < 1923) {
            throw new RecursoAntiguoException("El recurso '" + titulo + "' es anterior a 1923 y no puede registrarse como prestable.");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.añoPublicacion = anioPublicacion;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public int getAñoPublicacion() { return añoPublicacion; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // equals y hashCode basados en código porque es el identificador único de cada recurso
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RecursoPro otro = (RecursoPro) obj;
        return codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    // toString general para mostrar la información básica de cualquier recurso
    @Override
    public String toString() {
        return "[" + codigo + "] " + titulo + " (" + añoPublicacion+ ") - " + (disponible ? "Disponible" : "Prestado");
    }
}
