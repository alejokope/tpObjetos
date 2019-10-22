package modelo;

import lombok.Getter;
import lombok.Setter;
import modelo.lugarinteres.LugarInteres;
import modelo.lugarinteres.Reporte;

import java.util.List;
@Getter
@Setter
public class Pais {
    private String nombre;
    private List<String> caracteristicas;
    private List<LugarInteres> lugaresInteres;
    //todo puede ser una lista de paises tambien
    private List<Pais> conexiones;
    private Objetos objeto;
    private Reporte reporte;


    public void ingresoVillano(Villano villano){
        for(LugarInteres lugarInteres : lugaresInteres){
            lugarInteres.setPasoVillano(true);
            lugarInteres.setVillano(villano);
        }
    }


}
