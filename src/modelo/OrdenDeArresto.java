package modelo;

public class OrdenDeArresto {
	private Persona sospechoso;
	
	public Persona getSospechoso() {
		return sospechoso;
	}

	public void emitirOrdenDeArresto(Persona sospechoso) {
		this.sospechoso = sospechoso;
	}
}
