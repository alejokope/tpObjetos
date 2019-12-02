package vistaTest;

import modelo.*;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import modelo.lugarInteres.LugarInteres;
import vista.LugarInteresVista;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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

	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais2);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        caso.setResponsable(villano);
	        caso.setPlanEscape(villano.getPlanEscape());
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.getCaso().setResponsable(villano);
	        casoAJugar.setCaso(caso);
	        casoAJugar.actualizarEstadoDeMensaje();
	        club.darPista(jugador);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(club);

	        assertEquals(casoAJugar.getEstadoDeMensaje().mostrarMensaje(casoAJugar,club.getAyuda()), visitandoLugar.obtenerPista());
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

	        pais.setLugaresInteres(Arrays.asList(embajada, lugarInteres2, lugarInteres3));
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        paisFallido.setLugaresInteres(Arrays.asList(lugarInteresFallido, lugarInteresFallido2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais2);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        pais2.setCaracteristicas(Arrays.asList("tiene mar", "muy limpio"));
	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        caso.setResponsable(villano);
	        caso.setPlanEscape(villano.getPlanEscape());
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(paisFallido);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.getCaso().setResponsable(villano);
	        casoAJugar.setCaso(caso);
	        casoAJugar.actualizarEstadoDeMensaje();
	        lugarInteresFallido2.darPista(jugador);
	        LugarInteresVista visitandoLugar = new LugarInteresVista(lugarInteresFallido2);

	        assertEquals(casoAJugar.getEstadoDeMensaje().mostrarMensaje(casoAJugar,lugarInteresFallido2.getAyuda()), visitandoLugar.obtenerPista());
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

	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais2);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        villano.setLugarInteresActual(lugarInteresVillano); //esta cerca del villano
	        caso.setResponsable(villano);
	        caso.setPlanEscape(villano.getPlanEscape());
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais2);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.getCaso().setResponsable(villano);;
	        casoAJugar.setCaso(caso);
	        casoAJugar.actualizarEstadoDeMensaje();
	        lugarInteresVillano2.darPista(jugador); //esta cerca del villano
	        LugarInteresVista visitandoLugar = new LugarInteresVista(club);

	        assertEquals(casoAJugar.getEstadoDeMensaje().mostrarMensaje(casoAJugar,club.getAyuda()), visitandoLugar.obtenerPista());
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

	        pais.setLugaresInteres(Arrays.asList(club, lugarInteres2, lugarInteres3));
	        pais2.setLugaresInteres(Arrays.asList(lugarInteresVillano, lugarInteresVillano2));
	        Villano villano = new Villano();
	        villano.setPaisActual(pais2);
	        villano.setPlanEscape(Arrays.asList(pais,pais2));

	        villano.setSeniasParticulares(Arrays.asList("con anteojos", "alto"));
	        villano.setHobbies(Arrays.asList("surfear", "tomar sol"));

	        villano.viajar();
	        villano.setLugarInteresActual(lugarInteresVillano2); // se encuentran
	        caso.setResponsable(villano);
	        caso.setPlanEscape(villano.getPlanEscape());
	        caso.pasarVillanoPorPaises();

	        jugador.setPaisActual(pais2);
	        jugador.setLugarInteresActual(lugarInteresVillano2);
	        casoAJugar.setJugador(jugador);
	        casoAJugar.getCaso().setResponsable(villano);
	        casoAJugar.setCaso(caso);
	        casoAJugar.actualizarEstadoDeMensaje();
	        lugarInteresVillano2.darPista(jugador); // se encuentran
	        villano.setNombre("el flaco");
	        LugarInteresVista visitandoLugar = new LugaresInterVista(lugarInteres2);

	        assertEquals(casoAJugar.getEstadoDeMensaje().mostrarMensaje(casoAJugar,lugarInteresVillano2.getAyuda()), visitandoLugar.obtenerPista());
	    }
	}

