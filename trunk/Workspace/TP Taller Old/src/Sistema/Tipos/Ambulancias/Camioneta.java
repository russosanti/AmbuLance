package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;

/** Clase usada para simular las ambulancias del tipo Camioneta
 * @author Santiago Russo */
public class Camioneta extends Ambulancia{
	
	/**@definition public Camioneta(long id)
	 * @param id long - id de la Camioneta */
	public Camioneta(long id){
		super(id,5,null,2);
	}
	/** @definition public Camioneta(long id,Punto p)
	 * @param id long - Id de la Camioneta
	 * @param p - Punto donde se encuentra en su creacion */
	public Camioneta(long id,Punto p){
		super(id,5,p,2);
	}
}
