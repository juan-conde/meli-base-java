package enviosPostales;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DespachadorTest {

    @Mock AsignadorVehiculo asignadorVehiculo;
    @Mock CalculadorDeCostos calculadorDeCostos;

    @Test
    public void crearDespachador(){
        Despaschador despaschador = new Despaschador(asignadorVehiculo,calculadorDeCostos);
        Assertions.assertThat(despaschador.getEnviosDespachados()).isEqualTo(0);
    }

    @Test
    public void despacharPrimerEnvio(){
        Mockito.when(calculadorDeCostos.calcularCosto(Mockito.any())).thenReturn(10);
        Mockito.when(asignadorVehiculo.asignarVehiculo(Mockito.any())).thenReturn(new Bicicleta());

        Despaschador despaschador = new Despaschador(asignadorVehiculo,calculadorDeCostos);
        Paquete paquete = new Paquete(1);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete);

        Envio envio = despaschador.generarEnvio(paquetes, "MELI");
        despaschador.despacharEnvio(envio);

        Assertions.assertThat(envio.getCosto()).isEqualTo(10);
        Assertions.assertThat(envio.getTransporteAsociado()).isInstanceOf(Bicicleta.class);
        Assertions.assertThat(despaschador.getEnviosDespachados()).isEqualTo(1);
    }

    @Test
    public void despachar11Envios(){
        Mockito.when(calculadorDeCostos.calcularCosto(Mockito.any())).thenReturn(10);
        Mockito.when(asignadorVehiculo.asignarVehiculo(Mockito.any())).thenReturn(new Bicicleta());

        Despaschador despaschador = new Despaschador(asignadorVehiculo,calculadorDeCostos);
        Paquete paquete = new Paquete(1);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete);

        Envio envio = despaschador.generarEnvio(paquetes, "MELI");
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);
        despaschador.despacharEnvio(envio);

        Assertions.assertThat(envio.getCosto()).isEqualTo(11);
        Assertions.assertThat(envio.getTransporteAsociado()).isInstanceOf(Bicicleta.class);
        Assertions.assertThat(despaschador.getEnviosDespachados()).isEqualTo(11);
    }

    @Test
    public void testEnvioAumentado(){
        Mockito.when(calculadorDeCostos.calcularCosto(Mockito.any())).thenReturn(10);
        Despaschador despaschador = new Despaschador(asignadorVehiculo,calculadorDeCostos);
        Paquete paquete = new Paquete(1);
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paquete);
        Envio envio = despaschador.generarEnvio(paquetes, "MELI");
        envio.aumentarCostoEnvio(10);
        System.out.println(envio.getCosto());
    }

}
