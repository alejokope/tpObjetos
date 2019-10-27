package modelo;


import java.util.ArrayList;
import java.util.List;

public class Ayuda {
    private List<String> pistas = new ArrayList<String>();
    
    public Ayuda() {
		
	}

    public Ayuda(List<String> pistas) {
        this.pistas = pistas;
    }

    public List<String> getPistas(){
    	return pistas;
	}
	
	public String getPista1() {
		return pistas.get(0);
	}
	
	public String getPista2() {
		return pistas.get(1);
	}
	
	public String getPistaExtra() {
		return pistas.get(2);
	}

	public void agregarUnaPista(String palabra){
    	pistas.add(palabra);
	}

	public void agregarDosPistas(String palabra1, String palabra2){
    	agregarUnaPista(palabra1);
		agregarUnaPista(palabra2);
	}

}
