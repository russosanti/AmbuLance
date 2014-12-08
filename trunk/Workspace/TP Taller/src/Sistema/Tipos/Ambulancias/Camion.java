package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;

/** Clase usada para simular las ambulancias del tipo Camion
 * @author Santiago Russo */
public class Camion extends Ambulancia{
	
	/**@definition public Camion(long id)
	 * @param id long - id de la Camion */
	public Camion(long id){
		super(id,3,null,3);
	}
	/** @definition public Camion(long id,Punto p)
	 * @param id long - Id de la Camion
	 * @param p - Punto donde se encuentra en su creacion */
	public Camion(long id,Punto p){
		super(id,3,p,3);
	}
}
