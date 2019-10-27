package modelo;

import excepciones.NoEsPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Jugador {
    private Caso caso;
    private Pais paisOrigen;
    private CarmenSanDiego carmenSanDiego;
    private Pais paisActual;
    private LugarInteres lugarInteresActual;
    private OrdenDeArresto ordenDeArresto = new OrdenDeArresto();

    public Jugador(Caso caso) {
        this.caso = caso;
        this.paisOrigen = caso.getPaisOrigen();
        this.paisActual = caso.getPaisOrigen();
    }
    
    public void viajar(Pais pais){
        if(estaEstePaisConectadoAMiPaisActual(pais)){
            this.paisActual = pais;
        }
        else{
            throw new NoEsPaisProximoException();
        }
    }

    public boolean estaEstePaisConectadoAMiPaisActual(Pais pais) {
        return paisActual.getConexiones().contains(pais);
    }

    public Pais getPaisActual() {
		return paisActual;
	}

	public void setCarmenSanDiego(CarmenSanDiego carmenSanDiego) {
		this.carmenSanDiego = carmenSanDiego;
	}

	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}

	public void setLugarInteresActual(LugarInteres lugarInteresActual) {
		this.lugarInteresActual = lugarInteresActual;
	}
	
	public OrdenDeArresto getOrdenDeArresto() {
		return ordenDeArresto;
	}

	public void pedirOrdenDeArresto(Persona sospechoso) {
		ordenDeArresto.emitirOrdenDeArresto(sospechoso);
	}

    public void setPaisActual(Pais pais) {
        this.paisActual = pais;
    }

    public boolean esLaOrdenDeArrestoCorrecta(Villano villano){
        return ordenDeArresto.getSospechoso() == villano;
    }
}
