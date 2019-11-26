package modelo.lugarInteres;

import modelo.Jugador;

public class Banco extends LugarInteres {

	@Override
	public void darPista(Jugador jugador) {
		if (pasoElVillano) {
			ayuda.setPista(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo(jugador)) + "\n" +
						   obtenerPistas(villano.getSeniasParticulares()));
		}
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
