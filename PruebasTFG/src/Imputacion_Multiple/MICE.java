package Imputacion_Multiple;

import java.util.ArrayList;
import java.util.List;

public class MICE {
	
	List<Double> data; //Lista con datos faltantes 
	int numIterations; // Número de iteraciones para el algoritmo
	  
	// Constructor
	public MICE(List<Double> data, int numIterations) {
		this.data = data;
	    this.numIterations = numIterations;
	}
	  
	// Función que ejecuta el algoritmo MICE y devuelve la lista imputada
	public List<Double> runMICE() {
		
		// Iteramos cada variable individualmente para imputar los valores faltantes 
	    for(int i = 1; i <= numIterations; i++) {
	    	for(int j = 0; j < data.size(); j++) {
	    		double value = data.get(j);
	        
	    		// Si este valor ya está completo, saltamos al siguiente
	    		if(!Double.isNaN(value)) continue;
	        
	    		// Obtenemos los vecinos más cercanos y calculamos el promedio       
	    		int prevIndex = j-1;
	    		int nextIndex = j+1;
	    		while(Double.isNaN(data.get(prevIndex))) {
	    			prevIndex--;
	    		}
	    		while(Double.isNaN(data.get(nextIndex))) {
	    			nextIndex++;
	    		}
	        
	    		double prevValue = data.get(prevIndex);
	    		double nextValue = data.get(nextIndex);
	        
	    		double imputedValue = (prevValue + nextValue) / 2;
	        
	    		// Asignamos el valor imputado a la posición faltante en la lista
	    		data.set(j, imputedValue);
	      }
	    }
	    
	    // Devolvemos la lista con los valores faltantes completados
	    return data;
	  }

}
