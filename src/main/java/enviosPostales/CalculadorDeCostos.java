package enviosPostales;

import java.util.List;

public class CalculadorDeCostos {

    public CalculadorDeCostos() {}

    public Integer calcularCosto(List<Paquete> paquetes){
        if (paquetes.size() < 5) {
            return  50;
        }
        if (paquetes.size() < 10) {
            return 80;
        }
        return paquetes.size() * 15;
    }
}
