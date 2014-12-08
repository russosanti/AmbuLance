package Testers;

import java.util.Iterator;
import Utils.ArrayLista;
import Utils.Spath;
import Sistema.Tipos.*;

public class test_camino {

	public static void mainsp(String[] args) {
		// Creo mi ciudad vacia
		Ciudad c = new Ciudad(null);
		int i;
		// Creo un arrelgo de ptos y lo inserto en ciudad
		Punto ptos[] = new Punto[8];
	
		for(i=0;i<ptos.length;i++){
			ptos[i] = new Punto(i,i+1,i+2);
			c.crear_esquina(ptos[i]);
		}
	
		// Creo las calles y las inserto tambien 
		Calle clls[] = new Calle[13];

		// Incializo las calles
		clls[0]  =  new Calle(0,ptos[0], ptos[1]);
		clls[0].setDificultad(3);
		clls[1]  =  new Calle(1,ptos[0], ptos[3]);
		clls[1].setDificultad(8);
		clls[2]  =  new Calle(2,ptos[0], ptos[4]);
		clls[2].setDificultad(1);
		clls[3]  =  new Calle(3,ptos[1], ptos[2]);
		clls[3].setDificultad(0);
		clls[4]  =  new Calle(4,ptos[2], ptos[3]);
		clls[4].setDificultad(0);
		clls[5]  =  new Calle(5,ptos[2], ptos[7]);
		clls[5].setDificultad(1);
		clls[6]  =  new Calle(6,ptos[3], ptos[6]);
		clls[6].setDificultad(1);
		clls[7]  =  new Calle(7,ptos[3], ptos[7]);
		clls[7].setDificultad(2);
		clls[8]  =  new Calle(8,ptos[4], ptos[5]);
		clls[8].setDificultad(0);
		clls[9]  =  new Calle(9,ptos[5], ptos[3]);
		clls[9].setDificultad(1);
		clls[10] =  new Calle(10,ptos[6],ptos[7]);
		clls[10].setDificultad(1);
		clls[11] =  new Calle(11,ptos[5],ptos[4]);
		clls[11].setDificultad(0);
		clls[12] =  new Calle(12,ptos[7],ptos[2]);
		clls[12].setDificultad(0);
		
		for(i=0;i<clls.length;i++)
			c.crear_calle(clls[i]);
				
		// Testeamos la creacion de todo
		/*
		Iterator<Punto> it_esq = c.obtener_esquinas().iterator();
		while(it_esq.hasNext()){
			System.out.println("ID Esquina: " + it_esq.next().getId());
		}
			
		Iterator<Calle> it_clle = c.obtener_calles().iterator();
		Calle c_tmp;
		while(it_clle.hasNext()){
			c_tmp = it_clle.next();
			System.out.println("ID Calle: " + c_tmp.getId() + 
							   " ppio:" 	+ c_tmp.getInicio().getId() + 
							   " fin:" 		+ c_tmp.getFin().getId() + 
							   " dif:" 		+ c_tmp.getDificultad());
		}
		*/
		
		ArrayLista<Calle> camino = Spath.camino_mas_corto(ptos[0], ptos[7], c);
		// ArrayLista<Calle> camino = Spath.camino_mas_corto(ptos[7], ptos[0], c, null); // NO existe camino
			
		if(camino.isEmpty()){
			System.out.println("No existe el camino");
		}else {
			Iterator<Calle> it = camino.iterator();
			while(it.hasNext()){
				System.out.print("->" + it.next().getId());
			}
		}
		
		
	}

}
