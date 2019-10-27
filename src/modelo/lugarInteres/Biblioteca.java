package modelo.lugarInteres;

import modelo.*;

public class Biblioteca implements LugarInteres {
	private Villano villano;
	private boolean pasoVillano = false;

	public Pista darPista() {
		Pista pista = new Pista();
		if (pasoVillano) {
			pista.agregarDosPistas(obtenerSeñasParticulares(villano), obtenerPistaSobrePais(villano.getPaisProximo()));
			if (porcentajeMayorA50()) {
				pista.agregarUnaPista(obtenerHobbies(villano));
			}
		}
		return pista;
	}

	// todo o utils o herencia repite mucho codigo
	private String obtenerPistaSobrePais(Pais pais) {
		int numero = (int) (Math.random() * pais.getCaracteristicas().size());
		return pais.obtenerCaracteristica(numero);
	}

	private String obtenerSeñasParticulares(Villano villano) {
		int numero = (int) (Math.random() * villano.getSeñasParticulares().size());
		return villano.getSeñasParticulares().get(numero);
	}

	private String obtenerHobbies(Villano villano) {
		int numero = (int) (Math.random() * villano.getHobbies().size());
		return villano.getHobbies().get(numero);
	}

	private boolean porcentajeMayorA50() {
		int numeroAlAzar = (int) (Math.random() * 100);
		return numeroAlAzar >= 50;
	}

	public void setPasoVillano(boolean pasoVillano) {
		this.pasoVillano = pasoVillano;
	}

	public String informacion() {
		return "BIBLIOTECA";
	}

	public void setVillano(Villano villano) {
		this.villano = villano;
	}

	public Villano getVillano() {
		return villano;
	}

	public boolean getPasoVillano() {
		return pasoVillano;
	}
}
