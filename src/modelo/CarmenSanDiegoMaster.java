package modelo;

import excepciones.NoHayLugarDeInteresEnEstePais;
import modelo.lugarInteres.LugarInteres;

import java.util.List;

public class CarmenSanDiegoMaster {
    private Caso caso;
    private Jugador jugador;
    private Villano villano;
    private EstadoDeMensaje estadoDeMensaje;

	public CarmenSanDiegoMaster() {
		this.estadoDeMensaje = new NoPasoPorEstePaisMensaje();
	}

	public CarmenSanDiegoMaster(Caso caso, Jugador jugador, Villano villano) {
		this.estadoDeMensaje = new NoPasoPorEstePaisMensaje();
		this.caso = caso;
		this.jugador = jugador;
		this.villano = villano;
	}

	public boolean estanEnElMismoPais(){
		return villano.getPaisActual() == jugador.getPaisActual();
	}

	public boolean estanEnElMismoLugar(){
		return villano.getLugarInteresActual() == jugador.getLugarInteresActual();
	}

	public boolean seEncuentranAmbos(){
		return estanEnElMismoPais() && estanEnElMismoLugar();
	}

	public boolean gano(){
        return jugador.esLaOrdenDeArrestoCorrecta(villano) && seEncuentranAmbos();
    }
	
	public void viajar(Pais pais){
        jugador.viajar(pais);
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

	public EstadoDeMensaje getEstadoDeMensaje() {
		return estadoDeMensaje;
	}

	public void setEstadoDeMensaje(EstadoDeMensaje estadoDeMensaje) {
		this.estadoDeMensaje = estadoDeMensaje;
	}

	public void actualizarEstadoDeMensaje(){
		estadoDeMensaje.actualizarEstadoDeMensaje(this);
	}

	public boolean pasoPorElPais(){
		return this.getJugador().getPaisActual().elVillanoPasoPorEstePais(villano);
	}

}
