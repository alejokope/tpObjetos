package modelo;

import modelo.lugarInteres.LugarInteres;

import java.util.List;

public class Persona {

	protected List<String> seniasParticulares;
	protected List<String> hobbies;
	protected String nombre;
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

	public void setSeniasParticulares(List<String> seniasParticulares) {
		this.seniasParticulares = seniasParticulares;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getSeniasParticulares() {
		return seniasParticulares;
	}

	public List<String> getHobbies() {
		return hobbies;
	}
}