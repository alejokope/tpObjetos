package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import excepciones.NoEsPaisProximoException;
import modelo.Caso;
import modelo.Jugador;
import modelo.Pais;
import modelo.Persona;

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

}
