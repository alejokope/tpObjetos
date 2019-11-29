package modelo;

import excepciones.NoEsPaisProximoException;

public class Jugador extends Persona{
    private Persona sospechoso;

    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    public void viajar(Pais paisHasta){
        if(this.paisActual.estanConectadoCon(paisHasta)){
            this.paisActual = paisHasta;
        }
        else{
            throw new NoEsPaisProximoException();
        }
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

    public boolean hayOrdenDeArresto() {
        return sospechoso != null;
    }
}
