package Otros;

import java.util.ArrayList;
import java.util.List;

import Imputacion_Simple.LeerFichero;

public class MediaAritmeticaValoresNull {

	public static void main(String[] args) {
		// 
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(null);
		list.add(4);
		//System.out.println(generarListaConMediaConValorNull(list));
		//System.out.println("//////////////////////////////////////////////////////////");
		List<Double> listaDouble = new ArrayList<>();
		listaDouble.add(2.1);
		listaDouble.add(3.2);
		listaDouble.add(null);
		listaDouble.add(4.3);
		//System.out.println(generarListaDConMediaConValorNull(listaDouble));
		//
		LeerFichero.main(args);//IMPORTANTE 
		System.out.println("\n");
		long startTime = System.nanoTime();
		
		System.out.println("La lista es de pregnancies es:");
		System.out.println(LeerFichero.pregnancies);
		System.out.println("////");
		System.out.println("La lista es de glucose es: ");
		System.out.println(LeerFichero.glucose);
		System.out.println("////");
				//System.out.println("La lista es de bloodPressure es: " + bloodPressure + "\n");
				//System.out.println("La lista es de skinThickness es: " + skinThickness + "\n");
				//System.out.println("La lista es de insulin es: " + insulin + "\n");
				//System.out.println("La lista es de BMI es: " + BMI + "\n");
				//System.out.println("La lista es de DiabetesPedigreeFunction es: " + DiabetesPedigreeFunction + "\n");
				//System.out.println("La lista es de Age es: " + Age + "\n");
				//System.out.println("La lista es de Outcome es: " + Outcome + "\n");
		
		
		for(int i = 0; i<LeerFichero.pregnancies.size();i++) {
			if(LeerFichero.pregnancies.contains(0.0)) {
				generarListaDConMediaConValorNull(LeerFichero.pregnancies);
			}
		}
		for(int i = 0; i<LeerFichero.glucose.size();i++) {
			if(LeerFichero.glucose.contains(0.0)) {
				generarListaDConMediaConValorNull(LeerFichero.glucose);
			}
		}
		System.out.println(LeerFichero.pregnancies);
		System.out.println("////");
		System.out.println(LeerFichero.glucose);
		System.out.println("////");
		long endTime = System.nanoTime();
		System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
		
	}
	
	public static List<Integer> generarListaConMediaConValorNull(List<Integer> ls) {
		Integer res = 0;
		for(int i = 0; i<ls.size(); i++) {
			if(ls.get(i) == null) {
				System.out.println("La lista inicial es: " + ls);
				ls.remove(null);
				//Aqui iria una llamada a funcion donde se hace la media y se devuelve el valor
				//que luego se añade en la posicion de la lista.
				Double d = MediaAritmetica.mediaAritmeticaListaEntera(ls);
				System.out.println("El valor a añadir, a traves de la media aritmetica es: " + d);
				res = d.intValue();
				ls.add(i, res);
				//System.out.println(ls);
				break;
			}
		}
		System.out.print("La nueva lista es: ");
		return ls;
	}
	
	
	public static List<Double> generarListaDConMediaConValorNull(List<Double> ls) {
		List<Integer> indices = new ArrayList<>();
		for(int i = 0; i<ls.size(); i++) {
			if(ls.get(i) == null) {
				//System.out.println("La lista inicial es: " + ls);
				ls.remove(null);
				//Aqui iria una llamada a funcion donde se hace la media y se devuelve el valor
				//que luego se añade en la posicion de la lista.
				Double d = MediaAritmetica.mediaAritmeticaListaDouble(ls);
				System.out.println("El valor a añadir, a traves de la media aritmetica es: " + d);
				ls.add(i, d);
				//System.out.println(ls);
				break;
			}
			//Si es 0
			else if(ls.get(i) == 0.0) {
				//System.out.println("La lista inicial es: " + ls);
				ls.remove(i);
				
				indices.add(i);//Me guarda los indices;
				
				//CAMBIARLOO
				
				//Aqui iria una llamada a funcion donde se hace la media y se devuelve el valor
				//que luego se añade en la posicion de la lista.
				Double d = MediaAritmetica.mediaAritmeticaListaDouble(ls);
				//System.out.println("El valor a añadir, a traves de la media aritmetica es: " + d);
				ls.add(i, d);
				//System.out.println(ls);
				break;
			}
		}
		System.out.println(indices);
		//System.out.print("La nueva lista es: ");
		return ls;
	}

	

}
