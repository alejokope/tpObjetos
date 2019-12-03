package vistaTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import modelo.Jugador;
import viewmodel.PresentacionCasoViewModel;
import vista.PresentacionDelCaso;

public class PresentacionDelCasoTest {

	@Test
	public void presentacionDelCaso_seMuestraUnTitulo() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		
		assertNotNull(presentacion.mostrarTitulo());
	}
	
	@Test
	public void presentacionDelCaso_seMuestraUnSaludo() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		
		assertNotNull(presentacion.mostrarSaludo());
	}
	
	@Test
	public void presentacionDelCaso_seMuestraUnRelato() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		
		assertNotNull(presentacion.mostrarRelato());
	}
	
	@Test
	public void presentacionDelCaso_seMuestraUnTituloNuevo() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		presentacion.pedirOtroCaso(modelo);
		
		assertNotNull(presentacion.mostrarTitulo());
	}
	
	@Test
	public void presentacionDelCaso_seMuestraUnSaludoNuevo() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		presentacion.pedirOtroCaso(modelo);
		
		assertNotNull(presentacion.mostrarSaludo());
	}
	
	@Test
	public void presentacionDelCaso_seMuestraUnRelatoNuevo() {
		Jugador jugador = new Jugador("pepe");
		PresentacionCasoViewModel modelo = new PresentacionCasoViewModel();
		modelo.setJugador(jugador);
		
		PresentacionDelCaso presentacion = new PresentacionDelCaso(jugador);
		presentacion.pedirOtroCaso(modelo);
		
		assertNotNull(presentacion.mostrarRelato());
	}
}
