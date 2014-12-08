package Motor;

import Interfaz.*;
import Sistema.Sistema;

public class Main {
	//motor que arranca el sistema
	public static void main(String[] args) {
		IUser i = new IU();
		@SuppressWarnings("unused")
		Sistema s = new Sistema(i);
		Interface_Keeper.set_Interface(i); //pongo la interfaz a la que los demas se referencian
		i.load();
	}
}
