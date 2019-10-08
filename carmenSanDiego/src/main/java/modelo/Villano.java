package modelo;

import lombok.Getter;
import lombok.Setter;
import modelo.lugarinteres.LugarInteres;

import java.util.List;
@Setter
@Getter
public class Villano {
    private String nombre;
    private String sexo;
    private List<String> señasParticulares;
    private List<String> hobbies;
    //todo fijarse de poner un indice para indicar en que pais de la lista esta
    private Pais paisActual;
    private List<Pais> planEscape;

    public Pais getPaisActual() {
        return paisActual;
    }


    public Pais getPaisProximo(){
        for(int i = 0; i < planEscape.size(); i++){
            if(planEscape.get(i).equals(paisActual)){
                return planEscape.get(i+1);
            }
        }
        //TODO HACER EXCEPCION
        return null;
    }

    public void escaparProximoPais(){
        paisActual = getPaisProximo();
        paisActual.ingresoVillano(this);
    }
}
