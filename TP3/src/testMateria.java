import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testMateria {
	private Materias totalMaterias;

	@Before
	public void instancia(){
		Materia materia1 = new Materia(1,2);
		Materia materia2 = new Materia(2,3);
		Materia materia3 = new Materia(3,4);
		
		Materias  totalMaterias = new Materias();
		totalMaterias.agregarMateria(materia1);
		totalMaterias.agregarMateria(materia2);
		totalMaterias.agregarMateria(materia3);
	}
	
	@Test
	public void getMateriasTest() {
		assertEquals(totalMaterias,totalMaterias.getMaterias());
	}
	
	@Test(expected = NullPointerException.class)
	public void getMateriaInvalidaTest(){
		totalMaterias.getMateria(5);
	}
	
	@Test
	public void testTomarMateria(){
		Materia m = new Materia(2,3);
		
		assertEquals(totalMaterias.getMateria(1), m);
	}

}
