package test;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void darPista_elDetectivePasaPorLaEmbajadaPeroElVillanoNoPasoPorAhi(){
        Embajada embajada = new Embajada();
        Villano villano = mock(Villano.class);

        embajada.setVillano(villano);

        embajada.darPista().getPista1();
    }

    @Test
    public void darPista_elDetectivePasaPorLaEmbajadaYObtienePistaPorqueElVillanoPasoPorAlli(){
        Embajada embajada = new Embajada();
        List<String> caracteristicasPais = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        embajada.setVillano(villano);
        embajada.setPasoVillano(true);

        when(villano.obtenerCaracteristicasDelPaisProximo()).thenReturn(caracteristicasPais);

        assertNotNull(embajada.darPista().getPista1());
    }
}
