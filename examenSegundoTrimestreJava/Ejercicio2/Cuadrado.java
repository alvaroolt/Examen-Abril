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
public class Cuadrado extends Rectangulo implements Comparable<Cuadrado> {

	// Atributos de cuadrado
	private int lado;

	/**
	 * Constructor de Cuadrado
	 * 
	 * @param lado
	 */
	public Cuadrado(int lado) {
		super(lado, lado);
		setLado(lado);
	}

	/**
	 * getter
	 * 
	 * @return lado
	 */
	public int getLado() {
		return this.lado;
	}

	/**
	 * setter
	 * 
	 * @param lado
	 */
	public void setLado(int lado) {
		this.lado = lado;
	}

	/**
	 * toString()
	 */
	@Override
	public String toString() {
		String mensaje = "";
		System.out.println("La figura impresa es la siguiente:");
		for (int i = 0; i < getAlto(); i++) {
			for (int j = 0; j < getAlto(); j++) {
				mensaje += "X";
			}
			mensaje += "\n";
		}
		return mensaje;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lado;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuadrado other = (Cuadrado) obj;
		if (lado != other.lado)
			return false;
		return true;
	}

	@Override
	public int compareTo(Cuadrado other) {
		if (this.getLado() == other.getLado()) {
			return 0;
		} else if (this.getLado() < other.getLado()) {
			return -1;
		} else {
			return 1;
		}
	}

	// public void compararCuadrados(Cuadrado cuadrado) {
	//
	// if(this.getAlto() > cuadrado.getAlto()) {
	// System.out.println("Tu cuadrado es más grande.");
	// } else if(this.getAlto() < cuadrado.getAlto()) {
	// System.out.println("El otro cuadrado es más grande.");
	// } else {
	// System.out.println("Los cuadrados son igual de grandes.");
	// }
	// }

}
