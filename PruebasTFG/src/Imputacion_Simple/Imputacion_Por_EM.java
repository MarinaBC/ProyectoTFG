package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;

public class Imputacion_Por_EM {

	public static void main(String[] args) {
		// 
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		//
		System.out.println("-La lista es de pregnancies es:");
		List<Double> r1 = new ArrayList<>(cambiarValoresNaN(LeerFichero.pregnancies));
		System.out.println(r1);
		List<Double> l_pregnancies = new ArrayList<>(remplazarImputarNaNconEM(r1));
		System.out.println(l_pregnancies);
		System.out.println("\n");
		//
		
		
		
		//glucose
		System.out.println("-La lista es de glucose es:");
		List<Double> r2 = new ArrayList<>(cambiarValoresNaN(LeerFichero.glucose));
		System.out.println(r2);
		List<Double> l_glucose = new ArrayList<>(remplazarImputarNaNconEM(r2));
		System.out.println(l_glucose);
		System.out.println("\n");
		//
				
				
				
		//bloodPressure
		System.out.println("-La lista es de bloodPressure es:");
		List<Double> r3 = new ArrayList<>(cambiarValoresNaN(LeerFichero.bloodPressure));
		System.out.println(r3);
		List<Double> l_bloodPressure = new ArrayList<>(remplazarImputarNaNconEM(r3));
		System.out.println(l_bloodPressure);
		System.out.println("\n");
		//
				
				
				
		//skinThickness
		System.out.println("-La lista es de skinThickness es:");
		List<Double> r4 = new ArrayList<>(cambiarValoresNaN(LeerFichero.skinThickness));
		System.out.println(r4);
		List<Double> l_skinThickness = new ArrayList<>(remplazarImputarNaNconEM(r4));
		System.out.println(l_skinThickness);
		System.out.println("\n");
		//
				
				
				
		//insulin
		System.out.println("-La lista es de insulin es:");
		List<Double> r5 = new ArrayList<>(cambiarValoresNaN(LeerFichero.insulin));
		System.out.println(r5);
		List<Double> l_insulin = new ArrayList<>(remplazarImputarNaNconEM(r5));
		System.out.println(l_insulin);
		System.out.println("\n");
		//
				
				
				
		//BMI
		System.out.println("-La lista es de BMI es:");
		List<Double> r6 = new ArrayList<>(cambiarValoresNaN(LeerFichero.BMI));
		System.out.println(r6);
		List<Double> l_BMI = new ArrayList<>(remplazarImputarNaNconEM(r6));
		System.out.println(l_BMI);
		System.out.println("\n");
		//
				
				
				
		//DiabetesPedigreeFunction
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r7 = new ArrayList<>(cambiarValoresNaN(LeerFichero.DiabetesPedigreeFunction));
		System.out.println(r7);
		List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(remplazarImputarNaNconEM(r7));
		System.out.println(l_DiabetesPedigreeFunction);
		System.out.println("\n");
		//
				
				
				
		//Age
		System.out.println("-La lista es de Age es:");
		List<Double> r8 = new ArrayList<>(cambiarValoresNaN(LeerFichero.Age));
		System.out.println(r8);
		List<Double> l_Age = new ArrayList<>(remplazarImputarNaNconEM(r8));
		System.out.println(l_Age);
		System.out.println("\n");
		//
		
		long endTime = System.nanoTime();
		System.out.println("Duracion: " + (endTime - startTime)/1e6 + " ms");
		
		System.out.println("\n");
		
		double media_Diabetes_Predic = calcularMedia(LeerFichero.DiabetesPedigreeFunction);
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
	
	public static List<Double> remplazarImputarNaNconEM(List<Double> lista) {

	    // Iterar hasta que se hayan llenado todos los NaN
	    while (lista.contains(Double.NaN)) {
	        
	        // Paso de esperanza: calcular la media de los valores no NaN en la lista
	        double media = 0;
	        int numNoNan = 0;
	        for (Double valor : lista) {
	            if (!valor.isNaN()) {
	                media += valor;
	                numNoNan++;
	            }
	        }
	        media /= numNoNan;
	        
	        // Paso de maximización: cambiar los valores NaN en la lista por la media calculada.
	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i).isNaN()) {
	                lista.set(i, media);
	            }
	        }    
	    }
	    
	    return lista;
	}
	
	public static List<Double> cambiarValoresNaN(List<Double> l){
		for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == 0) {
                l.set(i, Double.NaN);
            }
        }
		return l;
	}
	
	
	public static double calcularMedia(List<Double> datos) {
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


