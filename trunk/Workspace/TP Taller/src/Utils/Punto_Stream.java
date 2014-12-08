package Utils;

import Sistema.Tipos.Punto;
import Utils.Map_Log;
import java.util.Iterator;


/** Clase usada para leer los puntos de un archivo aramado de forma especifica
 * @author Santiago Russo */
public class Punto_Stream extends Input_Stream {
	
	private Map_Log log;
	
	/** A partir del nombre del pack busca el archivo .pto
	 * @Definition public Punto_Stream(String s)
	 * @param s String - nombre del pack
	 */
	public Punto_Stream(String s) {
		super("mapas\\"+s+".pto");
		log = new Map_Log(s);
	}
	/** Lee los puntos linea por linea informa errores (tanto por interfaz como en el log).
	 * Retorna el ArrayLista de Puntos leidos leidos. Su size sera 0 si no leyo ningun punto.
	 * @Definition public ArrayLista<'Punto'> leer_puntos()
	 * @return ArrayLista<'Punto'> - El conjunto de calles formados
	 */
	public ArrayLista<Punto> leer_puntos(){
		ArrayLista<Punto> arr = new ArrayLista<Punto>();
		String aux;
		aux = this.read();
		Punto p;
		long i = 1;
		log.log_normal("Started procesing file: "+this.filename());
		while(aux!=null){ //mientras lea algo
			p = toPunto(aux); //convierto el algo a punto
			if(p == null){ //si lo convirtio mal
				log.log_error("Error proccesing point in line "+i);
			}else{  //si lo convirtio bien
				if(this.existe_coord(arr,p.getX(),p.getY())){ //si ya existe un punto en ese lugar
					log.log_warning("Id: "+p.getId()+". La coordenada: ("+p.getX()+";"+p.getY()+") ya existe y no se podra volver a cargar.");
				}else{
					if(!arr.add(p)){  //si ya existe el id
						log.log_warning("Error line "+i+". Id: "+p.getId()+" ya existe.");
					}
				}
			}
			aux = this.read();
			i++;
		}
		log.log_normal("Finished procesing file: "+this.filename());
		return (arr);
	}
	/** Convierte un string armada de forma id: (x,y) a un objeto del tipo Punto
	 * @Definition private Punto toPunto(String s)
	 * @param s String -  Usa el string de entrada para obtener los datos.
	 * @return Punto - El Punto armada
	 */
	private Punto toPunto(String s){
		Punto p;
		long id = 0;
		float x = 0;
		float y = 0;
		String aux;
		
		try{ //parseo la linea y convierto las cosas
			s = s.trim();
			aux = s.substring(0,s.indexOf(':'));
			aux = aux.trim();
			if(aux.length()==0){
				p = null;
			}else{
				id = Long.parseLong(aux);
				aux = s.substring(s.indexOf('(')+1,s.indexOf(';'));
				aux = aux.trim();
				if(aux.length()==0){
					p = null;
				}else{
					x = Float.parseFloat(aux);
					aux = s.substring(s.indexOf(';')+1,s.indexOf(')'));
					aux = aux.trim();
					if(aux.length()==0){
						p = null;
					}else{
						y = Float.parseFloat(aux);
						p = new Punto(id,x,y);
					}
				}
			}
		}catch(java.lang.StringIndexOutOfBoundsException e){
			return null;
		}
		return(p);
	}
	/** Informa si ya existe en el ArrayLista de puntos pasado la coordenada x e y
	 * @Definition private boolean existe_coord(ArrayLista<Punto> a, float x, float y)
	 * @param a ArrayLista<'Punto'> - Donde chequea si existen o no.
	 * @param x Float - La coordenada en x
	 * @param y Float - La coordenada en y
	 * @return Punto - El Punto armada
	 */
	private boolean existe_coord(ArrayLista<Punto> a, float x, float y){
		Iterator<Punto> i = a.iterator();
		boolean existe = false;
		while(i.hasNext() && !existe){
			if(i.next().equal_pos(x,y)){
				existe = true;
			}
		}
		return existe;
	}
}