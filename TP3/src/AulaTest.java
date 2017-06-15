import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AulaTest {
	private Aula aula;

	@Before
	public void instancia(){
		Materia materia1 = new Materia(13,14);
		Materia materia2 = new Materia(14,15);
		Materia materia3 = new Materia(15,16);
		Materia materia4 = new Materia(16,18);
		
		aula = new Aula();
		aula.agregar(materia1);
		aula.agregar(materia2);
		aula.agregar(materia3);
		aula.agregar(materia4);
	}
	
	@Test
	public void puedeAgregarMateriaTest(){
		Aula aula = new Aula();
		
		assertTrue(aula.puedeAgregar(new Materia(9,1)));
	}
	
	@Test
	public void agregarMateriaSuperpuesta(){
		Aula aula = new Aula();
		
		aula.agregar(new Materia(9,1));
		aula.puedeAgregar(new Materia(9,1));
		assertEquals(false, aula.puedeAgregar(new Materia(9,1)));
	}
	
	@Test 
	public void materiaLibreAnterior(){
		Materia materia = new Materia(22,23);
	
		assertFalse(aula.seSuperpone(materia, new Materia(21,22)));
	}
	
	@Test
	public void materiaLibreDespues(){
		Materia materia = new Materia(22,23);
		
		assertFalse(aula.seSuperpone(materia, new Materia(23,24)));
	}
	
	@Test
	public void agregarMateriaEnArreglo(){
		boolean ret = true;
		ArrayList<Materia> materias = aula.getMaterias();
		Materia materia = new Materia(14,15);
		
		for(Materia m: materias)
			ret = ret && aula.seSuperpone(m, materia);
		
		assertFalse(ret);
	}
	
	@Test
	public void cantidadMaterias(){
		assertEquals(4,aula.cantidadMaterias());
	}
	
	@Test(expected = NullPointerException.class)
	public void getMateriaInvalidaTest(){
		aula.getMateria(5);
	}
	
	@Test
	public void getMateriasTest() {
		assertEquals(aula.materias, aula.getMaterias());
	}
	
	@Test
	public void tomarMateriaTest(){
		Materia m = new Materia(14,15);
		
		assertEquals(aula.getMateria(1), m);
	}
	
	@Test
	public void agregarSuperpuesta(){
		Materia materia = new Materia(17,18);
		
		assertEquals(false, aula.puedeAgregar(materia));
	}

}
