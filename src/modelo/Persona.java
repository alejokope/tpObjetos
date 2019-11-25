package modelo;

import modelo.lugarInteres.LugarInteres;

import java.util.List;

public class Persona {

	private String nombre;
	private String sexo;
    private List<String> hobbies;
    private List<String> seniasParticulares;
	protected Pais paisActual;
	protected LugarInteres lugarInteresActual;

    public void setSeniasParticulares(List<String> seniasParticulares) {
        this.seniasParticulares = seniasParticulares;
    }

    public List<String> getSeniasParticulares() {
        return seniasParticulares;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

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

	public boolean estaEstePaisConectadoAMiPaisActual(List<Pais> paises, Pais pais){
        for(Pais _pais : paises){
            if(_pais.getNombre().equalsIgnoreCase(pais.getNombre())){
                return true;
            }
        }
        return false;
    }
}
