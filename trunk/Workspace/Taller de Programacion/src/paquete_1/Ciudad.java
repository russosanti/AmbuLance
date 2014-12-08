package paquete_1;

public class Ciudad{
	private String nombre;
	private int latitud;
	private int longitud;
	private String pais_pertenece;
	
	public Ciudad(String n,String p,int lat, int lon){
		this.nombre = n;
		this.pais_pertenece = p;
		this.latitud = lat;
		this.longitud = lon;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais_pertenece() {
		return pais_pertenece;
	}
}
