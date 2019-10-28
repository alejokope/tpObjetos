package modelo;

public class CarmenSanDiegoMaster {
    private Caso caso;
    private Jugador jugador;
    private Villano villano;

    public boolean gano(Villano villano, Jugador jugador){
        return jugador.esLaOrdenDeArrestoCorrecta(villano) && villano.estoyEnElMismoLugarDeInteresQueJugador(jugador);
    }
	
	public void viajar(Pais pais){
        jugador.viajar(pais);
        villano.escaparProximoPais();
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
