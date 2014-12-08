package Files_Streams;

import java.io.File;

public class file_main {

	public static void main(String[] args){
		File f = new File("C:\\Users\\Toshbia\\Documents\\Varios Santiago\\CAECE\\3er Año\\Taller de Programacion");
		if(f.exists()){
			recorrer(f);
		}
	}
	
	
	public static void recorrer(File f){
		File fi[] = f.listFiles();
		for(File fil : fi){
			System.out.println(fil.getName());
			if(fil.isDirectory()){
				recorrer(fil);
			}
		}
	}
}
