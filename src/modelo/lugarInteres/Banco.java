package modelo.lugarInteres;

public class Banco extends LugarInteres {

	@Override
	public void darPista() {
		if (pasoElVillano) {
			ayuda.setPista(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()) + "\n" +
							obtenerPistas(villano.getSeniasParticulares()));
		}
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
