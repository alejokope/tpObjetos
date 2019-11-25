package modelo;

import excepciones.NoHayLugarDeInteresEnEstePais;
import modelo.lugarInteres.LugarInteres;

import java.util.List;

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

	public void ubicacionDeJugadorOVillano(LugarInteres lugarInteres, Persona persona) {
		if(obtenerLugaresDeInteresDeUnaPersona(persona).contains(lugarInteres)){
			persona.setLugarInteresActual(lugarInteres);
		}
		else{
			throw new NoHayLugarDeInteresEnEstePais();
		}
	}

	public List<LugarInteres> obtenerLugaresDeInteresDeUnaPersona(Persona persona) {
		return persona.obtenerLugaresDeInteresDelPaisActual();
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Caso getCaso() {
		return caso;
	}

	public Villano getVillano() {
		return villano;
	}
}
