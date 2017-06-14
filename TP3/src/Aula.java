import java.util.ArrayList;

public class Aula {
	ArrayList<Materia> materias;
	
	public Aula(){
		materias = new ArrayList<Materia>();
	}

	public void agregar(Materia materia){	//puede ir un if no se superpone....
		if (puedeAgregar(materia))
			materias.add(materia);
	}
	
	public boolean puedeAgregar(Materia materia){
		if (materias.isEmpty())
			return true;
		
		boolean ret = false;
		for(Materia m: materias)
			ret = ret || hayEspacioLibre(m, materia);
			
		return ret;
	}

	boolean hayEspacioLibre(Materia m, Materia materia){
		boolean condicionAnterior = materia.getInicio() < m.getInicio() && materia.getFin() <= m.getFin();
		boolean condicionPosterior = materia.getInicio() >= m.getFin() && materia.getFin() > m.getFin();
		
		return condicionAnterior || condicionPosterior;
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
		
		return materias;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		
		final Aula otra = (Aula) obj;
		boolean ret = true;
		for (int i = 0; i< otra.cantidadMaterias(); i++)
			ret = ret && this.getMateria(i).equals(otra.getMateria(i));
		
		return ret;
	}
	
	public static void main(String[] args) {
		Materia materia1 = new Materia(1,2);
		Materia materia2 = new Materia(2,3);
		Materia materia3 = new Materia(3,4);
		
		Aula totalMaterias = new Aula();
		totalMaterias.agregar(materia1);
		totalMaterias.agregar(materia2);
		totalMaterias.agregar(materia3);
		
		
		Materia mat1 = new Materia(1,2);
		Materia mat2 = new Materia(2,3);
		Materia mat3 = new Materia(3,4);
		Aula m = new Aula();
		m.agregar(mat1);
		m.agregar(mat2);
		m.agregar(mat3);
		
		System.out.println(totalMaterias.equals(m));
	}
}
