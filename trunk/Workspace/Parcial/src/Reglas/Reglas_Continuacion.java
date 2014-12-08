package Reglas;

public interface Reglas_Continuacion {
	public int solicitud_continuacion(long punt1,long punt2,long empates); //te debe retornar 0 o 1 o 2 dependiendo que jugador es esa
	//regla me indica a que jugador debo preguntarle ya que ella internamente sabe como lo calculo
}
