package Parciales.Domino;

public class Main {

	public static void main(String[] args) {
		Domino_Clasico juego = new Domino_Clasico(6,2); //le digo que son fichas del 0 al 6 y 2 jugadores
		
		juego.repartir();
		juego.repartir();	
		juego.repartir();
		juego.repartir();
		juego.repartir();
		juego.repartir();
		
		juego.iniciar_juego();
		
		int flag=0;
		String line;
		String aux;
		int x=0;
		int y=0;
		int jugador = 1;
		while(flag<=0){
			System.out.print("Jugador "+jugador+": ");
			line = System.console().readLine();
			line = line.trim();
			aux = line.substring(0,line.indexOf(";"));
			aux = aux.trim();
			line = line.substring(line.indexOf(";")+1,line.length());
			line = line.trim();
			x = Integer.parseInt(aux);
			y = Integer.parseInt(line);
			System.out.print("Ingrese de que lado quiere ingresar la ficha (d o i): ");
			line = System.console().readLine();
			char d_i = dar_lado(line);
			while(d_i=='!'){
				d_i = dar_lado(line);
			}
			try{
				flag = juego.jugar_ficha(x,y,d_i);
			}catch(FichaInexistenteException e){
				System.out.println(e.getMessage());
				flag = -1;
			}catch(RuntimeException e){
				System.out.println(e.getMessage());
				flag = 1;	
			}
		}
	}
	
	public static char dar_lado(String s){
		String aux;
		s.trim();
		if(s=="i"||s=="d"||s=="I"||s=="D"){
			return s.charAt(0);
		}else{
			return '!';
		}
	}
}
