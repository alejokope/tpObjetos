package modelo;

import modelo.lugarInteres.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pais {
    private String nombre;
    private List<String> caracteristicas;
    private List<LugarInteres> lugaresInteres;
    private List<Pais> conexiones = new ArrayList<Pais>();


    public void ingresoVillano(Villano villano){
        for(LugarInteres lugarInteres : lugaresInteres){
            lugarInteres.setPasoVillano(true);
            lugarInteres.setVillano(villano);
        }
    }
    
    public void agregarConexiones(List<Pais> conexiones) {
		this.conexiones.addAll(conexiones);
		enlazarConexiones(conexiones);
	}
	
	public void agregarUnaConexion(Pais conexion) {
		conexiones.add(conexion);
	}

	public void enlazarConexiones(List<Pais> conexiones) {
		for(Pais conexion : conexiones) {
			conexion.agregarUnaConexion(this);
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
