package GESTIMALMejorado;

import java.util.ArrayList;

public class Almacen {
  //Atributos
  
  ArrayList<Producto> almacen = new ArrayList<Producto>();
  
  //Métodos
  
  /**
   * Añade un producto al arraylist
   * @param p Objeto producto
   */
  public void añadirArticulo(Producto p) {
    almacen.add(p);
  }
  
  /**
   * Retira un producto del arraylist
   * @param c Código del producto
   */
  public void retirarArticulo(int c) {
    for(int i = 0; i<almacen.size();i++) {
      if(almacen.get(i).getCodigo()==c) {
        almacen.remove(i);
        System.out.println("Producto retirado con éxito.");
        break;
      }
    }
    System.out.println("Producto no encontrado.");
    
    
  }
  
  /**
   * Devuelve un producto del arraylist
   * @param c Código del producto
   * @return
   */
  public Producto devolverArticulo(int c) {
    for(int i = 0; i<almacen.size();i++){
      if(almacen.get(i).getCodigo()== c) {
        return almacen.get(i);
      }
    }
    return null;
  }
  
  public int devolverIndice(int c) {
    for(int i = 0; i<almacen.size();i++){
      if(almacen.get(i).getCodigo()== c) {
        return i;
      }  
    }
    return -1;
  }
  public String toString() {
    String cadena = "";
    for(int i = 0; i<almacen.size();i++) {
      cadena += almacen.get(i);
    }
    return cadena;
  }
  
  
  
  
  
}
