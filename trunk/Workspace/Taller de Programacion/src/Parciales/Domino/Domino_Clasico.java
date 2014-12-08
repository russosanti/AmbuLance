package Parciales.Domino;

public class Domino_Clasico extends Domino_Generico{

	public Domino_Clasico(int fichas, int jugadores) {
		super(fichas,jugadores);
	}
	
	protected boolean Compatibilidad(int l1,int extr1,int l2,int extr2,int fichas_mesa){
		return(l1==extr1);
	}
}
