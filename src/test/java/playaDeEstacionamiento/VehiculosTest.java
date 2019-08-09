package playaDeEstacionamiento;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class VehiculosTest {

    @Test
    public void crearVehiculo(){
        Vehiculo auto = new Auto();
        Assertions.assertThat(auto).isNotNull();
    }

    @Test
    public void crearVehiculoUtilitario(){
        Utilitarios camioneta = new Camioneta();
        Assertions.assertThat(camioneta.getClass().getSimpleName()).isEqualTo(Camioneta.class.getSimpleName());
    }
}
