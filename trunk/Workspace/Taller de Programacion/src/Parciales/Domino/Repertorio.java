package Parciales.Domino;

import java.util.ArrayList;

public class Repertorio {
	ArrayList<Ficha> repertorio;
	
	public Repertorio(int max){
		this.repertorio = new ArrayList<Ficha>();
		Ficha f;
		for(int i=0;i<=max;i++){
			for(int j=max;j>=i;j--){
				f = new Ficha(i,j);
				this.repertorio.add(f);
			}
		}
	}
	
	public Ficha dar_ficha(){
		Ficha aux;
		int index = (int)(Math.random()*this.repertorio.size());
		aux = this.repertorio.get(index);
		this.repertorio.remove(index);
		return aux;
	}
}
