package modelo;

import java.util.List;

import excepciones.NoHayPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Villano extends Persona {
	public static final int OBTENER_ULTIMO_INDICE = 1;
	public static final int OBTENER_PROXIMO_INDICE = 1;

	private List<String> señasParticulares;
	private List<String> hobbies;
	private Pais paisActual;
	private LugarInteres lugarInteresActual;
	private List<Pais> planEscape;

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
	}

	public void setSeñasParticulares(List<String> señasParticulares) {
		this.señasParticulares = señasParticulares;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void setPaisActual(Pais paisActual) {
		this.paisActual = paisActual;
	}

	public Pais getPaisActual() {
		return paisActual;
	}

	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}

	public List<Pais> getPlanEscape() {
		return planEscape;
	}

	public List<String> getSeñasParticulares() {
		return señasParticulares;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}

	public void setLugarInteresActual(LugarInteres lugarInteres) {
		this.lugarInteresActual = lugarInteres;
	}
}