package Interfaz;

import javax.swing.JFrame;
import Sistema.Sistema;

/**Clase que brinda la interfaz con el sistema
 * @author Santy */
public interface IUser{
	public void load();
	public void setS(Sistema s);
	public void setActual_Frame(JFrame fr);
	public void error(String s);
	public void informar(String s);
    public void informar(String s, InformarConst type);
}
