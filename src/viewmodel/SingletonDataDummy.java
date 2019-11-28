package viewmodel;

import java.util.ArrayList;

import modelo.Caso;
import modelo.DataDummy;
import modelo.Persona;

public class SingletonDataDummy {
	private static final DataDummy instaciaDataDummy = new DataDummy();
	
	private SingletonDataDummy() {
	}
	
	public static DataDummy getInstance() {
		return instaciaDataDummy;
	}

	public ArrayList<Persona> getVillanos() {
		return instaciaDataDummy.obtenerVillanos();
	}
/*	public Caso getCaso() {
		return instaciaDataDummy.obtenerCasoAlAzar();
	}
*/
}
