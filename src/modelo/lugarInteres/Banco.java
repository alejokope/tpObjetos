package modelo.lugarInteres;

import modelo.*;

public class Banco extends LugarInteres {

	@Override
	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoElVillano) {
			pista.agregarDosPistas(obtenerPistaSobrePais(villano.getPaisProximo()), obtenerSeñasParticulares(villano));
		}
		return pista;
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
