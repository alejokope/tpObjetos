package viewmodel;

import java.util.ArrayList;

import modelo.Caso;
import modelo.DataDummy;
import modelo.Persona;

public class SingletonDataDummy {
    //ARREGLAR ESTE SINGLETON --> POSIBLE SOLUCION
    /*
    private static DataDummy instaciaDataDummy = null;
    public static DataDummy getInstance() {
        if(instanciaDataDummy == null){
            instanciaDataDummy = new DataDummy();
        }
		return instaciaDataDummy;
	}
     */
	private static final DataDummy instaciaDataDummy = new DataDummy();
	
	private SingletonDataDummy() {
	}
	
	public static DataDummy getInstance() {
		return instaciaDataDummy;
	}

	public ArrayList<Persona> getVillanos() {
		return instaciaDataDummy.obtenerVillanos();
	}

}
