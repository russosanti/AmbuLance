package Parciales.Domino;

public class Ficha{
	int lado1;
	int lado2;
	
	public Ficha(int x,int y){
		this.lado1 = x;
		this.lado2 = y;
	}
	
	public void girar(){
		int aux = this.lado2;
		this.lado2 = this.lado1;
		this.lado1 = aux;
	}
	
	public String toString(){
		return(this.lado1+"|"+this.lado2);
	}
}
