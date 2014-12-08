package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;

/** Clase usada para simular las ambulancias del tipo Moto
 * @author Santiago Russo */
public class Moto extends Ambulancia{
	
	/**@definition public Moto(long id)
	 * @param id long - id de la Moto*/
	public Moto(long id){
		super(id,8,null,1);  //o pongo this.maneobrabilidad
	}
	/** @definition public Moto(long id,Punto p)
	 * @param id long - Id de la Moto
	 * @param p - Punto donde se encuentra en su creacion */
	public Moto(long id,Punto p){
		super(id,8,p,1);  //o pongo this.maneobrabilidad
	}
}
