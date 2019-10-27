package modelo.lugarInteres;

import modelo.*;

public class Biblioteca extends LugarInteres {

	public static final int MAXIMO_NUMERO_RANDOM = 100;
	public static final int PORCENTAJE_EVALUADO = 50;

	@Override
	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoElVillano) {
			pista.agregarDosPistas(obtenerSeñasParticulares(villano), obtenerPistaSobrePais(villano.getPaisProximo()));
			if (porcentajeMayorA()) {
				pista.agregarUnaPista(obtenerHobbies(villano));
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
