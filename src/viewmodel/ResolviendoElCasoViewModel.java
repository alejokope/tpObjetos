package viewmodel;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;

import viewmodel.SingletonDataDummy;

public class ResolviendoElCasoViewModel {
	
	private CasoAJugar casoAJugar;

	private List<Pais> paisesDondePasoElCriminal = new ArrayList<Pais>();
    private List<Pais> paisesDondeNoPasoElCriminal = new ArrayList<Pais>();

    private List<Pais> recorridoAcertado = new ArrayList<>();
    private List<String> recorridoNoAcertado = new ArrayList<>();

    private List<LugarInteres> lugaresDeInteres= new ArrayList<LugarInteres>();

    public Pais getPaisDeOrigen() {
    	return getCaso().getPaisOrigen();
    }

    public List<LugarInteres> getLugaresDeInteres(){
    	return casoAJugar.getJugador().getPaisActual().getLugaresInteres();
    }
    
    public boolean estaPaisActualEnPlanEscape() {
    	List<String> paises = new ArrayList<String>();
    	casoAJugar.getCaso().getResponsable().getPlanEscape().stream().forEach(pais -> paises.add(pais.getNombre()));

    	for(String pais: paises){
    	    if(casoAJugar.getJugador().getPaisActual().getNombre().equalsIgnoreCase(pais)){
    	        return true;
            }
        }
    	return false;
    }

    public List<Pais> getPaisesDondePasoElCriminal() {
        return paisesDondePasoElCriminal;
    }

    public List<Pais> getPaisesDondeNoPasoElCriminal() {
        return paisesDondeNoPasoElCriminal;
    }

   public List<Pais> getRecorridoAcertado(){
	    List<Pais> paisesCaso = casoAJugar.getCaso().getResponsable().getPlanEscape();
	    Pais paisDondeEstaElJugador=casoAJugar.getJugador().getPaisActual();
        for(int i=0; i<paisesCaso.size();i++) {
        	if(paisesCaso.contains(paisDondeEstaElJugador)) {
        		Pais paisCorrecto=paisesCaso.get(i);
        		recorridoAcertado.add(paisCorrecto);
        	}	
        }
        return recorridoAcertado;
    }

    public Jugador getJugador() {
        return casoAJugar.getJugador();
    }

    public Caso getCaso() {
        return casoAJugar.getCaso();
    }

    public Villano getVillano() {
        return casoAJugar.getVillano();
    }

    public Pais getPaisDeInicio() {
        return getCaso().getPaisOrigen();
    }
    
    public Pais getPaisActual() {
    	return getJugador().getPaisActual();
    }

    public List<Pais> getConexiones() {
        return getPaisActual().getConexiones();
    }

    public String obtenerTituloDelCaso(){
        return getCaso().getTitulo();
    }


	public boolean hayVillanoCapturado() {
		return casoAJugar.getJugador().hayOrdenDeArresto();
	}

    public void setCasoAJugar(CasoAJugar casoAJugar) {
        this.casoAJugar = casoAJugar;
    }

    public String getNombrePaisActual() {
        return casoAJugar.getJugador().getPaisActual().getNombre();
    }

    public String getNombreDelVillanoACapturar() {
    	return casoAJugar.getJugador().getSospechoso().getNombre();
    }
    
    public List<String> obtenerNombresDePaises(){
        List<String> paises = new ArrayList<>();
        for(Pais pais: getConexiones()){
            paises.add(pais.getNombre());
        }
        return paises;
    }
    public CasoAJugar getCasoAJugar() {
		return casoAJugar;
	}
}
