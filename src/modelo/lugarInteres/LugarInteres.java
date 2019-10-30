package modelo.lugarInteres;

import modelo.*;

import java.util.List;

public abstract class LugarInteres {

    protected boolean pasoElVillano = false;
    protected Villano villano;

    abstract public Ayuda darPista();

    abstract public String informacion();

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

    protected String obtenerPistas(List<String> pistas){
        return pistas.get(obtenerPosicionAleatoria(pistas));
    }

    protected int obtenerPosicionAleatoria(List<String> pistas){
        return (int) (Math.random() * pistas.size());
    }

    protected boolean esPorcentajeMayorAPorcentajeEvaluado(){
    	return (Math.random() * maximoNumeroRandom()) >= porcentajeEvaluado();
    }

    protected int maximoNumeroRandom(){
        return 0;
    };

    protected int porcentajeEvaluado(){
        return 0;
    }
}