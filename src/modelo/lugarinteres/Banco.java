package modelo.lugarinteres;

import modelo.*;

public class Banco implements LugarInteres {
	private boolean pasoVillano = false;
	private Villano villano;

	public void setVillano(Villano villano) {
		this.villano = villano;
	}

	public Pista darPista() {
		// TODO MEJORAR
		Pista pista = new Pista();
		if (pasoVillano) {
			String pista1 = obtenerPistaSobrePais(villano.getPaisProximo());
			String pista2 = obtenerSeñasParticulares(villano);
			pista = new Pista(pista1, pista2);
		} else {
			System.out.println("No hay información.");
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

}
