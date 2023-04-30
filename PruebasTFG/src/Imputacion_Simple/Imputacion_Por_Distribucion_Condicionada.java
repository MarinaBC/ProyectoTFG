package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Imputacion_Por_Distribucion_Condicionada {

	public static void main(String[] args) {
		// 
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		// 
		System.out.println("-La lista es de pregnancies es:");
		List<Double> r1 = new ArrayList<>(cambiarNull(LeerFichero.pregnancies));
		List<Double> l_pregnancies = imputeByConditionalDistribution(r1);
		System.out.println("Lista original: " + r1);
		System.out.println("Lista imputada: " + l_pregnancies);
		System.out.println("\n");
		//
        
        
        
        //glucose
        System.out.println("-La lista es de glucose es:");
		List<Double> r2 = new ArrayList<>(cambiarNull(LeerFichero.glucose));
		List<Double> l_glucose = imputeByConditionalDistribution(r2);
        System.out.println("Lista original: " + r2);
        System.out.println("Lista imputada: " + l_glucose);
        System.out.println("\n");
        
        
        //bloodPressure
        System.out.println("-La lista es de bloodPressure es:");
		List<Double> r3 = new ArrayList<>(cambiarNull(LeerFichero.bloodPressure));
		List<Double> l_bloodPressure = imputeByConditionalDistribution(r3);
        System.out.println("Lista original: " + r3);
        System.out.println("Lista imputada: " + l_bloodPressure);
        System.out.println("\n");
        
        
        
        //skinThickness
        System.out.println("-La lista es de skinThickness es:");
		List<Double> r4 = new ArrayList<>(cambiarNull(LeerFichero.skinThickness));
		List<Double> l_skinThickness = imputeByConditionalDistribution(r4);
        System.out.println("Lista original: " + r4);
        System.out.println("Lista imputada: " + l_skinThickness);
        System.out.println("\n");
        
        
        
        //insulin
        System.out.println("-La lista es de insulin es:");
		List<Double> r5 = new ArrayList<>(cambiarNull(LeerFichero.insulin));
		List<Double> l_insulin = imputeByConditionalDistribution(r5);
        System.out.println("Lista original: " + r5);
        System.out.println("Lista imputada: " + l_insulin);
        System.out.println("\n");
        
        
        
        //BMI
        System.out.println("-La lista es de BMI es:");
		List<Double> r6 = new ArrayList<>(cambiarNull(LeerFichero.BMI));
		List<Double> l_BMI = imputeByConditionalDistribution(r6);
        System.out.println("Lista original: " + r6);
        System.out.println("Lista imputada: " + l_BMI);
        System.out.println("\n");
        
        
        
        //DiabetesPedigreeFunction
        System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r7 = new ArrayList<>(cambiarNull(LeerFichero.DiabetesPedigreeFunction));
		List<Double> l_DiabetesPedigreeFunction = imputeByConditionalDistribution(r7);
        System.out.println("Lista original: " + r7);
        System.out.println("Lista imputada: " + l_DiabetesPedigreeFunction);
        System.out.println("\n");
        
        
        
        //Age
        System.out.println("-La lista es de Age es:");
		List<Double> r8 = new ArrayList<>(cambiarNull(LeerFichero.Age));
		List<Double> l_Age = imputeByConditionalDistribution(r8);
        System.out.println("Lista original: " + r8);
        System.out.println("Lista imputada: " + l_Age);
        System.out.println("\n");
		
		
		
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
	
	
	
	
	public static List<Double> cambiarNull(List<Double> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == 0) {
                lista.set(i, null);
            }
        }
        return lista;
    }
	
	public static List<Double> imputeByConditionalDistribution(List<Double> list) {
	    List<Double> newList = new ArrayList<>(list);
	    Random random = new Random();
	    for (int i = 0; i < newList.size(); i++) {
	        if (newList.get(i) == null) {
	            double previousValue = 0.0;
	            double nextValue = 0.0;
	            int previousIndex = i - 1;
	            int nextIndex = i + 1;
	            while (previousIndex >= 0) {
	                if (newList.get(previousIndex) != null) {
	                    previousValue = newList.get(previousIndex);
	                    break;
	                }
	                previousIndex--;
	            }
	            while (nextIndex < newList.size()) {
	                if (newList.get(nextIndex) != null) {
	                    nextValue = newList.get(nextIndex);
	                    break;
	                }
	                nextIndex++;
	            }
	            double mean = (previousValue + nextValue) / 2.0;
	            double standardDeviation = (nextValue - previousValue) / 2.0;
	            double imputedValue = random.nextGaussian() * standardDeviation + mean;
	            newList.set(i, imputedValue);
	        }
	    }
	    return newList;
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
