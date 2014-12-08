package Interfaces;

import java.util.Iterator;

public class Mi_Iterador implements Iterator<Integer>{
	
	private int actual;
	private int fin;
	
	public Mi_Iterador(int inicial,int fin){
		this.actual = inicial;
		this.fin = fin;
	}
	
	public boolean hasNext(){
		return(this.actual<=this.fin);
	}
	
	public Integer next(){
		int aux;
		if(this.actual<=this.fin){
			aux = this.actual;
			this.actual++;
		}else{
			System.out.println("Error, te pasaste");
			aux = 0;
		}
		return aux;
	}
	
	public void remove(){
	}
}
