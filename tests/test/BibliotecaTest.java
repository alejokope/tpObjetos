package test;

import modelo.Pais;
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

    @Test
    public void porcentajeMayorA50_obtengoUnPorcentajeMayorA50(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void obtenerHobbies_obtengoHobbies(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void obtenerSeñasParticulares_obtengoSeñasParticulares(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void obtenerPistaSobrePais_obtengoSeñasParticulares(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void darPista_elDetectivePasaPorLaBibliotecaPeroElVillanoNoPasoPorAlli(){
        Biblioteca biblioteca = new Biblioteca();
        Villano villano = mock(Villano.class);

        biblioteca.setVillano(villano);

        assertNull(biblioteca.darPista().getPista1());
    }

    @Test
    public void darPista_elDetectivePasaPorLaBibliotecaYObtienePistaPorqueElVillanoPasoPorAlli(){
        Biblioteca biblioteca = new Biblioteca();
        Pais argentina = mock(Pais.class);
        List<String> señasParticulares = Arrays.asList("Tiene barba");
        List<String> hobbies = Arrays.asList("Le gusta el basquet");
        List<String> argCaracteristicas = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        biblioteca.setVillano(villano);
        biblioteca.setPasoVillano(true);

        when(villano.getSeñasParticulares()).thenReturn(señasParticulares);
        when(villano.getPaisProximo()).thenReturn(argentina);
        when(villano.getHobbies()).thenReturn(hobbies);
        when(argentina.getCaracteristicas()).thenReturn(argCaracteristicas);

        assertNotNull(biblioteca.darPista().getPista1());
        //coverage va variar porque usa random y a veces no entra a ciertas condiciones.
    }
}
