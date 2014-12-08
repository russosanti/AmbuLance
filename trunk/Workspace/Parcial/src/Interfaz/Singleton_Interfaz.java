package Interfaz;

public class Singleton_Interfaz {
	static private Interfaz i;
	
	public Singleton_Interfaz(Interfaz inter){
		i = inter;
	}
	
	public static Interfaz get_Interfaz(){
		return i;
	}
	
	public static void set_Interface(Interfaz inter){
		i = inter;
	}
}
