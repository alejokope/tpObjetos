package viewmodel;

import modelo.Caso;
import modelo.CasoAJugar;
import modelo.lugarInteres.LugarInteres;

public class LugarInteresViewModel {
    private CasoAJugar casoAJugar;
    private LugarInteres lugarInteres;
    
    public LugarInteresViewModel(CasoAJugar casoAJugar, LugarInteres lugarInteres, boolean pasoVillano) {
    	this.casoAJugar = casoAJugar;
    	this.lugarInteres = lugarInteres;
    	lugarInteres.setPasoVillano(pasoVillano);
    }

    public LugarInteres getLugarInteres() {
            return lugarInteres;
    }

	public CasoAJugar getCasoAJugar() {
		return casoAJugar;
	}

	public String darPista() {
		return lugarInteres.darPista(casoAJugar);
	}
	
	public Caso getCaso() {
		return casoAJugar.getCaso();
	}

	public void setLugarDeInteresDelJugador() {
		casoAJugar.getJugador().setLugarInteresActual(lugarInteres);
	}
    
    
}
