package modelo.lugarInteres;

import modelo.Jugador;

public class Biblioteca extends LugarInteres {

	public static final int MAXIMO_NUMERO_RANDOM = 100;
	public static final int PORCENTAJE_EVALUADO = 50;

	@Override
	public void darPista(Jugador jugador) {
		if (pasoElVillano && chanceDeObtenerPistaExtra()) {
			ayuda.setPista(obtenerPistas(villano.getHobbies()) + "\n" +
					       obtenerPistas(villano.getSeniasParticulares()) + "\n" +
					       obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo(jugador)));
		}
		else if(pasoElVillano){
			ayuda.setPista(obtenerPistas(villano.getSeniasParticulares()) + "\n" +
					       obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo(jugador)));
		}
	}

	@Override
	public String informacion() {
		return "BIBLIOTECA";
	}

	@Override
	protected int maximoNumeroRandom() {
		return MAXIMO_NUMERO_RANDOM;
	}

	@Override
	protected int porcentajeEvaluado() {
		return PORCENTAJE_EVALUADO;
	}
}