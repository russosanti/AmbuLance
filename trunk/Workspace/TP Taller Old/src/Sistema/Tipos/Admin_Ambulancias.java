package Sistema.Tipos;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Interfaz.IUser;
import Interfaz.Interface_Keeper;
import Sistema.Tipos.Ambulancias.Ambulancia;
import Utils.System_Log;
import Utils.Tipo_Utils;

/**Clase auxiliar del hospital la cual administra las ambulancias, las estaciona y brinda info
 * @author Santiago Russo */
public class Admin_Ambulancias{
	private HashMap<Class<? extends Ambulancia>,Integer> max_amb;
	private HashMap<Class<? extends Ambulancia>,Queue<Ambulancia>> estacion_amb;
	private Punto direccion;
	private IUser interfaz;
	private System_Log log;
	
	/**@definition public Admin_Ambulancias(Punto p)
	 * @param p Punto - Punto donde se encuentra el hospital */
	@SuppressWarnings("deprecation")
	public Admin_Ambulancias(Punto p){
		this.max_amb = new HashMap<Class<? extends Ambulancia>,Integer>();
		this.estacion_amb = new HashMap<Class<? extends Ambulancia>,Queue<Ambulancia>>();
		ArrayList<Class<Ambulancia>> ar = new ArrayList<Class<Ambulancia>>();
		ar = Tipo_Utils.subclases_ambulancia();
		Iterator<Class<Ambulancia>> i = ar.iterator();
		Class<Ambulancia> cl;
		while(i.hasNext()){
			cl = i.next();
			this.max_amb.put(cl,new Integer(0));
			this.estacion_amb.put(cl,new LinkedList<Ambulancia>());
		}
		this.direccion = p;
		this.interfaz = Interface_Keeper.get_Interfaz();
		Date d = new Date();
		d.getDate();
		String aux = d.toString();
		aux = aux.replace(':','_');
		log = new System_Log("(Ambulancias)"+aux);
	}
	
	/** @definition public Integer maximo(Class<'? extends Ambulancia'> cl)
	 * @param cl Class<'? extends Ambulancia'> - Tipo de la ambulancia a preguntar
	 * @return Integer - Maxima cantidad de ambulancias
	 */
	public Integer maximo(Class<? extends Ambulancia> cl){
		return this.max_amb.get(cl);
	}
	
	/** Se fija si hay o no ambulancia de un tipo especifico
	 * @param cl Class<'? extends Ambulancia'> - Tipo de ambulancia a preguntar
	 * @return boolean - True si hay disponibles, false si no lo hay.
	 * @definition public boolean hay_ambulancias(Class<'? extends Ambulancia'> cl) */
	public boolean hay_ambulancias(Class<? extends Ambulancia> cl){
		return !this.estacion_amb.get(cl).isEmpty();
	}
	
	/** Devuelve una ambulancia por el id buscado o null si no encuentra el id
	 * @param id long - El id a buscar
	 * @return Ambulancia - La ambulancia encontrada o null si no encuentra
	 * @definition public Ambulancia get_Ambulancia_byId(long id) */
	public Ambulancia get_Ambulancia_byId(long id){
		ArrayList<Queue<Ambulancia>> ar = new ArrayList<Queue<Ambulancia>>();
		ar.addAll(this.estacion_amb.values());
		Iterator<Queue<Ambulancia>> i = ar.iterator();
		Ambulancia aux;
		Iterator<Ambulancia> it;
		while(i.hasNext()){
			it = i.next().iterator();
			while(it.hasNext()){
				aux = it.next();
				if(aux.getId()==id){
					return aux;
				}
			}
		}
		return null;
	}
	
	/**Aumenta la cantidad de ambulancias en x y crea esas ambulancias asignando su id
	 * @param cl Class<'? extends Ambulancia'> - El tipo de ambulancia a comprar
	 * @param x Integer - La cantidad de ambulancias que se compran
	 * @definition public void comprar(Class<'? extends Ambulancia'> cl,Integer x) */
	public void comprar(Class<? extends Ambulancia> cl,Integer x){
		int aux = this.max_amb.get(cl).intValue();  //agarro la cantidad actual de ambulancias
		int nue =  aux + x;  // la cantidad actual mas la nueva
		aux = get_max_id()+1;  //obtengo la ultima id asignada
		this.max_amb.put(cl,new Integer(nue)); //pongo el nuevo maximo
		nue = nue + aux - 1; //al aux le sumo el nuevo y le resto 1 para usarlo como rango de creacion
		Ambulancia amb;
		try {
			Constructor<? extends Ambulancia> cons = cl.getConstructor(new Class[]{long.class,Punto.class}); //obtengo el constructor con inflexion
			try {
				for(int i=aux;i<=nue;i++){  // para el rengo
					amb = cons.newInstance(new Object[]{i,this.direccion}); //creo la instancia
					this.estacion_amb.get(cl).add(amb); //meto la instancia
					this.interfaz.informar("Se ha comprado la ambulancia "+i+" del tipo "+cl.toString());
				}
				log.log_normal("Se han comprado "+x+" "+cl);
			} catch (IllegalArgumentException e) {
				this.interfaz.error(e.getMessage());
				this.log.log_error(e.getMessage());
			} catch (InstantiationException e) {
				this.interfaz.error(e.getMessage());
				this.log.log_error(e.getMessage());
			} catch (IllegalAccessException e) {
				this.interfaz.error(e.getMessage());
				this.log.log_error(e.getMessage());
			} catch (InvocationTargetException e) {
				this.interfaz.error(e.getMessage());
				this.log.log_error(e.getMessage());
			}
		} catch (SecurityException e) {
			this.interfaz.error(e.getMessage());
			this.log.log_error(e.getMessage());
		} catch (NoSuchMethodException e) {
			this.interfaz.error(e.getMessage());
			this.log.log_error(e.getMessage());
		}
	}
	
	/**Retorna la primer ambulancia encontrada en el estacionamiento
	 * @definition public Ambulancia sacar_ambulancia(Class<'? extends Ambulancia'> cl)
	 * @param cl Class<'? extends Ambulancia'> - Tipo de ambulancia a sacar
	 * @return Ambulancia - La ambulancia desestacionada */
	public Ambulancia sacar_ambulancia(Class<? extends Ambulancia> cl){
		return (this.estacion_amb.get(cl).poll());
	}
	/** Estaciona la ambulancia pasada por parametro
	 * @definition public boolean estacionar(Ambulancia amb)
	 * @param amb Ambulancia - La ambulancia a estacionar
	 * @return boolean - True si la puede estacionar, false si no puede
	 */
	public boolean estacionar(Ambulancia amb){
		try{
			Queue<Ambulancia> q = this.estacion_amb.get(amb.getClass());
			q.add(amb);
			return true;
		}catch(NullPointerException e){
			return false;
		}
	}
	
	//Devuelve el maximo id encontrado para que asi no se repitan
	private int get_max_id(){
		int acum = 0;
		Integer aux;
		Iterator<Class<? extends Ambulancia>> i;
		i = this.max_amb.keySet().iterator();
		while(i.hasNext()){
			aux = this.max_amb.get(i.next());
			acum = acum + aux.intValue();
		}
		return acum;
	}
}