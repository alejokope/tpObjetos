package viewmodel;

import java.util.ArrayList;

import modelo.Persona;


public class ExpedientesViewModel {
	
	public ArrayList<Persona> getVillanos() {
		return SingletonDataDummy.getInstance().obtenerVillanos();
	}

}
