import java.util.ArrayList;

public class Instancia {
	private ArrayList<Materia> materias;
	
	public Instancia(ArrayList<Materia> Materias){
		materias = Materias;
	}

	public ArrayList<Materia> getMaterias() {
		ArrayList<Materia> ret = new ArrayList<Materia>();
		for(Materia m : materias)
			ret.add(m);
		
		return null;
	}
	
	public Materia getMateria(int indice){
		if (indice < 0 || indice > tamaño())
			throw new IllegalArgumentException("El indice es inválido! ìndice = " +indice);
		
		return materias.get(indice);
	}
	
	public int tamaño(){
		return materias.size();
	}
	
}
