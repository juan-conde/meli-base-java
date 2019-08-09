package enviosPostales;

import java.util.List;
import java.util.function.Consumer;

public class AsignadorVehiculo {

    public AsignadorVehiculo() {}

    public Transporte asignarVehiculo(List<Paquete> paquetes){
        int sum = paquetes.stream().mapToInt(Paquete::getPeso).sum();
        if(sum <= 5){
            return new Bicicleta();
        }
        if(sum <= 50){
            return new Auto();
        }
        if(sum < 150){
            return new Camioneta();
        } else {
            throw new RuntimeException("NO EXISTE VEHICULO PARA ESTO");
        }
    }
}
