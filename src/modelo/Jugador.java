package modelo;

import excepciones.NoEsPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Jugador {
    private Caso caso;
    private Pais paisOrigen;
    private CarmenSanDiegoMaster carmenSanDiego;
    private Pais paisActual;
    private LugarInteres lugarInteresActual;
    private Persona sospechoso = new Persona();

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

	public void setCarmenSanDiego(CarmenSanDiegoMaster carmenSanDiego) {
		this.carmenSanDiego = carmenSanDiego;
	}

	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}

	public void setLugarInteresActual(LugarInteres lugarInteresActual) {
		this.lugarInteresActual = lugarInteresActual;
	}
	
	public Persona getSospechoso() {
		return sospechoso;
	}

	public void pedirOrdenDeArresto(Persona persona) {
		sospechoso = persona;
	}
	
    public void setPaisActual(Pais pais) {
        this.paisActual = pais;
    }

    public boolean esLaOrdenDeArrestoCorrecta(Persona villano){
        return sospechoso == villano;
    }

}