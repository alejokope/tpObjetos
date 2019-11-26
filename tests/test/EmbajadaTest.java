package test;

import modelo.Villano;
import modelo.lugarInteres.Embajada;
import org.junit.Test;

import static org.junit.Assert.*;

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

}
