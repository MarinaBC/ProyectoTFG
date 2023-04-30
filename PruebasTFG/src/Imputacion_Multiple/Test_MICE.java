package Imputacion_Multiple;

import java.util.ArrayList;
import java.util.List;

import Imputacion_Simple.LeerFichero;

public class Test_MICE {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		LeerFichero.main(args);//IMPORTANTE
		
		
		//Iniciar
		System.out.println("-La lista es de pregnancies es:");
		//Cambiamos los 0 por null
		List<Double> r1 = new ArrayList<>(cambiarValoresNaN(LeerFichero.pregnancies));
		System.out.println(r1);
		// Crear primero los objetos de la clase MICE
		MICE m1 = new MICE(r1, 3);
		//m.runMICE();
		System.out.println(m1.runMICE());
		System.out.println("\n");
		//
		
		
		
		//Iniciar
		System.out.println("-La lista es de glucose es:");
		//Cambiamos los 0 por null
		List<Double> r2 = new ArrayList<>(cambiarValoresNaN(LeerFichero.glucose));
		System.out.println(r2);
		// Crear primero los objetos de la clase MICE
		MICE m2 = new MICE(r2, 3);
		//m.runMICE();
		System.out.println(m2.runMICE());
		System.out.println("\n");
		//
		
		
		//Iniciar
		System.out.println("-La lista es de bloodPressure es:");
		//Cambiamos los 0 por null
		List<Double> r3 = new ArrayList<>(cambiarValoresNaN(LeerFichero.bloodPressure));
		System.out.println(r3);
		// Crear primero los objetos de la clase MICE
		MICE m3 = new MICE(r3, 3);
		//m.runMICE();
		System.out.println(m3.runMICE());
		System.out.println("\n");
		//
		
		
		
		//Iniciar
		System.out.println("-La lista es de skinThickness es:");
		//Cambiamos los 0 por null
		List<Double> r4 = new ArrayList<>(cambiarValoresNaN(LeerFichero.skinThickness));
		System.out.println(r4);
		// Crear primero los objetos de la clase MICE
		MICE m4 = new MICE(r4, 3);
		//m.runMICE();
		System.out.println(m4.runMICE());
		System.out.println("\n");
		//
		
		
		
		//Iniciar
		System.out.println("-La lista es de insulin es:");
		//Cambiamos los 0 por null
		List<Double> r5 = new ArrayList<>(cambiarValoresNaN(LeerFichero.insulin));
		System.out.println(r5);
		// Crear primero los objetos de la clase MICE
		MICE m5 = new MICE(r5, 3);
		//m.runMICE();
		System.out.println(m5.runMICE());
		System.out.println("\n");
		//
		
		
		
		
		//Iniciar
		System.out.println("-La lista es de BMI es:");
		//Cambiamos los 0 por null
		List<Double> r6 = new ArrayList<>(cambiarValoresNaN(LeerFichero.BMI));
		System.out.println(r6);
		// Crear primero los objetos de la clase MICE
		MICE m6 = new MICE(r6, 3);
		//m.runMICE();
		System.out.println(m6.runMICE());
		System.out.println("\n");
		//
		
		
		
		
		//Iniciar
		System.out.println("-La lista es de DiabetesPedigreeFunction es:");
		//Cambiamos los 0 por null
		List<Double> r7 = new ArrayList<>(cambiarValoresNaN(LeerFichero.DiabetesPedigreeFunction));
		System.out.println(r7);
		// Crear primero los objetos de la clase MICE
		MICE m7 = new MICE(r7, 3);
		//m.runMICE();
		System.out.println(m7.runMICE());
		System.out.println("\n");
		//
		
		
		
		
		//Iniciar
		System.out.println("-La lista es de Age es:");
		//Cambiamos los 0 por null
		List<Double> r8 = new ArrayList<>(cambiarValoresNaN(LeerFichero.Age));
		System.out.println(r8);
		// Crear primero los objetos de la clase MICE
		MICE m8 = new MICE(r8, 3);
		//m.runMICE();
		System.out.println(m8.runMICE());
		System.out.println("\n");
		//
		
		
		
		
		long endTime = System.nanoTime();
		System.out.println("Duracion: " + (endTime - startTime)/1e6 + " ms");
		
		
		
	}

	public static List<Double> cambiarValores(List<Double> l){
		for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == 0) {
                l.set(i, null);
            }
        }
		return l;
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
