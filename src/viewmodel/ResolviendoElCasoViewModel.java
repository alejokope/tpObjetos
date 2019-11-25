package viewmodel;

import modelo.*;
import modelo.lugarInteres.LugarInteres;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResolviendoElCasoViewModel {
    private CarmenSanDiegoMaster carmenSanDiegoMaster;
    private LugarInteres lugarInteresActual;
    private List<Pais> paisesDondePasoElCriminal = new ArrayList<Pais>();
    private List<Pais> paisesDondeNoPasoElCriminal = new ArrayList<Pais>();

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
        return getPaisDeInicio().getConexiones();
    }

    public List<LugarInteres> getLugaresInteres() {
        return getPaisDeInicio().getLugaresInteres();
    }

    public LugarInteres obtenerLugarDeInteres(LugarInteres otroLugarInteres) {
        return getLugaresInteres().stream()
                .filter(lugarInteres -> lugarInteres.esElMismoLugarInteres(otroLugarInteres))
                .collect(Collectors.toList())
                .get(0);
    }

    public boolean existeLugarDeInteres(LugarInteres lugarInteres){
        return obtenerLugarDeInteres(lugarInteres) != null;
    }

    public void jugadorIngresarA(LugarInteres lugarInteres){
        getJugador().setLugarInteresActual(obtenerLugarDeInteres(lugarInteres));
        this.setLugarInteresActual(obtenerLugarDeInteres(lugarInteres));
    }

    private void setLugarInteresActual(LugarInteres lugarDeInteresActual) {
        this.lugarInteresActual = lugarDeInteresActual;
    }

    public String obtenerTituloDelCaso(){
        return getCaso().getTitulo();
    }

    public Ayuda obtenerAyuda(){
        return lugarInteresActual.darPista();
    }

    public void setCarmenSanDiegoMaster(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        this.carmenSanDiegoMaster = carmenSanDiegoMaster;
    }
}
