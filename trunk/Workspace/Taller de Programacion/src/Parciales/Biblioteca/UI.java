package Parciales.Biblioteca;

import javax.swing.JOptionPane;

public class UI implements Interfaz{
	
	private Menu menu;
	private Informe inf;
	
	public UI(){
		menu = new Menu();
		menu.setVisible(true);
		inf = new Informe();
	}
	
	
	public void error(String s) {
		JOptionPane.showMessageDialog(null,"ERROR: "+s,"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	public void clear_infomrme(){
		inf.clear();
	}
	
	public void informar_estado(String s) {
		inf.set_Texto(s);
		inf.setVisible(true);
	}

	public void informar_ocupados(String s) {
		
	}
}