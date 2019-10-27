package test;

import modelo.Pais;
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

    @Test
    public void obtenerSeñasParticulares_obtengoSeñasParticulares(){
        //es privado, ademas no se puede testear facilmente.
    }

    @Test
    public void obtenerPistaSobrePais_obtengoPistaSobrePais(){
        //es privado, ademas no se puede testear facilmente.
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
