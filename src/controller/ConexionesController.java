package controller;


import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import modelo.Pais;
import viewmodel.ResolviendoElCasoViewModel;

public class ConexionesController {
	ResolviendoElCasoViewModel modelo;

	public ConexionesController(ResolviendoElCasoViewModel modelo) {
		this.modelo = modelo;
	}
	
	public ListModel<Pais> getConexiones(){
		DefaultListModel<Pais> lista = new DefaultListModel<Pais>();
		List<Pais> conexiones = modelo.getConexiones();
		for(int i = 0; i < conexiones.size(); i++) {
			lista.add(i, conexiones.get(i));
		}
		return lista;
	}
	

}
