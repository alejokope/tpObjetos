package test;

import modelo.Villano;
import modelo.lugarInteres.Banco;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void darPista_elDetectivePasaPorElBancoPeroElVillanoNoPasoPorAlli(){
        Banco banco = new Banco();
        Villano villano = mock(Villano.class);

        banco.setVillano(villano);

        banco.darPista().getPista1();
    }

    @Test
    public void darPista_elDetectivePasaPorElBancoYObtienePistaPorqueElVillanoPasoPorAlli(){
        Banco banco = new Banco();
        List<String> señasParticulares = Arrays.asList("Tiene barba");
        List<String> caracteristicasPais = Arrays.asList("bandera celeste y blanca", "sol");
        Villano villano = mock(Villano.class);
        banco.setVillano(villano);
        banco.setPasoVillano(true);

        when(villano.getSeñasParticulares()).thenReturn(señasParticulares);
        when(villano.obtenerCaracteristicasDelPaisProximo()).thenReturn(caracteristicasPais);

        assertNotNull(banco.darPista().getPista1());
    }
}
