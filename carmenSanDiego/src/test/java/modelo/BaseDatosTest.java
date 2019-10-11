package modelo;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaseDatosTest {

    private BaseDatos baseDatos;
    private ArrayList<Pais> paises;
    @Before
    public void init(){
        baseDatos = new BaseDatos();
    }

    @Test
    public void obtenerCasoAlAzarTest(){
        Caso caso1 = baseDatos.obtenerCasoAlAzar();
        Caso caso2 = baseDatos.obtenerCasoAlAzar();

        assertFalse(compararPlanEscape(caso1.getPlanEscape(),caso2.getPlanEscape()));
        assertFalse(compararReporte(caso1.getReporte(),caso2.getReporte()));
        assertFalse(compararVillano(caso1.getResponsable(),caso2.getResponsable()));
        assertFalse(compararPaisOrigen(caso1.getPaisOrigen(),caso2.getPaisOrigen()));
        assertFalse(compararObjeto(caso1.getObjeto(),caso2.getObjeto()));
        assertFalse(compararCaso(caso1,caso2));
    }
    private boolean compararCaso(Caso caso1, Caso caso2){
        return compararObjeto(caso1.getObjeto(),caso2.getObjeto())
                && compararPaisOrigen(caso1.getPaisOrigen(),caso2.getPaisOrigen())
                && compararVillano(caso1.getResponsable(),caso2.getResponsable())
                && compararReporte(caso1.getReporte(),caso2.getReporte())
                && compararPlanEscape(caso1.getPlanEscape(),caso2.getPlanEscape());
    }
    private boolean compararObjeto(String nombre1, String nombre2){
        return nombre1.equals(nombre2);
    }
    private boolean compararVillano(Villano villano1, Villano villano2){
        return villano1.equals(villano2);
    }
    private boolean compararReporte(String reporte1, String reporte2){
        return reporte1.equals(reporte2);
    }
    private boolean compararPaisOrigen(Pais paisOrigen1, Pais paisOrigen2){
        return paisOrigen1.equals(paisOrigen2);
    }
    private boolean compararPlanEscape(List<Pais> planEscape1, List<Pais> planEscape2){
        for(int i = 0; i < planEscape1.size(); i++){
            if(!planEscape1.get(i).equals(planEscape2.get(i))){
                return false;
            }
        }
        return true;
    }
}
