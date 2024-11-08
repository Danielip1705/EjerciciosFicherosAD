package ejercicio6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio6 {

	public static void main(String[] args) {

		// Se declaran las variables necesarias para manejar las longitudes de los
		// archivos,
		// las posiciones para la lectura y escritura, y la variable para almacenar el
		// byte leído.
		long longitudLec = 0;
		long longitudEsc = 0;
		long lecPosicion = 0;
		byte letraLeida = 0;

		// Definir las rutas de los archivos
		File archivotxt = new File(
				"C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio6\\lecturaAbc.txt");
		File escrituraTxt = new File(
				"C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio6\\escrituraAbc.txt");

		// Se declaran las variables para los objetos RandomAccessFile que se utilizarán
		// para leer y escribir en los archivos.
		RandomAccessFile lec = null;
		RandomAccessFile escritura = null;
		
		BufferedWriter bw = null;

		try {

			// Creamos el archivo de lectura y escribimos datos en él
			bw = new BufferedWriter(new FileWriter(archivotxt));
			bw.write("a");
			bw.newLine();
			bw.write("b");
			bw.newLine();
			bw.write("c");
			bw.newLine();
			bw.write("d");
			bw.newLine();
			bw.write("e");
			bw.flush();
			bw.close();
			bw = new BufferedWriter(new FileWriter(escrituraTxt));
			bw.close();
			// Abrimos los archivos: 'lecturaAbc.txt' en modo solo lectura ('r') y
			// 'escrituraAbc.txt' en modo lectura/escritura ('rw').
			lec = new RandomAccessFile(archivotxt, "r");
			escritura = new RandomAccessFile(escrituraTxt, "rw");

			// Se obtiene la longitud del archivo de lectura (cantidad de bytes).
			longitudLec = lec.length();

			// Se establece la posición de lectura al último byte del archivo.
			lecPosicion = longitudLec - 1;

			// Iniciamos un bucle para leer el archivo de lectura de atrás hacia adelante.
			while (lecPosicion >= 0) {
				// Movemos el puntero del archivo de lectura a la posición actual.
				lec.seek(lecPosicion);
				// Leemos el byte en la posición actual.
				letraLeida = lec.readByte();

				// Se obtiene la longitud del archivo de escritura para escribir al final.
				longitudEsc = escritura.length();

				// Movemos el puntero del archivo de escritura al final del archivo.
				escritura.seek(longitudEsc);

				// Escribimos el byte leído en el archivo de escritura.
				escritura.writeByte(letraLeida);

				// Decrementamos la posición de lectura para leer el siguiente byte hacia atrás.
				lecPosicion--;

				// Si el byte leído es un salto de línea ('\n'), retrocedemos una posición más,
				// para evitar copiar el salto de línea extra.
				if (letraLeida == '\n') {

					lecPosicion--;
				}
			}
			// Se cierran ambos archivos después de finalizar las operaciones.
			lec.close();
			escritura.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
