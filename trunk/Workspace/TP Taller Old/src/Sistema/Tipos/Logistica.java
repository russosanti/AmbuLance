package Sistema.Tipos;

import Utils.ArrayLista;

/**Clase usada como ayuda al hospital la cual maneja los caminos
 * @author Santiago Russo */
public class Logistica{
	private Ciudad ciu;
	private Hospital hosp;
	
	/**@definition public Logistica(Ciudad c,Hospital h)
	 * @param c Ciudad - La ciudad la cual la logistica maneja
	 * @param h - El hospital al cual responde */
	public Logistica(Ciudad c,Hospital h){
		this.ciu = c;
		this.hosp = h;
	}
	
	/** Permite setear el hospital de nuevo
	 * @definition public void set_Hospital(Hospital h)
	 * @param h Hospital - El hospital al cual responde
	 */
	public void set_Hospital(Hospital h){
		this.hosp = h;
	}
	
	/**Devuelve el camino adecuado de ida de un pedido desde el punto actual donde esta el
	 * pedido hasta el destino
	 * @param ped Pedido - El pedido al cual se calculan las cosas
	 * @return ArrayLista<'Calle'> - Retorna el camino
	 * @definition public ArrayLista<'Calle'> camino_ida(Pedido ped) */
	public ArrayLista<Calle> camino_ida(Pedido ped){
		//devuelve el camino desde la pos actual de la ambulancia hasta el punto de destino
		return Utils.Spath.camino_mas_corto(ped.get_ambulancia().getPos_actual(),ped.get_destino(),this.ciu);
	}
	/**Devuelve el camino adecuado de regreso de un pedido desde el punto actual donde esta el
	 * pedido hasta el hospital
	 * @param ped Pedido - El pedido al cual se calculan las cosas
	 * @return ArrayLista<'Calle'> - Retorna el camino
	 * @definition public ArrayLista<'Calle'> camino_regreso(Pedido ped) */
	public ArrayLista<Calle> camino_regreso(Pedido ped){
		//devuelve el camino desde la pos actual de la ambulancia hasta el punto de destino
		return Utils.Spath.camino_mas_corto(ped.get_ambulancia().getPos_actual(),this.hosp.get_dir(),this.ciu);
	}
}
