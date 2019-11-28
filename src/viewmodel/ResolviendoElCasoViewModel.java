package viewmodel;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;

public class ResolviendoElCasoViewModel {
    private CarmenSanDiegoMaster carmenSanDiegoMaster;
    private Pais paisSeleccionado;
    
    //me parece que estos dos ya no van...
    private List<Pais> paisesDondePasoElCriminal = new ArrayList<Pais>();
    private List<Pais> paisesDondeNoPasoElCriminal = new ArrayList<Pais>();

    public ResolviendoElCasoViewModel(CarmenSanDiegoMaster carmenSanDiegoMaster) {
		this.carmenSanDiegoMaster = carmenSanDiegoMaster;
	}

	public Jugador getJugador() {
        return carmenSanDiegoMaster.getJugador();
    }

    public Caso getCaso() {
        return carmenSanDiegoMaster.getCaso();
    }

    public Villano getVillano() {
        return carmenSanDiegoMaster.getVillano();
    }

    public Pais getPaisDeInicio() {
        return getCaso().getPaisOrigen();
    }

    public List<Pais> getConexiones() {
        return getJugador().obtenerConexionesDeMiPaisActual();
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


    public void setCarmenSanDiegoMaster(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        this.carmenSanDiegoMaster = carmenSanDiegoMaster;
    }

	public Pais getPaisSeleccionado() {
		return paisSeleccionado;
	}

	public void setPaisSeleccionado(Pais paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}
	
	public void jugadorViajoAPaisSeleccionado() {
		carmenSanDiegoMaster.getJugador().viajar(paisSeleccionado);;
	}
    
    
}
