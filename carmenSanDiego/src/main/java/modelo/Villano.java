package modelo;

import modelo.lugarinteres.LugarInteres;
import java.util.List;

public class Villano {
    private String nombre;
    private String sexo;
    private List<String> señasParticulares;
    private List<String> hobbies;
    //todo fijarse de poner un indice para indicar en que pais de la lista esta
    private Pais paisActual;
    private List<Pais> planEscape;

    public Pais getPaisActual() {
        return paisActual;
    }


    public Pais getPaisProximo(){
        for(int i = 0; i < planEscape.size(); i++){
            if(planEscape.get(i).equals(paisActual)){
                return planEscape.get(i+1);
            }
        }
        //TODO HACER EXCEPCION
        return null;
    }

    public void escaparProximoPais(){
        paisActual = getPaisProximo();
        paisActual.ingresoVillano(this);
    }


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setSeñasParticulares(List<String> señasParticulares) {
		this.señasParticulares = señasParticulares;
	}


	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}


	public void setPaisActual(Pais paisActual) {
		this.paisActual = paisActual;
	}


	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}


	public List<Pais> getPlanEscape() {
		return planEscape;
	}


	public List<String> getSeñasParticulares() {
		return señasParticulares;
	}


	public List<String> getHobbies() {
		return hobbies;
	}
}
