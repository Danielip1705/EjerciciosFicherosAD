package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

	// Método principal que se ejecuta al iniciar el programa
	public static void main(String[] args) {

		// Se crea un objeto File que representa la ruta de la carpeta especificada
		File ruta = new File("C:\\Users\\diglesias\\");

		// Variable para almacenar la ruta de la carpeta actual
		File carpetaActual = null;

		// Variable para almacenar los datos leídos del archivo
		String dato = "";

		// Variable que almacenará el contenido HTML
		String html = "";

		// Variable para representar el archivo que será creado
		File documento = null;

		// BufferedWriter para escribir en el archivo
		BufferedWriter bw = null;

		// BufferedReader para leer el archivo de texto
		BufferedReader br = null;

		try {
			// Se inicializa el BufferedReader para leer el archivo carpeta.txt
			br = new BufferedReader(
					new FileReader("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\carpeta.txt"));

			// Se lee la primera línea del archivo
			dato = br.readLine();

			// Bucle que se ejecuta mientras haya líneas en el archivo
			while (dato != null) {

				// Se crea un objeto File que representa el archivo Documento.html en la ruta
				// especificada
				documento = new File(ruta + "\\" + dato + "\\" + "Documento.html");

				// Se crea un objeto File que representa la carpeta actual
				carpetaActual = new File(ruta + "\\" + dato);

				// Si el archivo Documento.html no existe, se crea uno nuevo
				if (!documento.exists()) {
					// Se inicializa el BufferedWriter para escribir en el archivo
					bw = new BufferedWriter(new FileWriter(documento, true));

					// Se genera el contenido HTML que se escribirá en el archivo
					html = "<html>\n" + "		<head>\n" + "			<title>" + dato + "</title>\n"
							+ "		</head>\n" + "		<body>\n" + "			<h1>" + documento + "</h1>\n"
							+ "			<h3> Daniel Iglesias Prieto</h3>\n" + "		</body>\n" + "</html>";

					// Se escribe el contenido HTML en el archivo
					bw.write(html);

					// Se vacía el buffer y se guarda el contenido en el archivo
					bw.flush();

					// Mensaje indicando que el archivo HTML se creó con éxito
					System.out.println("Documento html creado con exito en la ruta: " + carpetaActual);
				} else {
					// Mensaje indicando que el archivo ya existe
					System.out.println("El documento html ya existe en la ruta: " + carpetaActual);
				}

				// Se lee la siguiente línea del archivo
				dato = br.readLine();
			}

			// Se cierra el BufferedReader y BufferedWriter
			br.close();
			bw.close();

		} catch (IOException e) {
			// Manejo de excepción en caso de que ocurra un error al modificar el archivo
			System.out.println("Fichero no se puede modificar");
		} catch (NullPointerException e) {
			// Manejo de excepción en caso de un puntero nulo
			System.out.println();
		}
	}

}
