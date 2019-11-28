package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import modelo.Persona;
import modelo.Villano;
import viewmodel.ExpedientesViewModel;

public class ExpedientesController {
	ExpedientesViewModel modelo;
	
	public ExpedientesController( ExpedientesViewModel modelo) {
		this.modelo=modelo;
	}
	public ListModel<Persona> getVillanos(){
		DefaultListModel<Persona> lista= new DefaultListModel<Persona>();
		List<Persona> villanos= modelo.getVillanos();
		for(int i = 0; i<villanos.size();i++) {
			lista.add(i,villanos.get(i));
		}
		return lista;	
	}
	
	public List<Persona> getVillanos2(){
		List<Persona> lista = new ArrayList<Persona>();
		ArrayList<Persona> villanos= modelo.getVillanos();
		for(int i = 0; i<villanos.size();i++) {
			lista.add(i,villanos.get(i));
		}
		return lista;	
	}

}
