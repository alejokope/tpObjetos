package modelo;

import java.util.Scanner;

import excepciones.NoEsPaisProximoException;
import modelo.lugarInteres.LugarInteres;

public class Jugador {
    private Caso caso;
    private Pais origen;
    private CarmenSanDiego carmenSanDiego;
    private Pais paisActual;
    private LugarInteres lugarInteresActual;
    private Scanner scanner = new Scanner(System.in);
    private OrdenDeArresto ordenDeArresto;

    public Jugador(Caso caso) {
        this.caso = caso;
        this.origen = caso.getPaisOrigen();
        this.paisActual = caso.getPaisOrigen();
    }

    public void pedirPista(){

    }

    public void consultaDondeViajar(){
        for(int i = 0; i < this.paisActual.getConexiones().size(); i++){
            System.out.println(i + 1 + ": " + this.paisActual.getConexiones().get(i).getNombre());
        }

        int decision = scanner.nextInt();
        this.viajar(this.paisActual.getConexiones().get(decision - 1));
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

    public void setOrdenDeArresto(OrdenDeArresto ordenDeArresto) {
        this.ordenDeArresto = ordenDeArresto;
    }

    public void setPaisActual(Pais pais) {
        this.paisActual = pais;
    }
}
