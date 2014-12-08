package Piedra_Papel_Tijera;


public class Nucleo_Singleton {
	static private PPT i;
	
	public Nucleo_Singleton(PPT inter){
		i = inter;
	}
	
	public static PPT get_Nucleo(){
		return i;
	}
	
	public static void set_Nucleo(PPT inter){
		i = inter;
	}
}
