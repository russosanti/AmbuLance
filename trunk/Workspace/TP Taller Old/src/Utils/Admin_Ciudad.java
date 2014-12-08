package Utils;

import Sistema.Tipos.Calle;
import Sistema.Tipos.Punto;
import Utils.Calle_Stream;
import Utils.Punto_Stream;
/** Clase que encapsula la carga del mapa desde un paquete de archivos
 * @author Santiago Russo
 */
public class Admin_Ciudad {
	
	/** Utiliza la combinacion necesaria de objetos para crear la ciudad del paquete s.
	 * @Definition public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s)
	 * @param esquinas ArrayLista<'Punto'> - Esquinas de la ciudad para cargar.
	 * @param calles ArrayLista<'Calle'> - Calles que voy a cargar.
	 * @param s String - Nombre del pack que debo cargar.
	*/
	public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s){
		Punto_Stream ps = new Punto_Stream(s);
		Calle_Stream cs = new Calle_Stream(s);
		esquinas.addAll(ps.leer_puntos());
		calles.addAll(cs.leer_calles(esquinas));
	}
}
