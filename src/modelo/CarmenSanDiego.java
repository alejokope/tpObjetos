package modelo;

public class CarmenSanDiego {
    private Caso caso;
    private Jugador jugador;
    private Villano villano;

    public boolean gano(Villano villano, Jugador jugador){
        return estanEnELMismoLugarDeInteres(villano, jugador) && elVillanoCoincideConOrdenDeArresto(villano, jugador);
    }

	public boolean elVillanoCoincideConOrdenDeArresto(Villano villano, Jugador jugador) {
		return jugador.getOrdenDeArresto().getSospechoso().equals(villano);
	}

	public boolean estanEnELMismoLugarDeInteres(Villano villano, Jugador jugador) {
		return villano.getLugarInteresActual().equals(jugador.getLugarInteresActual());
	}
	
	public void viajar(Pais pais){
        jugador.viajar(pais);
        villano.escaparProximoPais();
	}
	
    public Pista obtenerPistas(Pista pista){
        if(pista.getPista1() != null && pista.getPista2() != null && pista.getPistaExtra() != null){
            System.out.println("PISTA 1: " + pista.getPista1());
            System.out.println("PISTA 2: " + pista.getPista2());
            System.out.println("PISTA 3: " + pista.getPistaExtra());
        }
        else if(pista.getPista1() != null && pista.getPista2() != null && pista.getPistaExtra() == null){
            System.out.println("PISTA 1: " + pista.getPista1());
            System.out.println("PISTA 2: " + pista.getPista2());
        }
        return pista;
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
