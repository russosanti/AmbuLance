package Interfaz;

import Interfaz.Swing.Datos_Ambulancia;
import Interfaz.Swing.Simulacion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**Ayuda en el informar de la interfaz
 * @author Santy */
public class Traductor {
    
    public static void informar_datos_ambu(String s,Datos_Ambulancia men){
        s = s.trim();
        String[] elemen = s.split("/");
        if(elemen.length==4){
            try{
                Datos_Ambulancia aux = (Datos_Ambulancia)men;
                aux.setID(elemen[0]);
                aux.setTitle(aux.getTitle()+": "+elemen[0]);
                aux.setTipo(elemen[1]);
                aux.setManeobrabilidad(elemen[2]);
                aux.setPos(elemen[3]);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"ERROR: "+e.getMessage(),"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR: Los parametros de la ambulancia son incorrectos","WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void informar_hosp(String s,JFrame jf){
        try{
            Simulacion sim = (Simulacion)jf;
            sim.set_ihosp(s+"\n");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: Error logico la ventana actual no es correcta","WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void informar_torre(String s,JFrame jf){
        try{
            Simulacion sim = (Simulacion)jf;
            sim.set_itorre(s+"\n");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: Error logico la ventana actual no es correcta","WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
