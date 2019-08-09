package libreria;

import libreria.exceptions.AlquilerNoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Libreria {

    //////////////////////////////////////////////////////
    private Libreria() {
        alquileres = new ArrayList<>();
    }

    private static class LazyHolder {
        static final Libreria INSTANCE = new Libreria();
    }

    public static Libreria getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void limpiar(){
        alquileres.clear();
    }
    //////////////////////////////////////////////////////

    public List<Alquiler> alquileres;

    public void agregarAlquiler(Alquiler alquiler){
        alquileres.add(alquiler);
        alquiler.getLibroAlquilado().alquilar();
    }

    public Alquiler buscarAlquiler(Libro libroABuscar){

//        Predicate<Alquiler> buscarLibroporAlquiler =
//                alquiler -> alquiler.getLibroAlquilado().getTitulo().equals(libroABuscar.getTitulo());
        Predicate<Alquiler> buscarLibroporAlquiler =
                alquiler -> {
                    Libro libroAlquilado = (Libro) alquiler.getLibroAlquilado();
                    return libroAlquilado.getTitulo().equals(libroABuscar.getTitulo());
                };

        List<Alquiler> collect = alquileres.stream().filter(buscarLibroporAlquiler).collect(Collectors.toList());

        if(collect.isEmpty()){
            throw new AlquilerNoEncontradoException("El alquiler buscado no se encuentra en la Libreria.");
        } else {
            return collect.get(0);
        }
    }

    public void listarAlquileres(){
//        Consumer<Alquiler> imprimirAlquileres = alquiler -> System.out.println(
//                alquiler.getLibroAlquilado().getTitulo() + " - " + alquiler.getFechaAlquiler() + '\n' );
        Consumer<Alquiler> imprimirAlquileres = alquiler -> {
            Libro libroAlquilado = (Libro) alquiler.getLibroAlquilado();
            System.out.println(libroAlquilado.getTitulo() + " - " + alquiler.getFechaAlquiler());
        };

        alquileres.stream().forEach(imprimirAlquileres);
    }
}
