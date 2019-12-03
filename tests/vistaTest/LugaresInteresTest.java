package vistaTest;

import modelo.*;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import modelo.lugarInteres.LugarInteres;
import viewmodel.LugarInteresViewModel;
import vista.LugarInteresVista;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LugaresInteresTest {
	
	    @Test
	    public void lugarInteresVista_elVillanoPasoPorElPaisYSeMuestraElMensajeCorrespondiente(){
	    	CasoAJugar casoAJugar = new CasoAJugar();
	        Club club = new Club();
	        LugarInteres lugarInteres2 = new LugarInteres();
	        LugarInteres lugarInteres3 = new LugarInteres();
	        LugarInteres lugarInteresVillano = new LugarInteres();
	        LugarInteres lugarInteresVillano2 = new LugarInteres();
	        Pais pais = new Pais();
	        Pais pais2 = new Pais();
	        Jugador jugador = new Jugador("pepe");
	        Caso caso = new Caso();
	        caso.setTitulo("Tomatelas flaco");

	        pais.setNombre("Alemania");
	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setNombre("Francia");
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        caso.setResponsable(villano);
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.setCaso(caso);
	        casoAJugar.getCaso().setResponsable(villano);
	        
	        String pista = club.darPista(casoAJugar);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(new LugarInteresViewModel(casoAJugar, club));

	        assertNotNull(visitandoLugar.obtenerPista()); //aca los mensajes enviados son random.
	    }

	    @Test
	    public void lugarInteresVista_elVillanoNoPasoPorElPaisYSeMuestraElMensajeCorrespondiente(){
	    	CasoAJugar casoAJugar = new CasoAJugar();
	        Embajada embajada = new Embajada();
	        LugarInteres lugarInteres2 = new LugarInteres();
	        LugarInteres lugarInteres3 = new LugarInteres();
	        LugarInteres lugarInteresVillano = new LugarInteres();
	        LugarInteres lugarInteresVillano2 = new LugarInteres();
	        LugarInteres lugarInteresFallido = new LugarInteres();
	        LugarInteres lugarInteresFallido2 = new LugarInteres();
	        Pais pais = new Pais();
	        Pais pais2 = new Pais();
	        Pais paisFallido = new Pais();
	        Jugador jugador = new Jugador("pepe");
	        Caso caso = new Caso();
	        caso.setTitulo("Tomatelas flaco");

	        pais.setNombre("Portugal");
	        pais.setLugaresInteres(Arrays.asList(embajada, lugarInteres2, lugarInteres3));
	        pais2.setNombre("España");
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        paisFallido.setNombre("China");
	        paisFallido.setLugaresInteres(Arrays.asList(lugarInteresFallido, lugarInteresFallido2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        pais2.setCaracteristicas(Arrays.asList("tiene mar", "muy limpio"));
	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        caso.setResponsable(villano);
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(paisFallido);
	        casoAJugar.setJugador(jugador);
	        
	        casoAJugar.setCaso(caso);
	        casoAJugar.getCaso().setResponsable(villano);
	        
	        String pista = lugarInteresFallido2.darPista(casoAJugar);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(new LugarInteresViewModel(casoAJugar, lugarInteresFallido2));

	        assertEquals(pista, visitandoLugar.obtenerPista());
	    }

	    @Test
	    public void lugarInteresVista_elVillanoEstaEnElPaisDelJugadorYSeMuestraElMensajeCorrespondiente(){
	    	CasoAJugar casoAJugar = new CasoAJugar();
	        Club club = new Club();
	        LugarInteres lugarInteres2 = new LugarInteres();
	        LugarInteres lugarInteres3 = new LugarInteres();
	        LugarInteres lugarInteresVillano = new LugarInteres();
	        LugarInteres lugarInteresVillano2 = new LugarInteres();
	        Pais pais = new Pais();
	        Pais pais2 = new Pais();
	        Jugador jugador = new Jugador("pepe");
	        Caso caso = new Caso();
	        caso.setTitulo("Tomatelas flaco");

	        pais.setNombre("Estados Unidos");
	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setNombre("Mexico");
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        villano.setLugarInteresActual(lugarInteresVillano); 
	        caso.setResponsable(villano);
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais2);
	        jugador.setLugarInteresActual(lugarInteresVillano2);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.setCaso(caso);
	        casoAJugar.getCaso().setResponsable(villano);
	        
	        String pista = lugarInteresVillano2.darPista(casoAJugar);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(new LugarInteresViewModel(casoAJugar, lugarInteresVillano2));


	        assertEquals(pista, visitandoLugar.obtenerPista());
	    }

	    @Test
	    public void lugarInteresVista_ambosSeEncuentranYSeMuestraElMensajeCorrespondiente(){
	    	CasoAJugar casoAJugar = new CasoAJugar();
	        Club club = new Club();
	        LugarInteres lugarInteres2 = new LugarInteres();
	        LugarInteres lugarInteres3 = new LugarInteres();
	        LugarInteres lugarInteresVillano = new LugarInteres();
	        LugarInteres lugarInteresVillano2 = new LugarInteres();
	        Pais pais = new Pais();
	        Pais pais2 = new Pais();
	        Jugador jugador = new Jugador("pepe");
	        Caso caso = new Caso();
	        caso.setTitulo("Tomatelas flaco");

	        pais.setNombre("Peru");
	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setNombre("Brasil");
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setNombre("el flaco");
	        villano.setPaisActual(pais);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        villano.setLugarInteresActual(lugarInteresVillano2); 
	        caso.setResponsable(villano);
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais2);
	        jugador.pedirOrdenDeArresto(villano);
	        jugador.setLugarInteresActual(lugarInteresVillano2);
	        
	        casoAJugar.setJugador(jugador);
	        casoAJugar.setCaso(caso);
	        casoAJugar.getCaso().setResponsable(villano);
	        
	        String pista = lugarInteresVillano2.darPista(casoAJugar);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(new LugarInteresViewModel(casoAJugar, lugarInteres2));

	        assertEquals(pista, visitandoLugar.obtenerPista());
	    }
	}