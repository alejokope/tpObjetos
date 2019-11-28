package modeloTest;

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

        List<String> argentinaCaracteristicas = Arrays.asList("bandera celeste y blanca", "toman mate", "moneda peso", "casa de gobierno rosada");
        Embajada embajadaArg = new Embajada();
        Biblioteca bibliotecaArg = new Biblioteca();
        LugarInteres clubArg = new Club();
        List<LugarInteres> argentinaLugaresDeInteres = Arrays.asList(embajadaArg, bibliotecaArg, clubArg);

        List<String> peruCaracteristicas = Arrays.asList("bandera roja y blanca", "montaniosa", "incas", "cebiche");
        Embajada embajadaPer = new Embajada();
        Biblioteca bibliotecaPer = new Biblioteca();
        LugarInteres clubPer = new Club();
        List<LugarInteres> peruLugaresDeInteres = Arrays.asList(embajadaPer, bibliotecaPer, clubPer);

        List<String> ecuadorCaracteristicas = Arrays.asList("bandera azul, roja y amarilla", "banana", "cafe", "galapagos");
        Embajada embajadaEcu = new Embajada();
        Biblioteca bibliotecaEcu = new Biblioteca();
        LugarInteres clubEcu = new Club();
        List<LugarInteres> ecuadorLugaresDeInteres = Arrays.asList(embajadaEcu, bibliotecaEcu, clubEcu);

        List<String> panamaCaracteristicas = Arrays.asList("bandera azul, roja y blanca con estrellas", "canal");
        Embajada embajadaPan = new Embajada();
        Biblioteca bibliotecaPan = new Biblioteca();
        LugarInteres clubPan = new Club();
        List<LugarInteres> panamaLugaresDeInteres = Arrays.asList(embajadaPan, bibliotecaPan, clubPan);

        List<String> mexicoCaracteristicas = Arrays.asList("bandera roja, blanca y verde", "tequila", "corridas de toros", "el chavo");
        Embajada embajadaMex = new Embajada();
        Biblioteca bibliotecaMex = new Biblioteca();
        LugarInteres clubMex = new Club();
        List<LugarInteres> mexicoLugaresDeInteres = Arrays.asList(embajadaMex, bibliotecaMex, clubMex);

        Pais argentina = new Pais("Argentina", argentinaCaracteristicas, argentinaLugaresDeInteres);
        Pais peru = new Pais("Peru", peruCaracteristicas, peruLugaresDeInteres);
        Pais ecuador = new Pais("Ecuador", ecuadorCaracteristicas, ecuadorLugaresDeInteres);
        Pais panama = new Pais("Panama", panamaCaracteristicas, panamaLugaresDeInteres);
        Pais mexico = new Pais("Mexico", mexicoCaracteristicas, mexicoLugaresDeInteres);

        List<Pais> argentinaConexiones = Arrays.asList(peru);
        List<Pais> peruConexiones = Arrays.asList(ecuador, mexico);
        List<Pais> ecuadorConexiones = Arrays.asList(panama);
        List<Pais> panamaConexiones = Arrays.asList(mexico);
        List<Pais> mexicoConexiones = Arrays.asList();

        argentina.agregarConexiones(argentinaConexiones);
        peru.agregarConexiones(peruConexiones);
        ecuador.agregarConexiones(ecuadorConexiones);
        panama.agregarConexiones(panamaConexiones);
        mexico.agregarConexiones(mexicoConexiones);

        List<Pais> paisesCaso = Arrays.asList(peru,ecuador,panama,mexico);
        Villano villano = new Villano(panama, paisesCaso);
        String reporte = "Se escapo una rata de laboratorio, encuentre su ladron.";
        String objeto = "Rata de laboratorio";
        Caso caso = new Caso(villano, paisesCaso, reporte, objeto, argentina);
        Jugador jugador = new Jugador(caso);

        jugador.setPaisActual(peru);

    	CarmenSanDiegoMaster carmenSanDiego = new CarmenSanDiegoMaster(caso, jugador, villano);
    	
    	jugador.viajar(mexico);
    	carmenSanDiego.ubicacionDeJugadorOVillano(embajadaMex, jugador);
    	carmenSanDiego.ubicacionDeJugadorOVillano(embajadaMex, villano);
    	
    	jugador.pedirOrdenDeArresto(villano);
    	carmenSanDiego.setVillano(villano);
    	villano.setPaisActual(mexico);
        
        assertTrue(carmenSanDiego.gano());
    }

    @Test
    public void casoEjemplo_ElJugadorPierde(){

        List<String> argentinaCaracteristicas = Arrays.asList("bandera celeste y blanca", "toman mate", "moneda peso", "casa de gobierno rosada");
        Embajada embajadaArg = new Embajada();
        Biblioteca bibliotecaArg = new Biblioteca();
        LugarInteres clubArg = new Club();
        List<LugarInteres> argentinaLugaresDeInteres = Arrays.asList(embajadaArg, bibliotecaArg, clubArg);

        List<String> peruCaracteristicas = Arrays.asList("bandera roja y blanca", "montaniosa", "incas", "cebiche");
        Embajada embajadaPer = new Embajada();
        Biblioteca bibliotecaPer = new Biblioteca();
        LugarInteres clubPer = new Club();
        List<LugarInteres> peruLugaresDeInteres = Arrays.asList(embajadaPer, bibliotecaPer, clubPer);

        List<String> ecuadorCaracteristicas = Arrays.asList("bandera azul, roja y amarilla", "banana", "cafe", "galapagos");
        Embajada embajadaEcu = new Embajada();
        Biblioteca bibliotecaEcu = new Biblioteca();
        LugarInteres clubEcu = new Club();
        List<LugarInteres> ecuadorLugaresDeInteres = Arrays.asList(embajadaEcu, bibliotecaEcu, clubEcu);

        List<String> panamaCaracteristicas = Arrays.asList("bandera azul, roja y blanca con estrellas", "canal");
        Embajada embajadaPan = new Embajada();
        Biblioteca bibliotecaPan = new Biblioteca();
        LugarInteres clubPan = new Club();
        List<LugarInteres> panamaLugaresDeInteres = Arrays.asList(embajadaPan, bibliotecaPan, clubPan);

        List<String> mexicoCaracteristicas = Arrays.asList("bandera roja, blanca y verde", "tequila", "corridas de toros", "el chavo");
        Embajada embajadaMex = new Embajada();
        Biblioteca bibliotecaMex = new Biblioteca();
        LugarInteres clubMex = new Club();
        List<LugarInteres> mexicoLugaresDeInteres = Arrays.asList(embajadaMex, bibliotecaMex, clubMex);

        Pais argentina = new Pais("Argentina", argentinaCaracteristicas, argentinaLugaresDeInteres);
        Pais peru = new Pais("Peru", peruCaracteristicas, peruLugaresDeInteres);
        Pais ecuador = new Pais("Ecuador", ecuadorCaracteristicas, ecuadorLugaresDeInteres);
        Pais panama = new Pais("Panama", panamaCaracteristicas, panamaLugaresDeInteres);
        Pais mexico = new Pais("Mexico", mexicoCaracteristicas, mexicoLugaresDeInteres);

        List<Pais> argentinaConexiones = Arrays.asList(peru);
        List<Pais> peruConexiones = Arrays.asList(ecuador, mexico);
        List<Pais> ecuadorConexiones = Arrays.asList(panama);
        List<Pais> panamaConexiones = Arrays.asList(mexico);
        List<Pais> mexicoConexiones = Arrays.asList();

        argentina.agregarConexiones(argentinaConexiones);
        peru.agregarConexiones(peruConexiones);
        ecuador.agregarConexiones(ecuadorConexiones);
        panama.agregarConexiones(panamaConexiones);
        mexico.agregarConexiones(mexicoConexiones);

        List<Pais> paisesCaso = Arrays.asList(peru,ecuador,panama,mexico);
        Villano villano = new Villano(panama, paisesCaso);
        String reporte = "Se escapo una rata de laboratorio, encuentre su ladron.";
        String objeto = "Rata de laboratorio";
        Caso caso = new Caso(villano, paisesCaso, reporte, objeto, argentina);
        Jugador jugador = new Jugador(caso);

        jugador.setPaisActual(peru);

        CarmenSanDiegoMaster carmenSanDiego = new CarmenSanDiegoMaster(caso, jugador, villano);

        jugador.viajar(ecuador);
        carmenSanDiego.ubicacionDeJugadorOVillano(clubEcu, jugador);
        carmenSanDiego.ubicacionDeJugadorOVillano(embajadaMex, villano);

        jugador.pedirOrdenDeArresto(villano);
        carmenSanDiego.setVillano(villano);
        villano.setPaisActual(mexico);

        assertFalse(carmenSanDiego.gano());
    }

}
