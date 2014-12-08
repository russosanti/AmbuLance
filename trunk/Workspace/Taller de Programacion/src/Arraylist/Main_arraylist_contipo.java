package Arraylist;

import java.util.*;
import paquete_1.Argentino;
import paquete_1.Persona;
import paquete_1.Uruguayo;
import paquete_1.Ciudad;

public class Main_arraylist_contipo {
	
	public static void maina2(String[] args) {
		ArrayList<Ciudad> ar = new ArrayList<Ciudad>();
		Ciudad cn = new Ciudad("Bs As","Arg",123,54);
		Argentino a = new Argentino("Santiago",cn);
		ar.add(cn);
		Ciudad cn1 = new Ciudad("Cordoba","Arg",130,48);
		ar.add(cn1);
		Ciudad cn2 = new Ciudad("Tucuman","Arg",150,40);
		ar.add(cn2);
		Ciudad cn3 = new Ciudad("Misiones","Arg",160,54);
		ar.add(cn3);
		for(int i=0;i<ar.size();i++){
			cn = ar.get(i);
			System.out.println("Nombre: " + cn.getNombre());
		}
		for(int i=0;i<ar.size();i++){
			cn = ar.get(i);
			System.out.println("Nombre: " + cn.getNombre());
		}
	}
}
