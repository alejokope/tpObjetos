package test;

import modelo.Villano;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.LugarInteres;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClubTest {

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        LugarInteres club = new Club();

        String nombreClub = "CLUB";

        assertEquals(club.informacion(), nombreClub);
    }

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        LugarInteres club = new Club();
        Villano villano = new Villano();

        club.setVillano(villano);

        assertEquals(club.getVillano(), villano);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorElClubEntoncesEstoCambiaATrue(){
        LugarInteres club = new Club();

        club.setPasoVillano(true);

        assertTrue(club.getPasoVillano());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void darPista_elDetectivePasaPorElClubPeroElVillanoNoPasoPorAlli(){
        LugarInteres club = new Club();
        Villano villano = mock(Villano.class);

        club.setVillano(villano);

        club.darPista().getPista1();
    }

    @Test
    public void darPista_elDetectivePasaPorElClubYObtienePistaPorqueElVillanoPasoPorAlli(){
        LugarInteres banco = new Club();
        List<String> señasParticulares = Arrays.asList("Tiene barba", "mide mas de 150cm");
        List<String> hobbies = Arrays.asList("Le gusta el basquet");
        Villano villano = mock(Villano.class);
        banco.setVillano(villano);
        banco.setPasoVillano(true);

        when(villano.getSeñasParticulares()).thenReturn(señasParticulares);
        when(villano.getHobbies()).thenReturn(hobbies);

        assertNotNull(banco.darPista().getPista1());
    }
}
