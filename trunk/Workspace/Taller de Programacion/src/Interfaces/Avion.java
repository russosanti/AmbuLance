package Interfaces;

public class Avion implements Volador {
	
	private int cant_ciudades_visito = 1;
	private int cant_aeropuertos_visito = 0;
	
	public void volando(){
		this.cant_aeropuertos_visito++;
		this.cant_ciudades_visito = this.cant_ciudades_visito*2;
	}
	
	public void mostrar_vuelo(){
		System.out.println(this.cant_ciudades_visito+" | "+ this.cant_aeropuertos_visito);
	}

}
