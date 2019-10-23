package test;

import modelo.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MundoTest {

    @Test
    public void setPaises_seteoPaisesEnElMundoYDevuelvoPaisesTambien(){
        Mundo mundo = new Mundo();
        Pais argentina = new Pais();
        Pais peru = new Pais();
        Pais chile = new Pais();
        Pais mexico = new Pais();
        List<Pais> paises = Arrays.asList(argentina, peru, chile, mexico);

        mundo.setPaises(paises);

        assertEquals(mundo.getPaises(), paises);
    }
}
