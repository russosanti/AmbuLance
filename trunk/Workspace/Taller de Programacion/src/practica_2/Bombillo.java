package practica_2;

public class Bombillo {
	private boolean estado = false;
	
	public boolean esta_prendida(){
		return this.estado;
	}
	
	public void prender(){
		this.estado = true;
	}
	
	public void apagar(){
		this.estado = false;
	}
}
