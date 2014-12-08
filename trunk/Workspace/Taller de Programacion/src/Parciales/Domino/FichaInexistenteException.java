package Parciales.Domino;

public class FichaInexistenteException extends RuntimeException {
	private static final long serialVersionUID = 3453252485028888887L;
	
	public FichaInexistenteException(){
		super("La ficha buscada no existe");
	}
	public FichaInexistenteException(String s){
		super(s);
	}
}
