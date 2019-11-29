package viewmodel;

import modelo.Ayuda;
import modelo.Caso;
import modelo.CasoAJugar;
import modelo.lugarInteres.LugarInteres;

import java.awt.*;

public class LugarInteresVM {
    private CasoAJugar casoAJugar;
    Ayuda ayuda = new Ayuda();
    LugarInteres lugarInteres;

        if(casoAJugar.getSospechoso  .tienePaisProximo() && jugador.getPaisActual().getNombre().equalsIgnoreCase(villano.getPaisActual().getNombre())
            && !lugarInteresVisitado.informacion().equalsIgnoreCase(villano.getLugarInteresActual().informacion())){
        pista = "CUIDADO DETECTIVE!! Ha estado a punto de caer en una trampa. La persona que busca esta en esta ciudad";
    }
        else if(!utils.paisEstaEnElCaso(caso.getPlanEscape(),jugador.getPaisActual())){
        pista = "Lo siento, creo que se ha equivocado de ciudad, no hay nadie con esas caracteristicas";
    }
        else if (!jugador.getPaisActual().getNombre().equalsIgnoreCase(caso.getPaisOrigen().getNombre()) &&jugador.getPaisActual().getNombre().equalsIgnoreCase(villano.getPaisActual().getNombre()) && lugarInteresVisitado.informacion().equalsIgnoreCase(villano.getLugarInteresActual().informacion())){
        if(jugador.getSospechoso() != null && jugador.getSospechoso().getNombre().equalsIgnoreCase(villano.getNombre())){
            pista = "ALTO DETENGASE!! " + dataDummy.getJugadorAsignado().getSospechoso().getNombre();
        }
    }
        else{ pista = lugarInteresVisitado.getAyuda().darPistaMensaje(); }

    public Ayuda getAyuda() {
            return ayuda;
    }

    public LugarInteres getLugarInteres() {
            return lugarInteres;
    }
}
