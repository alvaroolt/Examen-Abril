package examenSegundoTrimestreJava.Ejercicio1.test;

import java.io.IOException;

import examenSegundoTrimestreJava.Ejercicio1.excepciones.IvaInvalidoException;
import examenSegundoTrimestreJava.Ejercicio1.excepciones.ParametroNoNumericoException;
import examenSegundoTrimestreJava.Ejercicio1.excepciones.ValorNoPositivoException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.Almacen;
import examenSegundoTrimestreJava.Ejercicio1.negocio.Articulo;
import examenSegundoTrimestreJava.Ejercicio1.negocio.IVA;
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

  public static void main(String[] args) throws ParametroNoNumericoException, ValorNoPositivoException,
      NumberFormatException, IOException, IvaInvalidoException {

    // Algunas instancias predefinidas.
    almacen.darAlta("Coca-Cola", 30, 45, 68,IVA.GENERAL);
    almacen.darAlta("Nestea", 22, 35, 40,IVA.REDUCIDO);
    almacen.darAlta("Fanta", 33, 42, 53, IVA.SUPER_REDUCIDO);

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
   */
  private static void ejecutaMenu()
      throws ParametroNoNumericoException, ValorNoPositivoException, NumberFormatException, IOException {

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
  private static void darAlta() throws ValorNoPositivoException, NumberFormatException, IOException {

    try {

      String descripcion = Teclado.leerCadena("Introduce una breve descripción del artículo:");

      double precioCompra = Teclado.leerDecimal("Precio de compra del artículo: ");

      double precioVenta = Teclado.leerDecimal("Precio de venta del artículo: ");

      int stock = Teclado.leerEntero("Cantidad del artículo en stock: ");

      IVA iva = elegirIVA();

      almacen.darAlta(descripcion, precioCompra, precioVenta, stock, iva);
      System.out.println("Artículo dado de alta correctamente.\n");

    } catch (ValorNoPositivoException e) {

      System.err.println("Hubo algún problema al añadir el artículo.\n" + e.getMessage());

    } catch (Exception e) {

      System.err.println("Introdujiste valores erróneos.");
    }
  }

  /**
   * método vacio que elimina un artículo del almacén
   */
  private static void darBaja() {

    try {

      int codigo = Teclado.leerEntero("Introduce el código identificador del artículo a eliminar: ");

      almacen.darBaja(codigo);

    } catch (Exception e) { // si no existe el codigo, salta el catch

      System.err.println("El artículo no se encuentra en el almacén.\n");

    }

  }

  /**
   * método vacio que permite modificar los valores de un artículo
   */
  private static void modificarArticulo() {

    try {

      int codigo = Teclado.leerEntero("Introduce el código identificador del artículo a modificar: ");
      Articulo articulo = almacen.getCodigo(codigo);

      String descripcion = Teclado.leerCadena("Introduce una breve descripción del artículo:");

      double precioCompra = Teclado.leerDecimal("Precio de compra del artículo: ");

      double precioVenta = Teclado.leerDecimal("Precio de venta del artículo: ");

      int stock = Teclado.leerEntero("Cantidad del artículo en stock: ");

      // menuIva();
      IVA iva = elegirIVA();

      almacen.modificarArticulo(articulo, descripcion, precioCompra, precioVenta, stock, iva);

    } catch (ValorNoPositivoException e) {

      System.err.println("Hubo algún problema al añadir el artículo.\n" + e.getMessage());

    } catch (Exception e) {

      System.err.println("Introdujiste valores erróneos.");
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

      int cantidad = Teclado
          .leerEntero("Introduce cuánto stock nuevo hay en el almacén (" + articulo.getStock() + " actuales): ");

      almacen.incrementarStock(codigo, cantidad);
      System.out.println("Stock añadido correctamente.");

    } catch (Exception e) {

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

      int cantidad = Teclado
          .leerEntero("Introduce cuánto stock se ha eliminado del almacén (" + articulo.getStock() + " actuales): ");

      almacen.decrementarStock(codigo, cantidad);
      System.out.println("Stock eliminado correctamente.");

    } catch (Exception e) {

      System.err.println("Hubo algún problema al decrementar el stock.\n" + e.getMessage());

    }
  }

  /**
   * Método con el cuál se comprueba que el valor del menú del IVA sea correcto.
   * 
   * @return numeroIVA
   * @throws NumberFormatException
   * @throws IOException
   */
  private static IVA elegirIVA() throws NumberFormatException, IOException {

    switch (menuIVA.gestionar()) {
    case 1:
      return IVA.GENERAL;

    case 2:
      return IVA.REDUCIDO;

    case 3:
      return IVA.SUPER_REDUCIDO;
    }

    return null;
  }

}