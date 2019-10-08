package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Jugador {
    private Caso caso;
    private Pais origen;
    private CarmenSanDiego carmenSanDiego;
    private Pais actual;
    private Scanner scanner = new Scanner(System.in);



    public Jugador(Caso caso) {
        this.caso = caso;
        this.origen = caso.getPaisOrigen();
        this.actual = caso.getPaisOrigen();

    }

    public void pedirPista(){

    }

    public void consultaDondeViajar(){
        for(int i = 0; i < this.actual.getConexiones().size(); i++){
            System.out.println(i + 1 + ": " + this.actual.getConexiones().get(i).getNombre());
        }

        int decision = scanner.nextInt();
        this.viajar(this.actual.getConexiones().get(decision - 1));
    }
    private void viajar(Pais pais){
        actual = pais;
    }
}
