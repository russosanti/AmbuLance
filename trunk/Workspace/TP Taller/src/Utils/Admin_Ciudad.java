package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Excepciones.AccesoBaseDatosException;
import Sistema.Tipos.Calle;
import Sistema.Tipos.Punto;
import Utils.Calle_Stream;
import Utils.Punto_Stream;
/** Clase que encapsula la carga del mapa desde un paquete de archivos
 * @author Santiago Russo
 */
public class Admin_Ciudad {
	
	/** Utiliza la combinacion necesaria de objetos para crear la ciudad del paquete s.
	 * @Definition public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s)
	 * @param esquinas ArrayLista<'Punto'> - Esquinas de la ciudad para cargar.
	 * @param calles ArrayLista<'Calle'> - Calles que voy a cargar.
	 * @param s String - Nombre del pack que debo cargar.
	*/
	public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s){
		Punto_Stream ps = new Punto_Stream(s);
		Calle_Stream cs = new Calle_Stream(s);
		esquinas.addAll(ps.leer_puntos());
		calles.addAll(cs.leer_calles(esquinas));
		
		
	}

	/** Carga los datos de ciudad a partir de una base de datos
	 * @Definition public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s)
	 * @param esquinas ArrayLista<'Punto'> - Esquinas de la ciudad para cargar.
	 * @param calles ArrayLista<'Calle'> - Calles que voy a cargar.
	 * @param idCiudad int - ID de la ciudad en la base de datos.
	 * @return 
	 * @throws Exception 
	*/
	public static boolean Cargar_Ciudad_BD(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles, String idCiudad) throws AccesoBaseDatosException {
		
		esquinas.clear();
		calles.clear();
		
		Connection c = null;
		int i;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible invocar al driver de Base de datos");
		}

		try {
			c = DriverManager.getConnection("jdbc:odbc:tptaller");
		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible conectar a la Base de datos");
		}
		PreparedStatement s;
		Long _id;
		Float _x,_y;
		
		try {

			//Statement s = c.createStatement();
			s = c.prepareStatement("select id, puntox, puntoy from Puntos where idciudad = ?");
			s.setString(1, idCiudad);
			
			ResultSet rs = s.executeQuery();
			
			while (rs.next()) {
				_id = rs.getLong("id");

				_x = (float) rs.getInt("puntox");
				_y = (float) rs.getInt("puntoy");
				
				Punto unPunto = new Punto(_id, _x, _y);
				esquinas.add(unPunto);
			}
			rs.close();
			s.close();
			

		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible seleccionar tabla Puntos: " + e.getMessage());
		}
		try {

			s = c.prepareStatement("select inicio, fin, nro_ini, nro_fin, nombre from calles where idciudad = ?");
			s.setString(1, idCiudad);
			
			ResultSet rs = s.executeQuery();

			Integer _inicio,_fin;
			Punto _pto_inicio = null,_pto_fin = null;
			Integer _nro_ini,_nro_fin;
			String _nombre;
			
			while (rs.next()) {
				_id = new Long(rs.getRow());
				_inicio = rs.getInt("INICIO");
				_fin = rs.getInt("FIN");
				
				for (i=0; i<esquinas.size();i++) {
					Punto elPunto = esquinas.get(i);
					if (elPunto.getId() == _inicio) {
						_pto_inicio = elPunto;
						break;
					}
				}
				for (i=0; i<esquinas.size();i++) {
					Punto elPunto = esquinas.get(i);
					if (elPunto.getId() == _fin) {
						_pto_fin = elPunto;
						break;
					}
				}

				_nro_ini = rs.getInt("NRO_INI");
				_nro_fin = rs.getInt("NRO_FIN");
				_nombre = rs.getString("NOMBRE");

				Calle unaCalle = new Calle(_id, _pto_inicio, _pto_fin, _nombre, _nro_ini, _nro_fin);
				calles.add(unaCalle);
			}
			rs.close();
			c.close();

		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible seleccionar tabla Ciudad: " + e.getMessage());
		}
		
		return true;
	}
	
	/** Guarda los datos de ciudad en una base de datos
	 * @Definition public static void Crear_Ciudad(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles,String s)
	 * @param esquinas ArrayLista<'Punto'> - Esquinas de la ciudad para cargar.
	 * @param calles ArrayLista<'Calle'> - Calles que voy a cargar.
	 * @param idCiudad int - ID de la ciudad en la base de datos.
	 * @throws Exception 
	*/
	public static boolean Grabar_Ciudad_BD(ArrayLista<Punto> esquinas,ArrayLista<Calle> calles, String idCiudad) throws AccesoBaseDatosException {
		
		Connection c = null;
		int CantidadRegistros = 0;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} 
		catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible invocar al driver de Base de datos");
		}

		try {
			c = DriverManager.getConnection("jdbc:odbc:tptaller");
		} 
		catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible conectar a la Base de datos");
		}
		PreparedStatement s;
	
		try { 
			s = c.prepareStatement("select count(*) as rowcount from Calles where idciudad = ?");
			s.setString(1,idCiudad);
			ResultSet rs = s.executeQuery();
			
			if (rs.next())
			CantidadRegistros = rs.getInt("rowcount"); 
			
			rs.close();
			s.close();
		}
		catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible acceder a la Base de datos");
		}
		
		if (CantidadRegistros != 0) {
			throw new AccesoBaseDatosException("Ya existe la ciudad con ID " + idCiudad);
		}
		
		try {
			for (Punto punto : esquinas) {
				s = c.prepareStatement("INSERT INTO Puntos (idciudad, id, puntox, puntoy) VALUES (?,?,?,?)");
				s.setString(1, idCiudad);
				s.setInt(2,(int) punto.getId());
				s.setInt(3, (int) punto.getX());
				s.setInt(4, (int) punto.getY());
				
				s.executeUpdate();
				s.close();
			}
			
		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible insertar en tabla Puntos: " + e.getMessage());
		}
		try {
			for (Calle calle : calles) {
				s = c.prepareStatement("insert into Calles (idciudad,inicio,fin,nombre,nro_ini,nro_fin) " +
				"values (?,?,?,?,?,?)");
				
				s.setString(1, idCiudad);
				s.setInt(2, (int) calle.getInicio().getId());
				s.setInt(3, (int) calle.getFin().getId());
				s.setString(4, calle.getNombre());
				s.setFloat(5, calle.getNro_ini());
				s.setFloat(6, calle.getNro_fin());
				
				s.executeUpdate();
				s.close();
			}
			c.close();

		} catch (Exception e) {
			throw new AccesoBaseDatosException("Imposible insertar en tabla Ciudad: " + e.getMessage());
		}

		return true;
	}
}
