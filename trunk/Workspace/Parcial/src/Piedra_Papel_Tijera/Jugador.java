package Piedra_Papel_Tijera;

public class Jugador {
	private String nombre;
	private long puntaje;
	
	public Jugador(){
		this.setNombre(null);
		this.puntaje = 0;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void gano() {
		this.puntaje++;
	}
	public long getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(long puntaje){
		this.puntaje = puntaje;
	}
}
