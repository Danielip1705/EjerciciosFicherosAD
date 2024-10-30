package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Inicializamos el BufferedWriter y BufferedReader como nulos
		BufferedWriter bw = null;
		BufferedReader br = null;
		// Archivo file que crea un documento de texto
		File archivotxt = new File("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\PalabrasModificadas.txt");
		// Variables para almacenar líneas y palabras
		String linea = "";
		String cadenaLinea = "";
		ArrayList<String> palabras = new ArrayList<String>();

		try {
			// Creamos un BufferedReader para leer el archivo de entrada
			br = new BufferedReader(
					new FileReader("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\palabras.txt"));

			// Leemos la primera línea del archivo
			linea = br.readLine();

			// Iteramos mientras haya líneas para leer
			while (linea != null) {
				// Iteramos sobre cada carácter de la línea
				for (int i = 0; i < linea.length(); i++) {
					// Comprobamos si el carácter es una letra mayúscula
					if (Character.isUpperCase(linea.charAt(i))) {
						// Si 'prueba' está vacío, iniciamos una nueva palabra
						if (cadenaLinea.length() == 0) {
							cadenaLinea += linea.charAt(i);
						} else {
							// Si 'prueba' no está vacío, agregamos la palabra a la lista
							palabras.add(cadenaLinea);
							cadenaLinea = ""; // Reiniciamos 'prueba'
							cadenaLinea += linea.charAt(i); // Agregamos la mayúscula actual
						}
					} else {
						// Si no es mayúscula, continuamos construyendo la palabra
						cadenaLinea += linea.charAt(i);
					}
				}
				// Leemos la siguiente línea del archivo
				linea = br.readLine();
			}

			// Creamos un BufferedWriter para escribir en el archivo de salida
			bw = new BufferedWriter(new FileWriter(archivotxt));
			// Escribimos cada palabra en el archivo de salida
			for (int i = 0; i < palabras.size(); i++) {
				bw.write(palabras.get(i));
				bw.newLine(); // Agregamos una nueva línea
			}

			// Aseguramos que todos los datos se escriban en el archivo
			bw.flush();
			// Cerramos el BufferedWriter
			bw.close();
			// Imprimimos la lista de palabras procesadas en consola
			System.out.println(palabras);
			// Capturamos la expepcion IOException
		} catch (IOException e) {
			// Manejo de excepciones en caso de errores de entrada/salida
			System.out.println(e);
		}

	}

}
