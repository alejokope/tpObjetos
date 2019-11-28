package modelo;

public enum Titulo {
    TITULO1("Collar de perlas"),
    TITULO2("Telas finas"),
    TITULO3("Orquidias chinas"),
    TITULO4("Medallas y trofeos"),
    TITULO5("Contrabando de organos"),
    TITULO6("Muñequitas suiza"),
    TITULO7("Llave egipcia"),
    TITULO8("Fuentes electricas"),
    TITULO9("Pic magico");
	
	//prueba

    private String value;

    private Titulo(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
