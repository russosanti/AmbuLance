package Excepciones;

/** Excepcion para lanzar durante el acceso a base de datos
 * @author Fernando Pluss */
public class AccesoBaseDatosException extends RuntimeException {
	private static final long serialVersionUID = 4009170496269288005L;

	public AccesoBaseDatosException(String s){
		super(s);
	}
	
}
