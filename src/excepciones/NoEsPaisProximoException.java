package excepciones;

public class NoEsPaisProximoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoEsPaisProximoException() {
		super("No es un pais proximo.");
	}
}
