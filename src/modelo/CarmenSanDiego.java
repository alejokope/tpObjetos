package modelo;

import java.util.Scanner;

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
        System.out.println("Pais actual: " + jugador.getPaisActual().getNombre());



        int tope = jugador.getPaisActual().getLugaresInteres().size() + 1;
        int eleccion = -1;
        for (int p = 0; p < villano.getPlanEscape().size(); p++) {
            while (eleccion != tope) {
                for (int i = 0; i < jugador.getPaisActual().getLugaresInteres().size(); i++) {
                    System.out.println(i + 1 + ": " + jugador.getPaisActual().getLugaresInteres().get(i).informacion());
                }
                System.out.println(tope + ": VIAJAR");
                eleccion = scanner.nextInt();
                if (eleccion < tope)
                    handlerPistas(jugador.getPaisActual().getLugaresInteres().get(eleccion - 1).darPista());
                else {
                    System.out.println("A donde deseas viajar? : ");
                    viajar();
                    if(gano(villano,jugador)) {
                        System.out.println("GANASTE");
                        return;
                    }
                    System.out.println("Pais actual: " + jugador.getPaisActual().getNombre());
                }
            }
        }
        System.out.println("PERDISTE");
    }

    private boolean gano(Villano villano, Jugador jugador){
        return estanEnELMismoLugarDeInteres(villano, jugador) && elVillanoCoincideConOrdenDeArresto(villano, jugador);
    }

	private boolean elVillanoCoincideConOrdenDeArresto(Villano villano, Jugador jugador) {
		return jugador.getOrdenDeArresto().getSospechoso().equals(villano);
	}

	private boolean estanEnELMismoLugarDeInteres(Villano villano, Jugador jugador) {
		return villano.getLugarInteresActual().equals(jugador.getLugarInteresActual());
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
        else if(pista.getPista1() != null && pista.getPista2() != null && pista.getPistaExtra() == null){
            System.out.println("PISTA 1: " + pista.getPista1());
            System.out.println("PISTA 2: " + pista.getPista2());
        }
    }

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void setVillano(Villano villano) {
		this.villano = villano;
	}
}
