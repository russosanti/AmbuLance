package Sistema.Tipos.Ambulancias;

import Sistema.Tipos.Punto;

/** Clase para simular los tipos de Ambulancias Aereas
 * @author Santiago Russo */
public abstract class Aereos extends Ambulancia {
	
	protected Aereos(long id, int x, Punto p) {
		super(id, x, p,(float) 0.5);
	}
	
	/** Calcula el tiempo del trayecto entero y no por tramo
	 * @param cant_calles int - Para mas o menos simular el tiempo me fijo cuanto tendria que recorret
	 * @return int - El tiempo que tarda en recorrer todo un trayecto */
	public int tiempo_trayecto(int cant_calles){
		return (Math.round(this.tiempo_por_calle*cant_calles));
	}
}
