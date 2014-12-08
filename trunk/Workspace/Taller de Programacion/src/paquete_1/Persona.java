package paquete_1;

public abstract class Persona {
	//Attributes
	private String nombre;
	private int edad;
	private Ciudad ciudad_nacimiento;
	private Ciudad ciudad_recidencia;
	private int cant_mudanzas = 0;
	
	//Methods
	
	public Persona(String n,Ciudad cn){
		this(n,0,cn); //si no le quiero pasar nada como objeto le pongo null
	}
	
	public Persona(String n, int e,Ciudad cn){
		this.nombre = n;
		this.edad = e;
		this.ciudad_nacimiento = cn;
		this.ciudad_recidencia= cn;
	}
	
	//puedo poner this en todo los atributos pero da igual
	public void poner_nombre(String n){
		this.nombre = n;
	}
	
	public String obtener_nombre(){
		return this.nombre;
	}
	
	public void poner_edad(int e){
		edad = e;
	}
	
	public void cumplir_anios(){
		edad = edad+1;
	}
	
	public int obtener_edad(){
		return edad;
	}

	public void mudar_a(Ciudad ciudad_recidencia) {
		this.ciudad_recidencia = ciudad_recidencia;
		this.cant_mudanzas++;
	}

	public Ciudad ciudad_recidencia() {
		return this.ciudad_recidencia;
	}
	
	public int cant_mudanzas(){
		return this.cant_mudanzas;
	}
	
	public int tiempodevida(){
		return(edad + this.coef_nacionalidad());
	}
	public abstract int coef_nacionalidad();
}
