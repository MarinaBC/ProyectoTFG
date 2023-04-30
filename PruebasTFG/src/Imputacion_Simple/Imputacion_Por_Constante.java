package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;

public class Imputacion_Por_Constante {
	
	 public static void main(String[] args) {
		 //
		 long startTime = System.nanoTime();
		 LeerFichero.main(args);//IMPORTANTE 
		 
		 //
		 System.out.println("-La lista es de pregnancies es:");
		 List<Double> r1 = new ArrayList<>(cambiarValoresNaN(LeerFichero.pregnancies));
		 System.out.println(r1);
	     double media = calcularMedia(r1);
	     System.out.println("media: " + media);
	     List<Double> l_pregnancies = new ArrayList<>(imputarPorConstante(r1, media));
	     System.out.println(l_pregnancies);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de glucose es:");
		 List<Double> r2 = new ArrayList<>(cambiarValoresNaN(LeerFichero.glucose));
		 System.out.println(r2);
	     double media2 = calcularMedia(r2);
	     System.out.println("media: " + media2);
	     List<Double> l_glucose = new ArrayList<>(imputarPorConstante(r2, media2));
	     System.out.println(l_glucose);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de bloodPressure es:");
		 List<Double> r3 = new ArrayList<>(cambiarValoresNaN(LeerFichero.bloodPressure));
		 System.out.println(r3);
	     double media3 = calcularMedia(r3);
	     System.out.println("media: " + media3);
	     List<Double> l_bloodPressure = new ArrayList<>(imputarPorConstante(r3, media3));
	     System.out.println(l_bloodPressure);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de skinThickness es:");
		 List<Double> r4 = new ArrayList<>(cambiarValoresNaN(LeerFichero.skinThickness));
		 System.out.println(r4);
	     double media4 = calcularMedia(r4);
	     System.out.println("media: " + media4);
	     List<Double> l_skinThickness = new ArrayList<>(imputarPorConstante(r4, media4));
	     System.out.println(l_skinThickness);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de insulin es:");
		 List<Double> r5 = new ArrayList<>(cambiarValoresNaN(LeerFichero.insulin));
		 System.out.println(r5);
	     double media5 = calcularMedia(r5);
	     System.out.println("media: " + media5);
	     List<Double> l_insulin = new ArrayList<>(imputarPorConstante(r5, media5));
	     System.out.println(l_insulin);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de BMI es:");
		 List<Double> r6 = new ArrayList<>(cambiarValoresNaN(LeerFichero.BMI));
		 System.out.println(r6);
	     double media6 = calcularMedia(r6);
	     System.out.println("media: " + media6);
	     List<Double> l_BMI = new ArrayList<>(imputarPorConstante(r6, media6));
	     System.out.println(l_BMI);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		 List<Double> r7 = new ArrayList<>(cambiarValoresNaN(LeerFichero.DiabetesPedigreeFunction));
		 System.out.println(r7);
	     double media_Diabetes_Predic = calcularMedia(r7);
	     System.out.println("media: " + media_Diabetes_Predic);
	     List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(imputarPorConstante(r7, media_Diabetes_Predic));
	     System.out.println(l_DiabetesPedigreeFunction);
	     System.out.println("\n");
	     //
	     
	     
	     
	     //
		 System.out.println("-La lista es de Age es:");
		 List<Double> r8 = new ArrayList<>(cambiarValoresNaN(LeerFichero.Age));
		 System.out.println(r8);
	     double media8 = calcularMedia(r8);
	     System.out.println("media: " + media8);
	     List<Double> l_Age = new ArrayList<>(imputarPorConstante(r8, media8));
	     System.out.println(l_Age);
	     System.out.println("\n");
	     //
	     
	     
	     long endTime = System.nanoTime();
		 System.out.println("Duracion: " + (endTime - startTime)/1e6 + " ms");
		 
		 
		 System.out.println("//////");
			System.out.println("\n");
			/*PADECE_DIABETES p = new PADECE_DIABETES(l_pregnancies, l_glucose, l_bloodPressure, 
					l_skinThickness, l_insulin, l_BMI, l_DiabetesPedigreeFunction, l_Age);
			Boolean res = p.padeceDiabetes();
			System.out.println(res);
			*/
			System.out.println("-La lista es de Outcome es:");
			System.out.println(LeerFichero.Outcome);
			List<Double> l_Outcome = new ArrayList<>(LeerFichero.Outcome);
			
			List<Double> padece = new ArrayList<>(pacedeDiabetes(l_pregnancies, l_glucose, l_bloodPressure, 
					l_skinThickness, l_insulin, l_BMI, l_DiabetesPedigreeFunction, l_Age, l_Outcome, media_Diabetes_Predic));
			
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
				//Un nivel de glucosa en ayunas igual o superior a 126 mg/dl se considera diabetes
				//presión arterial diastólica igual o superior a 90 mmHg se considera hipertensión
				//Un nivel de insulina en ayunas superior a 25 microU/mL se considera elevado y puede indicar resistencia a la insulina, que es un factor de riesgo para la diabetes tipo 2
				//Un BMI igual o superior a 30 se considera obesidad, lo que aumenta el riesgo de desarrollar diabetes tipo 2.
				//la diabetes tipo 2 es más común en personas mayores de 40 años.
				if(d_l_glucose >= 126 && d_l_bloodPressure >= 90 && d_l_insulin >= 25 && d_l_BMI >= 30
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
	            if (!Double.isNaN(dato)) {
	                suma += dato;
	                cont++;
	            }
	        }
	        return suma / cont;
	    }
	    
	    public static List<Double> imputarPorConstante(List<Double> datos, double constante) {
	        List<Double> datosImputados = new ArrayList<>();//new double[datos.length];
	        for (int i = 0; i < datos.size(); i++) {
	            if (Double.isNaN(datos.get(i))) {
	            	datos.remove(i);
	            	datos.add(i, constante);
	                //datosImputados.get(i) = constante;
	            } 
	        }
	        return datos;
	    }
	    
	    
	    public static List<Double> cambiarValoresNaN(List<Double> l){
			for (int i = 0; i < l.size(); i++) {
	            if (l.get(i) == 0) {
	                l.set(i, Double.NaN);
	            }
	        }
			return l;
		}

}
