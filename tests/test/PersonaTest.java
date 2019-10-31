package test;

import modelo.Persona;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonaTest {

    @Test
    public void setNombre_seteoNombreAPersonaYObtengoNombreTambien(){
        Persona pepa = new Persona();
        String nombrePepa = "PepaPapa";

        pepa.setNombre(nombrePepa);

        assertEquals(pepa.getNombre(), nombrePepa);
    }

    @Test
    public void setSexo_seteoSexoAPersonaYObtengoSexoTambien(){
        Persona pepa = new Persona();
        String sexoPepa = "Femenino";

        pepa.setSexo(sexoPepa);

        assertEquals(pepa.getSexo(), sexoPepa);
    }
}
