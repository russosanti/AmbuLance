package Parciales.Biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cargar_BD {
	
	Interfaz i;
	
	public Cargar_BD(Interfaz inter){
		this.i = inter;
	}
	
	public void cargar(Bidimensional biblio){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c = DriverManager.getConnection("jdbc:odbc:BDLibros");
			Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet r = s.executeQuery("Select * from Libro");
			Statement s1 = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet r2 = s1.executeQuery("Select * from Ubicacion");
			long cod = 0;
			r.first();
			boolean encontro = false;
			int posx = -1;
			int posy = -1;
			Libro aux;
			do{
				cod = r.getLong(1);
				r2.first();
				encontro = false;
				do{
					if(r2.getLong(3)==cod){
						encontro = true;
						posx = r2.getInt(1);
						posy = r2.getInt(2);
					}
				}while(r2.next() && !encontro);
				if(!encontro){
					i.error("No se encontro Ubicacion para el objeto: "+cod);
				}else{
					aux = new Libro(cod,r.getString(2),r.getString(3),r.getString(4));
					try {
						biblio.archivar(aux,posx,posy);
					} catch (Biblioteca_Exception e) {
						i.error(e.getMessage());
					}
				}
			}while(r.next());
			r.close();
			r2.close();
			s.close();
			c.close();
		}catch(ClassNotFoundException e){
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
