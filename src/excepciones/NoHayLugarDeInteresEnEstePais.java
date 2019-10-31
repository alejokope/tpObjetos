package excepciones;

public class NoHayLugarDeInteresEnEstePais extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NoHayLugarDeInteresEnEstePais() {
        super("No existe este lugar de interes en este pais.");
    }
}
