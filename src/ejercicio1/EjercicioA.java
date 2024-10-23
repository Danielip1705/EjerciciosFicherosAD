package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioA {

	public static void main(String[] args) {
		// Se crea un objeto File que representa la carpeta personal en la ruta
		// especificada
		File dir = new File("C:\\Users\\diglesias");

		// Variable para almacenar cada línea leída del archivo carpeta.txt
		String linea = "";

		// Variable para crear una nueva carpeta
		File crearCarpeta = null;

		// Variable para leer el archivo
		BufferedReader lec = null;

		try {
			// Se inicializa el BufferedReader para leer el archivo "carpeta.txt", para eso pondremos la ruta absoluta donde se encuentra el archivo
			lec = new BufferedReader(new FileReader("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\carpeta.txt"));

			// Leemos la primera línea del archivo
			linea = lec.readLine();

			// Bucle que continúa mientras haya líneas en el archivo
			while (linea != null) {
				// Crea un nuevo objeto File que representa la nueva carpeta en la ruta
				// especificada
				crearCarpeta = new File(dir, linea);

				// Verificamos si la carpeta no existe
				if (!crearCarpeta.exists()) {
					// Creamos la carpeta
					if (crearCarpeta.mkdir()) {
						// Si se crea con éxito, se imprime un mensaje de confirmación
						System.out.println("Se ha creado la carpeta " + linea + " en la ruta " + dir);
					}
				} else {
					// Si la carpeta ya existe, se imprime un mensaje informando
					System.out.println("El fichero " + crearCarpeta + " ya existe");
				}

				// Lee la siguiente línea del archivo
				linea = lec.readLine();
				
			} // Fin bucle while
			
			// Cerramos el BufferedReader
			lec.close();

		} catch (FileNotFoundException e) {
			// Manejo de excepciones para el caso en que no se encuentra el archivo
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			// Manejo de excepciones para errores de entrada/salida
			System.out.println("Error al leer el fichero");
		}

	}
}