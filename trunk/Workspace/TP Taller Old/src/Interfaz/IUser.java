package Interfaz;

import Sistema.Sistema;

public interface IUser{
	public void load();
	public void setS(Sistema s);
	public void error(String s);
	public void informar(String s);
	public void informe_torre(String s);
	public void menu_ppal();
	public void ingreso(String s);
	public String pedido(String s);
	public void salir();
	public void borrar_pantalla();
}
