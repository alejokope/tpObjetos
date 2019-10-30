package test;

import modelo.*;
import modelo.lugarInteres.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class IntegracionModeloTest {

    @Test
    public void casoEjemplo_ElJugadorGana(){    	
        Pais argentina = new Pais();
        Pais peru = new Pais();
        Pais ecuador = new Pais();
        Pais panama = new Pais();
        Pais mexico = new Pais();


        argentina.setNombre("Argentina");
        List<String> argentinaCaracteristicas = Arrays.asList("bandera celeste y blanca", "toman mate", "moneda peso", "casa de gobierno rosada");
        argentina.setCaracteristicas(argentinaCaracteristicas);
        Embajada embajadaArg = new Embajada();
        Biblioteca bibliotecaArg = new Biblioteca();
        LugarInteres clubArg = new Club();
        List<LugarInteres> argentinaLugaresDeInteres = Arrays.asList(embajadaArg, bibliotecaArg, clubArg);
        argentina.setLugaresInteres(argentinaLugaresDeInteres);
        List<Pais> argentinaConexiones = Arrays.asList(peru);

        peru.setNombre("Peru");
        List<String> peruCaracteristicas = Arrays.asList("bandera roja y blanca", "montañosa", "incas", "cebiche");
        peru.setCaracteristicas(peruCaracteristicas);
        Embajada embajadaPer = new Embajada();
        Biblioteca bibliotecaPer = new Biblioteca();
        LugarInteres clubPer = new Club();
        List<LugarInteres> peruLugaresDeInteres = Arrays.asList(embajadaPer, bibliotecaPer, clubPer);
        peru.setLugaresInteres(peruLugaresDeInteres);
        List<Pais> peruConexiones = Arrays.asList(ecuador, mexico);

        ecuador.setNombre("Ecuador");
        List<String> ecuadorCaracteristicas = Arrays.asList("bandera azul, roja y amarilla", "banana", "cafe", "galapagos");
        ecuador.setCaracteristicas(ecuadorCaracteristicas);
        Embajada embajadaEcu = new Embajada();
        Biblioteca bibliotecaEcu = new Biblioteca();
        LugarInteres clubEcu = new Club();
        List<LugarInteres> ecuadorLugaresDeInteres = Arrays.asList(embajadaEcu, bibliotecaEcu, clubEcu);
        ecuador.setLugaresInteres(ecuadorLugaresDeInteres);
        List<Pais> ecuadorConexiones = Arrays.asList(panama);

        panama.setNombre("Panama");
        List<String> panamaCaracteristicas = Arrays.asList("bandera azul, roja y blanca con estrellas", "canal");
        panama.setCaracteristicas(panamaCaracteristicas);
        Embajada embajadaPan = new Embajada();
        Biblioteca bibliotecaPan = new Biblioteca();
        LugarInteres clubPan = new Club();
        List<LugarInteres> panamaLugaresDeInteres = Arrays.asList(embajadaPan, bibliotecaPan, clubPan);
        panama.setLugaresInteres(panamaLugaresDeInteres);
        List<Pais> panamaConexiones = Arrays.asList(mexico);

        mexico.setNombre("Mexico");
        List<String> mexicoCaracteristicas = Arrays.asList("bandera roja, blanca y verde", "tequila", "corridas de toros", "el chavo");
        mexico.setCaracteristicas(mexicoCaracteristicas);
        Embajada embajadaMex = new Embajada();
        Biblioteca bibliotecaMex = new Biblioteca();
        LugarInteres clubMex = new Club();
        List<LugarInteres> mexicoLugaresDeInteres = Arrays.asList(embajadaMex, bibliotecaMex, clubMex);
        mexico.setLugaresInteres(mexicoLugaresDeInteres);
        List<Pais> mexicoConexiones = Arrays.asList();
        
        argentina.agregarConexiones(argentinaConexiones);
        peru.agregarConexiones(peruConexiones);
        ecuador.agregarConexiones(ecuadorConexiones);
        panama.agregarConexiones(panamaConexiones);
        mexico.agregarConexiones(mexicoConexiones);


        Villano villano = new Villano();
        Caso caso = new Caso();
        Jugador jugador = new Jugador(caso);
        caso.setReporte("Se escapo una rata de laboratorio, encuentre su ladron.");
        caso.setObjeto("Rata de laboratorio");
        caso.setPaisOrigen(argentina);
        caso.setResponsable(villano);
        List<Pais> paisesCaso = Arrays.asList(peru,ecuador,panama,mexico);
        caso.setPlanEscape(paisesCaso);
        villano.setPlanEscape(paisesCaso);
        villano.setPaisActual(panama);
        jugador.setPaisActual(peru);

    	CarmenSanDiegoMaster carmenSanDiego = new CarmenSanDiegoMaster();
    	carmenSanDiego.setCaso(caso);
    	carmenSanDiego.setJugador(jugador);
    	carmenSanDiego.setVillano(villano);
    	
    	carmenSanDiego.viajar(mexico);

    	Biblioteca biblioteca = new Biblioteca();

    	villano.setLugarInteresActual(biblioteca);
    	jugador.setLugarInteresActual(biblioteca);
    	
    	jugador.pedirOrdenDeArresto(villano);
        
        assertTrue(carmenSanDiego.gano(villano, jugador));
    }

    @Test
    public void casoEjemplo_ElJugadorPierde(){
        Pais argentina = new Pais();
        Pais peru = new Pais();
        Pais ecuador = new Pais();
        Pais panama = new Pais();
        Pais mexico = new Pais();


        argentina.setNombre("Argentina");
        List<String> argentinaCaracteristicas = Arrays.asList("bandera celeste y blanca", "toman mate", "moneda peso", "casa de gobierno rosada");
        argentina.setCaracteristicas(argentinaCaracteristicas);
        Embajada embajadaArg = new Embajada();
        Biblioteca bibliotecaArg = new Biblioteca();
        LugarInteres clubArg = new Club();
        List<LugarInteres> argentinaLugaresDeInteres = Arrays.asList(embajadaArg, bibliotecaArg, clubArg);
        argentina.setLugaresInteres(argentinaLugaresDeInteres);
        List<Pais> argentinaConexiones = Arrays.asList(peru);

        peru.setNombre("Peru");
        List<String> peruCaracteristicas = Arrays.asList("bandera roja y blanca", "montañosa", "incas", "cebiche");
        peru.setCaracteristicas(peruCaracteristicas);
        Embajada embajadaPer = new Embajada();
        Biblioteca bibliotecaPer = new Biblioteca();
        LugarInteres clubPer = new Club();
        List<LugarInteres> peruLugaresDeInteres = Arrays.asList(embajadaPer, bibliotecaPer, clubPer);
        peru.setLugaresInteres(peruLugaresDeInteres);
        List<Pais> peruConexiones = Arrays.asList(ecuador, mexico);

        ecuador.setNombre("Ecuador");
        List<String> ecuadorCaracteristicas = Arrays.asList("bandera azul, roja y amarilla", "banana", "cafe", "galapagos");
        ecuador.setCaracteristicas(ecuadorCaracteristicas);
        Embajada embajadaEcu = new Embajada();
        Biblioteca bibliotecaEcu = new Biblioteca();
        LugarInteres clubEcu = new Club();
        List<LugarInteres> ecuadorLugaresDeInteres = Arrays.asList(embajadaEcu, bibliotecaEcu, clubEcu);
        ecuador.setLugaresInteres(ecuadorLugaresDeInteres);
        List<Pais> ecuadorConexiones = Arrays.asList(panama);

        panama.setNombre("Panama");
        List<String> panamaCaracteristicas = Arrays.asList("bandera azul, roja y blanca con estrellas", "canal");
        panama.setCaracteristicas(panamaCaracteristicas);
        Embajada embajadaPan = new Embajada();
        Biblioteca bibliotecaPan = new Biblioteca();
        LugarInteres clubPan = new Club();
        List<LugarInteres> panamaLugaresDeInteres = Arrays.asList(embajadaPan, bibliotecaPan, clubPan);
        panama.setLugaresInteres(panamaLugaresDeInteres);
        List<Pais> panamaConexiones = Arrays.asList(mexico);

        mexico.setNombre("Mexico");
        List<String> mexicoCaracteristicas = Arrays.asList("bandera roja, blanca y verde", "tequila", "corridas de toros", "el chavo");
        mexico.setCaracteristicas(mexicoCaracteristicas);
        Embajada embajadaMex = new Embajada();
        Biblioteca bibliotecaMex = new Biblioteca();
        LugarInteres clubMex = new Club();
        List<LugarInteres> mexicoLugaresDeInteres = Arrays.asList(embajadaMex, bibliotecaMex, clubMex);
        mexico.setLugaresInteres(mexicoLugaresDeInteres);
        List<Pais> mexicoConexiones = Arrays.asList();

        argentina.agregarConexiones(argentinaConexiones);
        peru.agregarConexiones(peruConexiones);
        ecuador.agregarConexiones(ecuadorConexiones);
        panama.agregarConexiones(panamaConexiones);
        mexico.agregarConexiones(mexicoConexiones);


        Villano villano = new Villano();
        Caso caso = new Caso();
        Jugador jugador = new Jugador(caso);
        caso.setReporte("Se escapo una rata de laboratorio, encuentre su ladron.");
        caso.setObjeto("Rata de laboratorio");
        caso.setPaisOrigen(argentina);
        caso.setResponsable(villano);
        List<Pais> paisesCaso = Arrays.asList(peru,ecuador,panama,mexico);
        caso.setPlanEscape(paisesCaso);
        villano.setPlanEscape(paisesCaso);
        villano.setPaisActual(panama);
        jugador.setPaisActual(peru);

        CarmenSanDiegoMaster carmenSanDiego = new CarmenSanDiegoMaster();
        carmenSanDiego.setCaso(caso);
        carmenSanDiego.setJugador(jugador);
        carmenSanDiego.setVillano(villano);

        carmenSanDiego.viajar(ecuador);

        Biblioteca biblioteca = new Biblioteca();
        Club club = new Club();

        villano.setLugarInteresActual(biblioteca);
        jugador.setLugarInteresActual(club);

        jugador.pedirOrdenDeArresto(villano);

        assertFalse(carmenSanDiego.gano(villano, jugador));
    }

}
