package tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TamborTest {

    private Tambor tambor1 = new Tambor();

    @Test
    public void posicionTamborEntre1y8(){
        for(int i = 0; i < 40; i++){
            tambor1.girar();
            Assertions.assertThat(tambor1.getPosicionTambor()).isBetween(1,8);
        }
    }
}
