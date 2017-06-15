import java.util.ArrayList;

public class Aula {
	ArrayList<Materia> materias;
	
	public Aula(){
		materias = new ArrayList<Materia>();
	}

	public boolean agregar(Materia materia){	//puede ir un if no se superpone....
		if (puedeAgregar(materia)){
			materias.add(materia);
			return true;
		}
		return false;
	}
	
	boolean puedeAgregar(Materia materia){
		if (materias.isEmpty())
			return true;
		
		boolean ret = true;
		for(Materia m: materias)
			ret = ret && !seSuperpone(m, materia);
			
		return ret;
	}

	boolean seSuperpone(Materia materiaFija, Materia otra){
		boolean condicionAnterior = otra.getInicio() >= materiaFija.getInicio() && otra.getInicio() < materiaFija.getFin();
		boolean condicionPosterior = otra.getFin() > materiaFija.getInicio() && otra.getFin() <= materiaFija.getFin();
		boolean mismoInicio = otra.getInicio() == materiaFija.getInicio();
		boolean mismoFin = otra.getFin() == materiaFija.getFin();
		
		return condicionAnterior || condicionPosterior || mismoInicio || mismoFin;
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
	
	
	//borrar
	public void print(){
		for(Materia m : materias){
			System.out.println(m);
		}
	}
	
	
}
