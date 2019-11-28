package modelo;

import excepciones.NoEsPaisProximoException;

import java.util.List;

public class Jugador extends Persona{
    private Caso caso;
    private Pais paisOrigen;
    private Persona sospechoso;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public Jugador(Caso caso) {
        this.caso = caso;
        this.paisOrigen = caso.getPaisOrigen();
        this.paisActual = caso.getPaisOrigen();
    }
    
    public void viajar(Pais pais){
        if(estaEstePaisConectadoAMiPaisActual(pais)){
            this.paisActual = pais;
            pais.setPasoElJugador(true);
        }
        else{
            throw new NoEsPaisProximoException();
        }
    }
    
    public boolean esPaisFallido() {
    	return paisActual.estoyFallido();
    }

    public boolean estaEstePaisConectadoAMiPaisActual(Pais pais) {
        return obtenerConexionesDeMiPaisActual().contains(pais);
    }

    public List<Pais> obtenerConexionesDeMiPaisActual() {
        return paisActual.getConexiones();
    }

	public Persona getSospechoso() {
		return sospechoso;
	}

	public void pedirOrdenDeArresto(Persona persona) {
		sospechoso = persona;
	}

    public boolean esLaOrdenDeArrestoCorrecta(Persona villano){
        return sospechoso == villano;
    }

    public void asignarPaisDelCaso(Caso caso) {
        this.paisOrigen = caso.getPaisOrigen();
        this.paisActual = caso.getPaisOrigen();
    }
}