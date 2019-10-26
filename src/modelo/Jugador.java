package modelo;

import java.util.Scanner;

import excepciones.NoEsPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Jugador {
    private Caso caso;
    private Pais paisOrigen;
    private CarmenSanDiego carmenSanDiego;
    private Pais paisActual;
    private LugarInteres lugarInteresActual;
    private Scanner scanner = new Scanner(System.in);
    private OrdenDeArresto ordenDeArresto = new OrdenDeArresto();

    public Jugador(Caso caso) {
        this.caso = caso;
        this.paisOrigen = caso.getPaisOrigen();
        this.paisActual = caso.getPaisOrigen();
    }

    public void pedirPista(){

    }

    public String consultaDondeViajar(){
    	String destinosPosibles = "";
    	
        for(int i = 0; i < this.paisActual.getConexiones().size(); i++){
            destinosPosibles = destinosPosibles + (i + 1 + ": " + this.paisActual.getConexiones().get(i).getNombre() + '\n');
        }
        
        //No se entiendo que hace esto pero me congela el test asi que lo comento
        /*int decision = scanner.nextInt();
        this.viajar(this.paisActual.getConexiones().get(decision - 1));*/
        
        return destinosPosibles;
    }
    
    public void viajar(Pais pais){
        if(paisActual.getConexiones().contains(pais)){
            this.paisActual = pais;
        }
        else{
            throw new NoEsPaisProximoException();
        }
    }

	public Pais getPaisActual() {
		return paisActual;
	}

	public void setCarmenSanDiego(CarmenSanDiego carmenSanDiego) {
		this.carmenSanDiego = carmenSanDiego;
	}

	public LugarInteres getLugarInteresActual() {
		return lugarInteresActual;
	}

	public void setLugarInteresActual(LugarInteres lugarInteresActual) {
		this.lugarInteresActual = lugarInteresActual;
	}
	
	public OrdenDeArresto getOrdenDeArresto() {
		return ordenDeArresto;
	}

	public void pedirOrdenDeArresto(Persona sospechoso) {
		ordenDeArresto.emitirOrdenDeArresto(sospechoso);
	}

    public void setPaisActual(Pais pais) {
        this.paisActual = pais;
    }
}
