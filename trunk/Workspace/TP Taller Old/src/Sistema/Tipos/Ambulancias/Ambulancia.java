package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.*;

/** Clase usada para la simulacion de ambulancias en general
 * @author Santiago Russo */
public abstract class Ambulancia {
	private long id;
	private Punto pos_actual;
	protected float tiempo_por_calle;
	private int maniobrabilidad; //dificultad hasta la que pasa
	
	
	protected Ambulancia(long id,int x,Punto p,float tiempo){
		this.id = id;
		this.maniobrabilidad = x;
		this.pos_actual = p;
		this.tiempo_por_calle = tiempo;
	}
	
	/** @definition public long getId()
	 * @return long - devuelve el Id de la Ambulancia */
	public long getId(){
		return this.id;
	}
	
	/** @definition public void setPos_actual(Punto pos_actual)
	 * @param pos_actual Punto - El punto acutal a setear
	 */
	public void setPos_actual(Punto pos_actual){
		this.pos_actual = pos_actual;
	}
	/** @definition public Punto getPos_actual()
	 * @return Punto - El punto actual donde se encuentra la Ambulancia*/
	public Punto getPos_actual() {
		return pos_actual;
	}
	
	/** @definition public int getManiobrabilidad()
	 * @return int - La maneobrabilidad que tiene esa Ambulancia*/
	public int getManiobrabilidad() {
		return maniobrabilidad;
	}
	
	/** Calcula el tiempo que se tarda en una determinada calle
	 * @param c Calle - La calle para la cual se calcula el tiempo
	 * @return int - El tiempo que se tarda en recorrer esa calle
	 */
	public int tiempoXcuadra(Calle c){
		int dif = c.getDificultad();
		if(this.maniobrabilidad>=dif){
			return Math.round(this.tiempo_por_calle);
		}else{
			return(Math.round(this.tiempo_por_calle*(dif-this.maniobrabilidad)));
		}
	}
}
