package playaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

public class PlayaDeCarga {

    ///////////////////////////////////////////////////////////////////////////////////
    private PlayaDeCarga() {}

    private static class LazyHolder {
        static final PlayaDeCarga INSTANCE = new PlayaDeCarga();
    }

    public static PlayaDeCarga getInstance() {
        return LazyHolder.INSTANCE;
    }
    ///////////////////////////////////////////////////////////////////////////////////

    private List<Utilitarios> utilitariosACargar = new ArrayList<>();
    private List<Carga> cargas = new ArrayList<>();

    public void agregarUtilitarioACargar(Utilitarios utilitario){
        if(cargas.size() > 0){
            utilitariosACargar.add(utilitario);
        }
    }

    public void agregarCarga(Carga carga){
        if (carga != null){
            cargas.add(carga);
        }
    }

    public List<Utilitarios> getUtilitariosACargar(){
        return utilitariosACargar;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public void limpiarSingleton(){
        cargas.clear();
        utilitariosACargar.clear();
    }
}
