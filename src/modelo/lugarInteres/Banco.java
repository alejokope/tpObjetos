package modelo.lugarInteres;

import modelo.*;

public class Banco extends LugarInteres {

	@Override
	public Ayuda darPista() {
		Ayuda ayuda = new Ayuda();
		if (pasoElVillano) {
			ayuda.agregarDosPistas(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()), obtenerPistas(villano.getSeñasParticulares()));
		}
		return ayuda;
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
