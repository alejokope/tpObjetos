package test;

import excepciones.NoEsPaisProximoException;
import modelo.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarmenSanDiegoMasterTest {

    @Test
    public void gano_elJugadorGanoPorqueEstabaEnElMismoLugarDeInteresYLaOrdenDeArrestoEraCorrecta(){
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(jugador.esLaOrdenDeArrestoCorrecta(villano)).thenReturn(true);
        when(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador)).thenReturn(true);

        assertTrue(carmen.gano(villano,jugador));
    }

    @Test
    public void gano_elJugadorNoGanoPorqueNoEstabaEnElMismoLugarDeInteresPeroSiLaOrdenDeArrestoEraCorrecta(){
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador)).thenReturn(false);
        when(jugador.esLaOrdenDeArrestoCorrecta(villano)).thenReturn(true);

        assertFalse(carmen.gano(villano,jugador));
    }

    @Test
    public void gano_elJugadorNoGanoAunqueEstabaEnElMismoLugarDeInteresPorqueLaOrdenDeArrestoEraIncorrecta(){
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador)).thenReturn(true);
        when(jugador.esLaOrdenDeArrestoCorrecta(villano)).thenReturn(false);

        assertFalse(carmen.gano(villano,jugador));
    }

    @Test
    public void gano_elJugadorNoGanoPorqueNoEstabaEnElMismoLugarDeInteresYLaOrdenDeArrestoEraIncorrecta(){
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Villano villano = mock(Villano.class);
        Jugador jugador = mock(Jugador.class);

        when(villano.estoyEnElMismoLugarDeInteresQueJugador(jugador)).thenReturn(false);
        when(jugador.esLaOrdenDeArrestoCorrecta(villano)).thenReturn(false);

        assertFalse(carmen.gano(villano,jugador));
    }

    @Test
    public void viajar_elJugadorYElVillanoViajanMuyCerca(){
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Pais argentina = new Pais();
        Pais brasil = mock(Pais.class);
        Pais chile = mock(Pais.class);
        Pais uruguay = mock(Pais.class);
        Pais bolivia = mock(Pais.class);
        Pais paraguay = mock(Pais.class);
        List<Pais> planEscapeVillano = Arrays.asList(argentina, brasil);
        List<Pais> argConexiones = Arrays.asList(brasil, chile, uruguay, bolivia, paraguay);
        argentina.agregarConexiones(argConexiones);
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
        CarmenSanDiegoMaster carmen = new CarmenSanDiegoMaster();
        Pais argentina = new Pais();
        Pais brasil = mock(Pais.class);
        Pais chile = mock(Pais.class);
        Pais uruguay = mock(Pais.class);
        Pais bolivia = mock(Pais.class);
        Pais paraguay = mock(Pais.class);
        Pais paisDeLasMaravillas = mock(Pais.class);
        List<Pais> planEscapeVillano = Arrays.asList(argentina, brasil);
        List<Pais> argConexiones = Arrays.asList(brasil, chile, uruguay, bolivia, paraguay);
        argentina.agregarConexiones(argConexiones);
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
}