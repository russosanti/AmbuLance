package Sistema.Tipos;

import Excepciones.*;
import Utils.ArrayLista;
import java.util.Iterator;

/**Clase usada para simular la ciudad, contiene las esquina y las calles
 * @author Santiago Russo */
public class Ciudad{
	private ArrayLista<Calle> calles;
	private ArrayLista<Punto> esquinas;
	private Hospital Hospital;
	private Logistica torre;
	private Torre_Transito transito;
	
	/**Crea la ciudad vacia
	 * @definition public Ciudad() */
	public Ciudad(){
		calles = new ArrayLista<Calle>();
		esquinas = new ArrayLista<Punto>();
		this.torre = new Logistica(this,this.Hospital);
		this.transito = new Torre_Transito(this);
	}
	
	/** Crea una ciudad y carga los puntos y calles de s.pto y s.clle
	 * @param s String - Nombre del pack
	 * @definition public Ciudad(String s) */
	public Ciudad(String s){
		this();
		Utils.Admin_Ciudad.Crear_Ciudad(this.esquinas,this.calles,s);
	}
	
	/**Setea el hospital en una esquina
	 * @Definition public Punto setHospital(long id)
	 * @param id long - El Id del punto donde se va a poner el Hospital
	 * @return Punto - Devuelve el punto donde se creo el hospital a partir del id pedido o null si el punto no existe.
	 * @throws Punto_Inexistente*/
	public Hospital setHospital(long id) throws Punto_Inexistente{  //puedo hacer que te devuelva el hospital derecho y no el punto (ya creado) el objeto
		Punto aux = new Punto(id,0,0);
		Punto p = this.esquinas.buscar(aux);
		if(p == null){
			throw new Punto_Inexistente("No existe un punto con ese id");
		}else{
			this.Hospital = new Hospital(this.torre,p);
			this.torre.set_Hospital(this.Hospital);
			return(this.Hospital);
		}
	}
	
	/** Setea el hospital en una esquina de coordenadas x e y si es que existe
	 * @Definition public Punto setHospital(float x, float y)
	 * @param x float
	 * @param y float
	 * @return Punto - Devuelve el punto donde se creo el hospital a partir del x e y pedidos o null si el punto no existe.
	 * @throws Punto_Inexistente*/
	public Hospital setHospital(float x, float y) throws Punto_Inexistente{
		Punto aux = this.punto_porcoord(x,y);
		if(aux==null){
			throw new Punto_Inexistente("No existe un punto con estas coordenadas (x,y)");
		}else{
			this.Hospital = new Hospital(this.torre,aux);
			this.torre.set_Hospital(this.Hospital);
			return(this.Hospital);
		}
	}
	
	/** Devuelve el punto donde esta situado el hospital
	 * @Definition public Punto getHospital()
	 * @return Punto - Devuelve el punto donde se encuentra el Hospital.*/
	public Hospital getHospital(){
		return this.Hospital;
	}
	
	/** Te devuelve el conjunto de calles
	 * @Definition public ArrayLista<Calle> obtener_calles()
	 * @return ArrayLista<'Calle'> - Devuelve un ArrayLista con las calles de la ciudad.
	 */
	public ArrayLista<Calle> obtener_calles(){
		return this.calles;
	}
	
	/** Devuelve conjunto de esquinas
	 * @Definition ArrayLista<Punto> obtener_esquinas()
	 * @return ArrayLista<'Puntos'> - Devuelve un ArrayLista con las esquinas de la ciudad
	 */
	public ArrayLista<Punto> obtener_esquinas(){
		return this.esquinas;
	}
	
	/** Metodo para crear una calle en una ciudad
	 * @Definition public boolean crear_calle(Calle calle)
	 * @param calle Calle - un objeto del tipo Calle
	 * @return boolean - True si pudo crear la calle y agregarla a la ciudad, de lo contrario False
	 */
	public boolean crear_calle(Calle calle){
		if(this.esquinas.contains(calle.getInicio()) && this.esquinas.contains(calle.getFin())){
			return(this.calles.add(calle)); //si ya existe el id no la agrega
		}else{
			return(false); //si no existen los puntos derecho va a false
		}
	}
	/** Metodo para crear una esquina en una ciudad
	 * @Definition public boolean crear_esquina(Punto esquina)
	 * @param esquina Punto - un objeto del tipo Punto
	 * @return boolean - True si pudo crear la esquina y agregarla a la ciudad, de lo contrario False
	 */
	public boolean crear_esquina(Punto esquina){
		return(this.esquinas.add(esquina));  //si no lo puede agregar devuelve false puede que sea xq ya exista
	}
	
	/** Metodo que devuelve si existe o no un punto con esa coordenada en esa ciudad.
	 * @Definition public Punto punto_porcoord(float x, float y)
	 * @param x float - Coordenada en x
	 * @param y float - Coordenada en y
	 * @return Punto - Devuelve el punto que tiene esas coordenadas o null si no existe algo con ese 'x' y ese 'y'*/
	public Punto punto_porcoord(float x, float y){
		Iterator<Punto> i = this.esquinas.iterator();
		Punto flag = null;
		Punto aux;
		while(i.hasNext() && (flag==null)){
			aux = i.next();
			if(aux.equal_pos(x,y)){
				flag = aux;
			}
		}
		return flag;
	}
	
	/**Permite,a traves de la torre,cambiar la dificultad de todas las calles por un random
	 * @definition public boolean cambiar_dificultad()
	 * @return boolean - True si puede cambiar todo o false si no */
	public boolean cambiar_dificultad(){
		return(this.transito.reporte_transito());
	}
	/**Permite,a traves de la torre,cambiar la dificulta de una calle por su id
	 * @param id long - Id de la calle
	 * @param dif int - La nueva dificultad
	 * @return boolean - True si puede cambiarlo o false sino (como que no existe calle
	 * con ese id)
	 * @definition public boolean cambiar_dificultad(long id,int dif) */
	public boolean cambiar_dificultad(long id,int dif){
		return(this.transito.dificultad_calle(id,dif));
	}
	/**Permite,a traves de la torre,cambiar la dificulta de una calle por el id de su esquina
	 * inicial y el id de su esquina final
	 * @param id_i long - Id de la esquina inicial
	 * @param id_f long - Id de la esquina final
	 * @param dif int - La nueva dificultad
	 * @return boolean - True si puede cambiarlo o false sino (como que no existe calle
	 * con esas esquinas)
	 * @definition public boolean cambiar_dificultad(long id,int dif) */
	public boolean cambiar_dificultad(long id_i,long id_f,int dif){
		return(this.transito.dificultad_calle(id_i,id_f,dif));
	}
}
