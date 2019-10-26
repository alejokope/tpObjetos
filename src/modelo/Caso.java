package modelo;

import java.util.List;

public class Caso {
    private Villano responsable;
    private List<Pais> planEscape;
    private String reporte;
    private String objetoRobado;
    private Pais paisOrigen;
    
    public void setResponsable(Villano responsable) {
		this.responsable = responsable;
	}
    
	public void setPlanEscape(List<Pais> planEscape) {
		this.planEscape = planEscape;
	}
	
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	
	public void setObjeto(String objeto) {
		this.objetoRobado = objeto;
	}
	
	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getReporte() {
		return reporte;
	}

	public String getObjeto() {
		return objetoRobado;
	}

	public Pais getPaisOrigen() {
		return paisOrigen;
	}


	public Villano getResponsable() {
    	return responsable;
	}

    public List<Pais> getPlanEscape() {
    	return planEscape;
    }
}


