package enviosPostales;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculadorDeCostosTest {

    private AsignadorVehiculo asignadorVehiculo = new AsignadorVehiculo();
    private CalculadorDeCostos calculadorDeCostos = new CalculadorDeCostos();

    @Test
    public void generarEnvioConCostoCalculado(){
        Paquete paquete1 = new Paquete(0);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.addAll(Arrays.asList(paquete1,paquete1,paquete1));
        Envio envio = new Envio(paquetes, "Posta 4789", asignadorVehiculo, calculadorDeCostos);
        Assertions.assertThat(envio.getCosto()).isEqualTo(50);
    }

    @Test
    public void generarEnvioConCostoCalculado80(){
        Paquete paquete1 = new Paquete(0);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.addAll(Arrays.asList(paquete1,paquete1,paquete1,paquete1,paquete1));
        Envio envio = new Envio(paquetes, "Posta 4789", asignadorVehiculo, calculadorDeCostos);
        Assertions.assertThat(envio.getCosto()).isEqualTo(80);
    }

    @Test
    public void generarEnvioConCostoCalculado150(){
        Paquete paquete1 = new Paquete(0);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.addAll(Arrays.asList(paquete1,paquete1,paquete1,paquete1,paquete1));
        paquetes.addAll(Arrays.asList(paquete1,paquete1,paquete1,paquete1,paquete1));
        Envio envio = new Envio(paquetes, "Posta 4789", asignadorVehiculo, calculadorDeCostos);
        Assertions.assertThat(envio.getCosto()).isEqualTo(150);
    }
}
