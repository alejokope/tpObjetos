package viewmodel;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import viewmodel.SingletonDataDummy;

public class ResolviendoElCasoViewModel {
   
    private List<Pais> paisesDondePasoElCriminal = new ArrayList<Pais>();
    private List<Pais> paisesDondeNoPasoElCriminal = new ArrayList<Pais>();
    private List<LugarInteres> lugaresDeInteres= new ArrayList<LugarInteres>();
    private SingletonDataDummy dataDummy;
    

    public Pais getPaisDeOrigen() {
    	return dataDummy.getInstance().getPaisActual();
    }
    public List<LugarInteres> getLugaresDeInteres(){
    	return dataDummy.getInstance().getPaisActual().getLugaresInteres();
    }
    

    public Jugador getJugador() {
        return dataDummy.getInstance().getJugadorAsignado();
    }

    public Caso getCaso() {
        return dataDummy.getInstance().getCasoAsignado();
    }

    public Villano getVillano() {
        return dataDummy.getInstance().getVillanoAsignado();
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


    public void setCarmenSanDiegoMaster(SingletonDataDummy dataDummy) {
        this.dataDummy = dataDummy;
    }
}
