package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;

import Imputacion_Multiple.MICE;

public class Imputacion_Por_HotDeck_KNN {
	
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		//
		System.out.println("-La lista es de pregnancies es:");
		List<Double> r1 = new ArrayList<>(cambiarValoresNaN(LeerFichero.pregnancies));
		System.out.println(r1);
		List<Double> l_pregnancies = new ArrayList<>(reemplazaKNN(r1));
		System.out.println(l_pregnancies);
		System.out.println("\n");
		//
		
		
		
		//glucose
		System.out.println("-La lista es de glucose es:");
		List<Double> r2 = new ArrayList<>(cambiarValoresNaN(LeerFichero.glucose));
		System.out.println(r2);
		List<Double> l_glucose = new ArrayList<>(reemplazaKNN(r2));
		System.out.println(l_glucose);
		System.out.println("\n");
		//
		
		
		
		//bloodPressure
		System.out.println("-La lista es de bloodPressure es:");
		List<Double> r3 = new ArrayList<>(cambiarValoresNaN(LeerFichero.bloodPressure));
		System.out.println(r3);
		List<Double> l_bloodPressure = new ArrayList<>(reemplazaKNN(r3));
		System.out.println(l_bloodPressure);
		System.out.println("\n");
		//
		
		
		
		//skinThickness
		System.out.println("-La lista es de skinThickness es:");
		List<Double> r4 = new ArrayList<>(cambiarValoresNaN(LeerFichero.skinThickness));
		System.out.println(r4);
		List<Double> l_skinThickness = new ArrayList<>(reemplazaKNN(r4));
		System.out.println(l_skinThickness);
		System.out.println("\n");
		//
		
		
		
		//insulin
		System.out.println("-La lista es de insulin es:");
		List<Double> r5 = new ArrayList<>(cambiarValoresNaN(LeerFichero.insulin));
		System.out.println(r5);
		List<Double> l_insulin = new ArrayList<>(reemplazaKNN(r5));
		System.out.println(l_insulin);
		System.out.println("\n");
		//
		
		
		
		//BMI
		System.out.println("-La lista es de BMI es:");
		List<Double> r6 = new ArrayList<>(cambiarValoresNaN(LeerFichero.BMI));
		System.out.println(r6);
		List<Double> l_BMI = new ArrayList<>(reemplazaKNN(r6));
		System.out.println(l_BMI);
		System.out.println("\n");
		//
		
		
		
		//DiabetesPedigreeFunction
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r7 = new ArrayList<>(cambiarValoresNaN(LeerFichero.DiabetesPedigreeFunction));
		System.out.println(r7);
		List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(reemplazaKNN(r7));
		System.out.println(l_DiabetesPedigreeFunction);
		System.out.println("\n");
		//
		
		
		
		//Age
		System.out.println("-La lista es de Age es:");
		List<Double> r8 = new ArrayList<>(cambiarValoresNaN(LeerFichero.Age));
		System.out.println(r8);
		List<Double> l_Age = new ArrayList<>(reemplazaKNN(r8));
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
	
	
	
	
	public static List<Double> replaceZerosWithAvg(List<Double> list) {
	    Double prevNonZero = 0.;
	    Double nextNonZero = 0.;
	    int zeroCount = 0;

	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i) == 0) {
	            zeroCount++;
	        } else {
	            if (prevNonZero > 0 && nextNonZero > 0 && zeroCount > 0) {
	                double avg = (double)(prevNonZero + nextNonZero) / 2.0;
	                for (int j = i - zeroCount; j < i; j++) {
	                    list.set(j, (double)Math.round(avg));
	                }
	                zeroCount = 0;
	            }
	            prevNonZero = nextNonZero;
	            nextNonZero = list.get(i);
	        }
	    }

	    // Check if there are zeros at the end of the list
	    if (prevNonZero > 0 && zeroCount > 0) {
	        double avg = (double)(prevNonZero + nextNonZero) / 2.0;
	        for (int i = list.size() - zeroCount; i < list.size(); i++) {
	            list.set(i, (double)Math.round(avg));
	        }
	    }
	    return list;
	}

	
	public static List<Double> reemplazaKNN(List<Double> list){
		for (int i = 0; i < list.size(); i++) { 
		    if(Double.isNaN(list.get(i))) {
		        int izquierda = i-1;
		        double izq = Double.NaN;
		        while(izquierda >= 0 && Double.isNaN(izq)) {
		            //izq = array[izquierda--];
		        	izq = list.get(izquierda--);
		        } 

		        int derecha = i+1;
		        double der = Double.NaN;
		        while(derecha < list.size() && Double.isNaN(der)) {
		            der = list.get(derecha++);
		        }

		        if(!Double.isNaN(izq) && !Double.isNaN(der)) {
		        	list.remove(i);
					list.add(i, (izq + der) / 2.0);
		            //array[i] = (izq + der) / 2.0;
		        } else if(Double.isNaN(izq) && Double.isNaN(der)) {
		           // array[i] = Double.NaN;
		        	list.remove(i);
					list.add(i, Double.NaN);
		        }
		    }
		}
		return list;

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
