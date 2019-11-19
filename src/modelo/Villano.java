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
	}

	public Villano(Pais paisActual, List<Pais> planEscape) {
		this.paisActual = paisActual;
		this.planEscape = planEscape;
	}

	public List<String> obtenerCaracteristicasDelPaisProximo() {
		return getPaisProximo().getCaracteristicas();
	}

	public Pais getPaisProximo() {
		return planEscape.get(obtenerSiguientePaisDeMiPlanDeEscape());
	}

	public int obtenerSiguientePaisDeMiPlanDeEscape() {
		if (miPlanDeEscapeContieneAMiPaisActualYPuedoSeguirMiPlanDeEscape()) {
			return planEscape.indexOf(paisActual) + OBTENER_PROXIMO_INDICE;
		} else {
			throw new NoHayPaisProximoException();
		}
	}

	public boolean miPlanDeEscapeContieneAMiPaisActualYPuedoSeguirMiPlanDeEscape() {
		return planEscape.contains(paisActual)
				&& planEscape.indexOf(paisActual) < planEscape.size() - OBTENER_ULTIMO_INDICE;
	}

	public boolean estoyEnElMismoLugarDeInteresQueJugador(Jugador jugador) {
		return lugarInteresActual == jugador.getLugarInteresActual();
	}

	public void escaparProximoPais() {
		paisActual = getPaisProximo();
		paisActual.ingresoVillano(this);
		lugarInteresActual = obtenerLugarDeInteresPaisProximo(this);
	}

    private LugarInteres obtenerLugarDeInteresPaisProximo(Villano villano){
        return villano.getPaisProximo().getLugaresInteres().get(utils.obtenerNumeroAleotorio(villano.getPaisProximo().getLugaresInteres().size()));
    }

	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}

	public List<Pais> getPlanEscape() {
		return planEscape;
	}


}
