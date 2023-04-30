package Otros;

import java.util.ArrayList;
import java.util.List;

public class MediaAritmetica {
	
	public static void main (String [] args) {
		System.out.println("Media aritmetica para una lista de enteros: ");
		List<Integer> ls = new ArrayList<>();
		ls.add(2);
		ls.add(3);
		ls.add(4);
		System.out.println(mediaAritmeticaListaEntera(ls));
		
		System.out.println("Media aritmetica para una lista de double: ");
		List<Double> listaDouble = new ArrayList<>();
		listaDouble.add(2.1);
		listaDouble.add(3.2);
		listaDouble.add(4.3);
		System.out.println(mediaAritmeticaListaDouble(listaDouble));		
	}
	
	
	public static Double mediaAritmeticaListaEntera(List<Integer> ls) {
		Double res = 0.;
		Integer suma = 0;
		for(int i = 0; i < ls.size(); i++) {
			suma = suma + ls.get(i);
		}
		Integer media = suma/ls.size();
		res = media*1.0;
		return res;
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
