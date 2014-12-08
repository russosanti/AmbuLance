package Parciales.Biblioteca;

public class Main {

	public static void main(String[] args) {
		Interfaz inter = new UI();
		Bidimensional biblio = new Bidimensional(5,inter);
		Nucleo.setNucleo(biblio);
		Cargar_BD bd = new Cargar_BD(inter);
		bd.cargar(biblio);
	}

}
