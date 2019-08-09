package playaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

public abstract class Utilitarios implements Vehiculo {

    public Integer pesoMaximo;
    public Integer cargaActual;
    public Integer maximaCargaPermitida;
    public List<Carga> carga;

    public Utilitarios() {
        this.pesoMaximo = 0;
        this.cargaActual = 0;
        this.maximaCargaPermitida = 0;
        this.carga = new ArrayList<>();
    }

    @Override
    public void estacionar() {
        System.out.println("ESTACIONANDO");
    }

    public boolean agregarCarga(Carga cargaAAgregar){
        if((cargaAAgregar.peso <= maximaCargaPermitida) && (cargaActual + cargaAAgregar.peso <= pesoMaximo)){
           this.carga.add(cargaAAgregar);
           this.cargaActual += cargaAAgregar.peso;
           return true;
        }
        return false;
    }
}
