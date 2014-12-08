package Testers;

import Interfaz.*;
import Sistema.Sistema;

public class test_interfaz {
		
		public static void main2(String[] args) {
			IUser i = new IU();
			@SuppressWarnings("unused")
			Sistema s = new Sistema(i);
			i.load();
		}
	
}
