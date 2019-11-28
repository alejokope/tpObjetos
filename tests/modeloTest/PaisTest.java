package modeloTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Banco;
import modelo.lugarInteres.Biblioteca;
import modelo.lugarInteres.LugarInteres;
import org.mockito.ArgumentCaptor;

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

	@Test
	public void agregarConexiones_agregoUnaListaDeConexionesAlPais(){
		Pais argentina = mock(Pais.class);
		Pais chile = mock(Pais.class);
		Pais uruguay = mock(Pais.class);
		Pais brasil = mock(Pais.class);
		List<Pais> paises = Arrays.asList(chile, uruguay, brasil);
		ArgumentCaptor valorACapturar = ArgumentCaptor.forClass(List.class);
		doNothing().when(argentina).agregarConexiones((List<Pais>) valorACapturar.capture());

		argentina.agregarConexiones(paises);

		assertEquals(paises, valorACapturar.getValue());

	}

	@Test
	public void agregarUnaConexion_agregoUnPaisAMisConexiones(){
		Pais argentina = mock(Pais.class);
		Pais chile = mock(Pais.class);
		ArgumentCaptor valorACapturar = ArgumentCaptor.forClass(List.class);
		doNothing().when(argentina).agregarUnaConexion((Pais) valorACapturar.capture());

		argentina.agregarUnaConexion(chile);

		assertEquals(chile, valorACapturar.getValue());

	}

	@Test
	public void enlazarConexiones_enlazoConexionesConMisConexionesYViceversa(){
		Pais argentina = mock(Pais.class);
		Pais chile = mock(Pais.class);
		Pais uruguay = mock(Pais.class);
		Pais brasil = mock(Pais.class);
		List<Pais> paises = Arrays.asList(chile, uruguay, brasil);
		ArgumentCaptor valorACapturar = ArgumentCaptor.forClass(List.class);
		doNothing().when(argentina).enlazarConexiones((List<Pais>) valorACapturar.capture());

		argentina.enlazarConexiones(paises);

		assertEquals(paises, valorACapturar.getValue());

	}

}
