package modelo;

import modelo.lugarInteres.*;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private String nombre;
	private Villano villano;
	private boolean pasoElJugador = false;
	private boolean estoyFallido = true;
	private List<String> caracteristicas;
	private List<LugarInteres> lugaresInteres;
	private List<Pais> conexiones = new ArrayList<Pais>();

	private Objeto objeto;
	private Reporte reporte;
	private Titulo titulo;

	public Pais(){

	}

	public Pais(String nombre, List<String> caracteristicas, List<LugarInteres> lugaresInteres) {
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.lugaresInteres = lugaresInteres;
	}


	public void ingresoVillano(Villano villano) {
		this.setPasoVillano(villano);
		this.setEstoyFallido(false);
		for (LugarInteres lugarInteres : lugaresInteres) {
			lugarInteres.setVillano(villano);
			lugarInteres.setPasoVillano(true);
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

	public void setConexiones(List<Pais> conexiones) {
		this.conexiones = conexiones;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	
	public boolean pasoElJugador() {
		return pasoElJugador;
	}

	public void setPasoElJugador(boolean b) {
		this.pasoElJugador = b;	
	}

	public boolean estoyFallido() {
		return estoyFallido;
	}

	public void setEstoyFallido(boolean estoyFallido) {
		this.estoyFallido = estoyFallido;
	}

	public Villano getVillano() {
		return villano;
	}

	public void setPasoVillano(Villano villano) {
		this.villano = villano;
	}
	
	
	
	
}