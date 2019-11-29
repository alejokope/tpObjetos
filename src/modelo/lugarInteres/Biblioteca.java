package modelo.lugarInteres;

import modelo.CasoAJugar;

public class Biblioteca extends LugarInteres {

	public static final int MAXIMO_NUMERO_RANDOM = 100;
	public static final int PORCENTAJE_EVALUADO = 50;

	@Override
	public String pasoPorElPais(CasoAJugar casoAJugar) {
		if (chanceDeObtenerPistaExtra()) {
			return ayuda.pasoPorElPais(obtenerPistas(casoAJugar.getVillano().getHobbies()) + "\n" +
					       obtenerPistas(casoAJugar.getVillano().getSeniasParticulares()) + "\n" +
					       obtenerPistas(casoAJugar.getVillano().obtenerCaracteristicasDelPaisProximo(casoAJugar.getJugador())));
		}
		else{
			return ayuda.pasoPorElPais(obtenerPistas(casoAJugar.getVillano().getSeniasParticulares()) + "\n" +
					       obtenerPistas(casoAJugar.getVillano().obtenerCaracteristicasDelPaisProximo(casoAJugar.getJugador())));
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