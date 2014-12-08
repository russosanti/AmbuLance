package Interfaz;

public class ConsoleWriter {
	
	public void printer(String s){
		System.out.println(s);
	}
	
	public void error(String s){
		System.out.println("ERROR: "+s);
	}
	
	public void borrar(){
		int con;
		for(con=1;con<=26;con++){
			System.out.println();
		}
	}
	
}
