package controllers;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;

public class RecorridoController {
	
	ResolviendoElCasoViewModel modelo;
	
	private DefaultListModel<String> listaCorrectos= new DefaultListModel<String>();
	private DefaultListModel<String> listaIncorrectos= new DefaultListModel<String>();
	
	
	public RecorridoController( ResolviendoElCasoViewModel modelo) {
		this.modelo=modelo;
	}
	

	public ListModel<Pais> agregarAlRecorrido(Pais paisActual) {
		DefaultListModel<Pais> lista= new DefaultListModel<Pais>();
		lista.addElement(paisActual);
		return lista;
	}
	
	public ListModel<String> paisesCorrectos(){
		if(!listaCorrectos.contains(modelo.getCasoAJugar().getJugador().getPaisActual().getNombre())) {
			listaCorrectos.addElement(modelo.getCasoAJugar().getJugador().getPaisActual().getNombre());
		}
		return listaCorrectos;
	}

	public ListModel<String> paisesIncorrectos() {
		if(!listaIncorrectos.contains(modelo.getCasoAJugar().getJugador().getPaisActual().getNombre())) {
			listaIncorrectos.addElement(modelo.getCasoAJugar().getJugador().getPaisActual().getNombre());
		}
		return listaIncorrectos;
	}
}

