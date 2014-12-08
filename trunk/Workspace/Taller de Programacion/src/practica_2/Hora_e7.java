package practica_2;

public class Hora_e7 {
	private int hora;
	private int min;
	private int seg;
	
	public Hora_e7(){
		this.hora = 0;
		this.min = 0;
		this.seg = 0;
	}
	public Hora_e7(int h, int m, int s){
		this.hora = h;
		this.min = m;
		this.seg = s;
	}
	
	public void visualizar(){
		System.out.println(hora+":"+min+":"+seg);
	}
	
}
