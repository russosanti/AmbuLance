package Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import Sistema.Tipos.Calle;
import Sistema.Tipos.Ciudad;
import Sistema.Tipos.Punto;
import Utils.ArrayLista;

public class Spath {
		
	// ALGORITMO PRINCIPAL
	
	/** Hace uso del algoritmo de Dijkstra para hallar la ruta mas corta entre pini y pfin
	 * en la ciudad c
	 * @Definition public static ArrayLista<Calle> camino_mas_corto(Punto pini, Punto pfin, Ciudad c){
	 * @param pini Punto - El punto de inicio
	 * @param pfin Punto - El punto de fin   
	 * @param c Ciudad - La ciudad en donde ocurre todo 
	 * @return ArrayLista<'Calle'> Un arraylista de calles con el camino mas corto entre pini y pfin
	 */
	
	public static ArrayLista<Calle> camino_mas_corto(Punto pini, Punto pfin, Ciudad c){
		// Variables que voy a usar para todo el proceso
		Punto_M p, u = null;
		boolean existe_camino = true;
		ArrayLista<Calle> temp = new ArrayLista<Calle>();
		ArrayLista<Punto_M> ret  = new ArrayLista<Punto_M>();
		ArrayLista<Calle> ret2 = new ArrayLista<Calle>();
		Punto_M pmfin = new Punto_M(pfin);
		
		// 1) Defino 1 conjunto de vertices
		ArrayLista<Punto_M> T = Spath.To_Mi_Punto(c.obtener_esquinas()); 
		Iterator<Punto_M> it_t = T.iterator();
	
		// 2) Asigno las etiquetas(a todas se les coloca inf, salvo a pini que se le coloca cero)  
		
		while(it_t.hasNext()){
			p = it_t.next();
			if(p.equals(pini)) 
				p.setEtiqueta(0);
			else 
				p.setEtiqueta(Integer.MAX_VALUE);
		}
		
		// 3) Obtengo el vertice con etiqueta minima (Test: La primer vez deberia ser pini)
		u = Collections.min(puntos_activos(T), new etq_comparator());
		
		// 4) Si u = t (pfin), el algoritmo termina
		while(!(u.equals(pmfin))){
		   
			// 5) Para toda arista que arranque en u y termine en v perteneciente a T...
			// Nota: Puede ser que no exista ningun camino que comienze en u y lleve 
			// a algun lado, si ese es el caso, el iterador no hace nada 
			temp = obtener_vecinos(c.obtener_calles(), u, puntos_activos(T));
			Iterator<Calle> it_temp = temp.iterator();
			Calle cl;
			Punto_M auxi,auxf;
			while(it_temp.hasNext()){
				cl = it_temp.next();
				// System.out.println("ID Calle: " + cl.getId());
				auxi = punto_equivalente(cl.getInicio(), T);
				auxf = punto_equivalente(cl.getFin(),    T);
				// Si la etiqueta de v es mayor que la suma de la etiqueta de u + el peso de la arista...
				if(auxf.getEtiqueta() > auxi.getEtiqueta() + cl.getDificultad()){
					// Reemplazo la etiqueta de v por la suma de la etiqueta de u + el peso de la arista...
					auxf.setEtiqueta(auxi.getEtiqueta() + cl.getDificultad());
					// Colocar en v ptero a u (para saber de donde vine)
					auxf.setAnterior(auxi);
				}
			}
			// System.out.println("Finalize iteracion");
			// 6) Quito a u de T y voy al paso 3) 
			u.setLeido(true);
			u = Collections.min(puntos_activos(T), new etq_comparator());	// Repteticion del paso 3)
		
			// Caso Especial(q se ejecuta a partir del segundo minimo obtenido)
			// Si el punto/esquina con minima etiqueta tiene infinito entonces corto
			if(u.getEtiqueta() == Integer.MAX_VALUE){
				existe_camino = false;
				break;	// Si, señores, rompo el bucle.
			}
			
			//System.out.println("Min: " + u.getId() + " con etiq: " + u.getEtiqueta() + "\n") ;
		}
		
		
		if (existe_camino){
			Punto_M auxini = punto_equivalente(pini, T);
			Punto_M auxfin = punto_equivalente(pfin, T);
			constuir_camino_de_puntos(auxini, auxfin, ret);
			Collections.reverse(ret);
			construir_camino_de_calles(ret, c.obtener_calles(), ret2);
		}
		
		return ret2;
	}

	// ALGORITMOS DEL PASO 1
	
	private static class Punto_M extends Punto { //inner class
		private int etiqueta;
		private Punto_M anterior = null;
		private boolean leido = false; 
		
		public Punto_M(){
			this(0,0,0);
		}
		public Punto_M(long id, float x, float y) {
			super(id, x, y);
		}
		public Punto_M(Punto p){
			this(p.getId(),p.getX(),p.getY());
		}
		
		public void setEtiqueta(int i) {
			this.etiqueta = i;	
		}
		public int getEtiqueta() {
			return this.etiqueta;
		}
		public void setAnterior(Punto_M p) {
			this.anterior = p;
		}
		public Punto_M getAnterior() {
			return this.anterior;
		}
		
		public void setLeido(boolean leido) {
			this.leido = leido;
		}
		public boolean isLeido() {
			return leido;
		}
	}
	
	private static class etq_comparator implements Comparator<Punto_M>{

		public int compare(Punto_M p1, Punto_M p2) {
			int ret;
			int etq1 = p1.getEtiqueta();        
			int etq2 = p2.getEtiqueta();
			
			if(etq1 > etq2)
				ret =  1;
			else if(etq1 < etq2)
				ret = -1;
			else
				ret =  0;  
			return ret;
		}
	}
		
	private static ArrayLista<Punto_M> To_Mi_Punto(ArrayLista<Punto> ar){
		ArrayLista<Punto_M> aux = new ArrayLista<Punto_M>();
		Punto_M auxiliar;
		Punto p;
		Iterator<Punto> i = ar.iterator();
		while(i.hasNext()){
			p = i.next();
			auxiliar = new Punto_M(p);
			aux.add(auxiliar);
		}
			return aux;
	}
		
	// ALGORITMOS DEL PASO 3
	/** 
	 * @param ptos
	 * @return Un array lista con los puntos que tienen sus flag is leido en false
	 */
	private static ArrayLista<Punto_M> puntos_activos(ArrayLista<Punto_M> ptos) {
		ArrayLista<Punto_M> ret = new ArrayLista<Punto_M>();
		Iterator<Punto_M> it_ptos = ptos.iterator() ;
		Punto_M p;
	
		while(it_ptos.hasNext()){
			p = it_ptos.next();
			if(p.isLeido() == false)
				ret.add(p);
		}
			
		return ret;
	}
	
	// ALGORITMOS DEL PASO 5
	/**	Busca las calles en arraylista a, tal que comienzen en el punto u y terminen 
	 *  en algun v perteneciente a t
	 * @definicion ArrayLista<Calle> buscar_calles(ArrayLista<Calle> a, Punto u, ArrayLista<Punto> t)
	 * @param ArrayLista<Calle> a (Las calles en donde busco)
	 * @param Punto u (El punto con el que tienen que comenzar las calles)
	 * @param ArrayLista<Punto> t (El punto final tiene que estar en t)
	 * @return	ArrayLista<Calle> Calles q arrancan en u y terminan an algun v perteneciente a "a" 
	 */
	private static ArrayLista<Calle> obtener_vecinos(ArrayLista<Calle> a, Punto_M u,
			ArrayLista<Punto_M> t) {
		
		ArrayLista<Calle> ret = new ArrayLista<Calle>();
		Iterator<Calle> i = a.iterator(); 
		Calle tmp;
		
		while(i.hasNext()){
			tmp = i.next(); 	
			if(tmp.getInicio().equals(u) && t.contains(tmp.getFin())){
				ret.add(tmp);
			}
		}
		return ret;
	}
	
	private static Punto_M punto_equivalente(Punto p, ArrayLista<Punto_M> t){
		Punto_M prox = null;
		boolean enc = false;
		Iterator<Punto_M> it = t.iterator();
		while(it.hasNext() && !enc){
			prox = it.next(); 
			if(prox.getId() == p.getId()){
				enc = true;
			}
		}
		
		return prox;
	}
	
	// ALGORITMOS DE RECONSTRUCCION DE CAMINO
	/**	Metodo recursivo que devuelve el camino obtenido
	 * @definicion void constuir_camino(Punto pini, Punto pfin, ArrayLista<Punto> ret)
	 * @param (in) Punto pini - El punto de inicio
	 * @param (in) Punto pfin - El punto de fin	
	 * @param (out)ArrayLista<Punto> ret -	Un arraylista con todos los puntos del camino
	 * Nota: Se puede reemplazar x uno iterativo
	 */
	private static void constuir_camino_de_puntos(Punto_M pini, Punto_M pfin, ArrayLista<Punto_M> ret) {
		if (pfin.getAnterior().equals(pini)){
			ret.add(pfin);
			ret.add(pini);
		}
		else {
			ret.add(pfin);
			constuir_camino_de_puntos(pini, pfin.getAnterior(), ret);
		}
	}

	/** Busca la calle con inicio p1 y fin p2
	 * @param p1
	 * @param p2
	 * @param calles_en_ciudad
	 * @return Una calle tal que posea p1 como punto de inicio y p2 como punto de fin
	 */
	private static Calle buscar_calle(Punto p1, Punto p2, ArrayLista<Calle> calles_en_ciudad) {
		Iterator<Calle> i = calles_en_ciudad.iterator();
		Calle next = null;
		boolean encontrado = false;
		while(i.hasNext() && !(encontrado)){
			next = i.next();
			if(next.getInicio().equals(p1) && next.getFin().equals(p2)){
				encontrado = true;
			}
		}
		
		return next;
	}
			
	/** A partir de una ciudad y un conjunto (ordenado) de ptos, retorna un 
	 * camino de calles
	 * @param camino_de_ptos
	 * @param calles_en_ciudad
	 * @return Un camino de calles
	 */
	private static void construir_camino_de_calles(ArrayLista<Punto_M> camino_de_ptos,
				        					ArrayLista<Calle> calles_en_ciudad, 
		        							ArrayLista<Calle> ret) {
		
		Iterator<Punto_M> it_pto  = camino_de_ptos.iterator(); 
		Calle c_tmp;
		
		Punto_M p1 = (it_pto.hasNext() )? it_pto.next(): new Punto_M();
		Punto_M p2 = null;
		
		while(it_pto.hasNext()){
			p2 =  it_pto.next();
			// Busco en calles_en_ciudad la calle que empieze en p1 y termine en p2
			c_tmp = buscar_calle(p1, p2, calles_en_ciudad);
			// Agrego la calle a cam_calles
			ret.add(c_tmp);
			// p2 pasa a ser p1
			p1 = p2;
		}
		
	}
	
}
