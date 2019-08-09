package enviosPostales;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AsignadorDeVehiculosTest {

    private Paquete paquete5 = new Paquete(5);
    private Paquete paquete50 = new Paquete(50);
    private Paquete paquete100 = new Paquete(100);
    private Paquete paquete151 = new Paquete(151);
    private AsignadorVehiculo asignadorVehiculo = new AsignadorVehiculo();

    @Test
    public void enviarPorBicicleta(){
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete5);
        Transporte transporte = asignadorVehiculo.asignarVehiculo(paquetes);
        Assertions.assertThat(transporte).isInstanceOf(Bicicleta.class);
    }

    @Test
    public void enviarPorAuto(){
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete50);
        Transporte transporte = asignadorVehiculo.asignarVehiculo(paquetes);
        Assertions.assertThat(transporte).isInstanceOf(Auto.class);
    }

    @Test
    public void enviarPorCamioneta(){
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete100);
        Transporte transporte = asignadorVehiculo.asignarVehiculo(paquetes);
        Assertions.assertThat(transporte).isInstanceOf(Camioneta.class);
    }

    @Test (expected = RuntimeException.class)
    public void noEnviarPorPeso(){
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete151);
        asignadorVehiculo.asignarVehiculo(paquetes);
    }
}
