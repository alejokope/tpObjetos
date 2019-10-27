package modelo;

import java.util.List;

import excepciones.NoHayPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Villano extends Persona{
    private List<String> señasParticulares;
    private List<String> hobbies;
    private Pais paisActual;
    private LugarInteres lugarInteresActual;
   	private List<Pais> planEscape;

    public Pais getPaisProximo(){
    	int cantidadPaises = planEscape.size();
    	
        for(int i = 0; i < cantidadPaises; i++){
            if(planEscape.get(i).equals(paisActual) && i != cantidadPaises - 1){
                return planEscape.get(i+1);
            }
        }
        
        throw new NoHayPaisProximoException();
    }

    public void escaparProximoPais(){
        paisActual = getPaisProximo();
        paisActual.ingresoVillano(this);
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

    public Pais getPaisActual() {
        return paisActual;
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
	
	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}
	
	public void setLugarInteresActual(LugarInteres lugarInteres) {
    	this.lugarInteresActual = lugarInteres;
	}
}
