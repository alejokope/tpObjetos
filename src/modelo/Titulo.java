package modelo;

public enum Titulo {
    TITULO1("titulo1"),
    TITULO2("titulo2"),
    TITULO3("titulo3"),
    TITULO4("titulo4"),
    TITULO5("titulo5"),
    TITULO6("titulo6"),
    TITULO7("titulo7"),
    TITULO8("titulo8"),
    TITULO9("titulo9");

    private String value;

    private Titulo(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
