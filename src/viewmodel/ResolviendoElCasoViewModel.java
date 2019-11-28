package viewmodel;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import viewmodel.SingletonDataDummy;

public class ResolviendoElCasoViewModel {
	
	private Caso caso;
   
    private List<Pais> paisesDondePasoElCriminal = new ArrayList<Pais>();
    private List<Pais> paisesDondeNoPasoElCriminal = new ArrayList<Pais>();
    private List<LugarInteres> lugaresDeInteres= new ArrayList<LugarInteres>();
    private DataDummy dataDummy = SingletonDataDummy.getInstance();


    public DataDummy getDataDummy() {
        return dataDummy;
    }

    public Pais getPaisDeOrigen() {
    	return SingletonDataDummy.getInstance().obtenerPaisOrigen();
    }
    public List<LugarInteres> getLugaresDeInteres(){
    	return SingletonDataDummy.getInstance().getPaisActual().getLugaresInteres();
    }


    public List<Pais> getPaisesDondePasoElCriminal() {
        return paisesDondePasoElCriminal;
    }

    public List<Pais> getPaisesDondeNoPasoElCriminal() {
        return paisesDondeNoPasoElCriminal;
    }



    public Jugador getJugador() {
        return SingletonDataDummy.getInstance().getJugadorAsignado();
    }

    public Caso getCaso() {
        return SingletonDataDummy.getInstance().getCasoAsignado();
    }

    public Villano getVillano() {
        return SingletonDataDummy.getInstance().getVillanoAsignado();
    }

    public Pais getPaisDeInicio() {
        return getCaso().getPaisOrigen();
    }

    public List<Pais> getConexiones() {
        return getPaisDeInicio().getConexiones();
    }

    public List<LugarInteres> getLugaresInteres() {
        return getPaisDeInicio().getLugaresInteres();
    }

    public LugarInteres obtenerLugarDeInteres(LugarInteres otroLugarInteres) {
        LugarInteres lugarInteresNuevo = new LugarInteres();
        for(LugarInteres lugarInteres : getLugaresInteres()){
            if(lugarInteres.esElMismoLugarInteres(otroLugarInteres)){
                lugarInteresNuevo = lugarInteres;
            }
        }
        return lugarInteresNuevo;
    }

    public void jugadorIngresarA(LugarInteres lugarInteres){
        getJugador().setLugarInteresActual(obtenerLugarDeInteres(lugarInteres));
    }

    public String obtenerTituloDelCaso(){
        return getCaso().getTitulo();
    }


	public void setCaso(Caso caso) {
		this.caso=caso;
		
	}
}
