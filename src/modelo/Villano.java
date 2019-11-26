package modelo;

import java.util.List;

import excepciones.NoHayPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Villano extends Persona {
	public static final int OBTENER_ULTIMO_INDICE = 1;
	public static final int OBTENER_PROXIMO_INDICE = 1;

	private List<Pais> planEscape;

	public Villano() {

	}

	public Villano(Pais paisActual, List<Pais> planEscape) {
		this.paisActual = paisActual;
		this.planEscape = planEscape;
	}

	public LugarInteres obtenerLugarInteresAleatorio(Pais pais){
		return pais.getLugaresInteres().get(obtenerPosicionAleatoriaDadoUnPais(pais));
	}

	public int obtenerPosicionAleatoriaDadoUnPais(Pais pais){
		return (int) (Math.random() * pais.getLugaresInteres().size());
	}

	public void escaparmeLejosYEnAlgunLugar(){
		this.paisActual = planEscape.get(ultimoPaisDelPlanDeEscape());
		this.lugarInteresActual = obtenerLugarInteresAleatorio(paisActual);
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

	//se usa en carmensandiegomaster...
	public boolean estoyEnElMismoLugarDeInteresQueJugador(Jugador jugador) {
		return lugarInteresActual == jugador.getLugarInteresActual();
	}

	public void escaparProximoPais() {
		paisActual = getPaisProximo();
		//paisActual.ingresoVillanoFinal(this); borrar?
	}

	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}

	public List<Pais> getPlanEscape() {
		return planEscape;
	}

	public void setPaisActual(Pais paisActual){
		this.paisActual = planEscape.get(ultimoPaisDelPlanDeEscape());
	}

	public int ultimoPaisDelPlanDeEscape() {
		return planEscape.size() - OBTENER_ULTIMO_INDICE;
	}


}