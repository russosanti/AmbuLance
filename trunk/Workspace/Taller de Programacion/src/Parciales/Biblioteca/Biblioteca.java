package Parciales.Biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

//si yo le pongo un generic <t> representando el tipo de objeto que tiene me genera una restriccion que
//la biblioteca contiene solo objetos del mismo tipo <t>
public abstract class Biblioteca {
	
	private ArrayList<Objeto_Biblio> bib;
	private int tam;
	private Interfaz i;
	
	protected Biblioteca(int n,int tam, Interfaz i){
		bib = new ArrayList<Objeto_Biblio>(tam);
		for(int a=0;a<tam;a++){
			bib.add(a,null);
		}
		this.tam = n;
		this.i = i;
	}
	
	public int get_Tamano(){
		return this.tam;
	}
	
	public void archivar(Objeto_Biblio o,int indice) throws Biblioteca_Exception{
		try{
			if(bib.get(indice)==null){
				o.set_Biblioteca(this);
				o.set_pos_actual(indice);
				bib.set(indice,o);
			}else{
				throw new Biblioteca_Exception("El indice donde se quiere archivar ya tiene un elemento");
			}
		}catch(Exception e){
			throw new Biblioteca_Exception("El indice donde se quiere archivar es mayor que el tamano de la biblioteca");
		}
	}
	
	public Objeto_Biblio retirar(int absolut) throws Biblioteca_Exception{
		try{
			Objeto_Biblio aux = bib.get(absolut);
			if(aux==null){
				throw new Biblioteca_Exception("El casillero de donde se quiere retirar esta vacio");
			}else{
				bib.set(absolut,null);
				aux.set_Biblioteca(null);
				aux.set_pos_actual(-1);
				return aux;
			}
		}catch(Exception e){
			throw new Biblioteca_Exception("El indice donde se quiere retirar es mayor que el tamano de la biblioteca");
		}
	}
	
	public void mostrar_estado(){
		String informe;
		ArrayList<Integer> ar;
		Iterator<Integer> it;
		int aux;
		for(int i=0;i<this.bib.size();i++){
			informe = "Coordenadas: (";
			ar = this.absolut_a_rel(i);
			it = ar.iterator();
			while(it.hasNext()){
				aux = it.next().intValue();
				informe = informe + aux;
				if(it.hasNext()){
					informe = informe + ";";
				}
			}
			informe = informe + ") Estado: ";
			if(this.bib.get(i)==null){
				informe = informe + "Libre";
			}else{
				informe = informe + "Ocupado";
			}
			this.i.informar_estado(informe);
		}
		informe = "";
		informe = informe + "Total Ocupados: " + this.cant_ocupados() + " de " + this.tam; 
	}
	
	public int cant_ocupados(){
		int ocupados = 0;
		for(int i=0;i<this.bib.size();i++){
			if(this.bib.get(i)!=null){
				ocupados++;
			}
		}
		return ocupados;
	}
	
	protected abstract int rel_a_absolut(ArrayList<Integer> ar) throws Biblioteca_Exception;
	protected abstract boolean pos_valida(ArrayList<Integer> ar);
	protected abstract ArrayList<Integer> absolut_a_rel(int abs);
}
