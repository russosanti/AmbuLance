package Piedra_Papel_Tijera;


public enum Eleccion {
	piedra, papel, tijera;
	
	public static boolean isEleccion(Eleccion e){
		if(e==Eleccion.piedra || e==Eleccion.papel || e==Eleccion.tijera){
			return true;
		}else{
			return false;
		}
	}
	
	public static int gana(Eleccion e1,Eleccion e2){
		if(e1 == e2){
			return 0;
		}else{
			if((e1 == Eleccion.piedra && e2 == Eleccion.tijera) ||
					(e1 == Eleccion.papel && e2 == Eleccion.piedra) ||
					(e1 == Eleccion.tijera && e2 == Eleccion.papel)){
				return 1;
			}else{
				return 2;
			}
		}
	}
	
	public static String toString(Eleccion e){
		switch(e){
			case papel:
				return "papel";
			case piedra:
				return "piedra";
			case tijera:
				return "tijera";
			default:
				return "";
		}
	}
}
