package examenSegundoTrimestreJava.Ejercicio1.test;

import java.io.IOException;

import examenSegundoTrimestreJava.Ejercicio1.negocio.Almacen;
import examenSegundoTrimestreJava.Ejercicio1.negocio.Articulo;
import examenSegundoTrimestreJava.Ejercicio1.negocio.IVA;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.ArticuloNoExisteException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.IvaInvalidoException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.ParametroNoNumericoException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.ValorNoPositivoException;
import utiles.EnteroNoValidoException;
import utiles.Menu;
import utiles.Teclado;

/**
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). La entrada y salida de mercancía supone respectivamente
 * el incremento y decremento de stock de un determinado artículo. Hay que
 * controlar que no se pueda sacar más mercancía de la que hay en el almacén.
 * 
 * @author Álvaro Leiva Toledano
 * @version 1.0
 */
public class TestAlmacen {

  // objeto almacen
  static Almacen almacen = new Almacen();

  public static void main(String[] args) {

    try {
      // Algunas instancias predefinidas.
      almacen.darAlta("Coca-Cola", 30, 45, 68, IVA.GENERAL);
      almacen.darAlta("Nestea", 22, 35, 40, IVA.REDUCIDO);
      almacen.darAlta("Fanta", 33, 42, 53, IVA.SUPER_REDUCIDO);
    } catch (ValorNoPositivoException | IvaInvalidoException e) {
      System.err.println("Aquí nunca va a entrar.");
    }

    ejecutaMenu();

  }

  /**
   * Menú principal de la aplicación
   */
  static Menu menuPrincipal = new Menu(" -- ALMACÉN -- ", new String[] { "Mostrar el listado.", "Dar de alta.",
      "Dar de baja.", "Modificación.", "Entrada de mercancía.", "Salida de mercancía.", "Salir." });

  /**
   * Menú para elegir el IVA del artículo
   */
  static Menu menuIVA = new Menu(" -- IVA -- ", new String[] { "General", "Reducido", "Súper reducido" });

  /**
   * método vacio que finaliza el programa
   */
  private static void finalizarPrograma() {

    System.out.println("Fin de programa.");
    System.exit(0);

  }

  /**
   * método vacio que ejecuta el menú junto a mostrarMenu() y elegirOpcion()
   * 
   * @throws ParametroNoNumericoException
   * @throws ValorNoPositivoException
   * @throws IOException
   * @throws NumberFormatException
   * @throws EnteroNoValidoException
   */
  private static void ejecutaMenu() {

    do {

      switch (menuPrincipal.gestionar()) {

      case 1:
        System.out.println(almacen);
        break;

      case 2:
        darAlta();
        break;

      case 3:
        darBaja();
        break;

      case 4:
        modificarArticulo();
        break;

      case 5:
        incrementarStock();
        break;

      case 6:
        decrementarStock();
        break;

      case 7:
        finalizarPrograma();
        break;

      // si el switch no entra en ningún case, entra en default
      default:
        System.out.println("No introdujiste una opción correcta. Inténtalo de nuevo.\n");
        break;
      }
    } while (true);

  }

  /**
   * método vacio que añade un nuevo artículo al almacén
   * 
   * @throws IOException
   * @throws NumberFormatException
   */
  private static void darAlta() {

    try {

      almacen.darAlta(Teclado.leerCadena("Introduce una breve descripción del artículo:"),
          Teclado.leerDecimal("Precio de compra del artículo: "), Teclado.leerDecimal("Precio de venta del artículo: "),
          Teclado.leerEntero("Cantidad del artículo en stock: "), elegirIVA());
      System.out.println("Artículo dado de alta correctamente.\n");

    } catch (ValorNoPositivoException | IvaInvalidoException | NumberFormatException | EnteroNoValidoException e) {

      System.err.println("Error al añadir el artículo.\n" + e.getMessage());

//    } catch (Exception e) {
//
//      System.err.println("Introdujiste valores erróneos.");
    }
  }

  /**
   * método vacio que elimina un artículo del almacén
   */
  private static void darBaja() {

    try {

      almacen.darBaja(Teclado.leerEntero("Introduce el código identificador del artículo a eliminar: "));

    } catch (ArticuloNoExisteException | NumberFormatException | EnteroNoValidoException e) { // si no existe el codigo,
                                                                                              // salta el catch
      System.err.println("El artículo no se encuentra en el almacén. " + e.getMessage());

    }

  }

  /**
   * método vacio que permite modificar los valores de un artículo
   */
  private static void modificarArticulo() {

    try {

      almacen.modificarArticulo(
          almacen.getCodigo(Teclado.leerEntero("Introduce el código identificador del artículo a modificar: ")),
          Teclado.leerCadena("Introduce una breve descripción del artículo:"),
          Teclado.leerDecimal("Precio de compra del artículo: "), Teclado.leerDecimal("Precio de venta del artículo: "),
          Teclado.leerEntero("Cantidad del artículo en stock: "), elegirIVA());

    } catch (ArticuloNoExisteException | ValorNoPositivoException | NumberFormatException | EnteroNoValidoException
        | IvaInvalidoException e) {

      System.err.println("Error al modificar el artículo. " + e.getMessage());
    }
  }

  /**
   * método vacio que incrementa el stock según el parámetro codigo que le envie
   * el usuario
   */
  private static void incrementarStock() {

    try {

      int codigo = Teclado.leerEntero("Introduce el código identificador del artículo a aumentar el stock: ");

      Articulo articulo = almacen.getCodigo(codigo);

      almacen.incrementarStock(codigo, Teclado
          .leerEntero("Introduce cuánto stock nuevo hay en el almacén (" + articulo.getStock() + " actuales): "));
      System.out.println("Stock añadido correctamente.");

    } catch (ArticuloNoExisteException | EnteroNoValidoException | ValorNoPositivoException e) {

      System.err.println("Hubo algún problema al incrementar el stock.\n" + e.getMessage());

    }
  }

  /**
   * método vacio que decrementa el stock según el parámetro codigo que le envie
   * el usuario
   */
  private static void decrementarStock() {

    try {

      int codigo = Teclado.leerEntero("Introduce el código identificador del artículo a disminuir el sotck: ");

      Articulo articulo = almacen.getCodigo(codigo);

      almacen.decrementarStock(codigo, Teclado
          .leerEntero("Introduce cuánto stock se ha eliminado del almacén (" + articulo.getStock() + " actuales): "));
      System.out.println("Stock eliminado correctamente.");

    } catch (ArticuloNoExisteException | EnteroNoValidoException | ValorNoPositivoException e) {

      System.err.println("Hubo algún problema al decrementar el stock.\n" + e.getMessage());

    }
  }

  /**
   * Método con el cuál se comprueba que el valor del menú del IVA sea correcto.
   * 
   * @return numeroIVA
   * @throws NumberFormatException
   * @throws IOException
   * @throws EnteroNoValidoException
   */
  private static IVA elegirIVA() {

    switch (menuIVA.gestionar()) {
    case 1:
      return IVA.GENERAL;

    case 2:
      return IVA.REDUCIDO;

    default:
      return IVA.SUPER_REDUCIDO;
    }

  }

}