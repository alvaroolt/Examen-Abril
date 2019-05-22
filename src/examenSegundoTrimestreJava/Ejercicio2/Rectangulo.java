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
public class Rectangulo {

  // Atributos de rectangulo
  private int ancho;
  private int alto;

  /**
   * 
   * @param ancho
   * @param alto
   */
  public Rectangulo(int ancho, int alto) {
    setAncho(ancho);
    setAlto(alto);
  }

  /**
   * @return the ancho
   */
  public int getAncho() {
    return ancho;
  }

  /**
   * @param ancho the ancho to set
   */
  public void setAncho(int ancho) {
    if (ancho > 10 || ancho < 1) {
      throw new ArithmeticException("Ancho no válido.");
    }
    this.ancho = ancho;
  }

  /**
   * @return the alto
   */
  public int getAlto() {
    return alto;
  }

  /**
   * @param alto the alto to set
   */
  public void setAlto(int alto) {
    if (alto > 10 || alto < 1) {
      throw new ArithmeticException("Alto no válido.");
    }
    this.alto = alto;
  }

  @Override
  public String toString() {
    String mensaje = "";
    for (int i = 0; i < alto; i++) {
      for (int j = 0; j < ancho; j++) {
        // System.out.print("X");
        mensaje += "X";
      }
      mensaje += "\n";
    }
    return mensaje;
  }
}
