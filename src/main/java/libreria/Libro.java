package libreria;

import java.util.Objects;

public abstract class Libro {

    private String titulo;
    private String editorial;
    private Boolean alquilado;

    public Libro() {
        this.alquilado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Boolean getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(Boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return titulo.equals(libro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
