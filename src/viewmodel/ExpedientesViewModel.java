package viewmodel;

import java.util.ArrayList;
import java.util.List;

import modelo.Persona;


public class ExpedientesViewModel {
	
	private Persona villanoSeleccionado;

	public ArrayList<Persona> getVillanos() {
		return SingletonDataDummy.getInstance().obtenerVillanos();
	}
	
	public void setVillanoSeleccionado(Persona villano) {
		villanoSeleccionado= villano;
	}

	public Persona getVillanoSeleccionado() {
		return villanoSeleccionado;
	}
	public List<String> getCaracteristicasDelVillano(){
		return SingletonDataDummy.getInstance().getVillanoAsignado().getSeniasParticulares();
	}

}
