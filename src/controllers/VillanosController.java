package controllers;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import viewmodel.ExpedientesViewModel;

public class VillanosController {
	ExpedientesViewModel modelo;
	
	public VillanosController(ExpedientesViewModel modelo) {
		this.modelo=modelo;
	}
	public ListModel<String> getCaracteristicasVillanoSeleccionado(){
		DefaultListModel<String> lista=new DefaultListModel<String>();
		List <String> caracteristicas=modelo.getCaracteristicasDelVillano();
		for(int i =0; i<caracteristicas.size();i++) {
			caracteristicas.add(i,caracteristicas.get(i));
		}
		return lista;
		
	}

}
