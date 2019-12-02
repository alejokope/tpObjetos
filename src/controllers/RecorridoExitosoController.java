package controllers;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;

public class RecorridoExitosoController {
	
	ResolviendoElCasoViewModel modelo;
	
	public RecorridoExitosoController( ResolviendoElCasoViewModel modelo) {
		this.modelo=modelo;
	}
	
	public ListModel<Pais> getRecorridoCorrecto(){
		DefaultListModel<Pais> lista= new DefaultListModel<Pais>();
		List<Pais> paisesRecorridos=modelo.getRecorridoAcertado();
		for(int i =0; i<paisesRecorridos.size();i++) {
			lista.add(i,paisesRecorridos.get(i));
		}
		return lista;
	}

}

