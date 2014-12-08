package Arraylist;
import java.util.*;
import paquete_1.*;

public class Main_arraylist_sintipos {
	public static void main2(String[] args) {
		ArrayList ar = new ArrayList();
		Ciudad cn = new Ciudad("Bs As","Arg",123,54);
		Argentino a = new Argentino("Santiago",cn);
		
		Object x = a;
		ar.add(a);
		System.out.println(((Argentino) x).get_Cant_asados());
		boolean is = x instanceof Argentino;
		if(is){
			System.out.println("Es Argentino");
		}else{
			System.out.println("Extranjero!!");
		}
		
	}
}