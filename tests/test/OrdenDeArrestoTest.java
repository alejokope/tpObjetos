package test;

import modelo.OrdenDeArresto;
import modelo.Persona;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class OrdenDeArrestoTest {

    @Test
    public void emitirOrdenDeArresto_emitoOrdenDeArrestoYObtengoResponsable(){
        Persona pepe = new Persona();
        OrdenDeArresto orden = new OrdenDeArresto();

        orden.emitirOrdenDeArresto(pepe);

        assertEquals(orden.getSospechoso(), pepe);
    }
}
