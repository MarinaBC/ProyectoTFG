package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;

import Pruebas.PADECE_DIABETES;

public class Imputacion_Por_Media {

	public static void main(String[] args) {
		// 
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		System.out.println("-La lista es de pregnancies es:");
		System.out.println(LeerFichero.pregnancies);
		List<Double> l_pregnancies = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.pregnancies));
		System.out.println(l_pregnancies);
		System.out.println("\n");
		
		System.out.println("-La lista es de glucose es:");
		System.out.println(LeerFichero.glucose);
		List<Double> l_glucose = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.glucose));
		System.out.println(l_glucose);
		System.out.println("\n");
		
		System.out.println("-La lista es de bloodPressure es:");
		System.out.println(LeerFichero.bloodPressure);
		List<Double> l_bloodPressure = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.bloodPressure));
		System.out.println(l_bloodPressure);
		System.out.println("\n");
		
		System.out.println("-La lista es de skinThickness es:");
		System.out.println(LeerFichero.skinThickness);
		List<Double> l_skinThickness = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.skinThickness));
		System.out.println(l_skinThickness);
		System.out.println("\n");
		
		System.out.println("-La lista es de insulin es:");
		System.out.println(LeerFichero.insulin);
		List<Double> l_insulin = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.insulin));
		System.out.println(l_insulin);
		System.out.println("\n");
		
		System.out.println("-La lista es de BMI es:");
		System.out.println(LeerFichero.BMI);
		List<Double> l_BMI = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.BMI));
		System.out.println(l_BMI);
		System.out.println("\n");
		
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		System.out.println(LeerFichero.DiabetesPedigreeFunction);
		List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.DiabetesPedigreeFunction));
		System.out.println(l_DiabetesPedigreeFunction);
		System.out.println("\n");
		
		System.out.println("-La lista es de Age es:");
		System.out.println(LeerFichero.Age);
		List<Double> l_Age = new ArrayList<>(generarListaDConMediaConValorNull(LeerFichero.Age));
		System.out.println(l_Age);
		System.out.println("\n");
		
		long endTime = System.nanoTime();
		System.out.println("Duracion: " + (endTime - startTime)/1e6 + " ms");
		
		
		System.out.println("//////");
		System.out.println("\n");
		/*PADECE_DIABETES p = new PADECE_DIABETES(l_pregnancies, l_glucose, l_bloodPressure, 
				l_skinThickness, l_insulin, l_BMI, l_DiabetesPedigreeFunction, l_Age);
		Boolean res = p.padeceDiabetes();
		System.out.println(res);
		*/
		double media_Diabetes_Predic = calcularMedia(LeerFichero.DiabetesPedigreeFunction);
		System.out.println("-La lista es de Outcome es:");
		System.out.println(LeerFichero.Outcome);
		List<Double> l_Outcome = new ArrayList<>(LeerFichero.Outcome);
		
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

	
	
	public static List<Double> generarListaDConMediaConValorNull(List<Double> ls) {
		List<Double> copiaLista = new ArrayList<>(ls);
		//copiaLista = ls;
		
		//System.out.println(ls);
		//System.out.println(copiaLista);
		
		for(int i = 0; i<copiaLista.size(); i++) {
			//Si es 0
			if(copiaLista.get(i) == 0.0) {
				copiaLista.remove(i); // -> Lista sin ceros
				//indices.add(i);
			}
		}
		//System.out.println(copiaLista);
		Double d = mediaAritmeticaListaDouble(copiaLista);
		
		System.out.println("El valor a imputar es: " + d);
		
		//System.out.println(ls);
		
		for(int j = 0; j < ls.size(); j++) {
			if(ls.get(j) == 0.0) {
				//System.out.println(ls.get(j));
				ls.remove(j);
				ls.add(j, d);
				
				//System.out.println(pos);
				//ls.add(j, d);
			}
		}
		
		return ls;
	}

	public static Double mediaAritmeticaListaDouble(List<Double> ls) {
		Double res = 0.;
		Double suma = 0.;
		for(int i = 0; i < ls.size(); i++) {
			suma = suma + ls.get(i);
		}
		Double media = suma/ls.size();
		res = media;
		return res;
	}


	
}
