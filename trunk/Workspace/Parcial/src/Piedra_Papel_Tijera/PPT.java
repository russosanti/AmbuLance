package Piedra_Papel_Tijera;

import java.util.ArrayList;
import Interfaz.Interfaz;
import Reglas.Reglas_Continuacion;
import Reglas.Reglas_NoAccion;

public class PPT {
	
	private boolean en_juego;
	private long max_turnos;
	private long turno_actual;
	private Jugador p1;
	private Jugador p2;
	private Interfaz i;
	private ArrayList<Eleccion> jugadas_ant1;
	private ArrayList<Eleccion> jugadas_ant2;
	private Ampire ampire;
	private Eleccion jugada_actual1;
	private Eleccion jugada_actual2;
	private long empates;
	private Admin_Partidas admin;
	
	public PPT(long turnos,Interfaz i,ArrayList<Reglas_NoAccion> r_noaccion,ArrayList<Reglas_Continuacion> r_cont,boolean tipo_admin){
		this.max_turnos = turnos;
		this.turno_actual = 1;
		this.empates = 0;
		this.p1 = new Jugador();
		this.p2 = new Jugador();
		this.ampire = new Ampire(r_noaccion,r_cont);
		this.jugada_actual1 = null;
		this.jugada_actual2 = null;
		admin = new Admin_Partidas(tipo_admin);
	}
	
	public void setNombre1(String n){
		this.setNombre1(n);
	}
	public void setNombre2(String n){
		this.setNombre2(n);
	}
	
	public void cargar(String id){
		ArrayList<Long> puntajes = new ArrayList<Long>();
		this.admin.cargar(id, puntajes,this.jugada_actual1,this.jugada_actual2,this.jugadas_ant1,this.jugadas_ant2);
		this.p1.setPuntaje(puntajes.get(0));
		this.p2.setPuntaje(puntajes.get(1));
		this.empates = puntajes.get(2);
	}
	
	public void guardar(String id){
		this.admin.guardar(id,this.p1.getPuntaje(),this.p2.getPuntaje(),this.empates,this.jugada_actual1,this.jugada_actual2,this.jugadas_ant1,this.jugadas_ant2);
	}
	
	public void eleccion_1(Eleccion eleccion){
		if(this.ampire.valido(eleccion,this.jugadas_ant1,this.jugadas_ant2)){
			this.jugada_actual1 = eleccion;
			if(this.jugada_actual2!=null){
				if(Eleccion.isEleccion(this.jugada_actual2)){
					this.jugar();
				}else{
					i.error("Error logico en la applicacion");
				}
			}
		}else{
			i.informar("Jugador 1: Eleccion invalida debido al conjunto de reglas");
		}
	}
	
	public void eleccion_2(Eleccion eleccion){
		if(this.ampire.valido(eleccion,this.jugadas_ant2,this.jugadas_ant1)){
			this.jugada_actual2 = eleccion;
			if(this.jugada_actual1!=null){
				if(Eleccion.isEleccion(this.jugada_actual1)){
					this.jugar();
				}else{
					i.error("Error logico en la applicacion");
				}
			}
		}else{
			i.informar("Jugador 1: Eleccion invalida debido al conjunto de reglas");
		}
	}
	
	private void jugar(){
		int gana = Eleccion.gana(this.jugada_actual1,this.jugada_actual2);
		if(gana == 1){
			this.p1.gano();
		}else{
			if(gana == 2){
				this.p2.gano();
			}else{
				this.empates++;
			}
		}
		this.jugadas_ant1.add(this.jugada_actual1);
		this.jugadas_ant2.add(this.jugada_actual2);
		this.jugada_actual1 = null;
		this.jugada_actual2 = null;
		
		if(this.max_turnos == this.turno_actual){
			this.informar_ganador();
		}else{
			int gan = this.ampire.continua(this.p1.getPuntaje(),this.p2.getPuntaje(),this.empates);
			if(gan==1){
				this.informar_ganador(1);
			}else{
				if(gan==2){
					this.informar_ganador(2);
				}
			}
			this.turno_actual++;
		}
	}
	
	private void informar_ganador(){
		if(this.p1.getPuntaje()>this.p2.getPuntaje()){
			this.informar_ganador(1);
		}else{
			if(this.p1.getPuntaje()<this.p2.getPuntaje()){
				this.informar_ganador(2);
			}else{
				this.informar_ganador(0);
			}
		}
	}
	private void informar_ganador(int j){
		if(j==0){
			this.i.informar("EMPATE");
		}else{
			this.i.informar("GANADOOR JUGADOR: "+j);
		}
	}
}