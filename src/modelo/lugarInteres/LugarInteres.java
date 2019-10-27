package modelo.lugarInteres;

import modelo.*;

import java.util.List;

public abstract class LugarInteres {

    protected boolean pasoElVillano = false;
    protected Villano villano;

    abstract public Pista darPista();

    public String informacion(){
        return "";
    }

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
        return pistas.get(obtenerNumeroRandom(pistas));
    }

    protected int obtenerNumeroRandom(List<String> pistas){
        return (int) (Math.random() * pistas.size());
    }

    protected boolean porcentajeMayorA(){
        return false;
    }

}
