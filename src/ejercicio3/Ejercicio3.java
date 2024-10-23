package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		BufferedWriter bw = null;

		BufferedReader br = null;

		String linea = "";
		
		String prueba ="";
		
		int contador=0;
		
		ArrayList<String> palabras = new ArrayList<String>();
		
		int principio=0;

		try {
			br = new BufferedReader(
					new FileReader("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\palabras.txt"));

			linea = br.readLine();

			while (linea != null) {

				
					for(int i =0;i<linea.length();i++) {
						
						if(Character.toUpperCase(linea.charAt(i))==linea.charAt(i)) {
							if(prueba.length()==0) {
								prueba+=linea.charAt(i);
							} else {
								palabras.add(prueba);
								prueba="";
								prueba+=linea.charAt(i);
							}
						} else {
							prueba+=linea.charAt(i);
						}
					}
					
					
				
			
				
				
				
				linea = br.readLine();
			}
			
			bw = new BufferedWriter(FileWriter())
			

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
