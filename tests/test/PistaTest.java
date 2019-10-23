package test;

import modelo.Pista;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PistaTest {

    @Test
    public void creoPista_creoPistaSinParametros(){
        Pista pista = new Pista();

        String resultado = pista.getPista1();

        assertEquals(resultado, null);
    }

    @Test
    public void creoPista_creoPistaConDosParametrosYObtengoLaPrimeraPista(){
        String primerPista = "tiene barba";
        String segundaPista = "le gusta nadar";
        Pista pista = new Pista(primerPista, segundaPista);

        String resultado = pista.getPista1();

        assertEquals(resultado, primerPista);
    }

    @Test
    public void creoPista_creoPistaConDosParametrosYObtengoLaSegundaPista(){
        String primerPista = "tiene bigote";
        String segundaPista = "le gusta esquiar";
        Pista pista = new Pista(primerPista, segundaPista);

        String resultado = pista.getPista2();

        assertEquals(resultado, segundaPista);
    }

    @Test
    public void creoPista_creoPistaConTresParametrosYObtengoLaPistaExtra(){
        String primerPista = "tiene ferrari";
        String segundaPista = "le gusta el futbol";
        String pistaExtra = "vive cerca de la embajada";
        Pista pista = new Pista(primerPista, segundaPista, pistaExtra);

        String resultado = pista.getPistaExtra();

        assertEquals(resultado, pistaExtra);
    }
}
