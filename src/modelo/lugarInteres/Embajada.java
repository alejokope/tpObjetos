package modelo.lugarInteres;

import modelo.*;

public class Embajada extends LugarInteres{

    @Override
    public Pista darPista() {
        Pista pista = new Pista();
        if(pasoElVillano){
            pista.agregarDosPistas(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()), obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()));
        }
        return pista;
    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
