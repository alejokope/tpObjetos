package modelo.lugarInteres;

public class Embajada extends LugarInteres{

    @Override
    public void darPista() {
        if(pasoElVillano){
            ayuda.setPista(obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()) + "\n" +
                            obtenerPistas(villano.obtenerCaracteristicasDelPaisProximo()));
        }
    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
