package Utils;

import Interfaz.IU;
import Interfaz.Interface_Keeper;
import Sistema.Tipos.Calle;
import Sistema.Tipos.Punto;
import Utils.Map_Log;

/** Clase usada para leer las calles de un archivo aramado de forma especifica
 * @author Santiago Russo */
public class Calle_Stream extends Input_Stream {
	
	private Map_Log log;
	
	/** A partir del nombre del pack busca el archivo .clle
	 * @Definitions public Calle_Stream(String s)
	 * @param s String - nombre del pack
	 */
	public Calle_Stream(String s) {
		super("mapas\\"+s+".clle");
		log = new Map_Log(s);
	}
	/** Lee las calles linea por linea informa errores (tanto por interfaz como en el log) y te retorna el arraylista armado
	 * @Definitions public ArrayLista<'Calle'> leer_calles(ArrayLista<'Punto'> ar)
	 * @param ar ArrayLista<'Punto'> - El conjunto de las esquinas que voy a usar en las calles
	 * @return ArrayLista<'Calle'> - El conjunto de calles formados
	 */
	public ArrayLista<Calle> leer_calles(ArrayLista<Punto> ar){
		ArrayLista<Calle> arr = new ArrayLista<Calle>();
		log.log_normal("Started procesing file "+this.filename());
		if(ar.size()==0){ //si cuando cargo los puntos no hay nada
			log.log_warning("Archivo de puntos del set vacio,calles de: "+this.filename()+" no se cargaran.");
			IU x = (IU)Interface_Keeper.get_Interfaz();
			x.error("Archivo de Puntos vacio. El mapa quedara vacio.");
		}else{
			String aux;
			aux = this.read(); //leo la linea
			if(aux==null){ //si no lee nada
				log.log_warning("Archivo de calles: "+this.filename()+" vacio,mapa vacio.");
				IU x1 = (IU)Interface_Keeper.get_Interfaz();
				x1.error("Archivo de Calles vacio. El mapa quedara vacio.");
			}else{
				Calle c;
				long i = 1;
				while(aux!=null){ //mientras lea algo
					c = toCalle(aux,ar); //convierte el sting a calle
					if(c==null){
						log.log_warning(this.filename()+" linea "+i+" mal compuesta; se omitira su carga.");
					}else{
						arr.add(c); //lo pongo en el set de calles
					}
					aux = this.read();
					i++;
				}
			}
		}
		log.log_normal("Finished procesing file "+this.filename());
		return (arr);
	}
	
	/** Convierte un string armada de forma id: {id_puntoini,id_puntofin,"Nombre",aini,afinal}
	 * un objeto del tipo Calle
	 * @Definitions private Calle toCalle(String s, ArrayLista<Punto> ar)
	 * @param s String -  Usa el string de entrada para obtener los datos.
	 * @param ar ArrayLista<'Punto'> - Busca en ArrayLista de puntos que los puntos determinados existan.
	 * @return Calle - La calle armada
	 */
	private Calle toCalle(String s, ArrayLista<Punto> ar){
		Calle c;
		Punto aux_ini;
		Punto aux_fin;
		long id = 0;
		long id_inicial = 0;
		long id_final = 0;
		String nombre = null;
		int nro_inicio = 0;
		int nro_fin = 0;
		String aux;
		
		s = s.trim(); //saco los blancos
		aux = s.substring(0,s.indexOf(':')); //corto el id de 0 hasta el :
		aux = aux.trim(); //saco los blancos de esa sub cadena
		if(aux.length()==0){ //si no me queda nada falla xq no hay id
			c = null;
		}else{
			id = Long.parseLong(aux); //convierto el id a long y asigno
			aux = s.substring(s.indexOf('{')+1,s.indexOf('}')); //corto el conjunto entre {}
			aux = aux.trim(); //saco blancos
			String[] elementos = aux.split(","); //me genera un array de strings con los elementos separados por ,
			if(elementos.length!=5){ //deben ser 5 exactos
				c = null;
			}else{
				//asigno los elementos
				id_inicial = Long.parseLong(elementos[0]);
				id_final = Long.parseLong(elementos[1]);
				nombre = elementos[2].substring(elementos[2].indexOf('"')+1,elementos[2].lastIndexOf('"'));
				nro_inicio = Integer.parseInt(elementos[3]);
				nro_fin = Integer.parseInt(elementos[4]);
				//creo puntos de prueba para chequear existencia
				aux_ini = new Punto(id_inicial,0,0);
				aux_fin = new Punto(id_final,0,0);
				if(!ar.contains(aux_ini)){
					log.log_warning(this.filename()+": Punto de inicio de Id: "+id_inicial+" no se encuentra.");
					c = null;
				}else{
					if(!ar.contains(aux_fin)){
						log.log_warning(this.filename()+": Punto de fin de Id: "+id_final+" no se encuentra.");
						c = null;
					}else{
						//Si ambos puntos existen creo la calle
						c = new Calle(id,ar.buscar(aux_ini),ar.buscar(aux_fin),nombre,nro_inicio,nro_fin);
					}
				}
			}
		}
		return(c);
	}
}
