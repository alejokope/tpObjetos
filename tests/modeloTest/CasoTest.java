package modeloTest;

import modelo.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CasoTest {

    @Test
    public void setResponsable_seteoUnResponsableParaElCasoYObtengoUnoTambien(){
        Caso caso = new Caso();
        Villano villano = new Villano();

        caso.setResponsable(villano);

        assertEquals(caso.getResponsable(), villano);
    }

    @Test
    public void setReporte_seteoUnReporteParaElCasoYObtengoUnoTambien(){
        Caso caso = new Caso();

        String reporteMandado = "Urgente se escapo el delincuente";
        caso.setReporte(reporteMandado);

        assertEquals(caso.getReporte(), reporteMandado);

    }

    @Test
    public void setObjeto_seteoUnObjetoParaElCasoYObtengoUnoTambien(){
        Caso caso = new Caso();

        String objetoMandado = "Caja de arena para gatos";
        caso.setObjeto(objetoMandado);

        assertEquals(caso.getObjeto(), objetoMandado);

    }

    @Test
    public void setPaisOrigen_seteoUnPaisOrigenParaElCasoYObtengoUnoTambien(){
        Caso caso = new Caso();
        Pais argentina = new Pais();

        caso.setPaisOrigen(argentina);

        assertEquals(caso.getPaisOrigen(), argentina);

    }
}
