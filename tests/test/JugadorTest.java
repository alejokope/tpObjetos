package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import modelo.*;
import org.junit.Test;

import excepciones.NoEsPaisProximoException;

public class JugadorTest {

	@Test
	public void pedirOrdenDeArresto_SePideUnaOrdenDeArrestoANombreDePepeYEstaEsObtenidaASuNombre() {
		Persona ramon = new Persona();
        Caso caso = mock(Caso.class);
		Jugador jugador = new Jugador(caso);

        jugador.pedirOrdenDeArresto(ramon);        
        Persona sospechoso = jugador.getOrdenDeArresto().getSospechoso();

        assertEquals(sospechoso, ramon);
	}
	
	@Test
	public void viajar_ElJugadorIntentaViajarAUnPaisConectadoConElActualYPuede() {
		Pais argentina = new Pais();
        Pais chile = new Pais();
        List<Pais> conexiones = new ArrayList<Pais>();
        Caso caso = mock(Caso.class);
		Jugador jugador = new Jugador(caso);
        
        argentina.setNombre("Argentina");
        chile.setNombre("Chile");
        
        conexiones.add(chile);
        argentina.setConexiones(conexiones);
        
        jugador.setPaisActual(argentina);
        
        jugador.viajar(chile);
        
        assertEquals("Chile", jugador.getPaisActual().getNombre());
	}
	
	@Test(expected = NoEsPaisProximoException.class)
	public void viajar_ElJugadorIntentaViajarAUnPaisNoConectadoConElActualYNoPuede() {
		Pais argentina = new Pais();
        Pais ecuador = new Pais();
        Pais chile = new Pais();
        List<Pais> conexiones = new ArrayList<Pais>();
        Caso caso = mock(Caso.class);
		Jugador jugador = new Jugador(caso);
        
		argentina.setNombre("Argentina");
        ecuador.setNombre("Ecuador");
        chile.setNombre("Chile");
        
        conexiones.add(chile);
        argentina.setConexiones(conexiones);
        
        jugador.setPaisActual(argentina);
        
        jugador.viajar(ecuador);        
	}

    @Test
    public void esLaOrdenDeArrestoCorrecta_laOrdenDeArrestoEsCorrecta(){
	    Caso caso = mock(Caso.class);
	    Villano villano = mock(Villano.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);
	    Jugador jugador = new Jugador(caso);
	    jugador.setOrdenDeArresto(ordenDeArresto);

	    when(ordenDeArresto.getSospechoso()).thenReturn(villano);

	    assertTrue(jugador.esLaOrdenDeArrestoCorrecta(villano));
    }

    @Test
    public void esLaOrdenDeArrestoCorrecta_laOrdenDeArrestoNoEsCorrecta(){
        Caso caso = mock(Caso.class);
        Villano villano = mock(Villano.class);
        Villano villano2 = mock(Villano.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);
        Jugador jugador = new Jugador(caso);
        jugador.setOrdenDeArresto(ordenDeArresto);

        when(ordenDeArresto.getSospechoso()).thenReturn(villano2);

        assertFalse(jugador.esLaOrdenDeArrestoCorrecta(villano));
    }

}
