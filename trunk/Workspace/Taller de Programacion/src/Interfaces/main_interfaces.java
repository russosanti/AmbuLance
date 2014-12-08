package Interfaces;

public class main_interfaces {
	public static void main(String[] args) {
		
		Pajaro p = new Pajaro();
		Avion a = new Avion();
		
		acciones_voladoras(p);
		a.volando();
		acciones_voladoras(a);
		
	}
	
	public static void acciones_voladoras(Volador v){
		v.volando();
		v.volando();
		v.mostrar_vuelo();
	}

}
