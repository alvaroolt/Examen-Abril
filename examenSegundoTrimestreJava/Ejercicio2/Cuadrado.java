package examenSegundoTrimestreJava.Ejercicio2;

import coleccionesYDiccionarios.ejercicio8.Carta;

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
 */
public class Cuadrado extends Rectangulo {

	// Atributos de cuadrado
	private int lado;

	public Cuadrado(int ancho, int alto) {
		super(ancho, alto);

		setAncho(ancho);
		setAlto(alto);
		
		if (ancho != alto) {
			throw new ArithmeticException("Los parámetros han de ser iguales.");
		}

	}

	@Override
	public void imprimirFigura() {

		System.out.println("El cuadrado impreso es el siguiente:");
		for (int i = 0; i < getAlto(); i++) {
			for (int j = 0; j < getAlto(); j++) {
				System.out.print("X");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void compararCuadrados(Cuadrado cuadrado) {
		
		if(this.getAlto() > cuadrado.getAlto()) {
			System.out.println("Tu cuadrado es más grande.");
		} else if(this.getAlto() < cuadrado.getAlto()) {
			System.out.println("El otro cuadrado es más grande.");
		} else {
			System.out.println("Los cuadrados son igual de grandes.");
		}
	}

}
