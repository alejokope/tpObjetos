package test;

import modelo.Ayuda;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AyudaTest {

    @Test
    public void creoAyuda_creoAyudaConUnParametroYObtengoLaPrimeraPista(){
        String primeraPista = "tiene barba";

        Ayuda ayuda = new Ayuda(Arrays.asList(primeraPista));

        String resultado = ayuda.getPista1();

        assertEquals(resultado, primeraPista);
    }

    @Test
    public void creoAyuda_creoAyudaConDosParametrosYObtengoLaSegundaPista(){
        String primeraPista = "tiene bigote";
        String segundaPista = "le gusta esquiar";
        Ayuda ayuda = new Ayuda(Arrays.asList(primeraPista, segundaPista));

        String resultado = ayuda.getPista2();

        assertEquals(resultado, segundaPista);
    }

    @Test
    public void creoAyuda_creoAyudaConTresParametrosYObtengoLaPistaExtra(){
        String primeraPista = "tiene ferrari";
        String segundaPista = "le gusta el futbol";
        String pistaExtra = "vive cerca de la embajada";

        Ayuda ayuda = new Ayuda(Arrays.asList(primeraPista, segundaPista, pistaExtra));

        String resultado = ayuda.getPistaExtra();

        assertEquals(resultado, pistaExtra);
    }

    @Test
    public void agregarUnaPista_agregoUnaPistaALaListaDePistas(){
        String primeraPista = "vivio en italia";
        Ayuda ayuda = new Ayuda();

        ayuda.agregarUnaPista(primeraPista);

        assertEquals(ayuda.getPistas().size(), 1);
    }

    @Test
    public void agregarDosPistas_agregoDosPistasALaListaDePistas(){
        String primeraPista = "vivio en italia";
        String segundaPista = "estudia en japon";
        Ayuda ayuda = new Ayuda();

        ayuda.agregarDosPistas(primeraPista, segundaPista);

        assertEquals(ayuda.getPistas().size(), 2);
    }
}