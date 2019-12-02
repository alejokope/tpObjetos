package viewmodel;

import modelo.Caso;
import modelo.CasoAJugar;
import modelo.Jugador;

public class PresentacionCasoViewModel {
    private Caso casoActual;
    private Jugador jugador;

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public PresentacionCasoViewModel() {
        casoActual = SingletonDataDummy.getInstance().obtenerCasoAlAzar();
    }

    public String getNombreDetective() {
        return jugador.getNombre();
    }

    public void obtenerOtroCaso() {
    	this.casoActual = SingletonDataDummy.getInstance().obtenerCasoAlAzar();
    }

    public String getReporte() {
        return casoActual.getReporte();
    }

    public String getTitulo() {
        return casoActual.getTitulo();
    }

    public CasoAJugar getCasoAJugar() {
        CasoAJugar casoAJugar = new CasoAJugar();
        casoAJugar.setCaso(casoActual);
        casoAJugar.setJugador(jugador);
        jugador.setPaisActual(casoActual.getPaisOrigen());
        casoAJugar.getVillano().viajar();
        return casoAJugar;
    }
}
