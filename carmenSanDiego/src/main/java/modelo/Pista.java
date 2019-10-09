package modelo;


public class Pista {
    private String pista1;
    private String pista2;
    private String pistaExtra;
    
    public Pista() {
		
	}

    public Pista(String pista1, String pista2) {
        this.pista1 = pista1;
        this.pista2 = pista2;
    }
    public Pista(String pista1, String pista2, String pistaExtra) {
        this.pista1 = pista1;
        this.pista2 = pista2;
        this.pistaExtra = pistaExtra;
    }
    
	
	public String getPista1() {
		return pista1;
	}
	
	public String getPista2() {
		return pista2;
	}
	
	public String getPistaExtra() {
		return pistaExtra;
	}

}
