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
		
		aula = new Aula();
		aula.agregar(materia1);
		aula.agregar(materia2);
		aula.agregar(materia3);
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
		
		assertFalse(aula.puedeAgregar(new Materia(9,1)));
	}
	
	@Test 
	public void materiaLibreAnterior(){
		Materia materia = new Materia(22,23);
	
		assertTrue(aula.hayEspacioLibre(materia, new Materia(21,22)));
	}
	
	@Test
	public void materiaLibreDespues(){
		Materia materia = new Materia(22,23);
		
		assertTrue(aula.hayEspacioLibre(materia, new Materia(23,24)));
	}
	
	@Test
	public void agregarMateriaEnArreglo(){
		boolean ret = true;
		ArrayList<Materia> materias = aula.getMaterias();
		Materia materia = new Materia(14,15);
		
		for(Materia m: materias)
			ret = ret && aula.hayEspacioLibre(m, materia);
		
		assertFalse(ret);
	}
	
	@Test
	public void cantidadMaterias(){
		assertEquals(3,aula.cantidadMaterias());
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

}
