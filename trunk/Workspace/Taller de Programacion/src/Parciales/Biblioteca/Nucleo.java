package Parciales.Biblioteca;

public class Nucleo {
	private static Biblioteca nucleo;

	
	public static void setNucleo(Biblioteca nucleo){
		Nucleo.nucleo = nucleo;
	}
	public static Biblioteca getNucleo(){
		return nucleo;
	}
	
	
}
