package libreria;

import java.time.LocalDateTime;

public class LibroEstudio extends Libro implements Alquilable {
    private String temaDeEstudio;

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

    public String getTemaDeEstudio() {
        return temaDeEstudio;
    }

    public void setTemaDeEstudio(String temaDeEstudio) {
        this.temaDeEstudio = temaDeEstudio;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
