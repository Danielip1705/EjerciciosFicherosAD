package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Ejercicio5 {

	public static void main(String[] args) {
		// Se declaran las variables necesarias para almacenar la longitud del archivo,
		// posicion para escritura, y la variable para almacenar
		// la letra leída del archivo.
		long longitud = 0;
		long posEscritura = 0;
		byte letraLeida = 0;
		
		File archivotxt = new File("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio5\\textoA.txt");
		File escrituraTxt = new File("C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio5\\escribirA.txt");
	
		BufferedWriter bw = null;
		// Se crea un objeto Random para generar números aleatorios.
		Random rand = new Random();

		try {
			//Creamos documento en el cual se va a leer
			bw = new BufferedWriter(new FileWriter(archivotxt));
			//Escribimos a
			bw.write("a");
			//Vaciamos bw
			bw.flush();
			//Cerramos bw
			bw.close();
			//Creamos documento de escritura
			bw = new BufferedWriter(new FileWriter(escrituraTxt));
			// Se abren dos archivos: uno en modo solo lectura ('r') y otro en modo
			// lectura/escritura ('rw').
			RandomAccessFile lectura = new RandomAccessFile(
					archivotxt, "r");
			RandomAccessFile escribir = new RandomAccessFile(
					escrituraTxt, "rw");

			// Se obtiene la longitud del archivo de lectura para saber hasta dónde se puede
			// leer.
			longitud = lectura.length();

			// Bucle que se ejecuta 5 veces, para realizar 5 lecturas/escrituras aleatorias.
			for (int i = 0; i < 5; i++) {

				// Se mueve el puntero de lectura a la posición aleatoria generada.
				lectura.seek(0);

				// Se lee un byte de datos desde la posición aleatoria en el archivo de lectura.
				letraLeida = lectura.readByte();
				
				// Se mueve el puntero del archivo de escritura a la posición
				// generada.
				escribir.seek(i);

				// Se escribe el byte leído en la posición generada del archivo de escritura.
				escribir.writeByte(letraLeida);
			}

			// Se cierran ambos archivos después de realizar las operaciones de lectura y
			// escritura.
			escribir.close();
			lectura.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

}
