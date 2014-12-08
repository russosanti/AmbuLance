package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.lang.reflect.Modifier;
import Interfaz.IUser;
import Interfaz.Interface_Keeper;
import Sistema.Tipos.Ambulancias.Ambulancia;

/** Clase util para el uso de tipos
 * @author Santiago Russo */
public class Tipo_Utils {
	/** Devuelve todos los tipos de Ambulancia que pueden existir evitando las subclases de subdivision como Aereos
	 * @Definition public static ArrayList<Class<Ambulancia>> subclases_ambulancia()throws ClassCastException {
	 * @return ArrayList<'Class<'Ambulancia'>'>
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Class<Ambulancia>> subclases_ambulancia()throws ClassCastException {
		String s = "Sistema.Tipos.Ambulancias.Ambulancia";
		ArrayList<Class<Ambulancia>> aux = new ArrayList<Class<Ambulancia>>();
		SubClassFinder finder = new SubClassFinder();;
		Vector<Class<?>> v = null;
		List<Throwable> errors = null;
 
		v = finder.findSubclasses(s);  //busco las subclases y las devuelvo en el vector
		errors = finder.getErrors();
		if (v != null && v.size() > 0){  //si no esta vacio ni tuvo ningun error
			if(errors.isEmpty()){
				try{
					for(Class<?> cls : v){  //por cada elemento del vector
						if(!Modifier.isAbstract(cls.getModifiers())){  //me fijo si es clase abstracta y si no lo es
							aux.add((Class<Ambulancia>)cls);  // lo agrego al  arraylist de salida
						}
					}
				}catch(ClassCastException e){
					throw new ClassCastException("Error en el armado de tipos, contacte al administrador del sistema");
				}
			}else{
				IUser i = Interface_Keeper.get_Interfaz();
				i.error(errors.get(0).getMessage());
			}
		} else {
			IUser i = Interface_Keeper.get_Interfaz();
			i.error("No se encontraron subclases de: "+s);
		}
		return aux;
	}
}
