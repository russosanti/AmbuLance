package paquete_1;

public class Main_Persona_Argentino {
	
	public static void main2(String[] args) {
		Ciudad cn = new Ciudad("Bs As","Arg",123,54);
		Argentino a = new Argentino("Santiago",cn);
		Uruguayo u = new Uruguayo("Marcos",cn);
		
		a.poner_nombre("guille");
		u.poner_nombre("pico");
		
		a.poner_edad(21);
		u.poner_edad(22);
		
		u.set_L_mate_ensangre(1);
		
		System.out.println("Nombre: "+a.obtener_nombre()+" Edad: "+a.tiempodevida());
		System.out.println("Nombre: "+u.obtener_nombre()+" Edad: "+u.tiempodevida());
	}
	
	public static void metodo_Pers(Persona p){
		
		p.poner_edad(12);
		p.cumplir_anios();
	}

}
