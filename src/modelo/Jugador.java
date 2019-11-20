package modelo;

import excepciones.NoEsPaisProximoException;

import java.util.List;

public class Jugador extends Persona{
    private Caso caso;
    private Pais paisOrigen;
    private Persona sospechoso;
    private boolean fuePedida;

    public Jugador(Caso caso) {
        this.caso = caso;
        this.paisOrigen = caso.getPaisOrigen();
        fuePedida = false;
        this.paisActual = caso.getPaisOrigen();
    }
    
    public void viajar(Pais pais){
        if(estaEstePaisConectadoAMiPaisActual(paisActual.getConexiones(),pais)){
            this.paisActual = pais;
        }
        else{
            throw new NoEsPaisProximoException();
        }
    }


    public List<Pais> obtenerConexionesDeMiPaisActual() {
        return paisActual.getConexiones();
    }

	public Persona getSospechoso() {
		return sospechoso;
	}

    public boolean isFuePedida() {
        return fuePedida;
    }

    public void setFuePedida(boolean fuePedida) {
        this.fuePedida = fuePedida;
    }

    public void pedirOrdenDeArresto(Persona persona) {
        fuePedida = true;
		sospechoso = persona;
	}

    public boolean esLaOrdenDeArrestoCorrecta(Persona villano){
        return sospechoso == villano;
    }

}
