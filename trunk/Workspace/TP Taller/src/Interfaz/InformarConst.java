package Interfaz;

/**Clase que brinda las constanted de informar
 * @author Santy */
public enum InformarConst{
	
	POPUP,DATOS_AMBULANCIA,INFORME_TORRE,INFORME_SIMULACION,PEDIDO_ESPERA;

	public static InformarConst toOpcion(String str){
	InformarConst o;
        try {
            o = valueOf(str);
            return o;
        } 
        catch (Exception ex) {
            return null;
        }
    } 
}
