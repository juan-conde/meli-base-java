package libreria;

import java.time.LocalDateTime;

public class Alquiler {

    private Alquilable alquilado;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;

    public Alquilable getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(Alquilable alquilado) {
        this.alquilado = alquilado;
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

    @Override
    public String toString() {
        return "Alquiler : { " +
                "alquilado = " + alquilado +
                ", fechaAlquiler = " + fechaAlquiler +
                '}';
    }



}
