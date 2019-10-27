package test;

import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Club;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClubTest {

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        Club club = new Club();

        String nombreClub = "CLUB";

        assertEquals(club.informacion(), nombreClub);
    }

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        Club club = new Club();
        Villano villano = new Villano();

        club.setVillano(villano);

        assertEquals(club.getVillano(), villano);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorElClubEntoncesEstoCambiaATrue(){
        Club club = new Club();

        club.setPasoVillano(true);

        assertTrue(club.getPasoVillano());
    }

    @Test
    public void obtenerSeñasParticulares_obtengoSeñasParticulares(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void obtenerHobbies_obtengoHobbies(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void porcentajeMayorA70_obtengoUnPorcentajeMayorA70(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void darPista_elDetectivePasaPorElClubPeroElVillanoNoPasoPorAlli(){
        Club club = new Club();
        Villano villano = mock(Villano.class);

        club.setVillano(villano);

        club.darPista().getPista1();
    }

    @Test
    public void darPista_elDetectivePasaPorElClubYObtienePistaPorqueElVillanoPasoPorAlli(){
        Club banco = new Club();
        Pais argentina = mock(Pais.class);
        List<String> señasParticulares = Arrays.asList("Tiene barba");
        List<String> hobbies = Arrays.asList("Le gusta el basquet");
        List<String> argCaracteristicas = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        banco.setVillano(villano);
        banco.setPasoVillano(true);

        when(villano.getSeñasParticulares()).thenReturn(señasParticulares);
        when(villano.getPaisProximo()).thenReturn(argentina);
        when(villano.getHobbies()).thenReturn(hobbies);
        when(argentina.getCaracteristicas()).thenReturn(argCaracteristicas);

        assertNotNull(banco.darPista().getPista1());
        //coverage va variar porque usa random y a veces no entra a ciertas condiciones.
    }
}
