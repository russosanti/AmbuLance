package Interfaz;

import javax.swing.JOptionPane;

public class IU implements Interfaz{
	
	public void error(String s){
		JOptionPane.showMessageDialog(null,"ERROR: "+s,"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	public void informar(String s){
		JOptionPane.showMessageDialog(null,"INFORME: "+s,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean continuar(String s) {
		if(JOptionPane.showConfirmDialog(null,s,"Continuar?",JOptionPane.YES_NO_OPTION)==0){
			return true;
		}else{
			return false;
		}
	}
}
