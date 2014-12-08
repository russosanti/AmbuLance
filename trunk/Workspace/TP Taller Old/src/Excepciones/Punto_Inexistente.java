package Excepciones;

/** Clase para simular una excepcion que se lanza cuando un punto no existe
 * @author Santiago Russo */
public class Punto_Inexistente extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	/** @definition public Punto_Inexistente()*/
	public Punto_Inexistente(){
		super("El Punto no existe");
	}
	/**@definition public Punto_Inexistente(String s)
	 * @param s String - El msj de de error que se setea */
	public Punto_Inexistente(String s){
		super(s);
	}
}
