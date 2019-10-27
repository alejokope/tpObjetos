package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Banco;
import modelo.lugarInteres.Biblioteca;
import modelo.lugarInteres.LugarInteres;

public class PaisTest {
	
	@Test
	public void ingresoVillano_IngresoElVillanoMonrroeAlPais() {
		Pais argentina = new Pais();
		Villano monrroe = new Villano();
		Banco banco = new Banco();
		Biblioteca biblioteca = new Biblioteca();
		List<LugarInteres> lugaresInteres = new ArrayList<LugarInteres>();
		
		lugaresInteres.add(banco);
		lugaresInteres.add(biblioteca);
		
		argentina.setLugaresInteres(lugaresInteres);		
		argentina.ingresoVillano(monrroe);
		
		assertEquals(monrroe, argentina.getLugaresInteres().get(0).getVillano());
	}
	
	@Test
	public void ingresoVillano_NoIngresoElVillanoMonrroeAlPais() {
		Pais argentina = new Pais();
		Villano monrroe = new Villano();
		Villano pepe = new Villano();
		Banco banco = new Banco();
		Biblioteca biblioteca = new Biblioteca();
		List<LugarInteres> lugaresInteres = new ArrayList<LugarInteres>();
		
		lugaresInteres.add(banco);
		lugaresInteres.add(biblioteca);
		
		argentina.setLugaresInteres(lugaresInteres);		
		argentina.ingresoVillano(pepe);
		
		assertFalse(argentina.getLugaresInteres().get(0).getVillano() == monrroe);
	}

}
