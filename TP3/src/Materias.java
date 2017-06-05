import java.util.ArrayList;

public class Materias {
	private ArrayList<Materia> materias;
	
	public Materias(){
		materias = new ArrayList<Materia>();
	}

	public void agregarMateria(Materia materia){	
		materias.add(materia);
	}

	public int cantidadMaterias(){
		return materias.size();
	}

	public Materia getMateria(int indice){
		if (indice < 0 || indice > cantidadMaterias()-1)
			throw new NullPointerException("el indice ingresado es incorrecto! indice = "+indice);
		
		return materias.get(indice);
	}

	public ArrayList<Materia> getMaterias(){
		ArrayList<Materia> auxiliar = new ArrayList<Materia>();
		for (Materia m : materias)
			auxiliar.add(m);
		
		return auxiliar;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		
		final Materias otra = (Materias) obj;
		boolean ret = true;
		for (int i = 0; i< otra.cantidadMaterias(); i++)
			ret = ret && this.getMateria(i).equals(otra.getMateria(i));
		
		return ret;
	}
}
