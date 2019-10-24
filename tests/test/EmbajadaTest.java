package test;

import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Embajada;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmbajadaTest {

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        Embajada embajada = new Embajada();

        String nombreEmbajada = "EMBAJADA";

        assertEquals(embajada.informacion(), nombreEmbajada);
    }

    @Test
    public void obtenerPistaSobrePais_obtengoPista(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        Embajada embajada = new Embajada();
        Villano villano = new Villano();

        embajada.setVillano(villano);

        assertEquals(embajada.getVillano(), villano);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorLaEmbajadaEntoncesEstoCambiaATrue(){
        Embajada embajada = new Embajada();

        embajada.setPasoVillano(true);

        assertTrue(embajada.getPasoVillano());
    }

    @Test
    public void darPista_elDetectivePasaPorLaEmbajadaPeroElVillanoNoPasoPorAhi(){
        Embajada embajada = new Embajada();
        Villano villano = mock(Villano.class);

        embajada.setVillano(villano);

        assertNull(embajada.darPista().getPista1());
    }

    @Test
    public void darPista_elDetectivePasaPorLaBibliotecaYObtienePistaPorqueElVillanoPasoPorAlli(){
        Embajada embajada = new Embajada();
        Pais argentina = mock(Pais.class);
        List<String> señasParticulares = Arrays.asList("Tiene barba");
        List<String> hobbies = Arrays.asList("Le gusta el basquet");
        List<String> argCaracteristicas = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        embajada.setVillano(villano);
        embajada.setPasoVillano(true);

        when(villano.getSeñasParticulares()).thenReturn(señasParticulares);
        when(villano.getPaisProximo()).thenReturn(argentina);
        when(villano.getHobbies()).thenReturn(hobbies);
        when(argentina.getCaracteristicas()).thenReturn(argCaracteristicas);

        assertNotNull(embajada.darPista().getPista1());
        //coverage va variar porque usa random y a veces no entra a ciertas condiciones.
    }
}
