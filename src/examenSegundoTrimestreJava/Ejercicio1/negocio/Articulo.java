package examenSegundoTrimestreJava.Ejercicio1.negocio;

import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.ArticuloNoExisteException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.IvaInvalidoException;
import examenSegundoTrimestreJava.Ejercicio1.negocio.excepciones.ValorNoPositivoException;

/**
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). La entrada y salida de mercancía supone respectivamente
 * el incremento y decremento de stock de un determinado artículo. Hay que
 * controlar que no se pueda sacar más mercancía de la que hay en el almacén.
 * 
 * Partiendo del enunciado del libro, vamos a planificar el diseño de la
 * aplicación antes de implementarla:
 * 
 * Necesito una clase Articulo que representa a los artículos del almacén. Su
 * estado será: código, descripción, precio de compra, precio de venta y número
 * de unidades (nunca negativas). Como comportamiento: Considero que el código
 * va a generarse de forma automática en el constructor, así no puede haber dos
 * artículos con el mismo código. Esto implica que no puede modificarse el
 * código de un artículo. Sí el resto de las propiedades. Podremos mostrar el
 * artículo, por lo que necesito una representación del artículo en forma de
 * cadena (toString) Clase Almacen que realice el alta, baja, modificación,
 * entrada de mercancía (incrementa unidades), salida de mercancía (decrementa
 * unidades) El estado será un ArrayList de artículos. Esta clase es un
 * envoltorio de un ArrrayList. Su comportamiento será: añadir artículos (no
 * puede haber dos artículos iguales), eliminar artículos, incrementar las
 * existencias de un articulo (se delega en la clase artículo), decrementar las
 * existencias de un artículo (nunca por debajo de cero, se delega en la clase
 * artículo), devolver un artículo (para mostrarlo). Para listar el almacén
 * podría devolverse una cadena con todos los artículos del almacén (toString)
 * Clase TestAlmacen, donde se realiza la comunicación con el usuario (mostrar
 * menú y recuperar opción del menú, mostrar errores, listar) y se manipula el
 * almacén. Debes organizarla en métodos que deleguen en la clase almacén
 * (listar, annadir, eliminar... al menos uno por cada una de las opciones del
 * menú).
 * 
 * ----------------------------- Añade el tipo de IVA a la clase Artículo usada
 * en la clase Almacén hecha en clase y modifica el código necesario para poder
 * aplicarlo: • Recuerda que hay tres tipos de IVA: general, reducido y super
 * reducido. • Solicita el tipo de IVA mediante un menú. Al objeto lo llamarás
 * menuIva. • Añade el IVA tanto a la opción de alta como a la de modificación
 * de artículo en la clase Almacén y en aquellos otras clases que sea necesario.
 * • En la clase Artículo, en caso de que el iva sea null lanzarás una excepción
 * IvaInvalidoException. • Actualiza el estado/comportamiento de la(s) clase(s)
 * afectada(s). -----------------------------
 * 
 * @author Álvaro Leiva Toledano
 * @version 1.0
 *          {@link https://github.com/alvaroolt/POO3/tree/master/ejerciciosPOO3/gestisimalOrientadoAObjetos}
 */

public class Articulo {

  // variable estática que utilizo para obtener el codigo de cada articulo
  private static int contador = 1;

  // atributos del Articulo
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  private IVA iva;

  // constructor
  /**
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws ValorNoPositivoException
   * @throws IvaInvalidoException
   */
  public Articulo(String descripcion, double precioCompra, double precioVenta, int stock, IVA iva)
      throws ValorNoPositivoException, IvaInvalidoException {

    setCodigo(generaCodigo());
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setIVA(iva);
    // compruebaStrock();

  }

  private void setIVA(IVA iva) throws IvaInvalidoException { // setter IVA

    if (iva == null) {
      throw new IvaInvalidoException("Iva no válido.");
    }
    this.iva = iva;

  }

  public IVA getIVA() { // getter IVA
    return iva;
  }

  // constructor (2)
  public Articulo(int codigo) {
    setCodigo(codigo);
  }

  public int getCodigo() {
    return codigo;
  }

  private void setCodigo(int codigoId) {
    this.codigo = codigoId;
  }

  public String getDescripcion() {
    return descripcion;
  }

  private void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  private void setPrecioCompra(double precioCompra) throws ValorNoPositivoException {
    if (precioCompra < 0)
      throw new ValorNoPositivoException("Precio de compra no puede ser negativo.");

    this.precioCompra = precioCompra;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  private void setPrecioVenta(double precioVenta) throws ValorNoPositivoException {
    if (precioVenta < 0)
      throw new ValorNoPositivoException("Precio de venta no puede ser negativo.");
    this.precioVenta = precioVenta;
  }

  public int getStock() {
    return stock;
  }

  /**
   * 
   * @param stock
   * @throws ValorNoPositivoException
   */
  void setStock(int stock) throws ValorNoPositivoException {
    if (stock < 0)
      throw new ValorNoPositivoException("Stock no puede ser negativo.");
    this.stock = stock;
  }

  /**
   * método que genera un código para cada artículo de forma automática
   * 
   * @return int
   */
  private int generaCodigo() {
    return contador++;
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
    result = prime * result + codigo;
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
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  /**
   * metodo vacio que modifica un articulo; todo salvo el codigo.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws ValorNoPositivoException
   * @throws IvaInvalidoException
   */
  public void modificarArticulo(String descripcion, double precioCompra, double precioVenta, int stock, IVA iva)
      throws ValorNoPositivoException, IvaInvalidoException {
    setStock(stock);
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setIVA(iva);

  }

  /**
   * metodo vacio que incrementa el stock
   * 
   * @param cantidad
   * @throws ValorNoPositivoException
   */
  void incrementarStock(int cantidad) throws ValorNoPositivoException {

    setStock(getStock() + cantidad);

  }

  /**
   * metodo vacio que decrementa el stock
   * 
   * @param cantidad
   * @throws ValorNoPositivoException
   */
  public void decrementarStock(int cantidad) throws ValorNoPositivoException {

    setStock(getStock() - cantidad);

  }

  /**
   * metodo toString articulo
   * 
   * @return String
   */
  @Override
  public String toString() {
    return "Articulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra
        + "€, precioVenta=" + precioVenta + "€, stock=" + stock + ", IVA=" + iva + "]\n";
  }

}