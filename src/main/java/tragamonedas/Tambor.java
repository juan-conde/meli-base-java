package tragamonedas;

import java.util.Random;

public class Tambor {

    private Integer posicionTambor;

    public Tambor() {
        girar();
    }

    public void girar(){
        Random r = new Random();
        int i = r.nextInt(8 - 1 + 1);
        i++;
        this.posicionTambor = i;
    }

    public Integer getPosicionTambor() {
        return posicionTambor;
    }
}
