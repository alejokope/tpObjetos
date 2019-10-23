package test;

import modelo.*;
import modelo.lugarInteres.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class modeloTest {

    @Test
    public void casoEjemplo(){
        Pais argentina = new Pais();
        Pais peru = new Pais();
        Pais ecuador = new Pais();
        Pais panama = new Pais();
        Pais mexico = new Pais();

        List<String> argentinaCaracteristicas = Arrays.asList("bandera celeste y blanca", "toman mate", "moneda peso", "casa de gobierno rosada");
        argentina.setCaracteristicas(argentinaCaracteristicas);
        Embajada embajadaArg = new Embajada();
        Biblioteca bibliotecaArg = new Biblioteca();
        Club clubArg = new Club();
        List<LugarInteres> argentinaLugaresDeInteres = Arrays.asList(embajadaArg, bibliotecaArg, clubArg);
        argentina.setLugaresInteres(argentinaLugaresDeInteres);
        List<Pais> argentinaConexiones = Arrays.asList(peru);
        argentina.setConexiones(argentinaConexiones);
        argentina.setNombre("Argentina");

        List<String> peruCaracteristicas = Arrays.asList("bandera roja y blanca", "montañosa", "incas", "cebiche");
        peru.setCaracteristicas(peruCaracteristicas);
        Embajada embajadaPer = new Embajada();
        Biblioteca bibliotecaPer = new Biblioteca();
        Club clubPer = new Club();
        List<LugarInteres> peruLugaresDeInteres = Arrays.asList(embajadaPer, bibliotecaPer, clubPer);
        peru.setLugaresInteres(peruLugaresDeInteres);
        List<Pais> peruConexiones = Arrays.asList(ecuador);
        peru.setConexiones(peruConexiones);
        peru.setNombre("Peru");

        List<String> ecuadorCaracteristicas = Arrays.asList("bandera azul, roja y amarilla", "banana", "cafe", "galapagos");
        ecuador.setCaracteristicas(ecuadorCaracteristicas);
        Embajada embajadaEcu = new Embajada();
        Biblioteca bibliotecaEcu = new Biblioteca();
        Club clubEcu = new Club();
        List<LugarInteres> ecuadorLugaresDeInteres = Arrays.asList(embajadaEcu, bibliotecaEcu, clubEcu);
        ecuador.setLugaresInteres(ecuadorLugaresDeInteres);
        List<Pais> ecuadorConexiones = Arrays.asList(panama);
        ecuador.setConexiones(ecuadorConexiones);
        ecuador.setNombre("Ecuador");

        List<String> panamaCaracteristicas = Arrays.asList("bandera azul, roja y blanca con estrellas", "canal");
        panama.setCaracteristicas(panamaCaracteristicas);
        Embajada embajadaPan = new Embajada();
        Biblioteca bibliotecaPan = new Biblioteca();
        Club clubPan = new Club();
        List<LugarInteres> panamaLugaresDeInteres = Arrays.asList(embajadaPan, bibliotecaPan, clubPan);
        panama.setLugaresInteres(panamaLugaresDeInteres);
        List<Pais> panamaConexiones = Arrays.asList(mexico);
        panama.setConexiones(panamaConexiones);
        panama.setNombre("Panama");

        List<String> mexicoCaracteristicas = Arrays.asList("bandera roja, blanca y verde", "tequila", "corridas de toros", "el chavo");
        mexico.setCaracteristicas(mexicoCaracteristicas);
        Embajada embajadaMex = new Embajada();
        Biblioteca bibliotecaMex = new Biblioteca();
        Club clubMex = new Club();
        List<LugarInteres> mexicoLugaresDeInteres = Arrays.asList(embajadaMex, bibliotecaMex, clubMex);
        mexico.setLugaresInteres(mexicoLugaresDeInteres);
        List<Pais> mexicoConexiones = Arrays.asList();
        mexico.setConexiones(mexicoConexiones);
        mexico.setNombre("Mexico");


        Villano villano = new Villano();
        Caso caso = new Caso();
        Jugador jugador = new Jugador(caso);
        caso.setReporte("Se escapo una rata de laboratorio, encuentre su ladron.");
        caso.setObjeto("Rata de laboratorio");
        caso.setPaisOrigen(argentina);
        caso.setResponsable(villano);
        List<Pais> paisesCaso = Arrays.asList(peru,ecuador,panama,mexico);
        caso.setPlanEscape(paisesCaso);
    }

}
