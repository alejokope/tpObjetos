package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class CarmenSanDiego {
    private Caso caso;
    private Jugador jugador;
    private Villano villano;
    private Scanner scanner = new Scanner(System.in);


    public void iniciarJuego() {
        System.out.println("Bienvenidos al juego.");
        System.out.println("Hoy tenemos el siguiente caso: \n");
        System.out.println("Se robo " + caso.getObjeto() + " en " + caso.getPaisOrigen().getNombre() + ". \n");
        System.out.println("El reporte policial es: \n");
        System.out.println(caso.getReporte());


        System.out.println("A donde deseas viajar? : ");
        viajar();
        if(gano(villano,jugador)) {
            System.out.println("GANASTE");
            return;
        }
        System.out.println("Pais actual: " + jugador.getActual().getNombre());



        int tope = jugador.getActual().getLugaresInteres().size() + 1;
        int eleccion = -1;
        for (int p = 0; p < villano.getPlanEscape().size(); p++) {
            while (eleccion != tope) {
                for (int i = 0; i < jugador.getActual().getLugaresInteres().size(); i++) {
                    System.out.println(i + 1 + ": " + jugador.getActual().getLugaresInteres().get(i).informacion());
                }
                System.out.println(tope + ": VIAJAR");
                eleccion = scanner.nextInt();
                if (eleccion < tope)
                    handlerPistas(jugador.getActual().getLugaresInteres().get(eleccion - 1).darPista());
                else {
                    System.out.println("A donde deseas viajar? : ");
                    viajar();
                    if(gano(villano,jugador)) {
                        System.out.println("GANASTE");
                        return;
                    }
                    System.out.println("Pais actual: " + jugador.getActual().getNombre());
                }
            }
        }
        System.out.println("PERDISTE");
    }

    private boolean gano(Villano villano, Jugador jugador){
        return villano.getPaisActual().equals(jugador.getActual());
    }
    private void viajar(){
        jugador.consultaDondeViajar();
        villano.escaparProximoPais();

    }
    private void handlerPistas(Pista pista){
        if(pista.getPista1() != null && pista.getPista2() != null && pista.getPistaExtra() != null){
            System.out.println("PISTA 1: " + pista.getPista1());
            System.out.println("PISTA 2: " + pista.getPista2());
            System.out.println("PISTA 3: " + pista.getPistaExtra());
        }
        if(pista.getPista1() != null && pista.getPista2() != null && pista.getPistaExtra() == null){
            System.out.println("PISTA 1: " + pista.getPista1());
            System.out.println("PISTA 2: " + pista.getPista2());
        }
        else {

        }
    }







}
