package ejercicio7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.foreign.ValueLayout;
import java.util.Random;

public class Ejercicio7 {

	public static void main(String[] args) {

		// Definir una variable para almacenar el valor del byte leído del archivo
		byte letraLeida = 0;

		// Inicializar las variables de posición de lectura, longitud de lectura y
		// longitud de escritura
		long posLectura = 0;
		long longitudLec = 0;
		long longitudEsc = 0;

		// Declarar los objetos RandomAccessFile para lectura y escritura de archivos
		RandomAccessFile lec = null;
		RandomAccessFile esc = null;

		try {
			// Abrir el archivo de lectura en modo solo lectura ("r")
			lec = new RandomAccessFile(
					"C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio7\\lecturaAbcNum.txt",
					"r");

			// Abrir el archivo de escritura en modo lectura y escritura ("rw")
			esc = new RandomAccessFile(
					"C:\\Users\\diglesias\\eclipse-workspace\\EjercicioFicheros\\src\\ejercicio7\\escrituraAbcNum.txt",
					"rw");

			// Obtener la longitud total del archivo de lectura
			longitudLec = lec.length();

			// Iniciar la posición de lectura desde el último byte del archivo
			posLectura = longitudLec - 1;

			// bucle que recorre el archivo de lectura desde el final hacia el principio
			while (posLectura >= 0) {
				// Colocar el puntero de lectura en la posición deseada
				lec.seek(posLectura);

				// Leer el byte en la posición actual
				letraLeida = lec.readByte();

				// Si el carácter leído es un dígito
				if (Character.isDigit((char) letraLeida)) {
					// Mover el puntero al byte anterior
					lec.seek(posLectura - 1);

					// Leer el byte en la nueva posición
					letraLeida = lec.readByte();
				}
				// Si el carácter leído es una letra
				else if (Character.isLetter(letraLeida)) {
					// Mover el puntero al siguiente byte
					lec.seek(posLectura + 1);

					// Leer el byte en la nueva posición
					letraLeida = lec.readByte();
				}

				// Obtener la longitud actual del archivo de escritura
				longitudEsc = esc.length();

				// Colocar el puntero de escritura al final del archivo
				esc.seek(longitudEsc);

				// Escribir el byte leído en el archivo de escritura
				esc.writeByte(letraLeida);

				// Decrementar la posición de lectura para continuar al siguiente byte
				posLectura--;

				// Si el byte leído es un salto de línea ('\n'), mover el puntero un byte más
				// atrás
				if (letraLeida == '\n') {
					posLectura--;
				}
			}

			// Cerrar el archivo de lectura
			lec.close();

			// Cerrar el archivo de escritura
			esc.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
