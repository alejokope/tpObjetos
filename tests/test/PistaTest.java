package test;

import modelo.Pista;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PistaTest {

    @Test
    public void creoPista_creoPistaConUnParametroYObtengoLaPrimeraPista(){
        String primeraPista = "tiene barba";

        Pista pista = new Pista(Arrays.asList(primeraPista));

        String resultado = pista.getPista1();

        assertEquals(resultado, primeraPista);
    }

    @Test
    public void creoPista_creoPistaConDosParametrosYObtengoLaSegundaPista(){
        String primeraPista = "tiene bigote";
        String segundaPista = "le gusta esquiar";
        Pista pista = new Pista(Arrays.asList(primeraPista, segundaPista));

        String resultado = pista.getPista2();

        assertEquals(resultado, segundaPista);
    }

    @Test
    public void creoPista_creoPistaConTresParametrosYObtengoLaPistaExtra(){
        String primeraPista = "tiene ferrari";
        String segundaPista = "le gusta el futbol";
        String pistaExtra = "vive cerca de la embajada";

        Pista pista = new Pista(Arrays.asList(primeraPista, segundaPista, pistaExtra));

        String resultado = pista.getPistaExtra();

        assertEquals(resultado, pistaExtra);
    }

    @Test
    public void agregarUnaPista_agregoUnaPistaALaListaDePistas(){
        String primeraPista = "vivio en italia";
        Pista pista = new Pista();

        pista.agregarUnaPista(primeraPista);

        assertEquals(pista.getPistas().size(), 1);
    }

    @Test
    public void agregarDosPistas_agregoDosPistasALaListaDePistas(){
        String primeraPista = "vivio en italia";
        String segundaPista = "estudia en japon";
        Pista pista = new Pista();

        pista.agregarDosPistas(primeraPista, segundaPista);

        assertEquals(pista.getPistas().size(), 2);
    }



}
