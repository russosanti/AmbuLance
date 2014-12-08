package Sistema.Tipos;

/**Clase usada para simular las Calles
 * @author Santiago Russo */
public class Calle{
	private long id;
	private Punto inicio; //el punto que lo conecta
	private Punto fin;  //el punto de fin del vector calle
	private String nombre;
	private int nro_ini;
	private int nro_fin;
	private int dificultad = 0;

	/**@definition public Calle(long id,Punto ini, Punto fin)
	 * @param id long - Id de la calle
	 * @param ini Punto - Esquina de inicio
	 * @param fin Punto - Esquina de fin */
	public Calle(long id,Punto ini, Punto fin){
		this(id,ini,fin,"",-1,-1);
	}
	/**@definition public Calle(long id, Punto ini, Punto fin, int nro_i, int nro_f)
	 * @param id long - Id de la calle
	 * @param ini Punto - Esquina de inicio
	 * @param fin Punto - Esquina de fin
	 * @param nro_i int - Altura al principio de la calle
	 * @param nro_f int - Altura al final de la calle */
	public Calle(long id, Punto ini, Punto fin, int nro_i, int nro_f){
		this(id,ini,fin,"",nro_i,nro_f);
	}
	/**@definition public Calle(long id, Punto ini, Punto fin, int nro_i, int nro_f)
	 * @param id long - Id de la calle
	 * @param ini Punto - Esquina de inicio
	 * @param fin Punto - Esquina de fin
	 * @param nom String - Nombre de la calle
	 * @param nro_i int - Altura al principio de la calle
	 * @param nro_f int - Altura al final de la calle */
	public Calle(long id, Punto ini, Punto fin, String nom, int nro_i, int nro_f){
		this.id = id;
		this.inicio = ini;
		this.fin = fin;
		this.setNombre(nom);
		this.setNro_ini(nro_i);
		this.setNro_fin(nro_f);
	}
	
	public long getId(){
		return this.id;
	}
	
	public Punto getInicio(){
		return(inicio);
	}
	public Punto getFin(){
		return(fin);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNro_ini(int nro_ini) {
		this.nro_ini = nro_ini;
	}
	public int getNro_ini() {
		return nro_ini;
	}
	
	public void setNro_fin(int nro_fin) {
		this.nro_fin = nro_fin;
	}
	public int getNro_fin() {
		return nro_fin;
	}
	
	public void setDificultad(int dif){
		this.dificultad = dif;
	}
	public int getDificultad(){
		return dificultad;
	}
	
	public boolean equals(Object c){
		if(c instanceof Calle){
			return(this.id == ((Calle) c).id);
		}else{
			return false;
		}
	}
}
