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
		this.sospechoso = persona;
	}

    public boolean esLaOrdenDeArrestoCorrecta(Persona villano){
    	if(hayOrdenDeArresto()) {
    		return sospechoso.getNombre().equalsIgnoreCase(villano.getNombre());
    	}
    	else {
    		return false;
    	}
       
    }

    public boolean hayOrdenDeArresto() {
        return sospechoso != null;
    }
}
