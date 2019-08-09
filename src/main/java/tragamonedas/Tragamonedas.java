package tragamonedas;

public class Tragamonedas {

    private Tambor tambor1;
    private Tambor tambor2;
    private Tambor tambor3;

    public Tragamonedas(Tambor tambor1, Tambor tambor2, Tambor tambor3) {
        this.tambor1 = tambor1;
        this.tambor2 = tambor2;
        this.tambor3 = tambor3;
    }

    public void activarTragamonedas(){
        tambor1.girar();
        tambor2.girar();
        tambor3.girar();
    }

    public boolean entregarPremio(){
        Integer posTambor1 = tambor1.getPosicionTambor();
        Integer posTambor2 = tambor2.getPosicionTambor();
        Integer posTambor3 = tambor3.getPosicionTambor();
        return (posTambor1.equals(posTambor2)) && (posTambor1.equals(posTambor3));
    }
}
