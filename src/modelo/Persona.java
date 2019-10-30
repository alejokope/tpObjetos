package modelo;

import modelo.lugarInteres.LugarInteres;

import java.util.List;

public class Persona {

	private String nombre;
	private String sexo;

	protected Pais paisActual;
	protected LugarInteres lugarInteresActual;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSexo() {
		return sexo;
	}

    public List<LugarInteres> obtenerLugaresDeInteresDelPaisActual() {
		return paisActual.getLugaresInteres();
    }

	public void setLugarInteresActual(LugarInteres lugarInteres) {
		this.lugarInteresActual = lugarInteres;
	}

	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}

	public void setPaisActual(Pais paisActual) {
		this.paisActual = paisActual;
	}

	public Pais getPaisActual() {
		return paisActual;
	}

}