package modelo;

import excepciones.NoHayLugarDeInteresEnEstePais;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;

public class CasoAJugar {
    private Caso caso;
    private Jugador jugador;
    private List<String> paisesCorrectos;
    private boolean termino = false;


    public boolean isTermino() {
        return termino;
    }

    public void setTermino(boolean termino) {
        this.termino = termino;
    }
	public CasoAJugar() {
		paisesCorrectos = new ArrayList<>();

	}

	public CasoAJugar(Caso caso, Jugador jugador) {
		this.caso = caso;
		this.jugador = jugador;
	}
	
	public boolean estaElCasoCerrado() {
		return seEncuentranAmbos() || gano();
	}

	public boolean estanEnElMismoPais(){
		return caso.getResponsable().getPaisActual().getNombre().equalsIgnoreCase(jugador.getPaisActual().getNombre());
	}

	public boolean estanEnElMismoLugar(){
		return caso.getResponsable().getLugarInteresActual().informacion().equalsIgnoreCase(
		        jugador.getLugarInteresActual().informacion());
	}

	public boolean seEncuentranAmbos(){
		return estanEnElMismoPais() && estanEnElMismoLugar();
	}

	public boolean gano(){
        return jugador.esLaOrdenDeArrestoCorrecta(caso.getResponsable()) && seEncuentranAmbos();
    }
	
	public void viajar(Pais pais){
        if(caso.getResponsable().tienePaisProximo()){
            caso.getResponsable().viajar();
            jugador.viajar(pais);
        }
        else{
           termino = true;
        }
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

    public void setJugador(Jugador jugador) {
		this.jugador = jugador;
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
		return caso.getResponsable();
	}

	public boolean pasoPorElPais(){
		return this.getJugador().getPaisActual().elVillanoPasoPorEstePais(getVillano());
	}
}
