package modelo.lugarInteres;

import modelo.*;

import java.util.List;

public class LugarInteres {

    protected boolean pasoElVillano = false;
    protected Villano villano;
    protected Ayuda ayuda = new Ayuda();

    public String darPista(CasoAJugar casoAJugar) {
        if (casoAJugar.seEncuentranAmbos()) {
            return ayuda.gameOverMensaje(casoAJugar.getVillano());
        } else if (casoAJugar.estanEnElMismoPais()) {
            return ayuda.mismoPaisMensaje();
        } else if (casoAJugar.pasoPorElPais()) {
            return pasoPorElPais(casoAJugar);
        } else {
            return ayuda.noPasoPorEstePaisMensaje();
        }
    }

    public String pasoPorElPais(CasoAJugar casoAJugar){
        return "Estas en un LugarInteres. Algo anda mal!";
    }

    public String informacion(){
        return "LUGARINTERES";
    };

    public void setVillano(Villano villano) {
        this.villano = villano;
    }

    public Villano getVillano() {
        return villano;
    }

    public boolean getPasoVillano() {
        return pasoElVillano;
    }

    public void setPasoVillano(boolean pasoVillano) {
        pasoElVillano = pasoVillano;
    }

    public boolean esElMismoLugarInteres(LugarInteres lugarInteres){
        return this.informacion() == lugarInteres.informacion();
    }

    protected String obtenerPistas(List<String> pistas){
        return pistas.get(obtenerPosicionAleatoria(pistas));
    }

    protected int obtenerPosicionAleatoria(List<String> pistas){
        return (int) (Math.random() * pistas.size());
    }

    protected boolean chanceDeObtenerPistaExtra(){
    	return (Math.random() * maximoNumeroRandom()) >= porcentajeEvaluado();
    }

    protected int maximoNumeroRandom(){
        return 0;
    };

    protected int porcentajeEvaluado(){
        return 0;
    }

    public Ayuda getAyuda() {
        return ayuda;
    }

    public void setAyuda(Ayuda ayuda) {
        this.ayuda = ayuda;
    }
}
