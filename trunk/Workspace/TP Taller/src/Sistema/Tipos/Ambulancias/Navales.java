package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;
/**Clase absracta que encapsula todas las ambulancias navales
 * @author Santiago Russo */
public abstract class Navales extends Ambulancia{
	
	protected Navales(long id, Punto p) {
		super(id,9,p,(float) 1);
	}
}
