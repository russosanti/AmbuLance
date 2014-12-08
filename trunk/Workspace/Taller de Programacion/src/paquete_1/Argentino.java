package paquete_1;

public class Argentino extends Persona {  //Argentino<T extends Persona> extends Persona aca le pasas como generic Persona o una subclase
	
	private int cant_asados;
	
	public Argentino(String n, Ciudad cn){
		this(0,n,cn);
	}
	
	public Argentino(int asados, String n, Ciudad cn){
		super(n,0,cn);
		this.cant_asados = asados;
	}
	
	public int get_Cant_asados(){
		return(cant_asados);
	}
	
	public void set_Cant_asados(int x){
		this.cant_asados = x;
	}
	
	public int coef_nacionalidad(){
		return(5);
	}
}
