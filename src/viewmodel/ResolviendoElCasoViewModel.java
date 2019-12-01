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

    private List<String> recorridoAcertado = new ArrayList<>();
    private List<String> recorridoNoAcertado = new ArrayList<>();

    private List<LugarInteres> lugaresDeInteres= new ArrayList<LugarInteres>();
    private DataDummy dataDummy = SingletonDataDummy.getInstance();


    public DataDummy getDataDummy() {
        return dataDummy;
    }

    public Pais getPaisDeOrigen() {
    	return getCaso().getPaisOrigen();
    }

    public List<LugarInteres> getLugaresDeInteres(){
    	return casoAJugar.getJugador().getPaisActual().getLugaresInteres();
    }

    public List<Pais> getPaisesDondePasoElCriminal() {
        return paisesDondePasoElCriminal;
    }

    public List<Pais> getPaisesDondeNoPasoElCriminal() {
        return paisesDondeNoPasoElCriminal;
    }

    public List<String> getRecorridoAcertado(){
        List<String> paisesCaso = dataDummy.obtenerListaPaisesCaso();
        List<String> paisesJugador = dataDummy.getPaisesVisitados();

        List<String> listaDevolver = new ArrayList<>();

        for(String pais: paisesJugador){
            for(String paisCaso : paisesCaso){
                if(pais.equalsIgnoreCase(paisCaso) && !listaDevolver.contains(pais)){
                    listaDevolver.add(pais);
                }
            }
        }
        return listaDevolver;
    }

    public List<String> getRecorridoNoAcertado(){
        List<String> paisesCaso = dataDummy.obtenerListaPaisesCaso();
        List<String> paisesJugador = dataDummy.getPaisesVisitados();

        List<String> listaDevolver = new ArrayList<>();

        for(String pais: paisesJugador){
            if(!paisesCaso.contains(pais) && !listaDevolver.contains(pais)){
                listaDevolver.add(pais);
            }
        }
        return listaDevolver;
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
        return casoAJugar.getVillano().getNombre();
    }
    
    public List<String> obtenerNombresDePaises(){
        List<String> paises = new ArrayList<>();
        for(Pais pais: getConexiones()){
            paises.add(pais.getNombre());
        }
        return paises;
    }
}
