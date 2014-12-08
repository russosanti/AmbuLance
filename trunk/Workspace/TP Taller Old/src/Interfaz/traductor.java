package Interfaz;

import java.util.ArrayList;
import Sistema.Sistema;
import Sistema.Tipos.Ambulancias.*;

public class traductor {

	public static void traducir(ArrayList<String> as, IUser i, Sistema s){
		
		if(as != null){

			switch (opciones.toOpcion(as.get(0))){

			case iniciar:   
				s.iniciar_simul();
			break;

			case salir :
				i.informar("Se salio del sistema con exito");
				i.salir();
			break;

			case clear:
				i.borrar_pantalla();
			break;

			case help:
				i.informar("Comandos del sistema");
				i.informar("salir, help, cargar, crear, comprar, cambiar, iniciar, pedido, error");
			break;

			case error:
				i.error("Comando incorrecto - Digite help para ver los comandos disponibles");
			break;
			
			case test:
				s.test();
			break;
		
			case detener:
				s.finalizar_sim();
			break;
			
			case adelantar:
				s.adelantar(Integer.parseInt(as.get(1)));
			break;
			
			case cargar:
				String str;

				try {
					str = as.get(1);		// Reviso que haya segundo param
					i.informar("Se cargara el paquete:" + str);
					s.crear_ciudad(str);	// Si hay, es el string del archivo
				} catch (IndexOutOfBoundsException e) {
					i.informar("Se creará una ciudad vacia");
					s.crear_ciudad();		// Si no hay, creo la ciudad vacia
				}
			break;

			case crear:
				// Se pueden crear puntos o calles o ambulancias
				switch (opciones.toOpcion(as.get(1))){
				case punto:
					try {
						int a =   Integer.parseInt(as.get(2));
						float x = Float.parseFloat(as.get(3));
						float y = Float.parseFloat(as.get(4));

						s.crear_pto(a,x,y);
					} catch (NumberFormatException e2) {
						i.error("Parametros incorrectos");
					}

				break;
				case calle:
					// Se subdivide en 2 casos
					// Caso 1
					try {
						String s7  = as.get(7);
						long id    = Long.parseLong(s7);
						long ini   = Long.parseLong(as.get(6));
						long fin   = Long.parseLong(as.get(5));
						String nom = as.get(4);
						int nro_i  = Integer.parseInt(as.get(3));
						int nro_f  = Integer.parseInt(as.get(2));
						s.crear_calle(id, ini, fin, nom, nro_i, nro_f);
					} catch(IndexOutOfBoundsException e) { 
					
						// Caso 2
						try {
							int a = Integer.parseInt(as.get(2));
							int b = Integer.parseInt(as.get(3));
							int c = Integer.parseInt(as.get(4));
	
							s.crear_calle(a,b,c);
						} catch (NumberFormatException e2) {
							i.error("Parametros incorrectos");
						}
					}
				break;
					// Se puede mejorar el tema del segundo param
				case error:
					i.error("El parametro es incorrecto, debe ser " +
					"una calle, un pto o un tipo de ambulancia");
				break;
				}	
			break;
				
				
			case comprar:
				// Se pueden crear puntos o calles o ambulancias
				switch (opciones.toOpcion(as.get(1))){
				case camion:
					s.crear_ambulancia(Camion.class, Integer.parseInt(as.get(2)));
					break;
				case camioneta:
					s.crear_ambulancia(Camioneta.class, Integer.parseInt(as.get(2)));
					break;
				case helicoptero:
					s.crear_ambulancia(Helicoptero.class, Integer.parseInt(as.get(2)));
					break;
				case moto:
					s.crear_ambulancia(Moto.class, Integer.parseInt(as.get(2)));
					break;
				case error:
					i.error("El parametro es incorrecto, debe ser " +
					"una calle, un pto o un tipo de ambulancia");
					break;
				}	
			break;
				
			case cambiar:
				// Se puede cambiar la dificultad de una calle o la posicion de un hospital
				switch (opciones.toOpcion(as.get(1))){
				// La dificultad se puede cambiar de 3 maneras:
				// 1) todas al mismo tiempo
				// 2) por id_calle + dif
				// 3) id _ini + id_fin + dif
				
				case dificultad:
				
					long idi, idf, idc;
					int dif;
					
					try {
						dif = Integer.parseInt(as.get(4));
						idf = Long.parseLong(as.get(3));
						idi = Long.parseLong(as.get(2)); 

						s.modificar_dificultad_calle(idi, idf, dif);

					} catch (RuntimeException e) {
						try {
							dif = Integer.parseInt(as.get(3));
							idc = Long.parseLong(as.get(2));

							s.modificar_dificultad_calle(idc, dif);
						} catch (RuntimeException e1) {
							s.modificar_dificultad_calle();
						}
					}
					break;


				case hospital:
					// Hay 2 casos por id o por x e y
					try {
						String str1 = as.get(3);
						s.config_hospital(Float.parseFloat(as.get(2)),Float.parseFloat(str1));
					} catch (IndexOutOfBoundsException e) {
						try {
							String str2 = as.get(2);
							s.config_hospital(Integer.parseInt(str2));
						} catch (IndexOutOfBoundsException e1) {
							i.informar("La cantidad de parametros no es correcta");
						}
					}
					break;
				} // Fin switch cambiar
				
			break; // cambiar
				
			case pedir:
				String tipo_vehiculo;
				Long id;
				try {
					tipo_vehiculo = as.get(2);
					try {
						id = Long.parseLong(as.get(1));
						s.realizar_pedido(id, tipo_vehiculo);
					} catch ( NumberFormatException e) {
						i.informar("No se paso un numero como parametro");
					}
				} catch (Exception e) {
					i.error("Cantidad de parametros incorrecta");
				}
			
			break;
				
			case responder:
				String id1, resp;
				int a;
				
				try {
					// Intento obtener el segundo param
					id1 = as.get(2);
					try {
						a = Integer.parseInt(id1);
						resp = as.get(1);
						s.responder(resp, a);
					} catch (NumberFormatException e) {
						i.error("El segundo parametro debe ser un numero");
					}
				} catch (IndexOutOfBoundsException e) {
					try {
						resp = as.get(1);
						s.responder(resp);
					} catch (Exception e1) {
						i.error("Cantidad de argumentos incorrecta");
					}
				}
			break;
			
			} // Fin switch
			
		} else {
			s.continuar();
		}
		
		
	}

}
