package excepciones;

public class NoHayPaisProximoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoHayPaisProximoException() {
		super("No hay un pais proximo.");
	}
}