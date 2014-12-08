package Motor;

import Interfaz.IU;
import Interfaz.Interfaz;
import Interfaz.Main;
import Interfaz.Singleton_Interfaz;

public class Motor {

	public static void main(String[] args) {
		Interfaz i = new IU();
		Singleton_Interfaz.set_Interface(i);
		@SuppressWarnings("unused")
		Main m = new Main();
	}

}
