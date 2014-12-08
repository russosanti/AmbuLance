package Interfaz;

import Sistema.Sistema;

public class Menu_Utils {
	public static String generar(){
		String s = "1) Crear Ciudad\n";
		s = s + "2) Cargar paquete de Ciudad\n";
		s = s + "----------------------------";
		return s;
	}
	
	public static void menu_dispatch(Sistema sis,int op,IUser i){
		switch(op){
		case 1:
			sis.crear_ciudad();
			break;
		case 2:
			//s=i.ingreso("Ingrese el nombre del paquete: ");
			//sis.crear_ciudad(s);
			break;
		default:
			i.error("Opcion elegida invalida, elija nuevamente");
		}
	}
}
