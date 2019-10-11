package modelo.lugarinteres;

public enum Reporte {
    REPORTE1("reporte1"),
    REPORTE2("reporte2"),
    REPORTE3("reporte3"),
    REPORTE4("reporte4"),
    REPORTE5("reporte5"),
    REPORTE6("reporte6"),
    REPORTE7("reporte7"),
    REPORTE8("reporte8"),
    REPORTE9("reporte9");

    private String value;

    private Reporte(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
