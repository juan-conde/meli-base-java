package libreria;

import java.time.LocalDateTime;

public class Alquiler {

    private Alquilable libroAlquilado;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;

    public Alquilable getLibroAlquilado() {
        return libroAlquilado;
    }

    public void setLibroAlquilado(Alquilable libroAlquilado) {
        this.libroAlquilado = libroAlquilado;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
