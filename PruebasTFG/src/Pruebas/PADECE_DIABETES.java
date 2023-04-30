package Pruebas;

import java.util.List;

public class PADECE_DIABETES {

	 private List<Double> embarazos;
	 private List<Double> glucosa;
	 private List<Double> bloodPressure;
	 private List<Double> grosorPiel;
	 private List<Double> insulina;
	 private List<Double> bmi;
	 private List<Double> diabetesPedigreeFunction;
	 private List<Double> edad;

	 public PADECE_DIABETES(List<Double> embarazos, List<Double> glucosa, List<Double> bloodPressure,
	                    List<Double> grosorPiel, List<Double> insulina, List<Double> bmi,
	                    List<Double> diabetesPedigreeFunction, List<Double> edad) {
	        this.embarazos = embarazos;
	        this.glucosa = glucosa;
	        this.bloodPressure = bloodPressure;
	        this.grosorPiel = grosorPiel;
	        this.insulina = insulina;
	        this.bmi = bmi;
	        this.diabetesPedigreeFunction = diabetesPedigreeFunction;
	        this.edad = edad;
	 }

	    public boolean padeceDiabetes() {
	        // Calcular el riesgo de diabetes en base a los datos de cada paciente
	        double sum = 0;
	        for (int i = 0; i < embarazos.size(); i++) {
	            sum += (glucosa.get(i) * 0.0031)
	                    + (bloodPressure.get(i) * 0.008)
	                    + (grosorPiel.get(i) * 0.1)
	                    + (insulina.get(i) * 0.00019)
	                    + (bmi.get(i) * 0.15)
	                    + (diabetesPedigreeFunction.get(i) * 1.13)
	                    + (edad.get(i) * 0.02)
	                    - 3.53;
	        }
	        double media = sum / embarazos.size();

	        // Si el riesgo de diabetes es mayor a 0, entonces el paciente la padece
	        return media > 0;
	    }
	
	

}
