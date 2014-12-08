package Sistema;

import java.util.ArrayList;
import java.util.Iterator;
import Excepciones.*;
import Interfaz.*;
import Sistema.Tipos.*;
import Sistema.Tipos.Ambulancias.*;
import Utils.Tipo_Utils;

/**Clase que encapsula el sistema
 * @author Santiago Russo
 *
 */
public class Sistema {
	private Ciudad ciu;
	IUser i;
	private boolean en_simulacion = false;
	private boolean amb_creada = false;
	private long tiempo;		
	
	// Constructor
	public Sistema(IUser i){
		i.setS(this);
		this.i = i;
		Interface_Keeper.set_Interface(i);
	}
	
	// Metodos que me dan el estado del sistema

	private boolean isEn_simulacion() {
		return en_simulacion;
	}

	private void setEn_simulacion(boolean en_simulacion) {
		this.en_simulacion = en_simulacion;
	}

	private boolean ciudadCreada(){
		return (this.ciu != null);
	}
	
	private boolean hopsitalCreado(){
		return (this.ciu.getHospital() != null);
	}
	
	private void setAmb_creada(boolean amb_creada) {
		this.amb_creada = amb_creada;
	}

	private boolean isAmb_creada() {
		return amb_creada;
	}
	
	// Metodos que exporto
	
	// Referidos a la creacion 
	
	public void crear_ciudad(){
		if(!isEn_simulacion())
			this.ciu = new Ciudad();
		else
			i.informar("Debe detener la simulacion primero para poder crear una ciudad");
	}
	
	public void crear_ciudad(String s){
		if(!isEn_simulacion())
			this.ciu = new Ciudad(s);
		else
			i.informar("Debe detener la simulacion primero para poder crear una ciudad");
	}

	public void cargar_mapa(String idCiudad){
		
		boolean resultado = false;
		
		if(!isEn_simulacion()) {
			try {
				this.ciu = new Ciudad();
				resultado = this.ciu.cargarCiudadBD(idCiudad);
			}
			catch (Exception e) {
				i.error(e.getMessage());
			}
		}
		else
			i.informar("Debe detener la simulacion primero para poder crear una ciudad");
		
		if (resultado) i.informar("Ciudad cargada con exito");
	}
	
	public void guardar_mapa(String idCiudad){
		
		boolean resultado = false;
		
		if(!isEn_simulacion())
			try {
				resultado = this.ciu.grabarCiudadBD(idCiudad);
			}
			catch (Exception e) {
				i.informar(e.getMessage());
		}
		else
			i.informar("Debe detener la simulacion primero para poder grabar una ciudad");
		
		if (resultado) i.informar("Ciudad grabada con �xito");
	}
	
	public void crear_pto(long id, float f, float g){
		Punto esquina = new Punto(id, f, g);
		if(!isEn_simulacion() && ciudadCreada()){
			if (!(this.ciu.crear_esquina(esquina))){
				i.informar("No se pudo crear la esquina");
			}else{
				i.informar("Esquina creada satisfactoriamente",InformarConst.POPUP);
			}
		} else {
			i.error("No se puede crear la esquina, debe detener primero la simulacion y/o crear la ciudad");
		}
	}	
	
	public void crear_calle(long id_calle,long id_pto_ini,long id_pto_fin){
		Punto p = new Punto(id_pto_ini, 0, 0);
		Punto q = new Punto(id_pto_fin, 0, 0);
			
		if(!isEn_simulacion() && ciudadCreada()){
			Calle c = new Calle(id_calle, p, q);
			if (!(this.ciu.crear_calle(c))){
				i.informar("No se pudo crear la calle",InformarConst.POPUP);
			}else{
				i.informar("Calle creada satisfactoriamente",InformarConst.POPUP);
			}
		} else {
			i.error("No se puede crear la calle, debe detener primero la simulacion y/o crear la ciudad");
		}
	}
	
	public void crear_calle(long id_calle, long id_ini, long id_fin, String nombre, int nro_ini, int nro_fin){
		if(!isEn_simulacion() && ciudadCreada()){
			Calle c = new Calle(id_calle, new Punto(id_ini, 0 ,0), new Punto(id_fin, 0 ,0), nro_ini, nro_fin);
			if (!(this.ciu.crear_calle(c))){
				i.informar("No se pudo crear la calle");
			}else{
				i.informar("Calle creada satisfactoriamente",InformarConst.POPUP);
			}
		} else {
			i.error("No se puede crear la calle, debe detener primero la simulacion y/o crear la ciudad");
		}
	}
	
	public void buscar_ambulancia(long id){
		Ambulancia amb = this.ciu.getHospital().get_Ambulancia_byId(id);
		String informe = "";
		informe = informe + amb.getId()+"/";
		String aux = amb.getClass().toString();
		aux = aux.trim();
		aux = aux.substring(aux.lastIndexOf(".")+1,aux.length());
		aux = aux.trim();
		informe = informe + aux + "/";
		informe = informe + amb.getManiobrabilidad()+"/"+amb.getPos_actual();
		this.i.informar(informe,InformarConst.DATOS_AMBULANCIA);
	}
	
	public void crear_ambulancia(Class<? extends Ambulancia> cl,int x){

            if(hopsitalCreado()){
                setAmb_creada(true);
                this.ciu.getHospital().comprar_ambulancia(cl, x);
                i.informar("Se ha(n) creado: " + x + "ambulancia(s) del tipo " + cl.getSimpleName());
            } else {
                i.informar("El hospital no ha sido creado");
            } 
        }
	
	// Referidos a la configuracion 
	
	public void config_hospital(long id){
		if(!isEn_simulacion()){
			try{
				ciu.setHospital(id);
				i.informar("Se ha seteado el hopspital en el pto con ID:" + id);
			}catch(Punto_Inexistente e){
				i.error(e.getMessage());
			}catch(Exception e){
				i.error("Se debe cargar una ciudad primero");
			}
		}
		else {
			i.informar("No se puede modificar el hospital mientras se simula");
		}
	}
	
	public void config_hospital(float x, float y){
		if(!isEn_simulacion()){
			try{
				ciu.setHospital(x,y);
				i.informar("El hospital fue correctamente seteado en el punto: ("+x+";"+y+")");
			}catch(Punto_Inexistente e){
				i.error(e.getMessage());
			}catch(Exception e){
				i.error("Se debe cargar una ciudad primero");
			}
		}
		else {
			i.informar("No se puede modificar el hospital mientras se simula");
		}
	}
	
	// Referidos a la simulacion 
	public void iniciar_simul(){
		if(ciudadCreada()){
			if(hopsitalCreado()){
				if(isAmb_creada()){
					this.tiempo = 0;
					this.setEn_simulacion(true);
					i.informar("Simulacion Iniciada");
				}
				else {
					i.informar("No hay ambulancias creadas");
				}
			} else {
				i.informar("No existe un hospital");
			}
		} else {
			i.informar("La ciudad no esta creada");
		}
	}
	
	public void continuar(){
		if(isEn_simulacion()){
			i.informar("TimeStamp = " + this.tiempo,InformarConst.INFORME_SIMULACION);
			this.ciu.getHospital().mover(this.tiempo++%100000);
		}
	}
	
	public void adelantar(long s){
		if(isEn_simulacion()){ 
			while(s>0){
				this.ciu.getHospital().mover(this.tiempo++%100000);
				s--;
			}
		}else{
			this.i.error("El sistema no esta en simulacion, debe iniciar la simulacion primero");
		}
	}
	
	public void finalizar_sim(){
		this.setEn_simulacion(false);
		i.informar("La simulacion ha sido detenida");
	}

	public void realizar_pedido(long id ,String tipo){
		Class<? extends Ambulancia> cl = null;
		
		if(isEn_simulacion()){
			if ((cl = existe_tipo_vehiculo(tipo)) != null){
				i.informar("Se ha hecho un pedido al punto: " + id + " con el tipo de Amb: " + tipo);		
				this.ciu.getHospital().crear_pedido(new Punto(id, 0, 0), cl);
			}
			else {
				i.informar("No existe el tipo solicitado de Ambulancia");
			}
		}
		else {
			i.informar("Falta hospital y/o ciudad o iniciar la simulacion");
		}
	}

	public void modificar_dificultad_calle(){
		if(ciudadCreada() && this.ciu.cambiar_dificultad())
                    i.informar("Se ha modificado la dificultad de todas las calles");
		else 
                    i.informar("No se pudo modificar la dificultad");
	}
	
	public void modificar_dificultad_calle(long id, int dif) {
		if(ciudadCreada() && this.ciu.cambiar_dificultad(id, dif))
                    i.informar("Se ha modificado la dificultad de la calle con id " + id + " a dificultad " + dif);
		else 
                    i.informar("No se pudo modificar la dificultad");
			
	}
	
	public void modificar_dificultad_calle(long id_i,long id_f,int dif){
		if(ciudadCreada() && this.ciu.cambiar_dificultad(id_i, id_f, dif))
                    i.informar("Se ha modificado la dificultad de la calle con ptos" +
					"de inicio y fin " + id_i + "," + id_f + " a dificultad " + dif);
		else 
                    i.informar("No se pudo modificar la dificultad");
	}
	
	public void test() {
		this.crear_ciudad("test");
		this.config_hospital(1);
		this.crear_ambulancia(Moto.class , 1);
		this.iniciar_simul();
		this.realizar_pedido(3, "Moto");
	}
	
	public void responder(String resp){
		if(isEn_simulacion())
			ciu.getHospital().respuesta_pedido(resp); 
		else 
			i.informar("No se permite responder cuando no se esta simulando");
	}
	
	public void responder(String resp, int id_p){
		if(isEn_simulacion())
			ciu.getHospital().respuesta_pedido(resp, id_p);  
		else 
			i.informar("No se permite responder cuando no se esta simulando");
	}
	
	private Class<Ambulancia> existe_tipo_vehiculo(String tipo){
		ArrayList<Class<Ambulancia>> ar = Tipo_Utils.subclases_ambulancia();
		Iterator<Class<Ambulancia>> it = ar.iterator();
		Class<Ambulancia> cl = null;
		Class<Ambulancia> ret = null;
		boolean existe = false;
		
		while(it.hasNext() && !existe){
			cl = it.next();
			if(cl.getName().equals("Sistema.Tipos.Ambulancias." + tipo)){
				existe = true;
				ret = cl;
			}
		}
		
		return ret;
	}

	public void exit(){
		Runtime.getRuntime().exit(0);
	}
}