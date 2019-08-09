package enviosPostales;

import java.util.List;

public class Despaschador {

    private Integer enviosDespachados;
    private AsignadorVehiculo asignadorVehiculo;
    private CalculadorDeCostos calculadorDeCostos;

    public Despaschador(AsignadorVehiculo asignadorVehiculo, CalculadorDeCostos calculadorDeCostos) {
        this.asignadorVehiculo = asignadorVehiculo;
        this.calculadorDeCostos = calculadorDeCostos;
        this.enviosDespachados = 0;
    }

    public Envio generarEnvio(List<Paquete> paquetes, String direccionDeEntrega){
        return new Envio(paquetes, direccionDeEntrega, asignadorVehiculo, calculadorDeCostos);

    }

    public void despacharEnvio(Envio envio){
        if(enviosDespachados >= 10){
            envio.aumentarCostoEnvio(10);
        }
        enviosDespachados++;
        System.out.println("DESPACHANDO ENVIO");
    }

    public Integer getEnviosDespachados() {
        return enviosDespachados;
    }
}
