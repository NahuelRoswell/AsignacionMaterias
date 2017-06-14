import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {
	private Instancia instancia;
	
	@Before
	public void construir(){
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias.add(new Materia(3,5));
		materias.add(new Materia(9,10));
		materias.add(new Materia(0,3));
		materias.add(new Materia(7,9));
		
		instancia = new Instancia(materias);
	}
	
	@Test
	public void ordenarMateriasTest() {
		Solver solver = new Solver(instancia, Comparador.porMenosHoras());
		ArrayList<Materia> expected = new ArrayList<Materia>();
		
		expected.add(new Materia(9,10));
		expected.add(new Materia(7,9));
		expected.add(new Materia(3,5));
		expected.add(new Materia(0,3));
		
		assertEquals(expected, solver.ordenarMaterias());
	}

}
