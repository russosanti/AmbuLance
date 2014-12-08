package Sistema.Tipos;

import Sistema.Tipos.Ambulancias.*;
import Utils.System_Log;
import Utils.Tipo_Utils;
import Utils.ArrayLista;
import Interfaz.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**Clase usada para simular el Hospital
 * @author Santiago Russo */
public class Hospital{
	private Punto direccion;
	//private int cant_tipos = 0; no se usaba
	private int numero_pedido = 0;
	private IUser interfaz;
	private Logistica logistica;
	private Admin_Ambulancias estacion;
	private ArrayLista<Pedido> pedidos_activos;
	private HashMap<Class<? extends Ambulancia>,Queue<Pedido>> cola_pedidos;
	private ArrayList<Pedido> pedidos_dudosos;
	private System_Log log;
	
	/** Crea el hospital a partir de un Punto valido en el mapa.
	 * @param logis Logistica - La logistica que tiene conocimiento de la ciudad para indicar
	 * los caminos
	 * @param dir Punto - Debe ser un punto valido.
	 * @Warnings: el punto debe ser un PUNTO VALIDO (que exista en la ciudad)
	 * @definition 	public Hospital(Logistica logis,Punto dir)
	 */
	@SuppressWarnings("deprecation")
	public Hospital(Logistica logis,Punto dir){
		this.direccion = dir;
		this.interfaz = Interface_Keeper.get_Interfaz();
		this.logistica = logis;
		ArrayList<Class<Ambulancia>> ar = new ArrayList<Class<Ambulancia>>();
		ar = Tipo_Utils.subclases_ambulancia();
		//this.cant_tipos = ar.size();
		this.pedidos_activos = new ArrayLista<Pedido>();
		this.cola_pedidos = new HashMap<Class<? extends Ambulancia>,Queue<Pedido>>();
		this.pedidos_dudosos = new ArrayList<Pedido>();
		this.estacion = new Admin_Ambulancias(this.direccion);
		Iterator<Class<Ambulancia>> i = ar.iterator();
		Class<Ambulancia> cl;
		while(i.hasNext()){
			cl = i.next();
			this.cola_pedidos.put(cl,new LinkedList<Pedido>());
		}
		Date d = new Date();
		d.getDate();
		String aux = d.toString();
		aux = aux.replace(':','_');
		log = new System_Log("(Pedidos)"+aux);
		log.log_normal("Simulacion Iniciada");
	}
	
	/** Devuelve el punto indicado como el Hospital
	 * @return Punto - La direccion del hospital
	 * @definition public Punto get_dir() */
	public Punto get_dir(){
		return this.direccion;
	}
	
	/** Retorna la cantidad de ambulancias de un tipo disponibles en el hospital.
	 * @Definition public int get_cant_ambulancia(Class<? extends Ambulancia> cl)
	 * @param cl Class<'? extends Ambulancia'> - El tipo a buscar
	 * @return int - Cantidad de camiones.
	 * @Warning El tipo pasado debe ser valido
	 * @definition public int get_cant_ambulancia(Class<'? extends Ambulancia'> cl) */
	public int get_cant_ambulancia(Class<? extends Ambulancia> cl){
		Integer aux;
		aux = this.estacion.maximo(cl);
		return aux.intValue();
	}
	
	/**Usa a la estacion y retorna la ambulancia buscada por su Id
	 * @param Id long - Id de la ambulancia a buscar
	 * @return Ambulancia - La Ambulancia buscada o null si no encuentra nada
	 * @definition public Ambulancia get_Ambulancia_byId(long Id) */
	public Ambulancia get_Ambulancia_byId(long Id){
		return this.estacion.get_Ambulancia_byId(Id);
	}
	
	/**Aumenta la cantidad maxima de ambulancias de un tipo en el hospital.
	 * @param cl Class<'? extends Ambulancia'> - Tipo a comprar
	 * @param x int - Cantidad que se compran
	 * @definition public void comprar_ambulancia(Class<'? extends Ambulancia'> cl,int x) */
	public void comprar_ambulancia(Class<? extends Ambulancia> cl,int x){
		this.estacion.comprar(cl,x);
	}
	
	/**Crea un pedido
	 * @param p Punto - El punto de destino del pedido
	 * @param cl Class<'? extends Ambulancia'> - El tipo de ambulancia para ese pedido
	 * @definition public void crear_pedido(Punto p, Class<'? extends Ambulancia'> cl)
	 */
	public void crear_pedido(Punto p, Class<? extends Ambulancia> cl){
		this.numero_pedido = (this.numero_pedido+1)%2000000; //ciclo para que las id no se me vayan
		if(this.numero_pedido<=0){
			this.numero_pedido = 1;
		}
		Pedido ped = new Pedido(this.numero_pedido,p,cl);
		dispatcher(ped); //hace dispatch del pedido
	}
	
	/**Realiza el movimiento para un tiempo t
	 * @param t long - Tiempo
	 * @definition public void mover(long t) */
	public void mover(long t){
		Iterator<Pedido> it = this.pedidos_activos.iterator();
		Pedido ped;
		long t_chk;
		boolean llego;
		while(it.hasNext()){
			ped = it.next();
			t_chk = ped.get_T();
			if(t_chk==0){
				if(ped.tipo_transporte().getSuperclass()!=Aereos.class){
					llego = ped.siguiente_tramo();
					if(llego){
						if(ped.en_retorno()){
							this.llego_hospital(ped);
							it = this.pedidos_activos.iterator();
						}else{
							this.llego_destino(ped);
						}
					}else{
						this.interfaz.informar("El movil: "+ped.get_ambulancia().getId()+" atendiendo al pedido "+ped.getId()+" ha llegado al punto: "+ped.get_ambulancia().getPos_actual());
						this.log.log_normal("CHECKPOINT" +ped.getId()+": Ambulancia"+ped.get_ambulancia().getId()+" con destino a: "+ped.get_destino());
					}
				}else{
					if(ped.en_retorno()){
						this.llego_hospital(ped);
						it = this.pedidos_activos.iterator();
					}else{
						this.llego_destino(ped);
					}
				}
			}else{
				t_chk--;
				ped.set_T(t_chk);
			}
		}
	}
	 /**Da la respuesta al primer pedido en estado dudoso
	  * @param resp String - Respuesta Si(lo encola) o No(lo rechaza) 
	  * @definition public void respuesta_pedido(String resp) */
	public void respuesta_pedido(String resp){
		try{
			Pedido ped = this.pedidos_dudosos.remove(0);
			if(resp.equalsIgnoreCase("SI")){
				ped.respondio();
				this.dispatcher(ped);
			}else{
				if(resp.equalsIgnoreCase("NO")){
					this.interfaz.informar("El pedido "+ped.getId()+" ha sido rechazado");
					this.log.log_normal("RECHAZADO: "+ped.getId()+", Destino: "+ped.get_destino());
				}
			}
		}catch(RuntimeException e){
			this.interfaz.error(e.getMessage());
		}
	}
	/**Da la respuesta al pedido con el id especificado en estado dudoso
	 * @param resp String - Respuesta Si(lo encola) o No(lo rechaza)
	 * @param id_pedido int - El id del pedido a dar respuesta
	 * @definition public void respuesta_pedido(String resp,int id_pedido) */
	public void respuesta_pedido(String resp,int id_pedido){
		try{
			Pedido ped = new Pedido(id_pedido,new Punto(0,0,0),Moto.class); //un punto auxiliar
			int index = this.pedidos_dudosos.indexOf(ped);
			ped = this.pedidos_dudosos.remove(index);
			if(resp.equalsIgnoreCase("SI")){
				ped.respondio();
				this.dispatcher(ped);
			}else{
				if(resp.equalsIgnoreCase("NO")){
					this.interfaz.informar("El pedido "+ped.getId()+" ha sido rechazado");
					this.log.log_normal("RECHAZADO: "+ped.getId()+", Destino: "+ped.get_destino());
				}
			}
		}catch(RuntimeException e){
			this.interfaz.error(e.getMessage());
		}
	}
	
	/**Lanzada por la torre Indicando que hubo un cambio en alguna o todas las calles
	 * @definition public void recalculo_ruta() */
	public void recalculo_ruta(){
		Iterator<Pedido> it = this.pedidos_activos.iterator();
		Pedido aux;
		this.interfaz.informar("Recalculando Rutas");
		this.log.log_normal("Recalculando Rutas");
		while(it.hasNext()){
			aux = it.next();
			if(aux.tipo_transporte().getSuperclass()!=Aereos.class){
				if(aux.en_retorno()){
					aux.asignar_camino(this.logistica.camino_regreso(aux));
					if(!aux.getCamino().isEmpty()){
						aux.getCamino().remove(0);
					}
				}else{
					aux.asignar_camino(this.logistica.camino_ida(aux));
					if(!aux.getCamino().isEmpty()){
						aux.getCamino().remove(0);
					}
				}
			}
		}
	}
	
	//Segun el estado del sistema el pedido va a parar a un lado o a otro
	private void dispatcher(Pedido ped){
		try{
			if(!this.estacion.hay_ambulancias(ped.tipo_transporte())){ //si no hay estaciones
				if(ped.en_limbo()){//si el estado del pedido es en el limbo
					this.pedidos_dudosos.add(ped); //lo meto en dudosos e informo
					this.interfaz.informar("El pedido "+ped.getId()+" no puede ser atendido en este momento, que desea hacer?");
					this.log.log_normal("ENESPERA A RESPUESTA: "+ped.getId()+", Destino: "+ped.get_destino());
				}else{ //si no esta en el limbo xq ya respondieron pero no hay ambulancias
					this.cola_pedidos.get(ped.tipo_transporte()).add(ped); //lo encolo
					this.interfaz.informar("El pedido "+ped.getId()+" ha sido encolado");
					this.log.log_normal("ENCOLADO: "+ped.getId()+", Destino: "+ped.get_destino());
				}
			}else{
				if(this.cola_pedidos.get(ped.tipo_transporte()).isEmpty()){ //si hay ambulancias y la cola esta vacia
					ped.asignar_ambulancia(this.estacion.sacar_ambulancia(ped.tipo_transporte()));
					ped.asignar_camino(this.logistica.camino_ida(ped));
					if(ped.tipo_transporte().getSuperclass()!=Aereos.class){ //si es aereo seteo el tiempo del trayecto entero
						ped.siguiente_tramo(); //si no es aereo calculo el tiempo del primer tramo
					}else{
						ped.set_T(ped.getCamino().size());
					}
					this.pedidos_activos.add(ped);
					this.interfaz.informar("El pedido "+ped.getId()+" ha sido despachado");
					this.log.log_normal("DESPACHADO: "+ped.getId()+", Destino: "+ped.get_destino()+", Ambulancia: "+ped.get_ambulancia().getId());
				}else{ //se supone que nunca deberia entrar aca xq a medida que llega una ambulancia ya se despacha
					Pedido p;
					p = this.cola_pedidos.get(ped.tipo_transporte()).poll();
					p.asignar_ambulancia(this.estacion.sacar_ambulancia(p.tipo_transporte()));
					p.asignar_camino(this.logistica.camino_ida(p));
					if(ped.tipo_transporte()!=Aereos.class){
						ped.siguiente_tramo();
					}else{
						ped.set_T(ped.getCamino().size());
					}
					this.pedidos_activos.add(p);
					this.log.log_normal("DESPACHADO: "+p.getId()+", Destino: "+p.get_destino()+", Ambulancia: "+p.get_ambulancia().getId());
					this.interfaz.informar("El pedido "+p.getId()+" ha sido despachado ya que tenia mayor prioridad.");
					if(ped.en_limbo()){//si el estado del pedido es en el limbo
						this.pedidos_dudosos.add(ped); //lo meto en dudosos e informo
						this.interfaz.informar("El pedido "+ped.getId()+" no puede ser atendido en este momento, que desea hacer?");
						this.log.log_normal("ENESPERA A RESPUESTA: "+ped.getId()+", Destino: "+ped.get_destino());
					}else{ //si no esta en el limbo xq ya respondieron pero no hay ambulancias
						this.cola_pedidos.get(ped.tipo_transporte()).add(ped); //lo encolo
						this.interfaz.informar("El pedido "+ped.getId()+" ha sido encolado");
						this.log.log_normal("ENCOLADO: "+ped.getId()+", Destino: "+ped.get_destino());
					}
				}
			}
		}catch(NullPointerException e){
			e = new NullPointerException("Error en el dispatcher, el tipo pasado como parametro es invalido");
			this.interfaz.error(e.getMessage());
		}
	}
	
	//Cuando llega al destino infomra, cambia su estado y emprende el regreso
	private void llego_destino(Pedido ped){
		ped.get_ambulancia().setPos_actual(ped.get_destino());
		ped.asignar_camino(this.logistica.camino_regreso(ped));
		this.interfaz.informar("El movil: "+ped.get_ambulancia().getId()+" atendiendo al pedido "+ped.getId()+" ha llegado al destino: "+ped.get_destino());
		this.log.log_normal("LLEGO A DESTINO" +ped.get_destino()+": "+ped.getId());
		ped.emprender_regreso();
		if(ped.tipo_transporte().getSuperclass()!=Aereos.class){
			ped.siguiente_tramo();
		}else{
			ped.set_T(ped.getCamino().size());
		}
	}
	
	//cuando llega al hospital informa y se carga otro pedido si hay en la cola
	private void llego_hospital(Pedido ped){
		Ambulancia amb;
		amb = ped.get_ambulancia();
		amb.setPos_actual(this.direccion);
		this.log.log_normal("VOLVIO AL HOSPITAL Pedido: "+ped.getId()+" Ambulancia: "+ped.get_ambulancia()
				+"Destino Original: "+ped.get_destino());
		this.interfaz.informar("El pedido: "+ped.getId()+" Ambulancia: "+ped.get_ambulancia()
				+"Destino Original: "+ped.get_destino()+", volvio al hospital exitosamente");
		this.estacion.estacionar(amb);
		int i = this.pedidos_activos.indexOf(ped);
		this.pedidos_activos.remove(i);
		Queue<Pedido> q = this.cola_pedidos.get(amb.getClass());
		if(!q.isEmpty()){
			ped = q.poll();
			ped.asignar_ambulancia(this.estacion.sacar_ambulancia(ped.tipo_transporte()));
			ped.asignar_camino(this.logistica.camino_ida(ped));
			if(ped.tipo_transporte()!=Aereos.class){
				ped.siguiente_tramo();
			}else{
				ped.set_T(ped.getCamino().size());
			}
			this.pedidos_activos.add(ped);
			this.interfaz.informar("El pedido "+ped.getId()+" ha sido despachado");
			this.log.log_normal("DESPACHADO: "+ped.getId()+", Destino: "+ped.get_destino()+", Ambulancia: "+ped.get_ambulancia().getId());
		}
	}
	
	//Cuando el hospital muere quiere decir que se termino y graba en el log sim finalizada
	protected void finalize(){
		this.log.log_normal("Simulacion Finalizada");
	}
}
