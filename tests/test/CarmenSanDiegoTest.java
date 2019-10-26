package test;

import excepciones.NoEsPaisProximoException;
import modelo.*;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarmenSanDiegoTest {

    @Test
    public void gano_elJugadorGanoPorqueEstabaEnElMismoLugarDeInteresYLaOrdenDeArrestoEraCorrecta(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);
        Embajada embajada = mock(Embajada.class);

        when(jugador.getOrdenDeArresto()).thenReturn(ordenDeArresto);
        when(ordenDeArresto.getSospechoso()).thenReturn(villano);
        when(villano.getLugarInteresActual()).thenReturn(embajada);
        when(jugador.getLugarInteresActual()).thenReturn(embajada);

        assertTrue(carmen.gano(villano,jugador));
    }

    @Test
    public void gano_elJugadorNoGanoPorqueNoEstabaEnElMismoLugarDeInteresPeroSiLaOrdenDeArrestoEraCorrecta(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);
        Embajada embajada = mock(Embajada.class);
        Embajada embajada2 = mock(Embajada.class);

        when(jugador.getOrdenDeArresto()).thenReturn(ordenDeArresto);
        when(ordenDeArresto.getSospechoso()).thenReturn(villano);
        when(villano.getLugarInteresActual()).thenReturn(embajada);
        when(jugador.getLugarInteresActual()).thenReturn(embajada2);

        assertFalse(carmen.gano(villano,jugador));
    }

    @Test
    public void gano_elJugadorNoGanoAunqueEstabaEnElMismoLugarDeInteresPorqueLaOrdenDeArrestoEraIncorrecta(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Villano villano = mock(Villano.class);
        Villano villano2 = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);
        Embajada embajada = mock(Embajada.class);

        when(jugador.getOrdenDeArresto()).thenReturn(ordenDeArresto);
        when(ordenDeArresto.getSospechoso()).thenReturn(villano2);
        when(villano.getLugarInteresActual()).thenReturn(embajada);
        when(jugador.getLugarInteresActual()).thenReturn(embajada);

        assertFalse(carmen.gano(villano,jugador));
    }

    @Test
    public void elVillanoCoincideConOrdenDeArresto_elVillanoQueApareceEnLaOrdenDeArrestoEsElResponsableDelCrimen(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);

        when(jugador.getOrdenDeArresto()).thenReturn(ordenDeArresto);
        when(ordenDeArresto.getSospechoso()).thenReturn(villano);

        assertTrue(carmen.elVillanoCoincideConOrdenDeArresto(villano, jugador));
    }

    @Test
    public void elVillanoCoincideConOrdenDeArresto_elVillanoQueApareceEnLaOrdenDeArrestoNoEsElResponsableDelCrimen(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Villano villano = mock(Villano.class);
        Villano villano2 = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);
        OrdenDeArresto ordenDeArresto = mock(OrdenDeArresto.class);

        when(jugador.getOrdenDeArresto()).thenReturn(ordenDeArresto);
        when(ordenDeArresto.getSospechoso()).thenReturn(villano2);

        assertFalse(carmen.elVillanoCoincideConOrdenDeArresto(villano, jugador));
    }

    @Test
    public void estanEnElMismoLugarDeInteres_elVillanoYElJugadorEstanEnElMismoLugarDeInteres(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Embajada embajada = mock(Embajada.class);
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(villano.getLugarInteresActual()).thenReturn(embajada);
        when(jugador.getLugarInteresActual()).thenReturn(embajada);

        assertTrue(carmen.estanEnElMismoLugarDeInteres(villano,jugador));
    }

    @Test
    public void estanEnElMismoLugarDeInteres_elVillanoYElJugadorNoEstanEnElMismoLugarDeInteres(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Embajada embajada = mock(Embajada.class);
        Club club = mock(Club.class);
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(villano.getLugarInteresActual()).thenReturn(embajada);
        when(jugador.getLugarInteresActual()).thenReturn(club);

        assertFalse(carmen.estanEnElMismoLugarDeInteres(villano,jugador));
    }

    @Test
    public void viajar_elJugadorYElVillanoViajanMuyCerca(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Pais argentina = new Pais();
        Pais brasil = mock(Pais.class);
        Pais chile = mock(Pais.class);
        Pais uruguay = mock(Pais.class);
        Pais bolivia = mock(Pais.class);
        Pais paraguay = mock(Pais.class);
        List<Pais> planEscapeVillano = Arrays.asList(argentina, brasil);
        List<Pais> argConexiones = Arrays.asList(brasil, chile, uruguay, bolivia, paraguay);
        argentina.setConexiones(argConexiones);
        Caso caso = new Caso();
        caso.setPaisOrigen(argentina);
        Jugador jugador = new Jugador(caso);
        Villano villano = new Villano();
        villano.setPaisActual(argentina);
        villano.setPlanEscape(planEscapeVillano);

        carmen.setJugador(jugador);
        carmen.setVillano(villano);
        carmen.viajar(brasil);

        assertEquals(villano.getPaisActual(), jugador.getPaisActual());
    }

    @Test(expected = NoEsPaisProximoException.class)
    public void viajar_elJugadorYElVillanoNoPuedenViajarAUnPaisDesconectadoDelResto(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Pais argentina = new Pais();
        Pais brasil = mock(Pais.class);
        Pais chile = mock(Pais.class);
        Pais uruguay = mock(Pais.class);
        Pais bolivia = mock(Pais.class);
        Pais paraguay = mock(Pais.class);
        Pais paisDeLasMaravillas = mock(Pais.class);
        List<Pais> planEscapeVillano = Arrays.asList(argentina, brasil);
        List<Pais> argConexiones = Arrays.asList(brasil, chile, uruguay, bolivia, paraguay);
        argentina.setConexiones(argConexiones);
        Caso caso = new Caso();
        caso.setPaisOrigen(argentina);
        Jugador jugador = new Jugador(caso);
        Villano villano = new Villano();
        villano.setPaisActual(argentina);
        villano.setPlanEscape(planEscapeVillano);

        carmen.setJugador(jugador);
        carmen.setVillano(villano);
        carmen.viajar(paisDeLasMaravillas);
    }

    @Test
    public void handlerPistas_manejara2PistasYLasMostraraSiNoEstanNull(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Pista pista = mock(Pista.class);

        when(pista.getPista1()).thenReturn("Tiene bigote");
        when(pista.getPista2()).thenReturn("Tiene bote");

        assertNotNull(carmen.handlerPistas(pista));
    }

    @Test
    public void handlerPistas_manejara3PistasYLasMostraraSiNoEstanNull(){
        CarmenSanDiego carmen = new CarmenSanDiego();
        Pista pista = mock(Pista.class);

        when(pista.getPista1()).thenReturn("Tiene bigote");
        when(pista.getPista2()).thenReturn("Tiene bote");
        when(pista.getPistaExtra()).thenReturn("Viaja en subte");

        assertNotNull(carmen.handlerPistas(pista));
    }

    //Bueno si no quieren testear getters y setters, no va haber 100% coverage...

    @Test
    public void iniciarJuego_elJugadorGanaElJuego(){
//        CarmenSanDiego juego = new CarmenSanDiego();
//        Caso caso = mock(Caso.class);
//
//        when(caso.getObjeto()).thenReturn("Ataud de Oro");
//        when(caso.getPaisOrigen().getNombre()).thenReturn("Alemania");
//        when(caso.getReporte()).thenReturn("Detengan al delincuente de articulos historicos");
//        when(jugador.)
        //Recomiendo borrar/modificar este metodo "iniciarJuego".

    }

}
