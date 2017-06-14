import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Instancia {
	private ArrayList<Materia> materias;
	
	public Instancia(ArrayList<Materia> Materias){
		materias = Materias;
	}

	public ArrayList<Materia> getMaterias() {
		ArrayList<Materia> ret = new ArrayList<Materia>();
		for(Materia m : materias)
			ret.add(m);
		
		return ret;
	}
	
	public Materia getMateria(int indice){
		if (indice < 0 || indice > tamaño())
			throw new IllegalArgumentException("El indice es inválido! ìndice = " +indice);
		
		return materias.get(indice);
	}
	
	public int tamaño(){
		return materias.size();
	}
	
	void generarJSON(String archivo){
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String json = gson.toJson(this);
		
		 try{
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		}
		 
		 catch(Exception e) { 
			 throw new IllegalArgumentException("Se intento guardar un archivo nulo. Nombre del archivo: "+archivo);}
		 }

	static ArrayList<Materia> leerJSON(String archivo) {
		Gson gson = new Gson();
		ArrayList<Materia> ret = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, Instancia.class);
		}

		catch (Exception e) {
			throw new IllegalArgumentException("Se ingreso un archivo nulo. Nombre del archivo: " + archivo);
		}

		return ret;
	}

}
