package modelo.lugarInteres;

import modelo.CasoAJugar;

public class Embajada extends LugarInteres{

    @Override
    public String pasoPorElPais(CasoAJugar casoAJugar) {
            return ayuda.pasoPorElPais(obtenerPistas(casoAJugar.getVillano().obtenerCaracteristicasDelPaisProximo(casoAJugar.getJugador())) + "\n" +
                                                 obtenerPistas(casoAJugar.getVillano().obtenerCaracteristicasDelPaisProximo(casoAJugar.getJugador())));

    }

    @Override
    public String informacion() {
        return "EMBAJADA";
    }


}
