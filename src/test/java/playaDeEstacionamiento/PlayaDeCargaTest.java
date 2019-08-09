package playaDeEstacionamiento;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class PlayaDeCargaTest {

    @Before
    public void setup(){
        PlayaDeCarga.getInstance().limpiarSingleton();
    }

    @Test
    public void crearPlayaDeCarga(){
        PlayaDeCarga playaDeCarga = PlayaDeCarga.getInstance();
        Assertions.assertThat(playaDeCarga).isNotNull();
    }

    @Test
    public void obtenerCargasDePlaya(){
        PlayaDeCarga playaDeCarga = PlayaDeCarga.getInstance();
        Carga carga1 = new Carga();
        Carga carga2 = new Carga();
        carga1.peso = 10;
        carga2.peso = 20;
        playaDeCarga.agregarCarga(carga1);
        playaDeCarga.agregarCarga(carga2);
        Assertions.assertThat(playaDeCarga.getCargas().size()).isEqualTo(2);
    }

    @Test
    public void obtenerPesoDeLasCargasDePlaya(){
        Carga carga1 = new Carga();
        Carga carga2 = new Carga();
        carga1.peso = 10;
        carga2.peso = 20;
        PlayaDeCarga.getInstance().agregarCarga(carga1);
        PlayaDeCarga.getInstance().agregarCarga(carga2);

        AtomicReference<Integer> pesoTotal = new AtomicReference<>(0);
        PlayaDeCarga.getInstance().getCargas().forEach(carga -> pesoTotal.updateAndGet(v -> v + carga.getPeso()));
        Assertions.assertThat(pesoTotal.get()).isEqualTo(30);
    }

    @Test
    public void agregarCarga(){
        Utilitarios camion = new Camion();
        camion.maximaCargaPermitida = 10;
        Carga carga1 = new Carga();
        Carga carga2 = new Carga();
        carga1.peso = 10;
        carga2.peso = 10;
        camion.agregarCarga(carga1);
        camion.agregarCarga(carga2);
//        Assertions.assertThat(camion.carga.size()).isEqualTo(2);
    }

    @Test
    public void agregarCargaNoPermitida(){
        Utilitarios camion = new Camion();
        camion.maximaCargaPermitida = 10;
        Carga carga1 = new Carga();
        Carga carga2 = new Carga();
        carga1.peso = 10;
        carga2.peso = 20;
        camion.agregarCarga(carga1);
        camion.agregarCarga(carga2);
//        Assertions.assertThat(camion.carga.size()).isEqualTo(1);
    }

    @Test
    public void agregarVehiculoAPlayaSinCargas(){
        Utilitarios camion = new Camion();
        PlayaDeCarga.getInstance().agregarUtilitarioACargar(camion);
        Assertions.assertThat(PlayaDeCarga.getInstance().getUtilitariosACargar().size()).isEqualTo(0);
    }

    @Test
    public void agregarVehiculoAPlayaConCargas(){
        Utilitarios camion = new Camion();
        PlayaDeCarga.getInstance().agregarCarga(new Carga());
        PlayaDeCarga.getInstance().agregarUtilitarioACargar(camion);
        Assertions.assertThat(PlayaDeCarga.getInstance().getUtilitariosACargar().size()).isEqualTo(1);
    }

    @Test
    public void testGeneral(){
        Carga carga1 = new Carga();
        carga1.peso = 10;
        Carga carga2 = new Carga();
        carga2.peso = 10;
        Carga carga3 = new Carga();
        carga3.peso = 10;
        Carga carga4 = new Carga();
        carga4.peso = 10;

        Utilitarios camion = new Camion();
        camion.maximaCargaPermitida = 20;
        camion.pesoMaximo = 30;

        PlayaDeCarga.getInstance().agregarCarga(carga1);
        PlayaDeCarga.getInstance().agregarCarga(carga2);
        PlayaDeCarga.getInstance().agregarCarga(carga3);
        PlayaDeCarga.getInstance().agregarCarga(carga4);

        PlayaDeCarga.getInstance().agregarUtilitarioACargar(camion);

        System.out.println(camion.carga.size());
//        Assertions.assertThat(PlayaDeCarga.getInstance().getCargas().size()).isEqualTo(1);
    }

}
