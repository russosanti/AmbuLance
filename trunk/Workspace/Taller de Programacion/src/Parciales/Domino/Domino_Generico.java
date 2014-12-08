package Parciales.Domino;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Domino_Generico {
	
	private int fichas_x_jugador;
	private ArrayList<ArrayList<Ficha>> fichas;
	private ArrayList<Ficha> fichas_mesa;
	private Repertorio rep;
	private int turno;
	private int max_jugadores;
	private boolean empezado;
	private Interfaz i;
	
	protected Domino_Generico(int fichas,int jugadores){
		this.fichas_x_jugador = 0;
		this.turno = 1;
		this.max_jugadores = jugadores;
		this.fichas = new ArrayList<ArrayList<Ficha>>();
		ArrayList<Ficha> aux;
		for(int i=0;i<jugadores;i++){
			aux = new ArrayList<Ficha>();
			this.fichas.add(i,aux);
		}
		this.fichas_mesa = new ArrayList<Ficha>();
		this.rep = new Repertorio(fichas);
		i = new Interfaz();
	}
	
	public void iniciar_juego(){
		Ficha aux = this.rep.dar_ficha();
		this.fichas_mesa.add(aux);
		if(!this.puede_jugar()){
			this.ganador(2);
		}
		this.empezado = true;
		this.i.informar("Ficha en mesa: "+aux);
	}
	
	public boolean repartir() throws RuntimeException{
		if(!this.empezado){
			try{
				Iterator<ArrayList<Ficha>> i = this.fichas.iterator();
				Ficha aux;
				while(i.hasNext()){
					aux = this.rep.dar_ficha();
					i.next().add(this.rep.dar_ficha());
					this.i.informar("Se ha otorgado la ficha: "+aux+" al jugador "+this.turno);
					this.turno++;
				}
				return true;
			}catch(RuntimeException e){
				return false;
			}
			finally{
				this.turno = 1;
			}
		}else{
			throw new RuntimeException("El juego ya ha empezado, no se puede repartir en este momento.");
		}
	}
	
	//si inserto por derecha el que coincide es lado 1, si inserto por izquierda el que coincide es lado 2
	public int jugar_ficha(int lado1,int lado2,char izq_der)throws FichaInexistenteException,RuntimeException{
		if(this.empezado){
			Ficha f = this.obtener_ficha(lado1,lado2);
			if(f==null){
				throw new FichaInexistenteException("La ficha ingresada no pertenece al conjunto de fichas del jugador");
			}else{
				Ficha extremo;
				if(izq_der=='D'||izq_der=='d'){
					extremo = this.fichas_mesa.get(this.fichas_mesa.size()-1);
					if(this.Compatibilidad(lado1,extremo.lado1,lado2,extremo.lado2,this.fichas_mesa.size())){
						this.tirar_ficha_mesa(f,izq_der);
					}else{
						return -1;
					}
				}else{
					extremo = this.fichas_mesa.get(0);
					if(this.Compatibilidad(lado2,extremo.lado1,lado1,extremo.lado2,this.fichas_mesa.size())){
						this.tirar_ficha_mesa(f,izq_der);
					}else{
						return -1;
					}
				}
			}
			if(this.fichas.get(this.turno).size()==0){
				this.ganador(this.turno);
				return this.turno;
			}
			int gan = this.turno;
			this.siguiente_turno();
			if(!this.puede_jugar()){
				this.ganador(gan);
				return gan;
			}
			return 0;
		}else{
			throw new RuntimeException("Para poder jugar debe iniciar el jugo.");
		}
	}
	
	private boolean puede_jugar(){
		ArrayList<Ficha> f = this.fichas.get(this.turno-1);
		Iterator<Ficha> iter = f.iterator();
		Ficha aux;
		boolean puede = false;
		int ex1 = this.fichas_mesa.get(this.fichas_mesa.size()-1).lado1;
		int ex2 = this.fichas_mesa.get(this.fichas_mesa.size()-1).lado2;
		while(iter.hasNext() && !puede){
			aux = iter.next();
			puede = (this.Compatibilidad(aux.lado1,ex1,aux.lado2,ex2,this.fichas_mesa.size())||
					this.Compatibilidad(aux.lado1,ex2,aux.lado2,ex1,this.fichas_mesa.size())||
					this.Compatibilidad(aux.lado2,ex1,aux.lado1,ex2,this.fichas_mesa.size())||
					this.Compatibilidad(aux.lado2,ex2,aux.lado1,ex1,this.fichas_mesa.size()));
		}
		return puede;
	}
	
	private int ganador(int jug){
		i.informar("Gano: "+jug);
		return jug;
	}
	
	private Ficha obtener_ficha(int x,int y){
		ArrayList<Ficha> ar = this.fichas.get(this.turno+1);
		Iterator<Ficha> it = ar.iterator();
		Ficha aux;
		while(it.hasNext()){
			aux = it.next();
			if(aux.lado1==x && aux.lado2==y){
				return aux;
			}
			if(aux.lado1==y && aux.lado2==x){ //si el que busca esta al reves se lo devuelvo girado
				aux.girar();
				return aux;
			}
		}
		return null;
	}
	
	private boolean tirar_ficha_mesa(Ficha f,char lado){
		if(lado=='D'||lado=='d'){
			this.fichas_mesa.add(f);
			return true;
		}else{
			if(lado=='I'||lado=='i'){
				this.fichas_mesa.add(f); //simplemente para crear un lugar mas
				int i = this.fichas_mesa.size() - 2;
				while(i>=0){
					this.fichas_mesa.add(i+1,this.fichas_mesa.get(i));
				}
				this.fichas_mesa.add(0,f);
				return true;
			}else{
				return false;
			}
		}
	}
	
	private void siguiente_turno(){
		this.turno++;
		if(this.turno>this.max_jugadores){
			this.turno = 1;
		}
	}
	//voy a pegar l1 con extr1
	protected abstract boolean Compatibilidad(int l1,int extr1,int l2,int extr2,int fichas_mesa);
}
