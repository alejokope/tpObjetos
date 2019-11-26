package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import modelo.Jugador;
import org.junit.Test;

import excepciones.NoHayPaisProximoException;
import modelo.Pais;
import modelo.Villano;

public class VillanoTest {

	@Test
	public void getPaisProximo_ElVillanoObtieneElPaisProximoQueElJugadorDebeSeguirSegunElPlanDeEscape() {
		Villano villano = new Villano();
		Jugador jugador = mock(Jugador.class);
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		villano.setPlanEscape(Arrays.asList(argentina, brasil, chile));

		villano.setPaisActual(chile);
		when(jugador.getPaisActual()).thenReturn(argentina);
		
		assertEquals(brasil, villano.getPaisProximo(jugador));
	}

	@Test
	public void getPaisProximo_ElVillanoNoTieneUnPaisProximoQueElJugadorDebeSeguirPorqueEsElUltimoSegunElPlanDeEscape() {
		Villano villano = new Villano();
		Jugador jugador = mock(Jugador.class);
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		villano.setPlanEscape(Arrays.asList(argentina, brasil, chile));
		
		villano.setPaisActual(chile);
		when(jugador.getPaisActual()).thenReturn(chile);
		
		assertEquals(chile, villano.getPaisProximo(jugador));
	}

	@Test
	public void obtenerCaracteristicasDelPaisProximo_obtenerListaDeCaracteristicasDelPaisProximo(){
		Villano villano = new Villano();
		Jugador jugador = mock(Jugador.class);
		Pais argentina = mock(Pais.class);
		Pais peru = mock(Pais.class);
		villano.setPlanEscape(Arrays.asList(peru, argentina));
		villano.setPaisActual(argentina);
		List<String> argCaracteristicas = Arrays.asList("Tiene costa", "Bandera roja y blanca");

		when(argentina.getCaracteristicas()).thenReturn(argCaracteristicas);
		when(jugador.getPaisActual()).thenReturn(peru);

		assertEquals(villano.obtenerCaracteristicasDelPaisProximo(jugador), argCaracteristicas);
	}

}
