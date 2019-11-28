package vistaTest;

import modelo.*;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import modelo.lugarInteres.LugarInteres;
import org.junit.Test;
import vista.VisitandoLugar;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class VisitandoLugarTest {

    @Test
    public void visitandoLugar_elVillanoPasoPorElPaisYSeMuestraElMensajeCorrespondiente(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
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

        villano.escaparmeAlUltimoPaisYEnAlgunLugar();
        caso.setResponsable(villano);
        caso.setPlanEscape(villano.getPlanEscape());
        caso.pasarVillanoPorPaises();

        jugador.setPaisActual(pais);
        carmenSanDiegoMaster.setJugador(jugador);
        carmenSanDiegoMaster.setVillano(villano);
        carmenSanDiegoMaster.setCaso(caso);
        carmenSanDiegoMaster.actualizarEstadoDeMensaje();
        club.darPista(jugador);
        VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, club);

        assertEquals(carmenSanDiegoMaster.getEstadoDeMensaje().mostrarMensaje(carmenSanDiegoMaster,club.getAyuda()), visitandoLugar.obtenerPista());
    }

    @Test
    public void visitandoLugar_elVillanoNoPasoPorElPaisYSeMuestraElMensajeCorrespondiente(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
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

        villano.escaparmeAlUltimoPaisYEnAlgunLugar();
        caso.setResponsable(villano);
        caso.setPlanEscape(villano.getPlanEscape());
        caso.pasarVillanoPorPaises();

        jugador.setPaisActual(paisFallido);
        carmenSanDiegoMaster.setJugador(jugador);
        carmenSanDiegoMaster.setVillano(villano);
        carmenSanDiegoMaster.setCaso(caso);
        carmenSanDiegoMaster.actualizarEstadoDeMensaje();
        lugarInteresFallido2.darPista(jugador);
        VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, lugarInteresFallido2);

        assertEquals(carmenSanDiegoMaster.getEstadoDeMensaje().mostrarMensaje(carmenSanDiegoMaster,lugarInteresFallido2.getAyuda()), visitandoLugar.obtenerPista());
    }

    @Test
    public void visitandoLugar_elVillanoEstaEnElPaisDelJugadorYSeMuestraElMensajeCorrespondiente(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
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

        villano.escaparmeAlUltimoPaisYEnAlgunLugar();
        villano.setLugarInteresActual(lugarInteresVillano); //esta cerca del villano
        caso.setResponsable(villano);
        caso.setPlanEscape(villano.getPlanEscape());
        caso.pasarVillanoPorPaises();

        jugador.setPaisActual(pais2);
        carmenSanDiegoMaster.setJugador(jugador);
        carmenSanDiegoMaster.setVillano(villano);
        carmenSanDiegoMaster.setCaso(caso);
        carmenSanDiegoMaster.actualizarEstadoDeMensaje();
        lugarInteresVillano2.darPista(jugador); //esta cerca del villano
        VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, club);

        assertEquals(carmenSanDiegoMaster.getEstadoDeMensaje().mostrarMensaje(carmenSanDiegoMaster,club.getAyuda()), visitandoLugar.obtenerPista());
    }

    @Test
    public void visitandoLugar_ambosSeEncuentranYSeMuestraElMensajeCorrespondiente(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
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

        villano.escaparmeAlUltimoPaisYEnAlgunLugar();
        villano.setLugarInteresActual(lugarInteresVillano2); // se encuentran
        caso.setResponsable(villano);
        caso.setPlanEscape(villano.getPlanEscape());
        caso.pasarVillanoPorPaises();

        jugador.setPaisActual(pais2);
        jugador.setLugarInteresActual(lugarInteresVillano2);
        carmenSanDiegoMaster.setJugador(jugador);
        carmenSanDiegoMaster.setVillano(villano);
        carmenSanDiegoMaster.setCaso(caso);
        carmenSanDiegoMaster.actualizarEstadoDeMensaje();
        lugarInteresVillano2.darPista(jugador); // se encuentran
        villano.setNombre("el flaco");
        VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, lugarInteres2);

        assertEquals(carmenSanDiegoMaster.getEstadoDeMensaje().mostrarMensaje(carmenSanDiegoMaster,lugarInteresVillano2.getAyuda()), visitandoLugar.obtenerPista());
    }
}
