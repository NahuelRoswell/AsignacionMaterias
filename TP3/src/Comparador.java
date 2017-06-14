import java.util.Comparator;

public class Comparador {

	public static Comparator<Materia> porMenosHoras() {
		Comparator<Materia> ret = new Comparator<Materia>() {
			@Override
			public int compare(Materia uno, Materia otro) {
				return (int) (uno.getCantidadHoras() - otro.getCantidadHoras());
			}
		};
		return ret;
	}
	
	public static Comparator<Materia> porMayorHoras(){
		Comparator<Materia> ret = new Comparator<Materia>(){
			@Override
			public int compare(Materia uno, Materia otro){
				return (int) (otro.getCantidadHoras() - uno.getCantidadHoras());
			}
		};
		return ret;
	}
	

}
