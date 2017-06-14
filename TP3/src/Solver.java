import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	private Instancia instancia;
	private Comparator<Materia> comparador;

	public Solver(Instancia Instancia, Comparator Comparador){
		instancia = Instancia;
		comparador = Comparador;
	}

	public ArrayList<Aula> resolver(){
		ArrayList<Materia> ordenadas = ordenarMaterias();
		return construirSolucion(ordenadas);
	}
	
	ArrayList<Materia> ordenarMaterias(){
		ArrayList<Materia> materias = instancia.getMaterias();
		Collections.sort(materias, comparador);
		
		return materias;
	}

	private ArrayList<Aula> construirSolucion(ArrayList<Materia> ordenadas){
		ArrayList<Aula> ret = new ArrayList<Aula>();
		for(Materia materias: ordenadas)
			buscarAulaPara(materias,ret);
		
		return ret;
	}
	
	private void buscarAulaPara(Materia materia, ArrayList<Aula> aulas){
		for(Aula aula : aulas)
			if (aula.puedeAgregar(materia)){
				aula.agregar(materia);
				break;
			} else{
				aulas.add(new Aula());
				aulas.get(aulas.size()-1).agregar(materia);
			}
	}
	
	public static void main(String[] args) {
		ArrayList<Materia> expected = new ArrayList<Materia>();
		
		expected.add(new Materia(9,10));
		expected.add(new Materia(7,9));
		expected.add(new Materia(3,5));
		expected.add(new Materia(0,3));
		Instancia instancia = new Instancia(expected);
		Solver solver = new Solver(instancia, Comparador.porMenosHoras());
		ArrayList<Materia> ordenado = solver.ordenarMaterias();
		
		for(Materia m : ordenado)
			System.out.println(m);
		
	}
	
}



