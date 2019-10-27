package modelo.lugarInteres;

import modelo.*;

public class Biblioteca extends LugarInteres {

	public static final int MAXIMO_NUMERO_RANDOM = 100;
	public static final int PORCENTAJE_EVALUADO = 50;

	@Override
	public Ayuda darPista() {
		Ayuda ayuda = new Ayuda();
		if (pasoElVillano) {
			ayuda.agregarDosPistas(obtenerPistas(villano.getSeñasParticulares()), obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()));
			if (porcentajeMayorA()) {
				ayuda.agregarUnaPista(obtenerPistas(villano.getHobbies()));
			}
		}
		return ayuda;
	}

	@Override
	public String informacion() {
		return "BIBLIOTECA";
	}

	@Override
	protected boolean porcentajeMayorA() {
		return (Math.random() * MAXIMO_NUMERO_RANDOM) >= PORCENTAJE_EVALUADO;
	}
}
