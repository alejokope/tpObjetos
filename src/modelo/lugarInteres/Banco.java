package modelo.lugarInteres;

import modelo.*;

public class Banco implements LugarInteres {
	private boolean pasoVillano = false;
	private Villano villano;

	public void setVillano(Villano villano) {
		this.villano = villano;
	}

	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoVillano) {
			pista.agregarDosPistas(obtenerPistaSobrePais(villano.getPaisProximo()), obtenerSeñasParticulares(villano));
		}
		return pista;
	}

	// todo o utils o herencia repite mucho codigo
	private String obtenerPistaSobrePais(Pais pais) {
		int numero = (int) (Math.random() * pais.getCaracteristicas().size());
		return pais.getCaracteristicas().get(numero);
	}

	private String obtenerSeñasParticulares(Villano villano) {
		int numero = (int) (Math.random() * villano.getSeñasParticulares().size());
		return villano.getSeñasParticulares().get(numero);
	}

	public void setPasoVillano(boolean pasoVillano) {
		this.pasoVillano = pasoVillano;
	}

	public String informacion() {
		return "BANCO";
	}

	public boolean getPasoVillano() {
		return pasoVillano;
	}

	public Villano getVillano() {
		return villano;
	}
}
