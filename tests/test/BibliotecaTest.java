package test;

import modelo.Villano;
import modelo.lugarInteres.Biblioteca;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        Biblioteca biblioteca = new Biblioteca();
        Villano villano = new Villano();

        biblioteca.setVillano(villano);

        assertEquals(biblioteca.getVillano(), villano);
    }

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        Biblioteca biblioteca = new Biblioteca();

        String informacion = "BIBLIOTECA";

        assertEquals(biblioteca.informacion(), informacion);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorLaBibliotecaEntoncesEstoCambiaATrue(){
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.setPasoVillano(true);

        assertTrue(biblioteca.getPasoVillano());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void darPista_elDetectivePasaPorLaBibliotecaPeroElVillanoNoPasoPorAlli(){
        Biblioteca biblioteca = new Biblioteca();
        Villano villano = mock(Villano.class);

        biblioteca.setVillano(villano);

        biblioteca.darPista().getPista1();
    }

    @Test
    public void darPista_elDetectivePasaPorLaBibliotecaYObtienePistaPorqueElVillanoPasoPorAlli(){
        Biblioteca biblioteca = new Biblioteca();
        List<String> señasParticulares = Arrays.asList("Tiene barba");
        List<String> hobbies = Arrays.asList("Le gusta el basquet");
        List<String> caracteristicasPais = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        biblioteca.setVillano(villano);
        biblioteca.setPasoVillano(true);

        when(villano.getSeniasParticulares()).thenReturn(señasParticulares);
        when(villano.getHobbies()).thenReturn(hobbies);
        when(villano.obtenerCaracteristicasDelPaisProximo()).thenReturn(caracteristicasPais);

        assertNotNull(biblioteca.darPista().getPista1());
    }
}
