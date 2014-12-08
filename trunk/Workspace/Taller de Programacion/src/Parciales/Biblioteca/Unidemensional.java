package Parciales.Biblioteca;

import java.util.ArrayList;

public class Unidemensional extends Biblioteca{

	public Unidemensional(int n, Interfaz i) {
		super(n,n,i);
	}
	
	public void archivar(Objeto_Biblio o,int x) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		int abs = this.rel_a_absolut(indi);
		this.archivar(o,abs);
	}
	
	public Objeto_Biblio retirar(int x) throws Biblioteca_Exception{
		ArrayList<Integer> indi = new ArrayList<Integer>();
		indi.add(new Integer(x));
		int abs = this.rel_a_absolut(indi);
		return this.retirar(abs);
	}

	protected int rel_a_absolut(ArrayList<Integer> ar) throws Biblioteca_Exception{
		if(!this.pos_valida(ar)){
			if(ar.size()>1 || ar.size()<=0){
				throw new Biblioteca_Exception("La cantidad de indices pasadas no es valida para este tipo de biblioteca");
			}else{
				throw new Biblioteca_Exception("El indice pasado no es valido");
			}
		}else{
			return ar.get(0);
		}
	}
	
	protected boolean pos_valida(ArrayList<Integer> ar){
		if(ar.size()>1 || ar.size()<=0){
			return false;
		}else{
			int x = ar.get(0);
			if(x < this.get_Tamano()){
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
