package modelo.lugarInteres;

import modelo.*;

public class Embajada implements LugarInteres{
    private boolean pasoElVillano = false;
    private Villano villano;

    public Pista darPista() {
        Pista pista = new Pista();
        if(pasoElVillano){
            pista =new Pista(obtenerPistaSobrePais(villano.getPaisProximo()),obtenerPistaSobrePais(villano.getPaisProximo()));
        }
        else{
            System.out.println("No tenemos información.");
        }
        return pista;
    }

    public void setVillano(Villano villano) {
        this.villano = villano;
    }

    public void setPasoVillano(boolean pasoVillano) {
        pasoElVillano = pasoVillano;
    }

    public String informacion() {
        return "EMBAJADA";
    }


    private String obtenerPistaSobrePais(Pais pais){
        int numero = (int) (Math.random() * pais.getCaracteristicas().size());
        return pais.getCaracteristicas().get(numero);
    }

    public Villano getVillano() {
        return villano;
    }

    public boolean getPasoVillano() {
        return pasoElVillano;
    }
}
