package GESTIMALMejorado;

public class Producto {
  //Atributos de instancia
  
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  
  //Atributos de clase
  
  private static int cuentaProductos = 0;
  //Constructor
  
  public Producto (String d, double pC, double pV, int s) {
    cuentaProductos++;
    setCodigo();
    setDescripcion(d);
    setPrecioCompra(pC);
    setPrecioVenta(pV);
    setStock(s);
  }
  //Getters
  
  public int getCodigo() {
    return this.codigo;
  }
  
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public double getPrecioCompra() {
    return this.precioCompra;
  }
  
  public double getPrecioVenta() {
    return this.precioVenta;
  }
  
  public int getStock() {
    return this.stock;
  }
  
  //Setters
  
  private void setCodigo(){
    this.codigo = cuentaProductos;
  }
  
  public void setDescripcion(String d){
    this.descripcion = d;
  }
  
  public void setPrecioCompra(double pc){
    if(pc <0) {
      this.precioCompra = 0;
      System.out.println("ERROR: El precio de compra no puede ser negativo");
    }else {
      this.precioCompra = pc;
    }
  }
  
  public void setPrecioVenta(double pv){
    if(pv <0) {
      this.precioVenta = 0;
      System.out.println("ERROR: El precio de venta no puede ser negativo.");
    }else {
      this.precioVenta = pv;
    }
  }
  
  public void setStock(int s){
    if(s <0) {
      this.stock = 0;
      System.out.println("ERROR: El stock no puede ser negativo");
    }else {
      this.stock = s;
    }
  }
  
  //Metodos
  
  /**
   * Incrementa el stock del producto
   * @param c Cantidad que se suma al stock
   */
  public void incrementarExistencias(int c){
    if(c <0) {
      System.out.println("ERROR: No se puede decrementar el stock.");
    }
    this.setStock(this.getStock()+c);

  }
  /**
   * Decrementa el stock del producto
   * @param c Cantidad que se resta al stock
   */
  public void reducirExistencias(int c) { 
    if(this.getStock()-c <0){
      System.out.println("ERROR: El stock no puede ser negativo");
    }else {
      this.setStock(this.getStock()-c);
    }
    
  }

  public String toString(){
    return "\nCódigo - "+this.codigo
        +"\nDescripción - "+this.descripcion
        +"\nPrecio de compra - "+this.precioCompra
        +"\nPrecio de venta - "+this.precioVenta
        +"\nStock - "+this.stock+"\n";
  }
}
