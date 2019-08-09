package playaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

public class PlayaDeEstacionamiento {

    ///////////////////////////////////////////////////////////////////////////////////
    private PlayaDeEstacionamiento() {}

    private static class LazyHolder {
        static final PlayaDeEstacionamiento INSTANCE = new PlayaDeEstacionamiento();
    }

    public static PlayaDeEstacionamiento getInstance() {
        return LazyHolder.INSTANCE;
    }
    ///////////////////////////////////////////////////////////////////////////////////

    private List<Vehiculo> vehiculosEstacionados = new ArrayList<>();

    public void estacionarVehiculo(Vehiculo vehiculo){
        vehiculosEstacionados.add(vehiculo);
    }

    public List<Vehiculo> getVehiculosEstacionados() {
        return vehiculosEstacionados;
    }
}
