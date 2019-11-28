package modeloTest;

import excepciones.NoEsPaisProximoException;
import excepciones.NoHayLugarDeInteresEnEstePais;
import modelo.*;
import modelo.lugarInteres.Banco;
import modelo.lugarInteres.Club;
import modelo.lugarInteres.Embajada;
import modelo.lugarInteres.LugarInteres;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarmenSanDiegoMasterTest {

    @Test
    public void ubicacionDeJugadorOVillano_seSeteaUnLugarDeInteresAUnaPersonaPorqueExisteEnElPais(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
        Caso caso = new Caso();
        Pais pais = new Pais();
        caso.setPaisOrigen(pais);
        Embajada embajada = mock(Embajada.class);
        Club club = mock(Club.class);
        List<LugarInteres> lugares = Arrays.asList(embajada, club);
        Jugador jugador = new Jugador(caso);
        pais.setLugaresInteres(lugares);

        carmenSanDiegoMaster.ubicacionDeJugadorOVillano(embajada, jugador);

        assertEquals(embajada, jugador.getLugarInteresActual());
    }

    @Test(expected = NoHayLugarDeInteresEnEstePais.class)
    public void ubicacionDeJugadorOVillano_NoSeSeteaUnLugarDeInteresAUnaPersonaPorqueNoExisteEnElPais(){
        CarmenSanDiegoMaster carmenSanDiegoMaster = new CarmenSanDiegoMaster();
        Caso caso = new Caso();
        Pais pais = new Pais();
        caso.setPaisOrigen(pais);
        Embajada embajada = mock(Embajada.class);
        Club club = mock(Club.class);
        List<LugarInteres> lugares = Arrays.asList(embajada, club);
        Jugador jugador = new Jugador(caso);
        pais.setLugaresInteres(lugares);

        Banco noExisteEnPais = new Banco();

        carmenSanDiegoMaster.ubicacionDeJugadorOVillano(noExisteEnPais, jugador);
    }
}