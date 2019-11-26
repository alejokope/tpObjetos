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

	public void escaparmeAlUltimoPaisYEnAlgunLugar(){
		this.paisActual = planEscape.get(ultimoPaisDelPlanDeEscape());
		this.lugarInteresActual = obtenerLugarInteresAleatorio(paisActual);
	}

	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}

	public List<Pais> getPlanEscape() {
		return planEscape;
	}

	public void setPaisActual(Pais paisActual){
		this.paisActual = paisActual;
	}

	public int ultimoPaisDelPlanDeEscape() {
		return planEscape.size() - OBTENER_ULTIMO_INDICE;
	}

	public List<String> obtenerCaracteristicasDelPaisProximo(Jugador jugador) {
		return getPaisProximo(jugador).getCaracteristicas();
	}

	public Pais getPaisProximo(Jugador jugador) {
		return planEscape.get(obtenerSiguientePaisDeMiPlanDeEscape(jugador));
	}

	public int obtenerSiguientePaisDeMiPlanDeEscape(Jugador jugador) {
		if (miPlanDeEscapeContieneAlPaisActualDelJugadorYNoEsElUltimoPais(jugador)) {
			return planEscape.indexOf(jugador.getPaisActual()) + OBTENER_PROXIMO_INDICE;
		}
		else if(miPlanDeEscapeContieneAlPaisActualDelJugadorYEsElUltimoPais(jugador)){
			return planEscape.indexOf(jugador.getPaisActual());
		}
		else {
			throw new NoHayPaisProximoException();
		}
	}

	public boolean miPlanDeEscapeContieneAlPaisActualDelJugadorYNoEsElUltimoPais(Jugador jugador) {
		return planEscape.contains(jugador.getPaisActual())
				&& planEscape.indexOf(jugador.getPaisActual()) < planEscape.size() - OBTENER_ULTIMO_INDICE;
	}

	public boolean miPlanDeEscapeContieneAlPaisActualDelJugadorYEsElUltimoPais(Jugador jugador) {
		return planEscape.contains(jugador.getPaisActual())
				&& planEscape.indexOf(jugador.getPaisActual()) == planEscape.size() - OBTENER_ULTIMO_INDICE;
	}

}