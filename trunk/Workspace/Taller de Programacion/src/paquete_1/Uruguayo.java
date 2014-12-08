package paquete_1;

public class Uruguayo extends Persona {
	private int l_mate_ensangre = 0;
	
	public Uruguayo(String n, Ciudad cn){
		this(0,n,cn);
	}
	
	public Uruguayo(int cant_mate, String n, Ciudad cn){
		super(n,0,cn);
		this.l_mate_ensangre = cant_mate;
	}
	
	public int get_L_mate_ensangre(){
		return(l_mate_ensangre);
	}
	
	public void set_L_mate_ensangre(int x){
		this.l_mate_ensangre = x;
	}
	
	public int tiempodevida(){
		return(super.tiempodevida()+ this.l_mate_ensangre);
	}
	public int coef_nacionalidad(){
		return(0);
	}
}
