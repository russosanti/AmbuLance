package Piedra_Papel_Tijera;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaz.Singleton_Interfaz;
import Reglas.Reglas_Continuacion;
import Reglas.Reglas_NoAccion;

public class Ampire {
	private ArrayList<Reglas_NoAccion> reglas_acc;
	private ArrayList<Reglas_Continuacion> reglas_cont;
	
	public Ampire(ArrayList<Reglas_NoAccion> reglas,ArrayList<Reglas_Continuacion> reglas_c){
		this.reglas_acc = reglas;
		this.reglas_cont = reglas_c;
	}
	
	public boolean valido(Eleccion jugada,ArrayList<Eleccion> jugant_1,ArrayList<Eleccion> jugant_2){
		if(this.reglas_acc.isEmpty()){
			return true;
		}else{
			Iterator<Reglas_NoAccion> it = this.reglas_acc.iterator();
			if(it.hasNext()){
				Reglas_NoAccion reg = it.next();
				ArrayList<Eleccion> aux = new ArrayList<Eleccion>();
				aux.addAll(reg.eleccion(jugant_1, jugant_2));
				while(it.hasNext()){
					reg = it.next();
					this.intersecar(aux,reg.eleccion(jugant_1, jugant_2));
				}
				if(aux.isEmpty()){
					return true;
				}else{
					return this.existe_ele(aux,jugada);
				}
			}else{
				return true;
			}
		}
	}
	
	public int continua(long puntos1,long puntos2,long empates){
		Iterator<Reglas_Continuacion> it = this.reglas_cont.iterator();
		Reglas_Continuacion aux;
		int q_jug = 0;
		while(it.hasNext() && q_jug!=0){
			aux = it.next();
			q_jug = aux.solicitud_continuacion(puntos1, puntos2, empates);
		}
		if(q_jug==1 || q_jug==2){
			if(Singleton_Interfaz.get_Interfaz().continuar("Jugador"+q_jug+": Desea continuar la partida?")){
				return 0;
			}else{
				return q_jug;
			}
		}
		return 0;
	}
	
	private void intersecar(ArrayList<Eleccion> a,ArrayList<Eleccion> b){
		Iterator<Eleccion> ita = a.iterator();
		Eleccion ele;
		while(ita.hasNext()){
			ele = ita.next();
			if(!this.existe_ele(b,ele)){
				a.remove(a.indexOf(ele));
				ita = a.iterator(); //el nuevo iterator
			}
		}
	}
	
	private boolean existe_ele(ArrayList<Eleccion> ar,Eleccion busq){
		Iterator<Eleccion> it = ar.iterator();
		boolean encontro = false;
		Eleccion aux;
		while(it.hasNext() && !encontro){
			aux = it.next();
			if(aux == busq){
				encontro = true;
			}
		}
		return encontro;
	}
}
