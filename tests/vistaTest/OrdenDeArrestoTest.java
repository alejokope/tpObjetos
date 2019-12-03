package vistaTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Caso;
import modelo.CasoAJugar;
import modelo.Jugador;
import modelo.Villano;
import viewmodel.ResolviendoElCasoViewModel;
import vista.OrdenDeArresto;

public class OrdenDeArrestoTest {
	
	@Test
	public void ordenDeArresto_seEmiteUnaOrdenDeArresto() {
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		Jugador jugador = new Jugador("perez");
		
		Villano villano = new Villano();
		villano.setNombre("lala");
		
		Caso caso = new Caso();
		caso.setResponsable(villano);

		CasoAJugar casoAJugar = new CasoAJugar();
		
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		
		modelo.setCasoAJugar(casoAJugar);
		OrdenDeArresto orden = new OrdenDeArresto(modelo);
		orden.setNombreVillano(villano.getNombre());
		
		assertEquals(orden.getNombreVillano(), villano.getNombre());
		
	}
	
	@Test
	public void ordenDeArresto_noSeEmiteUnaOrdenDeArrestoPorqueYaExistiaUnaAnterior() {
		ResolviendoElCasoViewModel modelo = new ResolviendoElCasoViewModel();
		
		Jugador jugador = new Jugador("perez");
		
		Villano villano = new Villano();
		villano.setNombre("lala");
		
		Caso caso = new Caso();
		caso.setResponsable(villano);

		CasoAJugar casoAJugar = new CasoAJugar();
		
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		
		modelo.setCasoAJugar(casoAJugar);
		OrdenDeArresto orden = new OrdenDeArresto(modelo);
		orden.setNombreVillano(villano.getNombre());
		
		jugador.pedirOrdenDeArresto(villano);
		
		assertEquals(orden.getNombreVillano(), villano.getNombre());
		
	}

}
