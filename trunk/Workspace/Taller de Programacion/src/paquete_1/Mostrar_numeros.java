package paquete_1;

public class Mostrar_numeros {
	public static void main2(String[] args) {
		for(int i=1;i<=10;i++){
			if(es_par(i)){ //o Mostrar_numeros.es_par(i);
				System.out.println(i);
			}
		}

	}
	
	public static boolean es_par(int x){
		if(x%2 == 0){
			return true;
		}
		return false;
	}

}

//de tarea en e mail creamos una persona y aplicamos algunos de los atributos
