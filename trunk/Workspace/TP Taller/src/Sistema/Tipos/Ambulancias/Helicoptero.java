package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;

/** Clase usada para simular las ambulancias del tipo Helicoptero
 * @author Santiago Russo */
public class Helicoptero extends Aereos{
	/**@definition public Helicoptero(long id)
	 * @param id long - id de la Helicoptero */
	public Helicoptero(long id){
		super(id,10,null);
	}
	/** @definition public Helicoptero(long id,Punto p)
	 * @param id long - Id de la Helicoptero
	 * @param p - Punto donde se encuentra en su creacion
	 */
	public Helicoptero(long id,Punto p){
		super(id,10,p);
	}
}
