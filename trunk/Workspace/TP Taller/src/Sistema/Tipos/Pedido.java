package Sistema.Tipos;

import Sistema.Tipos.Ambulancias.Ambulancia;
import Utils.ArrayLista;

/** Clase usada para simular Pedidos
 * @author Santiago Russo */
public class Pedido{
	private int id;
	private Punto destino;
	private long t_sig_checkpoint;
	private boolean en_retorno;
	private boolean en_el_limbo;
	private Ambulancia transporte;
	private Class<? extends Ambulancia> tipo;
	private ArrayLista<Calle> camino;
	
	/** Crea el pedido, el punto del pedido debe ser un punto existente
	 * @param id int - Id del Pedido
	 * @param p Punto - Punto a donde se debe llegar, debe ser un punto valido
	 * @param trans Class<'? extends Ambulancia'> - Tipo de ambulancia que se desea llevar
	 * @definition public Pedido(int id,Punto p, Class<? extends Ambulancia> trans) */
	public Pedido(int id,Punto p, Class<? extends Ambulancia> trans){
		this.id = id;
		this.destino = p;
		this.tipo = trans;
		this.en_retorno = false;
		this.en_el_limbo = true;
	}
	
	/**@definition public int getId()
	 * @return int - Devuelve el Id del Pedido */
	public int getId(){
		return this.id;
	}
	
	/**@definition public Punto get_destino()
	 * @return Punto - Devuelve el Punto del destino */
	public Punto get_destino(){
		return this.destino;
	}
	
	/**@definition public Class<? extends Ambulancia> tipo_transporte()
	 * @return Class<'? extends Ambulancia'> - El tipo de transporte */
	public Class<? extends Ambulancia> tipo_transporte(){
		return(this.tipo);
	}
	
	/**@definition public Ambulancia get_ambulancia()
	 * @return Ambulancia - Devuelve la Ambulancia asignada a este pedido
	 */
	public Ambulancia get_ambulancia(){
		return this.transporte;
	}
	/**@definition public void asignar_ambulancia(Ambulancia a)
	 * @param a Ambulancia - La ambulancia a asignar */
	public void asignar_ambulancia(Ambulancia a){
		this.transporte = a;
	}
	
	/** Asigna el camino designado a este pedido
	 * @param camino ArrayLista<'Calle'> - El camino a asignar
	 * @definition public void asignar_camino(ArrayLista<'Calle'> camino) */
	public void asignar_camino(ArrayLista<Calle> camino){
		this.camino = camino;
	}
	/**@definition public ArrayLista<'Calle'> getCamino()
	 * @return ArrayLista<'Calle'> - Devuelve el camino que se asigno a este Pedido*/
	public ArrayLista<Calle> getCamino(){
		return camino;
	}
	
	/**Pone al Pedido en estado de regreso
	 * @definition public void emprender_regreso() */
	public void emprender_regreso(){
		this.en_retorno = true;
	}
	/**@definition public boolean en_retorno()
	 * @return boolean - Devuelve true si el Pedido esta regresando al hospital, sino false
	 */
	public boolean en_retorno(){
		return this.en_retorno;
	}
	
	/** Setea el tiempo que tarda hasta el siguiente checkpoint.
	 * @param t long - Tiempo al checkpoint.
	 * @definition public void set_T(long t) */
	public void set_T(long t){
		this.t_sig_checkpoint = t;
	}
	/**@definition public long get_T()
	 * @return long - Tiempo hasta el siguiente checkpoint.
	 */
	public long get_T(){
		return this.t_sig_checkpoint;
	}
	
	/** El pedido deja de estar en el limbo.
	 * @definition public void respondio() */
	public void respondio(){
		this.en_el_limbo = false;
	}
	/**@definition public boolean en_limbo()
	 * @return boolean - Devuelve true si el usuario todavia no respondio y el pedido
	 * esta en el limbo, sino devuelve false. */
	public boolean en_limbo(){
		return this.en_el_limbo;
	}
	
	/**Saca un tramo del camino, el ya recorrido y calcula el nuevo checkpoint
	 * @return boolean - True si no hay siguiente tramo, es el fin; sino false y sigue el 
	 * trayecto.
	 * @definition public boolean siguiente_tramo() */
	public boolean siguiente_tramo(){
		if(this.camino.isEmpty()){
			return true;
		}else{
			Calle c = this.camino.remove(0);
			this.transporte.setPos_actual(c.getInicio());
			this.t_sig_checkpoint = this.transporte.tiempoXcuadra(c);
			return false;
		}
	}
	/** */
	public boolean equals(Object c){
		if(c instanceof Pedido){
			return(this.id == ((Pedido) c).id);
		}else{
			return false;
		}
	}
}