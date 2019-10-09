package main;

import java.util.Arrays;
import java.util.Scanner;

import modelo.*;
import modelo.lugarinteres.*;

public class Main {

    public static void main(String[] args) {
        Caso caso = new Caso();
        Villano villano = new Villano();
        villano.setNombre("Carmen Sandiego");
        villano.setSexo("Femenino");
        villano.setHobbies(Arrays.asList("Juega tenis","Baila tango"));
        villano.setSeñasParticulares(Arrays.asList("Pelo rojo","Maneja un convertible","Posee un collar de rubies","Su comida favorita son los tacos mexicanos"));


        Pais argentina = new Pais();
        Pais uruguay = new Pais();
        Pais brasil = new Pais();
        argentina.setNombre("Argentina");
        argentina.setCaracteristicas(Arrays.asList("Bandera celeste y blanca","Bandera con un sol","Moneda Peso","beben mate"));
        argentina.setLugaresInteres(Arrays.asList(new Embajada(),new Biblioteca(), new Club()));
        argentina.setConexiones(Arrays.asList(brasil,uruguay));

        uruguay.setNombre("Uruguay");
        uruguay.setCaracteristicas(Arrays.asList("Bandera celeste y blanca"));
        uruguay.setLugaresInteres(Arrays.asList(new Club(),new Biblioteca()));
        uruguay.setConexiones(Arrays.asList(argentina,brasil));

        brasil.setNombre("Brasil");
        brasil.setCaracteristicas(Arrays.asList("Bandera amarilla, verde y blanca"));
        brasil.setLugaresInteres(Arrays.asList(new Club(),new Biblioteca(),new Embajada()));
        brasil.setConexiones(Arrays.asList(argentina,uruguay));


        caso.setResponsable(villano);
        caso.setPlanEscape(Arrays.asList(argentina,brasil,uruguay));

        villano.setPlanEscape(Arrays.asList(argentina,brasil,uruguay));
        caso.setReporte(" A las 9 de la mañana en la ciudad del Cairo la comunidad científica fue conmovida al darse cuenta del faltante\n" +
                "   de gran valor! El sarcófago del faraón Usermaatra-Meriamón Ramsés-Heqaiunu, mejor conocido como Ramsés III. El criminal\n" +
                "   fue muy prolijo y la escena del crimen no contaba con pista alguna, su misión como detective es descifrar el\n" +
                "   responsable de tal crimen y apresarlo.\n");
        caso.setObjeto("Sarcófago del faraón");
        caso.setPaisOrigen(argentina);
        villano.setPaisActual(caso.getPaisOrigen());
        Jugador jugador = new Jugador(caso);
        CarmenSanDiego carmenSanDiego = new CarmenSanDiego();
        jugador.setCarmenSanDiego(carmenSanDiego);
        carmenSanDiego.setCaso(caso);
        carmenSanDiego.setJugador(jugador);
        carmenSanDiego.setVillano(villano);
        carmenSanDiego.iniciarJuego();
            //Scanner scanner = new Scanner(System.in);

    }
}
