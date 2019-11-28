package modeloTest;

import modelo.Villano;
import modelo.lugarInteres.Biblioteca;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void setVillano_seteoVillanoYObtengoUnVillanoTambien(){
        Biblioteca biblioteca = new Biblioteca();
        Villano villano = new Villano();

        biblioteca.setVillano(villano);

        assertEquals(biblioteca.getVillano(), villano);
    }

    @Test
    public void informacion_obtengoElNombreDeEsteLugar(){
        Biblioteca biblioteca = new Biblioteca();

        String informacion = "BIBLIOTECA";

        assertEquals(biblioteca.informacion(), informacion);
    }

    @Test
    public void setPasoVillano_elVillanoPasoPorLaBibliotecaEntoncesEstoCambiaATrue(){
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.setPasoVillano(true);

        assertTrue(biblioteca.getPasoVillano());
    }

}
