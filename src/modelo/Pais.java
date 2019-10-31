package modelo;

import modelo.lugarInteres.*;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private String nombre;
	private List<String> caracteristicas;
	private List<LugarInteres> lugaresInteres;
	private List<Pais> conexiones = new ArrayList<Pais>();

	public Pais(){

	}

	public Pais(String nombre, List<String> caracteristicas, List<LugarInteres> lugaresInteres) {
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.lugaresInteres = lugaresInteres;
	}

	public void ingresoVillano(Villano villano) {
		for (LugarInteres lugarInteres : lugaresInteres) {
			lugarInteres.setPasoVillano(true);
			lugarInteres.setVillano(villano);
		}
	}

	public void agregarConexiones(List<Pais> paises) {
		conexiones.addAll(paises);
		enlazarConexiones(paises);
	}

	public void agregarUnaConexion(Pais pais) {
		conexiones.add(pais);
	}

	public void enlazarConexiones(List<Pais> paises) {
		for (Pais pais : paises) {
			pais.agregarUnaConexion(this);
		}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public void setLugaresInteres(List<LugarInteres> lugaresInteres) {
		this.lugaresInteres = lugaresInteres;
	}

	public String getNombre() {
		return nombre;
	}

	public List<LugarInteres> getLugaresInteres() {
		return lugaresInteres;
	}

	public List<Pais> getConexiones() {
		return conexiones;
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}
}