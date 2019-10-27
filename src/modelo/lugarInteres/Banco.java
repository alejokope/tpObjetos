package modelo.lugarInteres;

import modelo.*;

public class Banco extends LugarInteres {

	@Override
	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoElVillano) {
			pista.agregarDosPistas(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()), obtenerPistas(villano.getSeñasParticulares()));
		}
		return pista;
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
