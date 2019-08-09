package playaDeEstacionamiento;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PlayaDeEstacionamientoTest {

    @Test
    public void crearPlayaDeEstacionamiento(){
        PlayaDeEstacionamiento estacionamiento = PlayaDeEstacionamiento.getInstance();
        Assertions.assertThat(estacionamiento).isNotNull();
    }

    @Test
    public void estacionarAutos(){
        PlayaDeEstacionamiento estacionamiento = PlayaDeEstacionamiento.getInstance();
        Utilitarios camioneta = new Camioneta();
        estacionamiento.estacionarVehiculo(camioneta);
        Assertions.assertThat(estacionamiento.getVehiculosEstacionados().size()).isEqualTo(1);
    }
}
