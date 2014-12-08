package Threads;

public class Thread_1 implements Runnable{
	
	String nombre;
	Exclusion_Mutua mut;
	
	public Thread_1(String nombre,Exclusion_Mutua m){
		this.nombre = nombre;
		this.mut = m;
	}
	
	public void run(){
		this.mut.mos(this.nombre);
	}
}
