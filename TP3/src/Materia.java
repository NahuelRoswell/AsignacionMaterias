
public class Materia {
	private int inicio;
	private int fin;
	
	public Materia(int Inicio, int Fin){
		inicio = Inicio;
		fin = Fin;
	}

	public int getCantidadHoras(){
		return fin-inicio;
	}

	public int getInicio() {
		return inicio;
	}

	public int getFin() {
		return fin;
	}
	
	@Override
	public String toString(){
		return "[" +inicio +"-" +fin +"] ";
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass()) 
			return false;
		
		final Materia otra = (Materia) obj;
		if (inicio != otra.getInicio()) 
			return false;
		if (fin != otra.getFin())
			return false;

		return true;
	}
}
