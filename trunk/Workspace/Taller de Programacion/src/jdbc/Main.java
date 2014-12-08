package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void mainjdb(String[] args) {
		ej_prepared_statement("Argentina");
	}
	
	public static void ej_resultmetadata(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/universitios", "root", "admin123");
			PreparedStatement p = c.prepareStatement("Select * from pais where cod_pais=?");
			ResultSet r = p.executeQuery();
			ResultSetMetaData res = r.getMetaData(); 
			r.close();
			p.close();
			c.close();
		}catch(ClassNotFoundException e){
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ej_prepared_statement(String str){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/universitios", "root", "admin123");
			PreparedStatement p = c.prepareStatement("Select * from pais where cod_pais=?");
			p.setString(1,str);
			ResultSet r = p.executeQuery();
			r.first();
			System.out.println(r.getString(1));
			while(r.next()){
				System.out.println(r.getString(1));
			}
			int i = p.executeUpdate("Insert into pais values('Holanda')");
			System.out.println(i+" afectadas");
			r.close();
			p.close();
			c.close();
		}catch(ClassNotFoundException e){
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ej_statement(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/universitios", "root", "admin123");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("Select * from pais");
			r.first();
			System.out.println(r.getString(1));
			while(r.next()){
				System.out.println(r.getString(1));
			}
			int i = s.executeUpdate("Insert into pais values('Holanda')");
			System.out.println(i+" afectadas");
			r.close();
			s.close();
		}catch(ClassNotFoundException e){
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
