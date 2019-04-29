package examenSegundoTrimestreJava.Ejercicio2;

/**
 * Crea la clase Rectángulo de forma que: • Un objeto de esta clase se construye
 * pasándole el ancho y el alto. Ninguno de los dos atributos puede ser menor o
 * igual a cero ni mayor que diez, en esos casos se debe lanzar la excepción
 * ArithmeticException. • Mediante getters y setters permite que se acceda y se
 * modifique el ancho y el alto del rectángulo teniendo en cuenta las
 * restricciones en cuanto a las dimensiones del apartado anterior. • Al
 * imprimir en pantalla un objeto de la clase usando System.out.print se debe
 * dibujar el rectángulo por la pantalla (de manera similar a como se imprime un
 * cuadrado en la página 130 del libro Aprende Java con Ejercicios). • Crea la
 * clase Cuadrado como subclase de Rectángulo. Le debes añadir a su
 * comportamiento la posibilidad de comparar objetos cuadrados entre sí. • Crea
 * los programas de test correspondientes a ambas clases. Debes provocar que se
 * lance la excepción y capturarla.
 * 
 * @author Álvaro Leiva Toledano
 * @version 1.0
 *
 */
public class TestCuadrado {

	public static void main(String[] args) {

		try {

			Cuadrado cuadrado1 = new Cuadrado(6);
			Cuadrado cuadrado2 = new Cuadrado(5);
			// Cuadrado cuadrado3 = new Cuadrado(5);

			System.out.println(cuadrado1);
			System.out.println(cuadrado2);

			if (cuadrado1.compareTo(cuadrado2) == 0) {
				System.out.println("Cuadrados 1 y 2 iguales.");

			} else if (cuadrado1.compareTo(cuadrado2) < 0) {
				System.out.println("Cuadrado 1 menor que cuadrado 2.");

			} else {
				System.out.println("Cuadrado 1 mayor que cuadrado 2.");
			}

			// cuadrado2.compareTo(cuadrado1);
			// cuadrado1.compareTo(cuadrado3);

		} catch (ArithmeticException e) {

			System.err.println("ERROR. " + e.getMessage());
		}
	}

}
