import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {
	private Instancia instancia;
	private ArrayList<Materia> materias;
	private Solver solver;
	@Before
	public void construir(){
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias.add(new Materia(3,6));
		materias.add(new Materia(9,10));
		materias.add(new Materia(0,3));
		materias.add(new Materia(7,9));
		
		instancia = new Instancia(materias);
		this.materias = materias;
		solver = new Solver(instancia, Comparador.porMenosHoras());
	}
	
	@Test
	public void ordenarMateriasTest() {
		ArrayList<Materia> expected = new ArrayList<Materia>();
		
		expected.add(new Materia(9,10));
		expected.add(new Materia(7,9));
		expected.add(new Materia(3,6));
		expected.add(new Materia(0,3));
		
		assertEquals(expected, solver.ordenarMaterias());
	}
	
	@Test
	public void buscarAulaTest(){
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		Aula aula= new Aula();
		for (Materia materia : materias)
			aula.agregar(materia);
		
		aulas.add(aula);
		Materia m = new Materia(3,6);

		solver.buscarAulaPara(m, aulas);
		assertEquals(2,aulas.size());
	}

}
