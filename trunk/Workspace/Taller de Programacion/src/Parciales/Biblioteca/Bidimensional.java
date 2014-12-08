package Parciales.Biblioteca;

import java.util.ArrayList;

public class Bidimensional extends Biblioteca{
	
	public Bidimensional(int n, Interfaz i) {
		super(n,n*n,i);
	}

	public void archivar(Objeto_Biblio o,int x , int y) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		indi.add(new Integer(y));
		int abs = this.rel_a_absolut(indi);
		this.archivar(o,abs);
	}
	
	public Objeto_Biblio retirar(int x, int y) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		indi.add(new Integer(y));
		int abs = this.rel_a_absolut(indi);
		return this.retirar(abs);
	}

	protected int rel_a_absolut(ArrayList<Integer> ar) throws Biblioteca_Exception{
		if(!this.pos_valida(ar)){
			throw new Biblioteca_Exception("El indice pasado no es valido");
		}else{
			int x = ar.get(0);
			int y = ar.get(1);
			int n = this.get_Tamano();
			return (y*n + x);
		}
	}
	
	protected boolean pos_valida(ArrayList<Integer> ar){
		if(ar.size()>2 || ar.size()<=0){
			return false;
		}else{
			int x = ar.get(0);
			int y = ar.get(1);
			int n = this.get_Tamano();
			if(x < n && y < n){
				return true;
			}
			return false;
		}
	}
	
	protected ArrayList<Integer> absolut_a_rel(int abs) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(abs);
		return ar;
	}
}
