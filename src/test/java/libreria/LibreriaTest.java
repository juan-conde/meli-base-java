package libreria;

import libreria.exceptions.AlquilerNoEncontradoException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LibreriaTest {

    private LibroNovela hp = new LibroNovela();
    private LibroNovela principito = new LibroNovela();
    private LibroNovela reyLeon = new LibroNovela();
    private LibroEstudio programacion1 = new LibroEstudio();
    private LibroEstudio cocina = new LibroEstudio();
    private LibroInfantil pepaPig = new LibroInfantil();
    private LibroInfantil barney = new LibroInfantil();
    private Alquiler hpAlquilado = new Alquiler();
    private Alquiler principitoAlquilado = new Alquiler();
    private Alquiler reyLeonAlquilado = new Alquiler();
    private Alquiler programacionAlquilado = new Alquiler();
    private Alquiler cocinaAlquilado = new Alquiler();

    private LocalDateTime fechaAlquilerTODOS = LocalDateTime.now();
    private LocalDateTime fechaDevolucionTODOS = LocalDateTime.now();

    @Before
    public void setUp(){
        Libreria.getInstance().limpiar();

        hp.setTitulo("Harry Potter");
        hp.setEditorial("Bloomsbury");
        hpAlquilado.setLibroAlquilado(hp);
        hpAlquilado.setFechaAlquiler(fechaAlquilerTODOS);
        hpAlquilado.setFechaDevolucion(fechaDevolucionTODOS);

        principito.setTitulo("El Principito");
        principito.setEditorial("Planeta");
        principitoAlquilado.setLibroAlquilado(principito);
        principitoAlquilado.setFechaAlquiler(fechaAlquilerTODOS);
        principitoAlquilado.setFechaDevolucion(fechaDevolucionTODOS);

        reyLeon.setTitulo("Rey Leon");
        reyLeon.setEditorial("Disney");
        reyLeonAlquilado.setLibroAlquilado(reyLeon);
        reyLeonAlquilado.setFechaAlquiler(fechaAlquilerTODOS);
        reyLeonAlquilado.setFechaDevolucion(fechaDevolucionTODOS);

        programacion1.setTitulo("Programacion");
        programacion1.setEditorial("JAVA");
        programacion1.setTemaDeEstudio("JAVA");
        programacionAlquilado.setLibroAlquilado(programacion1);
        programacionAlquilado.setFechaAlquiler(fechaAlquilerTODOS);
        programacionAlquilado.setFechaDevolucion(fechaDevolucionTODOS);

        cocina.setTitulo("Cocina");
        cocina.setEditorial("Cuchillo y tenedor");
        cocina.setTemaDeEstudio("Cocina");
        cocinaAlquilado.setLibroAlquilado(cocina);
        cocinaAlquilado.setFechaAlquiler(fechaAlquilerTODOS);
        cocinaAlquilado.setFechaDevolucion(fechaDevolucionTODOS);

        pepaPig.setTitulo("Pepa Pig");
        pepaPig.setEditorial("Pepa Libros");
        pepaPig.setEdadDesde(1);
        pepaPig.setEdadHasta(10);

        barney.setTitulo("Barney");
        barney.setEditorial("Barney Libros");
        barney.setEdadDesde(2);
        barney.setEdadHasta(14);
    }

    @Test
    public void crearLibreria(){
        Assertions.assertThat(Libreria.getInstance()).isNotNull();
        Assertions.assertThat(Libreria.getInstance().alquileres.size()).isEqualTo(0);
    }

    @Test
    public void agregarLibroAAlquileres(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        Libreria.getInstance().agregarAlquiler(principitoAlquilado);

        Assertions.assertThat(Libreria.getInstance().alquileres.size()).isEqualTo(2);
    }

    @Test
    public void buscarLibroAAlquilado(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        Libreria.getInstance().agregarAlquiler(principitoAlquilado);

        Alquiler alquiler = Libreria.getInstance().buscarAlquiler(principito);
        Assertions.assertThat(alquiler).isEqualTo(principitoAlquilado);
    }

    @Test (expected = AlquilerNoEncontradoException.class)
    public void buscarLibroNoAlquilado(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        Libreria.getInstance().agregarAlquiler(principitoAlquilado);

        Alquiler alquiler = Libreria.getInstance().buscarAlquiler(reyLeon);
    }

    @Test
    public void listarLosLibrosAlquilados(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        Libreria.getInstance().agregarAlquiler(principitoAlquilado);
        Libreria.getInstance().listarAlquileres();
    }

    @Test
    public void checkearLibrosAlquiladosEstenAlquilados(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        Libreria.getInstance().agregarAlquiler(principitoAlquilado);
        Assertions.assertThat(hp.getAlquilado()).isTrue();
        Assertions.assertThat(principito.getAlquilado()).isTrue();
    }

    @Test
    public void buscarLibroEstudioEnAlquileresDeLibreria(){
        Libreria.getInstance().agregarAlquiler(cocinaAlquilado);
        Libreria.getInstance().agregarAlquiler(programacionAlquilado);
        Alquiler alquiler = Libreria.getInstance().buscarAlquiler(programacion1);
        Assertions.assertThat(alquiler).isEqualTo(programacionAlquilado);
    }

    @Test
    public void alquilarLibroAlquilable(){
        hp.alquilar();
        Assertions.assertThat(hp.getAlquilado()).isTrue();
    }

    @Test
    public void devolverLibroAlquilableYBorrarDeLibreria(){
        Libreria.getInstance().agregarAlquiler(hpAlquilado);
        hp.devolver();
        Assertions.assertThat(hp.getAlquilado()).isFalse();
        Assertions.assertThat(Libreria.getInstance().alquileres.size()).isEqualTo(0);
        Assertions.assertThat(hpAlquilado.getFechaDevolucion()).isEqualTo(LocalDateTime.parse("2019-08-08T21:06:23.534690"));
    }

    @Test
    public void testPedidoA(){
        Libreria libreria = Libreria.getInstance();
        libreria.agregarAlquiler(hpAlquilado);
        //Meto HARDCODEADO un Libro que no este alquilado para probar
        libreria.alquileres.add(programacionAlquilado);
        Assertions.assertThat(hp.getAlquilado()).isTrue();
        Libro libro1 = (Libro) principitoAlquilado.getLibroAlquilado();
        Assertions.assertThat(libro1.getAlquilado()).isFalse();

        List<Alquiler> alquileres = libreria.alquileres;
        List<Alquiler> alquileresSinDevolver = alquileres.stream().filter(alquiler -> {
            Libro libroAlquilado = (Libro) alquiler.getLibroAlquilado();
            return libroAlquilado.getAlquilado();
        }).collect(Collectors.toList());

        Assertions.assertThat(alquileresSinDevolver.size()).isEqualTo(1);
    }

    @Test
    public void testPedidoB(){
        Libreria libreria = Libreria.getInstance();
        libreria.agregarAlquiler(programacionAlquilado);
        libreria.agregarAlquiler(cocinaAlquilado);
        Assertions.assertThat(libreria.alquileres.size()).isEqualTo(2);
        Assertions.assertThat(programacion1.getAlquilado()).isTrue();
        Assertions.assertThat(cocina.getAlquilado()).isTrue();

        programacion1.devolver();
        Assertions.assertThat(libreria.alquileres.size()).isEqualTo(1);
        Assertions.assertThat(programacion1.getAlquilado()).isFalse();
        Assertions.assertThat(cocina.getAlquilado()).isTrue();
    }

}