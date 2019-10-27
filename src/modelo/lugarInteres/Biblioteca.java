package modelo.lugarInteres;

import modelo.*;

public class Biblioteca extends LugarInteres {

	public static final int MAXIMO_NUMERO_RANDOM = 100;
	public static final int PORCENTAJE_EVALUADO = 50;

	@Override
	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoElVillano) {
			pista.agregarDosPistas(obtenerPistas(villano.getSeñasParticulares()), obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()));
			if (porcentajeMayorA()) {
				pista.agregarUnaPista(obtenerPistas(villano.getHobbies()));
			}
		}
		return pista;
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
