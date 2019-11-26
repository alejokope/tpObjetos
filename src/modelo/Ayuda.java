package modelo;

public class Ayuda {

	private String pista;

	public Ayuda (){

	}

	public Ayuda(String pista) {
		this.pista = pista;
	}

	public String darPistaMensaje(){
    	return pista;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}

	public String noPasoPorEstePaisMensaje() {
    	return "Lo siento, creo que se ha equivocado de \n" +
				"Ciudad, no hay nadie con esas caracteristicas";
	}

	public String mismoPaisMensaje() {
		return "CUIDADO DETECTIVE!! Ha estado a punto de \n" +
				"caer en una trampa... La persona que busca \n" +
				"esta en la ciudad!";
	}

	public String gameOverMensaje(Villano villano) {
		return "ALTO!!! Detengase: " + villano.getNombre();
	}

}
