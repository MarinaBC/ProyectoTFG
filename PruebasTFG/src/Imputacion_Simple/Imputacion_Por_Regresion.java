package Imputacion_Simple;

import java.util.ArrayList;
import java.util.List;

public class Imputacion_Por_Regresion {
	
	
	
	//y=ax+b
 
	public static void main(String[] args) {
		// 
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE 
		
		System.out.println("-La lista es de pregnancies es:");
		System.out.println(LeerFichero.pregnancies);
		//Para obtener pregnancies sobre glucose
		//System.out.println(regresionLineal(LeerFichero.glucose, LeerFichero.pregnancies));
		List<Double> res1 = regresionLineal(LeerFichero.glucose, LeerFichero.pregnancies);
		List<Double> l_pregnancies = new ArrayList<>(imputacionValorLista(LeerFichero.pregnancies, res1));
		//System.out.println(l_pregnancies);
		System.out.println("\n");
		//
		System.out.println("-La lista es de glucose es:");
		System.out.println(LeerFichero.glucose);
		//Para obtener glucose sobre pregnancies  
		//System.out.println(regresionLineal(LeerFichero.pregnancies, LeerFichero.glucose));
		List<Double> res2 = regresionLineal(LeerFichero.pregnancies, LeerFichero.glucose);
		List<Double> l_glucose = new ArrayList<>(imputacionValorLista(LeerFichero.glucose, res2));
		//System.out.println(l_glucose);
		System.out.println("\n");
		
		
		
		
		//Para obtener bloodPressure sobre skinThickness
		System.out.println("-La lista es de bloodPressure es:");
		System.out.println(LeerFichero.bloodPressure);
		//System.out.println(regresionLineal(LeerFichero.skinThickness, LeerFichero.bloodPressure));
		List<Double> res3 = regresionLineal(LeerFichero.skinThickness, LeerFichero.bloodPressure);
		List<Double> l_bloodPressure = new ArrayList<>(imputacionValorLista(LeerFichero.bloodPressure, res3));
		//System.out.println(l_bloodPressure);
		System.out.println("\n");
		//
		System.out.println("-La lista es de skinThickness es:");
		System.out.println(LeerFichero.skinThickness);
		//Para obtener skinThickness sobre bloodPressure
		//System.out.println(regresionLineal(LeerFichero.bloodPressure, LeerFichero.skinThickness));
		List<Double> res4 = regresionLineal(LeerFichero.bloodPressure, LeerFichero.skinThickness);
		List<Double> l_skinThickness = new ArrayList<>(imputacionValorLista(LeerFichero.skinThickness, res4));
		//System.out.println(l_skinThickness);
		System.out.println("\n");
		
		
		
		
		//Para obtener insulin sobre BMI
		System.out.println("-La lista es de insulin es:");
		System.out.println(LeerFichero.insulin);
		//System.out.println(regresionLineal(LeerFichero.BMI, LeerFichero.insulin));
		List<Double> res5 = regresionLineal(LeerFichero.BMI, LeerFichero.insulin);
		List<Double> l_insulin = new ArrayList<>(imputacionValorLista(LeerFichero.insulin, res5));
		//System.out.println(l_insulin);
		System.out.println("\n");
		//
		System.out.println("-La lista es de BMI es:");
		System.out.println(LeerFichero.BMI);
		//Para obtener BMI sobre insulin 
		//System.out.println(regresionLineal(LeerFichero.insulin, LeerFichero.BMI));
		List<Double> res6 = regresionLineal(LeerFichero.insulin, LeerFichero.BMI);
		List<Double> l_BMI = new ArrayList<>(imputacionValorLista(LeerFichero.BMI, res6));
		//System.out.println(l_BMI);
		System.out.println("\n");
		
		
		
		//Para obtener DiabetesPedigreeFunction sobre Age
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		System.out.println(LeerFichero.DiabetesPedigreeFunction);
		//System.out.println(regresionLineal(LeerFichero.Age, LeerFichero.DiabetesPedigreeFunction));
		List<Double> res7 = regresionLineal(LeerFichero.Age, LeerFichero.DiabetesPedigreeFunction);
		List<Double> l_DiabetesPedigreeFunction = new ArrayList<>(imputacionValorLista(LeerFichero.DiabetesPedigreeFunction, res7));
		//System.out.println(l_DiabetesPedigreeFunction);
		System.out.println("\n");
		//
		System.out.println("-La lista es de Age es:");
		System.out.println(LeerFichero.Age);
		//Para obtener Age sobre DiabetesPedigreeFunction 
		//System.out.println(regresionLineal(LeerFichero.DiabetesPedigreeFunction, LeerFichero.Age));
		List<Double> res8 = regresionLineal(LeerFichero.DiabetesPedigreeFunction, LeerFichero.Age);
		List<Double> l_Age = new ArrayList<>(imputacionValorLista(LeerFichero.Age, res8));
		//System.out.println(l_Age);
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
	
	
	/*
	 *  método regresionLineal (array de reales x, array de reales y)
 real sumX=0, sumY=0, sumXY=0, sumX2=0
 entero n= longitud de x
 para i desde 0 hasta n -1
 sumX=sumX+x[i]
 sumY=sumY+y[i]
 sumXY=sumXY+x[i]*y[i]
 sumX2=sumX2+x[i]*x[i]
 fin para
 pendiente=(n*sumXY-sumX*sumY)/(n*sumX2-sumX*sumX)
 interseccion=(sumY-pendiente*sumX)/n
 fin método
La regresión lineal es una técnica que permite obtener la pendiente y punto de intersección de la
recta que más se aproxima a la función y=f(x), definiéndose esta función como un conjunto de
parejas (x,y). La ecuación de la recta resultante es: y=pendiente*x+intersección
	 */
	
	public static List<Double> regresionLineal(List<Double> x, List<Double> y){
		List<Double> res = new ArrayList<>();
		
		Double sumX = 0.;
		Double sumY = 0.;
		Double sumXY = 0.;
		Double sumX2 = 0.;
		Integer n = x.size();
		
		for(int i = 0; i < n; i++) {
			sumX = sumX + x.get(i);
			sumY = sumY + y.get(i);
			sumXY = sumXY + x.get(i) * y.get(i);
			sumX2 = sumX2 + x.get(i) * x.get(i);
		}
		
		Double pendiente = (n*sumXY-sumX*sumY)/(n*sumX2-sumX*sumX);
		Double interseccion = (sumY-pendiente*sumX)/n;
		
		// La ecuación de la recta resultante es: y=pendiente*x+intersección
		for(int j = 0; j<n; j++) {
			res.add(pendiente* x.get(j) + interseccion);//y.get(i)=pendiente*x.get(i)+intersección;
		}
		
		//System.out.println(res);
		
		return res;
	}
	
	

	
	public static List<Double> imputacionValorLista(List<Double> ls, List<Double> listR){
		List<Double> res = new ArrayList<>(ls);
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) == 0.0) {
				//System.out.print(ls.indexOf(i));
				ls.remove(i);
				//System.out.println("El valor imputado es: " + listR.get(i));
				ls.add(i, listR.get(i));
			}
		}
		System.out.println(ls);
		return res;
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
