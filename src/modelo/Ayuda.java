package modelo;

public class Ayuda {

	public String gameOverMensaje(Villano villano) {
		return "ALTO!!! Detengase: " + villano.getNombre();
	}

	public String mismoPaisMensaje() {
		return "CUIDADO DETECTIVE!! Ha estado a punto de \n" +
				"caer en una trampa... La persona que busca \n" +
				"esta en la ciudad!";
	}

	public String pasoPorElPais(String loQueSea) {
		return loQueSea;
	}

	public String noPasoPorEstePaisMensaje() {
    	return "Lo siento, creo que se ha equivocado de \n" +
				"Ciudad, no hay nadie con esas caracteristicas";
	}

}
