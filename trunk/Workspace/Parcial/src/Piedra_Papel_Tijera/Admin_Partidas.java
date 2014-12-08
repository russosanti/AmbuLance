package Piedra_Papel_Tijera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Interfaz.Singleton_Interfaz;

public class Admin_Partidas {
	private boolean grabador_pantalla;
	
	public Admin_Partidas(boolean estilo){
		this.grabador_pantalla = estilo; 
	}
	
	public void guardar(String id,long punt1,long punt2,long emp,Eleccion ja1,Eleccion ja2,
			ArrayList<Eleccion> jug_ant1,ArrayList<Eleccion> jug_ant2){
		if(this.grabador_pantalla){
			//muestra por pantalla
		}else{
			this.guardar_bd(id,punt1,punt2,emp,ja1,ja2,jug_ant1,jug_ant2);
		}
	}
	
	public void cargar(String id,ArrayList<Long> puntajes,Eleccion ja1,Eleccion ja2,
			ArrayList<Eleccion> jug_ant1,ArrayList<Eleccion> jug_ant2){
		if(!this.grabador_pantalla){
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection c = DriverManager.getConnection("jdbc:odbc:Parcial_Taller");
				
			}catch(ClassNotFoundException e){
				Singleton_Interfaz.get_Interfaz().error(e.getMessage());
			}catch (SQLException e) {
				Singleton_Interfaz.get_Interfaz().error(e.getMessage());
			}
		}
	}
	
	private void guardar_bd(String id,long punt1,long punt2,long emp,Eleccion ja1,Eleccion ja2,
			ArrayList<Eleccion> jug_ant1,ArrayList<Eleccion> jug_ant2){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c = DriverManager.getConnection("jdbc:odbc:Parcial_Taller");
			PreparedStatement s = c.prepareStatement("INSERT INTO Juego (Id,Punt1,Punt2,Empates,Jug_Actual1,Jug_Actual2) VALUES (?,?,?,?,?,?)");
			s.setString(1, id);
			s.setLong(2,punt1);
			s.setLong(3,punt2);
			s.setLong(4,emp);
			s.setString(5,Eleccion.toString(ja1));
			s.setString(6,Eleccion.toString(ja2));
			s.executeUpdate();
			s.close();
			
			Iterator<Eleccion> it = jug_ant1.iterator();
			Eleccion aux;
			while(it.hasNext()){
				aux = it.next();
				s = c.prepareStatement("INSERT INTO Jugadas_1 (Id,Jugada) VALUES (?,?)");
				s.setString(1,id);
				s.setString(2,Eleccion.toString(aux));
			}
			
			it = jug_ant2.iterator();
			while(it.hasNext()){
				aux = it.next();
				s = c.prepareStatement("INSERT INTO Jugadas_2 (Id,Jugada) VALUES (?,?)");
				s.setString(1,id);
				s.setString(2,Eleccion.toString(aux));
			}
			
			
		}catch(ClassNotFoundException e){
			Singleton_Interfaz.get_Interfaz().error(e.getMessage());
		} catch (SQLException e) {
			Singleton_Interfaz.get_Interfaz().error(e.getMessage());
		}
	}
}
