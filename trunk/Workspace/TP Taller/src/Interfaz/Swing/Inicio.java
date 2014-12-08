package Interfaz.Swing;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.JProgressBar;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**Ventana del inicio que muestra la carga
 * @author Santy */
public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JProgressBar progreso = null;
	private JLabel info = null;
	
        
	public Inicio() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(608, 260);
		this.setResizable(false);
		this.setName("inicio");
		this.setForeground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Cargando...");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			info = new JLabel();
			info.setBounds(new Rectangle(116, 208, 400, 16));
			info.setFont(new Font("Dialog", Font.BOLD, 10));
			info.setHorizontalAlignment(SwingConstants.CENTER);
			info.setHorizontalTextPosition(SwingConstants.CENTER);
			info.setText("");
			jContentPane = new JPanel(){
				private static final long serialVersionUID = 1L;
				public void paintComponent(Graphics g){
	                Image img = new ImageIcon("Imagenes/logo.jpg").getImage();
	                setLayout(null);
	                g.drawImage(img,0,0,getWidth(),getHeight(),null);
	            } 
	        };
			jContentPane.setLayout(null);
			jContentPane.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			jContentPane.add(getProgreso(), null);
			jContentPane.add(info, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes progreso	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getProgreso() {
		if (progreso == null) {
			try {
				progreso = new JProgressBar();
				progreso.setBounds(new Rectangle(40, 177, 536, 25));
			} catch (java.lang.Throwable e) {
				
			}
		}
		return progreso;
	}
	
	public void setProgreso(int val){
		this.progreso.setValue(val);
	}
	
	public void setInfo(String s){
		this.info.setText(s);
	}
}