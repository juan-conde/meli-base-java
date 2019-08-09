package tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TragamonedasTest {

    @Mock Tambor tambor1;
    @Mock Tambor tambor2;
    @Mock Tambor tambor3;

    private Tragamonedas tragamonedas;

    @Test
    public void tragamonedasDaPremio(){
        Mockito.when(tambor1.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor2.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor3.getPosicionTambor()).thenReturn(3);

        tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);
        tragamonedas.activarTragamonedas();
        Assertions.assertThat(tragamonedas.entregarPremio()).isTrue();
        System.out.println("GO GO MELI GO GO");
        System.out.println("GANASTE TODA LA PLATITA");
        System.out.println("GO GO MELI GO GO");
    }

    @Test
    public void tragamonedasNoDaPremio(){
        Mockito.when(tambor1.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor2.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor3.getPosicionTambor()).thenReturn(1);

        tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);
        tragamonedas.activarTragamonedas();
        Assertions.assertThat(tragamonedas.entregarPremio()).isFalse();
        System.out.println("STOP STOP MELI STOP STOP");
        System.out.println("NO GANASTE NADA");
        System.out.println("STOP STOP MELI STOP STOP");
    }

    @Test
    public void asd(){
        Mockito.when(tambor1.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor2.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor3.getPosicionTambor()).thenReturn(1);

        tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);
        tragamonedas.activarTragamonedas();

        Mockito.verify(tambor1, Mockito.times(1)).girar();
        Mockito.verify(tambor2, Mockito.times(1)).girar();
        Mockito.verify(tambor3, Mockito.times(1)).girar();
    }

    @Test
    public void asda(){
        Mockito.when(tambor1.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor2.getPosicionTambor()).thenReturn(3);
        Mockito.when(tambor3.getPosicionTambor()).thenReturn(1);

        tragamonedas = new Tragamonedas(tambor1,tambor2,tambor3);

        Mockito.verify(tambor1,Mockito.never()).girar();
        Mockito.verify(tambor2,Mockito.never()).girar();
        Mockito.verify(tambor3,Mockito.never()).girar();
    }
}
