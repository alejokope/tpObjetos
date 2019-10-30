package modelo;

import modelo.lugarInteres.LugarInteres;

public class CarmenSanDiegoMaster {
    private Caso caso;
    private Jugador jugador;
    private Villano villano;

	public CarmenSanDiegoMaster() {

	}

	public CarmenSanDiegoMaster(Caso caso, Jugador jugador, Villano villano) {
		this.caso = caso;
		this.jugador = jugador;
		this.villano = villano;
	}

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

	public void ubicacionDelJugador(LugarInteres lugarInteres) {
    	jugador.setLugarInteresActual(lugarInteres);
	}

	public void ubicacionDelVillano(LugarInteres lugarInteres) {
    	villano.setLugarInteresActual(lugarInteres);
	}
}
