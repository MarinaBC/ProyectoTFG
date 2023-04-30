package Imputacion_Simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Imputacion_Por_MV {
	
	public static void main(String[] args) {
		// 
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE
		
		
		
		//
		System.out.println("-La lista es de pregnancies es:");
		List<Double> r1 = new ArrayList<>(LeerFichero.pregnancies);
		double[] array1 = new double[r1.size()];
		for (int i1 = 0; i1 < r1.size(); i1++) {
			array1[i1] = r1.get(i1);
		}
	        
		System.out.println(Arrays.toString(array1));
	        
	    double mean1 = getMean(array1);
	    double var1 = getVar(array1, mean1);
	        
	    System.out.println("Media: " + mean1);
	    System.out.println("Varianza: " + var1);
	    
	    List<Double> l_pregnancies = new ArrayList<>(cambiaValor(r1, mean1));
	    System.out.println(l_pregnancies);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de glucose es:");
		List<Double> r2 = new ArrayList<>(LeerFichero.glucose);
		double[] array2 = new double[r2.size()];
		for (int i2 = 0; i2 < r2.size(); i2++) {
			array2[i2] = r2.get(i2);
		}
	        
		System.out.println(Arrays.toString(array2));
	        
	    double mean2 = getMean(array2);
	    double var2 = getVar(array2, mean2);
	        
	    System.out.println("Media: " + mean2);
	    System.out.println("Varianza: " + var2);
	    
	    List<Double> l_glucose = new ArrayList<>(cambiaValor(r2, mean2));
	    System.out.println(l_glucose);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de bloodPressure es:");
		List<Double> r3 = new ArrayList<>(LeerFichero.bloodPressure);
		double[] array3 = new double[r3.size()];
		for (int i3 = 0; i3 < r3.size(); i3++) {
			array3[i3] = r3.get(i3);
		}
	        
		System.out.println(Arrays.toString(array3));
	        
	    double mean3 = getMean(array3);
	    double var3 = getVar(array3, mean3);
	        
	    System.out.println("Media: " + mean3);
	    System.out.println("Varianza: " + var3);
	    
	    List<Double> l_bloodPressure = new ArrayList<>(cambiaValor(r3, mean3));
	    System.out.println(l_bloodPressure);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de skinThickness es:");
		List<Double> r4 = new ArrayList<>(LeerFichero.skinThickness);
		double[] array4 = new double[r4.size()];
		for (int i4 = 0; i4 < r4.size(); i4++) {
			array4[i4] = r4.get(i4);
		}
	        
		System.out.println(Arrays.toString(array4));
	        
	    double mean4 = getMean(array4);
	    double var4 = getVar(array4, mean4);
	        
	    System.out.println("Media: " + mean4);
	    System.out.println("Varianza: " + var4);
	    
	    List<Double> l_skinThickness = new ArrayList<>(cambiaValor(r4, mean4));
	    System.out.println(l_skinThickness);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de insulin es:");
		List<Double> r5 = new ArrayList<>(LeerFichero.insulin);
		double[] array5 = new double[r5.size()];
		for (int i5 = 0; i5 < r5.size(); i5++) {
			array5[i5] = r5.get(i5);
		}
	        
		System.out.println(Arrays.toString(array5));
	        
	    double mean5 = getMean(array5);
	    double var5 = getVar(array5, mean5);
	        
	    System.out.println("Media: " + mean5);
	    System.out.println("Varianza: " + var5);
	    
	    List<Double> l_insulin = new ArrayList<>(cambiaValor(r5, mean5));
	    System.out.println(l_insulin);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de BMI es:");
		List<Double> r6 = new ArrayList<>(LeerFichero.BMI);
		double[] array6 = new double[r6.size()];
		for (int i6 = 0; i6 < r6.size(); i6++) {
			array6[i6] = r6.get(i6);
		}
	        
		System.out.println(Arrays.toString(array6));
	        
	    double mean6 = getMean(array6);
	    double var6 = getVar(array6, mean6);
	        
	    System.out.println("Media: " + mean6);
	    System.out.println("Varianza: " + var6);
	    
	    List<Double> l_BMI = new ArrayList<>(cambiaValor(r6, mean6));
	    System.out.println(l_BMI);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		List<Double> r7 = new ArrayList<>(LeerFichero.DiabetesPedigreeFunction);
		double[] array7 = new double[r7.size()];
		for (int i7 = 0; i7 < r7.size(); i7++) {
			array7[i7] = r7.get(i7);
		}
	        
		System.out.println(Arrays.toString(array7));
	        
	    double mean7 = getMean(array7);
	    double var7 = getVar(array7, mean7);
	        
	    System.out.println("Media: " + mean7);
	    System.out.println("Varianza: " + var7);
	    
	    List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(cambiaValor(r7, mean7));
	    System.out.println(l_DiabetesPedigreeFunction);
		System.out.println("\n");
		//

		
		
		//
		System.out.println("-La lista es de Age es:");
		List<Double> r8 = new ArrayList<>(LeerFichero.Age);
		double[] array8 = new double[r8.size()];
		for (int i8 = 0; i8 < r8.size(); i8++) {
			array8[i8] = r8.get(i8);
		}
	        
		System.out.println(Arrays.toString(array8));
	        
	    double mean8 = getMean(array8);
	    double var8 = getVar(array8, mean8);
	        
	    System.out.println("Media: " + mean8);
	    System.out.println("Varianza: " + var8);
	    
	    List<Double> l_Age = new ArrayList<>(cambiaValor(r8, mean8));
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
    
    // Función para calcular la media muestral
    public static double getMean(double[] data) {
        double sum = Arrays.stream(data).sum();
        return sum / data.length;
    }
    
    // Función para calcular la varianza muestral
    public static double getVar(double[] data, double mean) {
        double sum = Arrays.stream(data).map(x -> Math.pow(x - mean, 2)).sum();
        return sum / (data.length - 1);
    }
    
    //Funcion para cambiar el valor missing por el valor de la madia
    public static List<Double> cambiaValor(List<Double> list, Double mean){
    	for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == 0.0) {
				list.remove(i);
				list.add(i, mean);
				
			}
		}
    	return list;
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
