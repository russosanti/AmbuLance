package Parciales.Biblioteca;

public interface Objeto_Biblio {
	void set_Biblioteca(Biblioteca b);
	Biblioteca get_Biblioteca();
	Class<? extends Objeto_Biblio> tipo();
	int get_pos_absoluta();
	void set_pos_actual(int x);
}