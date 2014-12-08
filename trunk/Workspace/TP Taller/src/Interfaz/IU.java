package Interfaz;

import Interfaz.Swing.Datos_Ambulancia;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Interfaz.Swing.Inicio;
import Interfaz.Swing.Main;
import Interfaz.Swing.Nucleo_Keeper;
import Sistema.Sistema;

/**Clase que implementa la interfaz
 * @author Santy
 */
public class IU implements IUser{
	private Sistema nucleo;
	private JFrame actual_frame;
	
	// Constructor
	public IU(){
	}
	
    @Override
	public void load(){
		Inicio x = new Inicio();
		x.setVisible(true);
		try {
			x.setInfo("Cargando Kernel");
			Thread.sleep(500);
			x.setProgreso(20);
			x.setInfo("Cargando librerias");
			Thread.sleep(500);
			x.setProgreso(60);
			x.setInfo("Inicializando el Nucleo");
			Thread.sleep(2000);
			x.setProgreso(100);
			x.setInfo("Cargando Completa");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			this.error("Error en la carga: "+e.getMessage());
		}finally{
            Main y = new Main();
            y.setLocation(x.getLocationOnScreen());
            x.setVisible(false);
			x.dispose();
			this.actual_frame = y;
		}
		
	}
	
    @Override
	public void setS(Sistema s){
		if(s==null){
			this.error("No se pudo inicializar el Sistema");
			System.exit(1);
		}else{
			nucleo = s;
			Nucleo_Keeper.set_Nucleo(s);
		}
	}
	
    @Override
	public void setActual_Frame(JFrame fr){
		this.actual_frame = fr;
	}
	
    @Override
	public void error(String s){
		JOptionPane.showMessageDialog(this.actual_frame,"ERROR: "+s,"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
    @Override
	public void informar(String s){
            JOptionPane.showMessageDialog(this.actual_frame,"INFORME: "+s,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
	}
        
    @Override
    public void informar(String s, InformarConst type){
    	switch(type){
        	case POPUP:
        		JOptionPane.showMessageDialog(this.actual_frame,"INFORME: "+s,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
        		break;
            case DATOS_AMBULANCIA:
                Datos_Ambulancia amb = new Datos_Ambulancia();
                amb.setVisible(true);
            	Traductor.informar_datos_ambu(s,amb);
                break;
            case INFORME_SIMULACION:
                Traductor.informar_hosp(s,this.actual_frame);
                break;
            case INFORME_TORRE:
                Traductor.informar_torre(s, this.actual_frame);
                break;
            case PEDIDO_ESPERA:
                Sistema sys = Nucleo_Keeper.get_Nucleo();
                if(JOptionPane.showConfirmDialog(this.actual_frame,s,"ALERTA",JOptionPane.YES_NO_OPTION)==0){
                    sys.responder("SI");
                }else{
                    sys.responder("NO");
                }
                break;
            default:
                this.informar(s);
                break;
        }
    }
}


