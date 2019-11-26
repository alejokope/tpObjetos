package test;

import modelo.Villano;
import modelo.lugarInteres.Banco;
import org.junit.Test;

import static org.junit.Assert.*;


public class BancoTest {

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        Banco banco = new Banco();

        String nombreBanco = "BANCO";

        assertEquals(banco.informacion(), nombreBanco);
    }

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        Banco banco = new Banco();
        Villano villano = new Villano();

        banco.setVillano(villano);

        assertEquals(banco.getVillano(), villano);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorElBancoEntoncesEstoCambiaATrue(){
        Banco banco = new Banco();

        banco.setPasoVillano(true);

        assertTrue(banco.getPasoVillano());
    }

}
