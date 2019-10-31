package modelo.lugarInteres;

import modelo.*;

public class Embajada extends LugarInteres{

    @Override
    public Ayuda darPista() {
        Ayuda ayuda = new Ayuda();
        if(pasoElVillano){
            ayuda.agregarDosPistas(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()), obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()));
        }
        return ayuda;
    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
