package enviosPostales;

import java.util.List;

public class Envio {

    private List<Paquete> paquetes;
    private Integer costo;
    private String direccionEntrega;
    private Transporte transporteAsociado;

    public Envio(List<Paquete> paquetes, String direccionEntrega,
                 AsignadorVehiculo asignadorVehiculo, CalculadorDeCostos calculadorDeCostos) {
        this.paquetes = paquetes;
        this.direccionEntrega = direccionEntrega;
        this.costo = calculadorDeCostos.calcularCosto(paquetes);
        this.transporteAsociado = asignadorVehiculo.asignarVehiculo(paquetes);
    }

    public void aumentarCostoEnvio(Integer porcentaje){
        this.costo = costo + (costo * porcentaje / 100);
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public Integer getCosto() {
        return costo;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public Transporte getTransporteAsociado() {
        return transporteAsociado;
    }
}
