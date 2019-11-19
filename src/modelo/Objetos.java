package modelo;

public enum Objetos {
    OBJETO1("objeto1"),
    OBJETO2("objeto2"),
    OBJETO3("objeto3"),
    OBJETO4("objeto4"),
    OBJETO5("objeto5"),
    OBJETO6("objeto6"),
    OBJETO7("objeto7"),
    OBJETO8("objeto8"),
    OBJETO9("objeto9");

    private String value;

    private Objetos(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
