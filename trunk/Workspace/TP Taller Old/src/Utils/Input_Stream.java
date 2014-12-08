package Utils;

import java.io.*;
import Interfaz.IUser;
import Interfaz.Interface_Keeper;
/** Clase usada para leer de un archivo
 * @author Santiago Russo */
public class Input_Stream{
	
	private FileReader reader;
	private String fileIn;
	private File f;
	BufferedReader br;
	
	/** Crea un Stream para lectura de texto basandose en String que se pasa.
	 * @definicion public Input_Stream(String s)
	 * @param String s - Nombre y directorio del archivo
	*/
	public Input_Stream(String s){
		this.fileIn = s;
		f = new File(s);
		if(this.crear_directorio(s.substring(0,s.lastIndexOf("\\")))){ //si no existe el directiorio pasado lo creo
			if(!f.exists()){ //si el archivo no existe
				try {
					f.createNewFile(); //crea el archivo vacio
					IUser x = Interface_Keeper.get_Interfaz();
					x.informar("El archivo '"+s+"' no existe, se creara el mismo. Procure llenarlo con datos.");
				}catch(NullPointerException e){
					System.out.println("La interfaz se rompio");
					Runtime.getRuntime().exit(0);
				}catch(IOException e) {
					IUser x = Interface_Keeper.get_Interfaz();
					x.error("Error creando el archivo " + s);
				}
			}
			try {
				reader = new FileReader(this.f); //usa el archvio para leer
			}
			catch(IOException e){
				IUser x = Interface_Keeper.get_Interfaz();
				x.error("Error al abrir el archivo: "+ this.fileIn);
			}
			br = new BufferedReader(this.reader);
		}else{
			IUser x = Interface_Keeper.get_Interfaz();
			x.error("Error creando el directorio para el archivo");
		}
	}
	
	/** Indica si el Stream esta listo o no para usarse.
	 * @Definition public boolean ready()
	 * @param void
	 * @return boolean - True si esta listo, False si no lo esta.
	*/
	public boolean ready(){
		return(this.reader!=null);
	}
	
	/** Lee una linea entera del archivo (hasta el primer enter).
	 * @Definition public String read()
	 * @param void
	 * @return String - Devuelve una linea a la vez
	*/
	public String read(){
		int s = 1;
		if(s <= 0){
			return null;
		}else{
			String linea;
			try {
				linea = br.readLine(); //lee una linea
			} catch (IOException e) {
				IUser i = Interface_Keeper.get_Interfaz();
				i.error(e.getMessage());
				return null;
			}
			return(linea);
		}
	}
	
	/** Te retorna el nombre del archivo usado sin los directorios donde se encuentra.
	 * @Definition public String filename()
	 * @param void
	 * @return String - Nombre del archivo que es usado por el Stream
	*/
	public String filename(){
		return this.fileIn.substring(this.fileIn.indexOf("\\")+1,this.fileIn.length());
	}
	
	/** Crea el directorio/s fisicos que se le pasa por parametro en el String.
	 * @Definition public boolean crear_directorio(String s)
	 * @param String s - Directorio/s a crear escritos en la forma del SO a\b\c
	 * @return boolean - True si logra crear toda la familia de directorios, False si no logra crarlos
	 * todos
	*/
	private boolean crear_directorio(String s){
		File f = new File(s);
		if(f.exists()){
			return true;
		}
		return(f.mkdirs());
	}
	//cuando se destruye el objeto cierra el archivo
	protected void finalize(){
		try{
			this.reader.close();
		}catch (IOException e){
			IUser x = Interface_Keeper.get_Interfaz();
			x.error("Error al cerrar el archivo:"+this.fileIn);
		}
	}
}
