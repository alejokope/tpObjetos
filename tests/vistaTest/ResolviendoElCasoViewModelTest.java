package vistaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import modelo.Caso;
import modelo.CasoAJugar;
import modelo.Jugador;
import modelo.Pais;
import modelo.Villano;
import viewmodel.ResolviendoElCasoViewModel;

public class ResolviendoElCasoViewModelTest {
	
	@Test
	public void estaPaisActualEnPlanEscape_elPaisEstaEnElPlanDeEscape() {
		Villano villano = new Villano();
		Jugador jugador = new Jugador("gonzalez");
		Pais arg = new Pais();
		Pais ven = new Pais();
		Caso caso = new Caso();
		CasoAJugar casoAJugar = new CasoAJugar();
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		arg.setNombre("argentina");
		ven.setNombre("venezuela");
		villano.setPlanEscape(Arrays.asList(arg, ven));
		caso.setResponsable(villano);
		caso.setPlanEscape(villano.getPlanEscape());
		jugador.setPaisActual(arg);
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		modelo.setCasoAJugar(casoAJugar);
	
		assertTrue(modelo.estaPaisActualEnPlanEscape());
	}

	@Test
	public void estaPaisActualEnPlanEscape_elPaisNoEstaEnElPlanDeEscape() {
		Villano villano = new Villano();
		Jugador jugador = new Jugador("gonzalez");
		Pais arg = new Pais();
		Pais ven = new Pais();
		Pais otro = new Pais();
		Caso caso = new Caso();
		CasoAJugar casoAJugar = new CasoAJugar();
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		arg.setNombre("argentina");
		ven.setNombre("venezuela");
		otro.setNombre("inglaterra");
		villano.setPlanEscape(Arrays.asList(arg, ven));
		caso.setResponsable(villano);
		caso.setPlanEscape(villano.getPlanEscape());
		jugador.setPaisActual(otro);
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		modelo.setCasoAJugar(casoAJugar);
	
		assertFalse(modelo.estaPaisActualEnPlanEscape());
	}
	
	@Test
	public void hayVillanoCapturado_hayUnVillanoConOrdenDeArresto() {
		Villano villano = new Villano();
		Jugador jugador = new Jugador("gonzalez");
		CasoAJugar casoAJugar = new CasoAJugar();
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		jugador.pedirOrdenDeArresto(villano);
		casoAJugar.setJugador(jugador);
		modelo.setCasoAJugar(casoAJugar);
		
		assertTrue(modelo.hayVillanoCapturado());
	}
	
	@Test
	public void hayVillanoCapturado_noHayUnVillanoConOrdenDeArresto() {
		Villano villano = new Villano();
		Jugador jugador = new Jugador("gonzalez");
		CasoAJugar casoAJugar = new CasoAJugar();
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		casoAJugar.setJugador(jugador);
		modelo.setCasoAJugar(casoAJugar);
		
		assertFalse(modelo.hayVillanoCapturado());
	}
	
	
}
