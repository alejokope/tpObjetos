package controllers;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;

public class RecorridoController {
	
	ResolviendoElCasoViewModel modelo;
	
	private DefaultListModel<Pais> listaCorrectos= new DefaultListModel<Pais>();
	private DefaultListModel<Pais> listaIncorrectos= new DefaultListModel<Pais>();
	
	
	public RecorridoController( ResolviendoElCasoViewModel modelo) {
		this.modelo=modelo;
	}
	

	public ListModel<Pais> agregarAlREcorrido(Pais paisActual) {
		DefaultListModel<Pais> lista= new DefaultListModel<Pais>();
		lista.addElement(paisActual);
		return lista;
	}
	
	public ListModel<Pais> paisesCorrectos(){
		if(!listaCorrectos.contains(modelo.getCasoAJugar().getJugador().getPaisActual())) {
			listaCorrectos.addElement(modelo.getCasoAJugar().getJugador().getPaisActual());
		}
		return listaCorrectos;

		
	}


	public ListModel<Pais> getRecorridoCorrecto() {
		// TODO Auto-generated method stub
		return null;
	}


	public ListModel<Pais> paisesIncorrectos() {
		listaIncorrectos.addElement(modelo.getCasoAJugar().getJugador().getPaisActual());
		return listaIncorrectos;
	}
}

