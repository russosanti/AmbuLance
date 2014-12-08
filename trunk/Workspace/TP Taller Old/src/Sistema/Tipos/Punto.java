package Sistema.Tipos;

/** Clase para simular las esquinas
 * @author Santiago Russo */
public class Punto{
	private long id;
	private float x;
	private float y;
	
	/**@definition public Punto(long id,float x, float y)
	 * @param id long - Id del punto
	 * @param x float - Coordenada en x
	 * @param y float - Coordenada en y
	 */
	public Punto(long id,float x, float y){
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	/** Devuelve el Id del Punto
	 * @definition public long getId()
	 * @return long - Id del Punto */
	public long getId(){
		return this.id;
	}
	
	/** */
	public boolean equals(Object p){
		if(p instanceof Punto){
			return(this.id == ((Punto)p).id);
		}else{
			return false;
		}
	}
	
	/**@definition public float getX()
	 * @return float - Devuelve la coordenada en X */
	public float getX(){
		return this.x;
	}
	/**@definition public float getY()
	 *  @return float - Devuelve la coordenada en Y */
	public float getY(){
		return this.y;
	}
	
	/**@definition public void setX(float a)
	 * @param a float - La coordenada a setear */
	public void setX(float a){
		this.x = a;
	}
	/**@definition public void SetY(float b)
	 * @param a float - La coordenada a setear */
	public void SetY(float b){
		this.y = b;
	}
	
	/** Devuelve true si el punto esta en esa pos
	 * @param x float - Coordenada a igualar en x
	 * @param y float - Coordenada a igualar en y
	 * @return boolean - True si el punto tiene esas coordenadas, sino false
	 * @definition public boolean equal_pos(float x, float y) */
	public boolean equal_pos(float x, float y){
		return((this.x == x) && (this.y == y));
	}
	
	/** */
	public String toString(){
		return("Id: "+this.id+") ("+this.x+";"+this.y+")");
	}
}