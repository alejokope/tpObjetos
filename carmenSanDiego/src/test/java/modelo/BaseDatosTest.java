package modelo;

import org.junit.*;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class BaseDatosTest {

    private BaseDatos baseDatos;
    private ArrayList<Pais> paises;
    @Before
    public void init(){
        baseDatos = new BaseDatos();
        paises = baseDatos.obtenerListaPaises();
    }


    @Test
    public void generarCasosTest(){
        Pais paisOrigen  = baseDatos.obtenerPaisOrigen();
        ArrayList<Pais> caso = baseDatos.generarCasos(paisOrigen);

        assertEquals(caso.size(),7);
    }
    @Test
    public void obtenerListaPaisesTest(){
        ArrayList<Pais> lista = baseDatos.obtenerListaPaises();

        assertEquals(lista.size(),9);
    }






}
