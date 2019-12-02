package vistaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import modelo.CasoAJugar;
import modelo.Caso;
import modelo.DataDummy;
import modelo.Jugador;
import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Club;
import viewmodel.SingletonDataDummy;
import vista.FinalDelJuego;

public class FinalDelJuegoTest {
	
	@Test
	public void finalDelJuego_muestroQuePerdi() {
		DataDummy dataDummy = SingletonDataDummy.getInstance();
		CasoAJugar casoAJugar = new CasoAJugar();
		
		Club club = new Club();
		Pais argentina = new Pais();
		Jugador jugador = new Jugador("pepe");
		Villano villano = new Villano();
		jugador.setPaisActual(argentina);
		jugador.setLugarInteresActual(club);
		villano.setPaisActual(argentina);
		villano.setLugarInteresActual(club);
		argentina.setNombre("argentina");
		Caso caso = new Caso();
		caso.setObjeto("lalala");
		villano.setNombre("el barto");
		
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		casoAJugar.getCaso().setResponsable(villano);
		dataDummy.setJugadorAsignado(jugador);
		dataDummy.setVillanoAsignado(villano);
		dataDummy.setCasoAsignado(caso);
		dataDummy.setearCarmenSanDiego(casoAJugar);
		
		Villano villano2 = new Villano();
		villano2.setNombre("bart");
		jugador.pedirOrdenDeArresto(villano2);
		
		FinalDelJuego finalDelJuego = new FinalDelJuego(casoAJugar);
		
	//	assertEquals(finalDelJuego.obtenerPrimerOracion(), "Malas noticias.....");
		
	}
	
	@Test
	public void finalDelJuego_muestroQueGane() {
		DataDummy dataDummy = SingletonDataDummy.getInstance();
		CasoAJugar casoAJugar = new CasoAJugar();
		
		Club club = new Club();
		Pais argentina = new Pais();
		argentina.setNombre("argentina");
		
		Jugador jugador = new Jugador("pepe");
		Villano villano = new Villano();
		jugador.setPaisActual(argentina);
		jugador.setLugarInteresActual(club);
		villano.setPaisActual(argentina);
		villano.setLugarInteresActual(club);
		
		Caso caso = new Caso();
		caso.setObjeto("lalala");
		villano.setNombre("el barto");
		
		casoAJugar.setCaso(caso);
		casoAJugar.setJugador(jugador);
		casoAJugar.getCaso().setResponsable(villano);
		dataDummy.setJugadorAsignado(jugador);
		dataDummy.setVillanoAsignado(villano);
		dataDummy.setCasoAsignado(caso);
		dataDummy.setearCarmenSanDiego(casoAJugar);
		jugador.pedirOrdenDeArresto(villano);
		
		FinalDelJuego finalDelJuego = new FinalDelJuego(casoAJugar);
		
		
		//assertEquals(finalDelJuego.obtenerPrimerOracion(), "Enhorabuena!");
		
	}
}
