package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Jugador;
import modelo.lugarInteres.*;
import org.junit.Test;

import excepciones.NoHayPaisProximoException;
import modelo.Pais;
import modelo.Villano;

public class VillanoTest {

	@Test
	public void getPaisProximo_ElVillanoObtieneElPaisProximoSegunElPlanDeEscape() {
		Villano villano = new Villano();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		List<Pais> planDeEscape = Arrays.asList(argentina, brasil, chile);

		villano.setPaisActual(argentina);
		villano.setPlanEscape(planDeEscape);
		
		assertEquals(brasil, villano.getPaisProximo());
	}
	
	@Test(expected = NoHayPaisProximoException.class)
	public void getPaisProximo_ElVillanoNoTieneUnPaisProximoSegunElPlanDeEscape() {
		Villano villano = new Villano();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		List<Pais> planDeEscape = Arrays.asList(argentina, brasil, chile);
		
		villano.setPaisActual(chile);
		villano.setPlanEscape(planDeEscape);
		
		villano.getPaisProximo();
	}
	
	@Test
	public void escaparProximoPais_ElVillanoEscapaAlProximoPais() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		Banco banco = new Banco();
		Biblioteca biblioteca = new Biblioteca();
		List<LugarInteres> lugaresInteres = new ArrayList<LugarInteres>();
				
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);

		
		lugaresInteres.add(banco);
		lugaresInteres.add(biblioteca);
		
		brasil.setLugaresInteres(lugaresInteres);
		
		villano.setPaisActual(argentina);
		villano.setPlanEscape(planDeEscape);
		villano.escaparProximoPais();
		
		assertEquals(brasil, villano.getPaisActual());
	}
	
	@Test(expected = NoHayPaisProximoException.class)
	public void escaparProximoPais_ElVillanoNoAPodidoEscapaAUnProximoPais() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);
		
		villano.setPaisActual(chile);
		villano.setPlanEscape(planDeEscape);
		villano.escaparProximoPais();
	}

	@Test
	public void obtenerCaracteristicasDelPaisProximo_obtenerListaDeCaracteristicasDelPaisProximo(){
		Villano villano = new Villano();
		Pais argentina = mock(Pais.class);
		Pais peru = mock(Pais.class);
		villano.setPaisActual(peru);
		villano.setPlanEscape(Arrays.asList(peru, argentina));
		List<String> argCaracteristicas = Arrays.asList("Tiene costa", "Bandera roja y blanca");

		when(argentina.getCaracteristicas()).thenReturn(argCaracteristicas);

		assertEquals(villano.obtenerCaracteristicasDelPaisProximo(), argCaracteristicas);
	}

	@Test
	public void estoyEnElMismoLugarDeInteresQueJugador_villanoEstaEnElMismoLugarQueElJugador(){
		Villano villano = new Villano();
		Embajada embajada = mock(Embajada.class);
		Jugador jugador = mock(Jugador.class);
		villano.setLugarInteresActual(embajada);

		when(jugador.getLugarInteresActual()).thenReturn(embajada);

		assertTrue(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador));
	}

	@Test
	public void estoyEnElMismoLugarDeInteresQueJugador_villanoNoEstaEnElMismoLugarQueElJugador(){
		Villano villano = new Villano();
		Embajada embajada = mock(Embajada.class);
		LugarInteres club = mock(Club.class);
		Jugador jugador = mock(Jugador.class);
		villano.setLugarInteresActual(embajada);

		when(jugador.getLugarInteresActual()).thenReturn(club);

		assertFalse(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador));
	}
}
