package modelo.lugarInteres;

import modelo.*;

public class Embajada extends LugarInteres{

    @Override
    public Pista darPista() {
        Pista pista = new Pista();
        if(pasoElVillano){
            pista.agregarDosPistas(obtenerPistaSobrePais(villano.getPaisProximo()), obtenerPistaSobrePais(villano.getPaisProximo()));
        }
        return pista;
    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
