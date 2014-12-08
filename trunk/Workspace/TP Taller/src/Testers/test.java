package Testers;

import Interfaz.*;
import Sistema.Tipos.*;
import Sistema.Tipos.Ambulancias.*;

public class test {
	
	public static void mainer(String[] args) {
		IUser inter = new IU();
		Interface_Keeper.set_Interface(inter);
		Ciudad ciu = new Ciudad("test");
		Hospital h;
		
		Torre_Transito to = new Torre_Transito(ciu);
		
		h = ciu.setHospital(1);
		
		h.comprar_ambulancia(Camion.class,1);
		h.comprar_ambulancia(Camioneta.class,8);
		h.comprar_ambulancia(Helicoptero.class,2);
				
		h.crear_pedido(new Punto(14,3,2),Camion.class);
		h.crear_pedido(new Punto(21,0,0),Camion.class);
		h.crear_pedido(new Punto(21,0,0),Camion.class);
		h.crear_pedido(new Punto(13,2,2),Camioneta.class);
		h.crear_pedido(new Punto(13,2,2),Helicoptero.class);
		
		h.respuesta_pedido("si",3);
		
		long t = 0;
		while(true){
			System.out.println(t+":");
			h.mover(t);
			if(t==3){
				to.dificultad_calle(3,8,8);
				to.dificultad_calle(4,9,9);
				to.dificultad_calle(7,1,7);
			}
			System.out.println("-------------------------------------------------");
			t++;
		}
	}

}
