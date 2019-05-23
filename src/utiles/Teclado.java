package utiles;
 
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

  static private Scanner sc = new Scanner(System.in);

  /**
   * Lee un carácter del teclado
   * 
   * @return carácter introducido por el usuario
   * @throws IOException
   */
  public static char leerCaracter() throws IOException {
    char caracter;
    try {
      caracter = leerCadena().charAt(0);
    } catch (InputMismatchException e) {
      caracter = 0;
    }
    return caracter;
  }

  /**
   * Lee un carácter del teclado
   * 
   * @param msj: mensaje mostrado al usuario
   * @return carácter introducido por el usuario
   * @throws IOException
   */
  public static char leerCaracter(String msj) throws IOException {
    System.out.println(msj);
    return leerCaracter();
  }

  /**
   * Lee una cadena del teclado
   * 
   * @param msj: mensaje mostrado al usuario
   * @return cadena introducida por el usuario
   * @throws IOException
   */
  public static String leerCadena(String msj) throws IOException {
    System.out.println(msj);
    return leerCadena();
  }

  /**
   * Lee una cadena del teclado
   * 
   * @return cadena introducida por el usuario
   * @throws IOException
   */

  public static String leerCadena() throws IOException {
    return sc.nextLine();
  }

  /**
   * Lee un entero del teclado
   * 
   * 
   * @return entero introducido por el usuario
   * @throws IOException
   * @throws NumberFormatException
   * @throws EnteroNoValidoException
   */
  public static int leerEntero() throws NumberFormatException, IOException, EnteroNoValidoException {
    try {
      return Integer.parseInt(leerCadena().trim()); // Quita los espacios del String y convierte a int
    } catch (NumberFormatException e) {
      throw new EnteroNoValidoException("Introduce un entero.");
    }
  }

  /**
   * Lee una entero del teclado
   * 
   * @param msj: mensaje mostrado al usuario
   * @return entero introducida por el usuario
   * @throws IOException
   * @throws NumberFormatException
   */
  public static int leerEntero(String msj) throws NumberFormatException, IOException, EnteroNoValidoException {
    System.out.println(msj);
    return leerEntero();
  }

  /**
   * Lee un decimal del teclado
   * 
   * @return decimal introducido por el usuario
   * @throws IOException
   * @throws NumberFormatException
   */
  public static double leerDecimal() throws NumberFormatException, IOException {
    try {
      return Double.parseDouble(leerCadena().trim()); // Quita los espacios del String y convierte a double
    } catch (InputMismatchException e) {
      throw new NumberFormatException("Introduzca un número decimal.");
    }
  }

  /**
   * Lee una decimal del teclado
   * 
   * @param msj: mensaje mostrado al usuario
   * @return decimal introducida por el usuario
   * @throws IOException
   * @throws NumberFormatException
   */
  public static double leerDecimal(String msj) throws NumberFormatException, IOException {//
    System.out.println(msj);
    return leerDecimal();
  }

  /**
   * Pregunta al usuario si desea continuar con la ejecución del programa
   * 
   * @return falso si el caracter introducido es distinto de S/s
   * @throws IOException
   */
  public static boolean deseaContinuar() throws IOException {
    char caracterIntroducido = Teclado.leerCaracter("\nDesea continuar? (s/n)");
    if (caracterIntroducido == 's' || caracterIntroducido == 'S')
      return true;
    else
      return false;
  }

}
