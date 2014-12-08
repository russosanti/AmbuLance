package Interfaz.Swing;

import Sistema.Sistema;

/**Singleton del Nucleo
 * @author Santy */
public class Nucleo_Keeper {
	static private Sistema sys;
	
	public Nucleo_Keeper(Sistema nucleo){
		sys = nucleo;
	}
	public static Sistema get_Nucleo(){
		return sys;
	}
	
	public static void set_Nucleo(Sistema nucleo){
		sys = nucleo;
	}
}