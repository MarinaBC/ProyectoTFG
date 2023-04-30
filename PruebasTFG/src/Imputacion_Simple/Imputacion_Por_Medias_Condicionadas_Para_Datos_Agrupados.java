package Imputacion_Simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Imputacion_Por_Medias_Condicionadas_Para_Datos_Agrupados {
	
	
	
	public static void main (String [] args) {
		
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		
		System.out.println("-La lista es de pregnancies es:");
		List<Double> r1 = new ArrayList<>(cambiarNull(LeerFichero.pregnancies));
		System.out.println("Lista original: " + r1);
        double media1 = calcularMedia(r1);
        System.out.println("Media: " + media1);
        List<Double> l_pregnancies = completarLista(r1, media1);
        System.out.println("Lista completa: " + l_pregnancies);
        System.out.println("\n");
        
        
        //glucose
        System.out.println("-La lista es de glucose es:");
		List<Double> r2 = new ArrayList<>(cambiarNull(LeerFichero.glucose));
		System.out.println("Lista original: " + r2);
        double media2 = calcularMedia(r2);
        System.out.println("Media: " + media2);
        List<Double> l_glucose = completarLista(r2, media2);
        System.out.println("Lista completa: " + l_glucose);
        System.out.println("\n");
        
        
        
        //bloodPressure
        System.out.println("-La lista es de bloodPressure es:");
		List<Double> r3 = new ArrayList<>(cambiarNull(LeerFichero.bloodPressure));
		System.out.println("Lista original: " + r3);
        double media3 = calcularMedia(r3);
        System.out.println("Media: " + media3);
        List<Double> l_bloodPressure = completarLista(r3, media3);
        System.out.println("Lista completa: " + l_bloodPressure);
        System.out.println("\n");

        
        
        
        //skinThickness
        System.out.println("-La lista es de skinThickness es:");
		List<Double> r4 = new ArrayList<>(cambiarNull(LeerFichero.skinThickness));
		System.out.println("Lista original: " + r4);
        double media4 = calcularMedia(r4);
        System.out.println("Media: " + media4);
        List<Double> l_skinThickness = completarLista(r4, media4);
        System.out.println("Lista completa: " + l_skinThickness);
        System.out.println("\n");

        
        
        
        //insulin
        System.out.println("-La lista es de insulin es:");
		List<Double> r5 = new ArrayList<>(cambiarNull(LeerFichero.insulin));
		System.out.println("Lista original: " + r5);
        double media5 = calcularMedia(r5);
        System.out.println("Media: " + media5);
        List<Double> l_insulin = completarLista(r5, media5);
        System.out.println("Lista completa: " + l_insulin);
        System.out.println("\n");

        
        
        
        //BMI
        System.out.println("-La lista es de BMI es:");
		List<Double> r6 = new ArrayList<>(cambiarNull(LeerFichero.BMI));
		System.out.println("Lista original: " + r6);
        double media6 = calcularMedia(r6);
        System.out.println("Media: " + media6);
        List<Double> l_BMI = completarLista(r6, media6);
        System.out.println("Lista completa: " + l_BMI);
        System.out.println("\n");
        
        
        
        //DiabetesPedigreeFunction
        System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r7 = new ArrayList<>(cambiarNull(LeerFichero.DiabetesPedigreeFunction));
		System.out.println("Lista original: " + r7);
        double media7 = calcularMedia(r7);
        System.out.println("Media: " + media7);
        List<Double> l_DiabetesPedigreeFunction = completarLista(r7, media7);
        System.out.println("Lista completa: " + l_DiabetesPedigreeFunction);
        System.out.println("\n");

        
        
        
        //Age
        System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r8 = new ArrayList<>(cambiarNull(LeerFichero.Age));
		System.out.println("Lista original: " + r8);
        double media8 = calcularMedia(r8);
        System.out.println("Media: " + media8);
        List<Double> l_Age = completarLista(r8, media8);
        System.out.println("Lista completa: " + l_Age);
        System.out.println("\n");
        
        long endTime = System.nanoTime();
		System.out.println("Duracion: " + (endTime - startTime)/1e6 + " ms");
		
System.out.println("\n");
		
		double media_Diabetes_Predic = calcularMedia2(LeerFichero.DiabetesPedigreeFunction);
		System.out.println("-La lista es de Outcome es:");
		System.out.println(LeerFichero.Outcome);
		List<Double> l_Outcome = new ArrayList<>(LeerFichero.Outcome);
		
		//
		List<Double> padece = new ArrayList<>(pacedeDiabetes(l_pregnancies, l_glucose, l_bloodPressure, 
				l_skinThickness, l_insulin, l_BMI, l_DiabetesPedigreeFunction, l_Age, l_Outcome,
				media_Diabetes_Predic));
		
		System.out.println(padece);
		
		// Comparar las listas
        if (l_Outcome.equals(padece)) {
            System.out.println("Las listas son iguales");
        } else {
            System.out.println("Las listas son diferentes");
            for (int i = 0; i < l_Outcome.size(); i++) {
                if (!l_Outcome.get(i).equals(padece.get(i))) {
                    System.out.println("La posición en la que cambia es: " + i);
                }
            }
        }
        
		
	}
	
	public static List<Double> cambiarNull(List<Double> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == 0) {
                lista.set(i, null);
            }
        }
        return lista;
    }

	    
	// Calcula la media de los elementos no nulos de la lista
	public static double calcularMedia(List<Double> lista) {
		double suma = 0.0;
	    int contador = 0;
	    for (Double valor : lista) {
	    	if (valor != null) {
	                suma += valor;
	                contador++;
	            }
	        }
	        return suma / contador;
	    }

	    // Completa la lista con los valores obtenidos mediante la técnica de medias condicionadas
	    public static List<Double> completarLista(List<Double> lista, double media) {
	        List<Double> listaCompleta = new ArrayList<>();
	        double suma = 0.0;
	        int contador = 0;
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i) == null) {
	                if (i > 0 && lista.get(i - 1) != null) {
	                    suma += lista.get(i - 1);
	                    contador++;
	                }
	                if (i < lista.size() - 1 && lista.get(i + 1) != null) {
	                    suma += lista.get(i + 1);
	                    contador++;
	                }
	                double valor = suma / contador;
	                if (Double.isNaN(valor)) {
	                    valor = media;
	                }
	                listaCompleta.add(valor);
	                suma = 0.0;
	                contador = 0;
	            } else {
	                listaCompleta.add(lista.get(i));
	            }
	        }
	        return listaCompleta;
	    }
	    
	    
	    public static double calcularMedia2(List<Double> datos) {
	        double suma = 0.0;
	        int cont = 0;
	        for (double dato : datos) {
	            if (dato != 0.0) {
	                suma += dato;
	                cont++;
	            }
	        }
	        return suma / cont;
	    }
		
		
		
		private static List<Double> pacedeDiabetes(List<Double> l_pregnancies, List<Double> l_glucose,
				List<Double> l_bloodPressure, List<Double> l_skinThickness, List<Double> l_insulin, 
				List<Double> l_BMI, List<Double> l_DiabetesPedigreeFunction, List<Double> l_Age, 
				List<Double> l_Outcome, double media_Diabetes_Predic) {
			// 
			for(int i=0; i<l_pregnancies.size(); i++) {
				Double d_l_pregnancies = l_pregnancies.get(i);
				Double d_l_glucose = l_glucose.get(i);
				Double d_l_bloodPressure = l_bloodPressure.get(i);
				Double d_l_skinThickness = l_skinThickness.get(i);
				Double d_l_insulin = l_insulin.get(i);
				Double d_l_BMI = l_BMI.get(i);
				Double d_l_DiabetesPedigreeFunction = l_DiabetesPedigreeFunction.get(i);
				Double d_l_Age = l_Age.get(i);
				if(d_l_glucose >= 126 && d_l_bloodPressure >= 90 && d_l_BMI >= 30
						&& d_l_DiabetesPedigreeFunction > media_Diabetes_Predic) {
					l_Outcome.remove(i);
					l_Outcome.add(i, 1.0);
				}
				
			}
			return l_Outcome;
			
		}

}
