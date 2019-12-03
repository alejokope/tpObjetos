package modelo;

import java.util.List;

public class Caso {
    private Villano responsable;
    private String titulo;
    private String reporte;
    private String objetoRobado;
    private Pais paisOrigen;

	public Caso() {

	}

	public Caso(Villano responsable, String reporte, String objetoRobado, Pais paisOrigen) {
		this.responsable = responsable;
		this.reporte = reporte;
		this.objetoRobado = objetoRobado;
		this.paisOrigen = paisOrigen;
	}

	public void setResponsable(Villano responsable) {
		this.responsable = responsable;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void pasarVillanoPorPaises(){
		for (Pais pais : getResponsable().getPlanEscape()){
			pais.ingresoVillano(responsable);
		}
	}

}