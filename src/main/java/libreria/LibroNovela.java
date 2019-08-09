package libreria;

import java.time.LocalDateTime;

public class LibroNovela extends Libro implements Alquilable {

    private String autor;
    private String edicion;

    @Override
    public void alquilar() {
        this.setAlquilado(true);
    }

    @Override
    public void devolver() {
        this.setAlquilado(false);
        Alquiler alquiler = Libreria.getInstance().buscarAlquiler(this);
        alquiler.setFechaDevolucion(LocalDateTime.parse("2019-08-08T21:06:23.534690"));
        Libreria.getInstance().alquileres.remove(alquiler);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
}
