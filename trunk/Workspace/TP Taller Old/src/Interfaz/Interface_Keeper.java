package Interfaz;

// Sirve para algo???
public class Interface_Keeper {
	static private IUser i;
	
	public Interface_Keeper(IUser inter){
		i = inter;
	}
	public static IUser get_Interfaz(){
		return i;
	}
	
	public static void set_Interface(IUser inter){
		i = inter;
	}
}
