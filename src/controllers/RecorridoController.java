package controllers;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;

public class RecorridoController {
	
	ResolviendoElCasoViewModel modelo;
	
	
	public RecorridoController( ResolviendoElCasoViewModel modelo) {
		this.modelo=modelo;
	}
	

	public ListModel<Pais> agregarAlREcorrido(Pais paisActual) {
		DefaultListModel<Pais> lista= new DefaultListModel<Pais>();
		lista.addElement(paisActual);
		return lista;
	}


	public ListModel<Pais> getRecorridoCorrecto() {
		// TODO Auto-generated method stub
		return null;
	}
}

