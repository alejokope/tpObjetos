package modeloTest;

import modelo.Villano;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.LugarInteres;

import org.junit.Test;

import static org.junit.Assert.*;

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

}
