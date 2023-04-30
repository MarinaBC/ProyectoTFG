package Otros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fichero {
	
	//Creo variables globales(Con los elementos de la base de datos)
	public static final List<Double> pregnancies  = new ArrayList<>();
	public static final List<Double> glucose = new ArrayList<>(); 
	public static final List<Double> bloodPressure = new ArrayList<>();
	public static final List<Double> skinThickness = new ArrayList<>();
	public static final List<Double> insulin = new ArrayList<>();
	public static final List<Double> BMI = new ArrayList<>();
	public static final List<Double> DiabetesPedigreeFunction = new ArrayList<>();
	public static final List<Double> Age = new ArrayList<>();
	public static final List<Double> Outcome = new ArrayList<>();

	
	public static void main(String[] args) {
		
		File fichero = new File("ficheros/ficheroEditado.txt");
		lecturaFichero(fichero);//Devuelve el fichero en listas Double
		System.out.println("La lista es de pregnancies es: " + pregnancies);
		System.out.println("La lista es de glucose es: " + glucose);
		System.out.println("La lista es de bloodPressure es: " + bloodPressure);
		System.out.println("La lista es de skinThickness es: " + skinThickness);
		System.out.println("La lista es de insulin es: " + insulin);
		System.out.println("La lista es de BMI es: " + BMI);
		System.out.println("La lista es de DiabetesPedigreeFunction es: " + DiabetesPedigreeFunction);
		System.out.println("La lista es de Age es: " + Age);
		System.out.println("La lista es de Outcome es: " + Outcome);
				
	}
	
	

	public static List<Double> lecturaFichero(File fichero) {
		List<Double> res = new ArrayList<>();
		// Fichero del que queremos leer
		
		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			//System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				String[] enterosArray = linea.split(",");
				
				int i = 0;
				List<String> lista = new ArrayList<String>();
				if(!(linea.length()==0)){
					while(i<enterosArray.length) {
						//System.out.print(enterosArray[i]);
						if(enterosArray[i] == null || enterosArray[i].isBlank()) {
							System.out.println("prueba");
							//Cambiar el blank o null a String "null" para la posterior conversion
							//a double
							enterosArray[i] = "null";
						}
						
						String enterosCadena = enterosArray[i];
						//Integer enteros = Integer.parseInt(enterosCadena);
						lista.add(enterosCadena);
						i += 1;
					}
				} else {
					//listaEnteros = emptyList();
				}
				
				//System.out.println(linea);      // Imprimimos la linea
				//System.out.println(lista);      // Imprimimos la linea
				//Convertimos los datos de la lista a double
				List<Double> nuevaL = conversionListaDouble(lista);
				//System.out.println(nuevaL);
				//inicializamos las variables globales
				pregnancies.add(nuevaL.get(0));
				glucose.add(nuevaL.get(1)); 
				bloodPressure.add(nuevaL.get(2));
				skinThickness.add(nuevaL.get(3));
				insulin.add(nuevaL.get(4));
				BMI.add(nuevaL.get(5));
				DiabetesPedigreeFunction.add(nuevaL.get(6));
				Age.add(nuevaL.get(7));
				Outcome.add(nuevaL.get(8));
				
				res = nuevaL;
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
					System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		return res;
	}

	public static List<Double> conversionListaDouble(List<String> lista) {
		List<Double> l = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).equals("null")) {
				//System.out.println(lista.get(i));
				l.add(null);
			}
			else {
				double d = Double.parseDouble(lista.get(i));
				l.add(d);
			}
			
		}
		return l;
	}

}
