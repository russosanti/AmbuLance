package Utils;

import java.util.ArrayList;
import java.util.Iterator;

/** Extension de ArrayList que no permite repetidos y ofrece 2 busquedas:
 * buscar(Objeto)Objeto retorna el objeto que coincida segun la definicion de equals() de ese Objeto
 * existe(Objeto)boolean donde retorna si existe o no segun la definicio de equals() de ese Objeto
 * @declaration public class ArrayLista<'T extends Equalers'> extends ArrayList<'T'>
 * @extends ArrayList
 * @author Santiago Russo */
public class ArrayLista<T> extends ArrayList<T>{
	private static final long serialVersionUID = 1L;
	
	/** Crea un ArrayLista vacio listo para usarse.
	*/
	public ArrayLista(){
		
	}
	/** A partir de un ArrayList<'T'> crea un ArrayLista con sus elementos
	 * @definicion public ArrayLista(ArrayList<T> arr)
	 * @param ArrayList<'T'>
	 * @return ArrayLista
	*/
	public ArrayLista(ArrayList<T> arr){
		Iterator<T> i = arr.iterator();
		while(i.hasNext()){
			this.add(i.next());
		}
	}
	/** Agrega un Objeto al ArrayLista al menos que el mismo ya exista.
	 * @definicion public boolean add(T x)
	 * @param T x - Objeto del tipo T
	 * @return boolean - True si lo logra agregar, False si no lo logro.
	*/
	public boolean add(T x){
		if(this.contains(x)){
			return false;
		}else{
			super.add(x);
			return true;
		}
	}
	
	/** Busca el elemento t en el arraylist segun la definicion de equals.
	 * @definicion public T buscar(T x)
	 * @param T x - Objeto del tipo T
	 * @return T - Devuelve el objeto que se desea buscar o null si no lo encuentra.
	*/
	public T buscar(T x){
		int i = 0;
		T aux = null;
		//Podria usar iterator pero bue
		while((i<this.size()) && (aux==null)){
			if(this.get(i).equals(x)){
				aux=this.get(i);
			}
			i++;
		}
		return(aux);
	}
}
