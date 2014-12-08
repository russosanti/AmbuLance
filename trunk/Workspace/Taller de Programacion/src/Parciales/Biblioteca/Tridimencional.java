package Parciales.Biblioteca;

import java.util.ArrayList;

public class Tridimencional extends Biblioteca{
	
	public Tridimencional(int n, Interfaz i) {
		super(n,n*n*n,i);
	}

	public void archivar(Objeto_Biblio o,int x , int y, int z) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		indi.add(new Integer(y));
		indi.add(new Integer(z));
		int abs = this.rel_a_absolut(indi);
		this.archivar(o,abs);
	}
	
	public Objeto_Biblio retirar(int x, int y, int z) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		indi.add(new Integer(y));
		indi.add(new Integer(z));
		int abs = this.rel_a_absolut(indi);
		return this.retirar(abs);
	}

	protected int rel_a_absolut(ArrayList<Integer> ar) throws Biblioteca_Exception{
		if(!this.pos_valida(ar)){
			throw new Biblioteca_Exception("El indice pasado no es valido");
		}else{
			int x = ar.get(0);
			int y = ar.get(1);
			int z = ar.get(2);
			int n = this.get_Tamano();
			return (z*(n*n)+(y*n)+x);
		}
	}
	
	protected boolean pos_valida(ArrayList<Integer> ar){
		if(ar.size()>3 || ar.size()<=0){
			return false;
		}else{
			int x = ar.get(0);
			int y = ar.get(1);
			int z = ar.get(2);
			int n = this.get_Tamano();
			if(x < n && y < n && z < n){
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
