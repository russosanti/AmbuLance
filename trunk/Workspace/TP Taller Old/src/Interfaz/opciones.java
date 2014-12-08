package Interfaz;

public enum opciones {
	
	// Comandos
	salir, help, cargar, crear, comprar, cambiar, iniciar,
	detener, responder, pedir, error, adelantar, clear, test,
	// Objetos a los que aplican los comandos
	punto, 
	calle, 
	dificultad, 
	hospital,
	
	// En particular, las tipos de ambulancias que puedo crear
	camion,
	camioneta,
	helicoptero,
	moto;

	public static opciones toOpcion(String str)
    {
		opciones o;
        try {
            o = valueOf(str);
        } 
        catch (Exception ex) {
            o = error;
        }
        return o;    
    } 
}
