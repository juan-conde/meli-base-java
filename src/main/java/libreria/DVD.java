package libreria;

import libreria.exceptions.DVDNoDisponibleException;

import java.time.LocalDateTime;
import java.util.Objects;

public class DVD implements Alquilable {

    public String dvdId;
    public Integer cantidadDeAlquileres;

    public DVD() {
        this.cantidadDeAlquileres = 0;
    }

    @Override
    public void alquilar() {
        if( cantidadDeAlquileres <= 10 ){
            cantidadDeAlquileres++;
        } else {
            throw new DVDNoDisponibleException("DVD ya fue alquilado 10 veces. ANDA A NETFLIX RATA");
        }
    }

    @Override
    public void devolver() {
        Alquiler alquiler = Libreria.getInstance().buscarAlquiler(this);
        alquiler.setFechaDevolucion(LocalDateTime.parse("2019-08-08T21:06:23.534690"));
        Libreria.getInstance().alquileres.remove(alquiler);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return dvdId.equals(dvd.dvdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dvdId);
    }
}
