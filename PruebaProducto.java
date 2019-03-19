/**
 * pruebaProducto.java
 * Programa para gestionar un almacén
 * usando la clase Producto definida en el fichero Producto.java
 * @author �?lvaro García Fuentes
 * @author Rafael Jesús Nieto Cardador
 */
package GESTIMALMejorado;

import java.util.Scanner;

public class PruebaProducto {
	//Funci�n para leer un Double por teclado
	public static double tecladoDouble(){
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner( System.in );   
		return teclado.nextDouble();
		}
  
	//Funci�n para leer un entero por teclado
	public static int tecladoInt(){
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner( System.in );   
		return teclado.nextInt();
		}
  
	//Funci�n para leer una cadena por teclado
	public static String tecladoString(){
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner( System.in );   
		return teclado.nextLine();
		}
  
	public static void main( String[] args ) {
   
	  Almacen almacen = new Almacen();
	  
		int opcion = 0;
		int indice;
		String d = "";
		double pC = 0;
		double pV = 0;
		int s = 0;
		boolean error = false;
		int codigo;
 
		//Menu
		//Bucle do while para que se muestre el men� continuamente hasta que se escoja la opci�n "salir"
		do {
			System.out.println("======ALMAC�N======");
			System.out.println("1. Mostrar almac�n");
			System.out.println("2. Mostrar producto");
			System.out.println("3. Alta");
			System.out.println("4. Baja");
			System.out.println("5. Modificaci�n");
			System.out.println("6. Entrada de mercanc�a");
			System.out.println("7. Salida de mercanc�a");
			System.out.println("8. Salir");
			
			do {
				try {
					System.out.println("Introduzca una opción");
					opcion = tecladoInt();
				} catch (Exception e) {
					error = true;
					System.out.println("ERROR: entrada incorrecta.");
					}
				}while( error );

					//Estructura switch para manejar el men�
				switch( opcion ){
				// Listado
				case 1:
					System.out.println(almacen);
					break;
				//Mostrar producto
				case 2:
					System.out.println( "\n======MOSTRAR PRODUCTO======" );
					
					try {
						System.out.println("Introduzca el c�digo del producto.");
						codigo = tecladoInt();
						if(almacen.devolverArticulo(codigo ) == null) {
						  System.out.println("Producto no encontrado.");
						}else {
						  System.out.println(almacen.devolverArticulo(codigo ));
						}
					} catch (NumberFormatException e) {
						System.out.println("Error en la entrada de datos.");
					} catch (ArrayIndexOutOfBoundsException  i) {
						System.out.println("ERROR: codigo incorrecto");
						}
					break;
				// Alta
				case 3:
					System.out.println( "\n======DAR DE ALTA PRODUCTO======" );

					try {
						System.out.println("Introduzca la descripci�n del producto.");
						d = tecladoString();
					} catch (Exception e) {
						System.out.println("ERROR: Entrada incorrecta.");  
						}
				  				  
					try {
						System.out.println("Introduzca el precio de compra del producto.");
						pC = tecladoDouble();
					} catch (Exception e) {
						System.out.println("ERROR: Entrada incorrecta.");
						}
				  				  
					try {
						System.out.println("Introduzca el precio de venta del producto.");
						pV = tecladoDouble();
					} catch (Exception e) {
						System.out.println("ERROR: Entrada incorrecta.");
						}	  
				  
					try{
						System.out.println("Introduzca el stock del producto.");
						s = tecladoInt();
					} catch (Exception e ){
						System.out.println("ERROR: Entrada incorrecta.");  
						}
				  
					Producto producto = new Producto(d, pC, pV, s);
					almacen.a�adirArticulo(producto);
					System.out.println("Producto a�adido con �xito.");
					break;	
				
				// Baja
				case 4:
					System.out.println( "\n======DAR DE BAJA PRODUCTO======" );
			
					try {
						System.out.println("Introduzca el c�digo del producto a eliminar.");
						almacen.retirarArticulo(tecladoInt());        
					} catch (Exception e) {
						System.out.println("ERROR: Entrada incorrecta.");
						}
					break;
				// Modificar
				case 5:
					System.out.println( "\n======MODIFICAR EL PRODUCTO======" );
					
					try {
						System.out.println( "Introduzca el c�digo del producto a modificar" );
						indice = almacen.devolverIndice(tecladoInt());					
 
						System.out.println("Descripci�n: "+almacen.almacen.get(indice).getDescripcion() );
						System.out.println("Nueva descripci�n: ");
						almacen.almacen.get(indice).setDescripcion(tecladoString());
						System.out.println("Precio de compra: "+almacen.almacen.get(indice).getPrecioCompra() );
						System.out.println("Nuevo precio de compra: ");
						almacen.almacen.get(indice).setPrecioCompra(tecladoDouble());
						System.out.println("Precio de venta: "+almacen.almacen.get(indice).getPrecioVenta() );
						System.out.println("Nuevo precio de venta: ");
						almacen.almacen.get(indice).setPrecioVenta(tecladoDouble());
						System.out.println("Stock: "+almacen.almacen.get(indice).getStock() );
						System.out.println("Nuevo stock: ");
						almacen.almacen.get(indice).setStock(tecladoInt());
					}catch (Exception e) {
						System.out.println("ERROR: entrada incorrecta.");
						}
					break;
					
				// Entrada de mercancia
				case 6:
					System.out.println( "\n======ENTRADA DE MERCANC�A======" );
				  
					try {
						System.out.println("Introduzca el c�digo del producto");
						indice = almacen.devolverIndice(tecladoInt());
			  
						System.out.println("Introduzca la cantidad que desea sumar al stock");
						almacen.almacen.get(indice).incrementarExistencias(tecladoInt());
						System.out.println("Stock actualizado");
					} catch (Exception e) {
						System.out.println("ERROR: entrada incorrecta.");
						}
					break;
				//Salida de mercancia
				case 7:
				  try {
  					System.out.println( "\n======SALIDA DE MERCANC�A======" );
  					System.out.println("Introduzca el c�digo del producto");
  					indice = almacen.devolverIndice(tecladoInt());
  					System.out.println("Introduzca la cantidad que desea restar al stock");
  					almacen.almacen.get(indice).reducirExistencias(tecladoInt());
  					System.out.println("Stock actualizado");
				  }catch(Exception e) {
				    System.out.println("ERROR: entrada incorrecta.");
				  }
					break;

				case 8:
					// Salir
					System.out.println( "Saliendo..." );
					break;
				default:
					System.out.println( "Opción incorrecta" );
				}
			
			}while( opcion != 8 );			
		}
} // Fin del programa