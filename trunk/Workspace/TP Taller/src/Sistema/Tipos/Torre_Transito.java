package Sistema.Tipos;

import java.util.Date;
import java.util.Iterator;

import Interfaz.IUser;
import Interfaz.Interface_Keeper;

/** Clase usada para simular la Torre de Transito
 * @author Santiago Russo */
public class Torre_Transito {
	
	Ciudad ciu;
	
	/** definition public Torre_Transito(Ciudad c)
	 * @param c Ciudad - Se pasa la ciudad a la cual maneja la torre */
	public Torre_Transito(Ciudad c){
		this.ciu = c;
	}
	
	/** Metodo que cambia las dificultades en cada calle
	 * @Definition public boolean reporte_transito()
	 * @return boolean - Devuelve True si logra cambiar todo, si hay una excepcion o error devuelve False
	 */
	@SuppressWarnings("deprecation")
	public boolean reporte_transito(){  //el a es un array con las calles
		try{
			IUser inter = Interface_Keeper.get_Interfaz();
			Calle aux;
			int x;
			Date d = new Date();
			d.getDate();
			inter.informar("Informe de transito a las: "+d.toString(), Interfaz.InformarConst.INFORME_TORRE);
			for(int i =0;i<this.ciu.obtener_calles().size();i++){
				aux = this.ciu.obtener_calles().get(i);
				x = (int)(Math.random()*10);
				aux.setDificultad(x);
				inter.informar("La Calle "+aux.getId()+" ha cambiado su dificultad a: "+x, 
                                        Interfaz.InformarConst.INFORME_TORRE);
			}
			this.ciu.getHospital().recalculo_ruta();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/** Metodo que cambia la dificultad en una calle dada su Id
	 * @param id long - El Id de la calle a cambiar
	 * @param dificultad int - La nueva dificultad de la calle
	 * @return boolean - Devuelve True si logra cambiar la dificultad, si hay una excepcion o error devuelve False */
	@SuppressWarnings("deprecation")
	public boolean dificultad_calle(long id,int dificultad){
		if(dificultad>=0){
			IUser inter = Interface_Keeper.get_Interfaz();
			Date d = new Date();
			d.getDate();
			inter.informar("Informe de transito a las: "+d.toString(), Interfaz.InformarConst.INFORME_TORRE);
			Calle aux = new Calle(id,new Punto(0,0,0),new Punto(0,0,0));
			this.ciu.obtener_calles().buscar(aux).setDificultad(dificultad);
			inter.informar("La Calle "+id+" ha cambiado su dificultad a: "+dificultad, Interfaz.InformarConst.INFORME_TORRE);
			this.ciu.getHospital().recalculo_ruta();
			return true;
		}else{
			return false;
		}
	}
	
	/**  Metodo que cambia la dificultad en una calle dados el Id del punto inicial y final
	 * @param id_ini long - Id del punto inicial
	 * @param id_fin long - Id del punto final
	 * @param dificultad - La nueva dificultad de la calle
	 * @return  boolean - Devuelve True si logra cambiar la dificultad, si hay una excepcion o error devuelve False */
	@SuppressWarnings("deprecation")
	public boolean dificultad_calle(long id_ini,long id_fin,int dificultad){
		if(dificultad>=0){
			IUser inter = Interface_Keeper.get_Interfaz();
			Date d = new Date();
			d.getDate();
			Iterator<Calle> it = this.ciu.obtener_calles().iterator();
			Calle aux;
			inter.informar("Informe de transito a las: "+d.toString(), Interfaz.InformarConst.INFORME_TORRE);
			while(it.hasNext()){
				aux = it.next();
				if((aux.getInicio().getId()==id_ini) && (aux.getFin().getId()==id_fin)){
					aux.setDificultad(dificultad);
					inter.informar("La Calle "+aux.getId()+" ha cambiado su dificultad a: "+dificultad, Interfaz.InformarConst.INFORME_TORRE);
					this.ciu.getHospital().recalculo_ruta();
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}
}
