package controllers;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import modelo.Persona;
import viewmodel.ExpedientesViewModel;

public class VillanosController {
	
	ExpedientesViewModel modelo;
	Persona villanoSeleccionado;
	
	public VillanosController(ExpedientesViewModel modelo) {
		
		this.modelo=modelo;
		this.villanoSeleccionado=modelo.getVillanoSeleccionado();
	}
	public ListModel<String> getCaracteristicasVillanoSeleccionado(){
		DefaultListModel<String> lista=new DefaultListModel<String>();
		List <String> caracteristicas=villanoSeleccionado.getSeniasParticulares();
		for(int i =0; i<caracteristicas.size();i++) {
			lista.add(i, caracteristicas.get(i));;
		}
		return lista;
		
	}
	public ListModel<String> getHobbiessVillanoSeleccionado(){
		DefaultListModel<String> lista=new DefaultListModel<String>();
		List <String> hobbies=villanoSeleccionado.getHobbies();
		for(int i =0; i<hobbies.size();i++) {
			lista.add(i, hobbies.get(i));;
		}
		return lista;
		
	}

}
