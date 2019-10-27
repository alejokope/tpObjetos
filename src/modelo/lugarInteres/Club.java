package modelo.lugarInteres;

import modelo.*;

public class Club implements LugarInteres{
    private boolean pasoVillano = false;
    private Villano villano;

    public void setVillano(Villano villano) {
        this.villano = villano;
    }

    public Pista darPista() {
        Pista pista = new Pista();
        if (pasoVillano) {
            pista.agregarDosPistas(obtenerSeñasParticulares(villano), obtenerSeñasParticulares(villano));
            if (porcentajeMayorA70()) {
                pista.agregarUnaPista(obtenerHobbies(villano));
            }
        }
        return pista;
    }

    //todo o utils o herencia repite mucho codigo
    private String obtenerHobbies(Villano villano){
        int numero = (int) (Math.random() * villano.getHobbies().size());
        return villano.getHobbies().get(numero);
    }

    private boolean porcentajeMayorA70(){
        int numeroAlAzar = (int) (Math.random() * 100 + 1);
        return numeroAlAzar >= 70;
    }

    private String obtenerSeñasParticulares(Villano villano){
        int numero = (int) (Math.random() * villano.getSeñasParticulares().size());
        return villano.getSeñasParticulares().get(numero);
    }

    public void setPasoVillano(boolean pasoVillano) {
        this.pasoVillano = pasoVillano;
    }

    public String informacion() {
        return "CLUB";
    }

    public Villano getVillano() {
        return villano;
    }

    public boolean getPasoVillano() {
        return pasoVillano;
    }
}
