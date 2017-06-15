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
		ret.add(new Aula());
		
		for(Materia materias: ordenadas)
			buscarAulaPara(materias,ret);
		
		return ret;
	}
	
	void buscarAulaPara(Materia materia, ArrayList<Aula> aulas){
		for(Aula aula : aulas)
			if (aula.agregar(materia))
				break;
			else{
				aulas.add(new Aula());
				aulas.get(aulas.size()-1).agregar(materia);
				break;
			}
	}
	
}



