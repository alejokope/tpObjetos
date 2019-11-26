package modelo.lugarInteres;

import modelo.Jugador;

public class Embajada extends LugarInteres{

    @Override
    public void darPista(Jugador jugador) {
        if(pasoElVillano){
            ayuda.setPista(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo(jugador)) + "\n" +
                           obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo(jugador)));
        }
    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
