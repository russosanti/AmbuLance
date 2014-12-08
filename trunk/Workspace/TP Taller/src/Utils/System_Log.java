package Utils;

import java.io.IOException;
import java.io.File;
import java.util.logging.*;
import Interfaz.IUser;
import Interfaz.Interface_Keeper;

/** Clase que facilita el armado de un log usando logger
 * @author Santiago Russo */
public class System_Log{
	private Logger logger;
	private FileHandler fh;
	
	/** Crea el log en el directorio sys_log\
	 * @Definition public Map_Log(String s)
	 * @param s String -  Nombre del archivo .log.
	 */
	public System_Log(String s){
		logger = Logger.getLogger(s);
		if(this.crear_directorio("sys_log")){ //si no existe el directiorio pasado lo creo
			try {
				fh = new FileHandler("sys_log\\"+s+".log", true);
				logger.addHandler(fh);
				logger.setLevel(Level.ALL);
				logger.setUseParentHandlers(false);
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
			}catch (SecurityException e) {
				IUser i = Interface_Keeper.get_Interfaz();
				i.error(e.getMessage());
			} catch (IOException e) {
				IUser i = Interface_Keeper.get_Interfaz();
				i.error(e.getMessage());
			}
		}else{
			IUser i = Interface_Keeper.get_Interfaz();
			i.error("Error creando el directorio para el log: "+s);
		}
	}
	
	/** Inserta en el log un error
	 * @Definition public void log_error(String s)
	 * @param s String -  Mensaje a guardar en el log.
	 */
	public void log_error(String s){
		logger.log(Level.SEVERE,s);
	}
	/** Inserta en el log un warning
	 * @Definition public void log_warning(String s)
	 * @param s String -  Mensaje a guardar en el log.
	 */
	public void log_warning(String s){
		logger.log(Level.WARNING,s);
	}
	/** Inserta en el log un mensaje normal
	 * @Definition public void log_normal(String s)
	 * @param s String -  Mensaje a guardar en el log.
	 */
	public void log_normal(String s){
		logger.log(Level.FINE,s);
	}
	
	//Crea un directorio segun lo que se paso en el string s
	private boolean crear_directorio(String s){
		File f = new File(s);
		if(f.exists()){
			return true;
		}
		return(f.mkdirs());
	}
}
