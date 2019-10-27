package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import excepciones.NoHayPaisProximoException;
import modelo.Pais;
import modelo.Villano;
import modelo.lugarInteres.Banco;
import modelo.lugarInteres.Biblioteca;
import modelo.lugarInteres.LugarInteres;

public class VillanoTest {

	@Test
	public void getPaisProximo_ElVillanoObtieneElPaisProximoSegunElPlanDeEscape() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);
		
		villano.setPaisActual(argentina);
		villano.setPlanEscape(planDeEscape);
		
		assertEquals(brasil, villano.getPaisProximo());
	}
	
	@Test(expected = NoHayPaisProximoException.class)
	public void getPaisProximo_ElVillanoNoTieneUnPaisProximoSegunElPlanDeEscape() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);
		
		villano.setPaisActual(chile);
		villano.setPlanEscape(planDeEscape);
		
		villano.getPaisProximo();
	}
	
	@Test
	public void escaparProximoPais_ElVillanoEscapaAlProximoPais() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		Banco banco = new Banco();
		Biblioteca biblioteca = new Biblioteca();
		List<LugarInteres> lugaresInteres = new ArrayList<LugarInteres>();
				
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);

		
		lugaresInteres.add(banco);
		lugaresInteres.add(biblioteca);
		
		brasil.setLugaresInteres(lugaresInteres);
		
		villano.setPaisActual(argentina);
		villano.setPlanEscape(planDeEscape);
		villano.escaparProximoPais();
		
		assertEquals(brasil, villano.getPaisActual());
	}
	
	@Test(expected = NoHayPaisProximoException.class)
	public void escaparProximoPais_ElVillanoNoAPodidoEscapaAUnProximoPais() {
		Villano villano = new Villano();
		List<Pais> planDeEscape = new ArrayList<Pais>();
		Pais argentina = new Pais();
		Pais chile = new Pais();
		Pais brasil = new Pais();
		
		planDeEscape.add(argentina);
		planDeEscape.add(brasil);
		planDeEscape.add(chile);
		
		villano.setPaisActual(chile);
		villano.setPlanEscape(planDeEscape);
		villano.escaparProximoPais();
	}
}
