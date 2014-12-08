package Interfaces;

public class Pajaro implements Volador {
	
	private int cant_agitar_alas = 0;
	
	@Override
	public void volando(){
		this.cant_agitar_alas++;
	}
	
	public void mostrar_vuelo(){
		System.out.println(this.cant_agitar_alas);
	}

}
