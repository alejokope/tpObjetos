package modelo.lugarInteres;

import modelo.*;

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

    protected String obtenerPistaSobrePais(Pais pais) {
        int numero = (int) (Math.random() * pais.getCaracteristicas().size());
        return pais.obtenerCaracteristica(numero);
    }

    protected String obtenerSeñasParticulares(Villano villano) {
        int numero = (int) (Math.random() * villano.getSeñasParticulares().size());
        return villano.getSeñasParticulares().get(numero);
    }

    protected String obtenerHobbies(Villano villano) {
        int numero = (int) (Math.random() * villano.getHobbies().size());
        return villano.getHobbies().get(numero);
    }

    protected boolean porcentajeMayorA(){
        return false;
    }

}
