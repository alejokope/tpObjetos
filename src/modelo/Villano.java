package modelo;

import java.util.List;

import excepciones.NoHayPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Villano extends Persona {
	public static final int OBTENER_ULTIMO_INDICE = 1;
	public static final int OBTENER_PROXIMO_INDICE = 1;
	private Utils utils;

	private List<Pais> planEscape;

	public Villano() {
	    utils = new Utils();
	}

	public Villano(Pais paisActual, List<Pais> planEscape) {
		this.paisActual = paisActual;
		this.planEscape = planEscape;
	}

	public List<String> obtenerCaracteristicasDelPaisProximo() {
		return getPaisProximo().getCaracteristicas();
	}

	public Pais getPaisProximo() {
	    for(int i = 0; i < planEscape.size(); i++){
	        if(planEscape.get(i).getNombre().equalsIgnoreCase(paisActual.getNombre())){
	            return planEscape.get(i++);
            }
	    }
	    throw new NoHayPaisProximoException();
	}

	public boolean estoyEnElMismoLugarDeInteresQueJugador(Jugador jugador) {
		return lugarInteresActual == jugador.getLugarInteresActual();
	}

	public void escaparProximoPais() {
		paisActual = getPaisProximo();
		paisActual.ingresoVillano(this);
		//lugarInteresActual = obtenerLugarDeInteresPaisProximo();
	}

    private LugarInteres obtenerLugarDeInteresPaisProximo(){
        return this.getPaisActual().getLugaresInteres().get(utils.obtenerNumeroAleotorio(this.getPaisActual().getLugaresInteres().size()));
    }

	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}

	public List<Pais> getPlanEscape() {
		return planEscape;
	}


}
