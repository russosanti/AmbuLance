package Interfaz.Swing;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import Interfaz.IUser;
import Interfaz.Interface_Keeper;
import Sistema.Sistema;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;

/**Ventana del menu principal
 * @author Santy */
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton mapa = null;
	private JButton ambulancias = null;
	private JButton simular = null;
	private JButton salir = null;
	private JLabel help = null;
	private JLabel about = null;
	
        
	public Main() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 371);
		this.setName("main_menu");
		this.setContentPane(getJContentPane());
		this.setTitle("Main Menu");
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				Sistema s = Nucleo_Keeper.get_Nucleo();
				s.exit();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			about = new JLabel();
			about.setBounds(new Rectangle(108, 302, 53, 20));
			about.setFont(new Font("Dialog", Font.PLAIN, 12));
			about.setHorizontalAlignment(SwingConstants.CENTER);
			about.setOpaque(true);
			about.setText("About");
			about.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					About a = new About();
					a.setLocation(Main.this.getLocationOnScreen());
					a.setVisible(true);
				}
			});
			help = new JLabel();
			help.setBounds(new Rectangle(22, 302, 53, 20));
			help.setFont(new Font("Dialog", Font.PLAIN, 12));
			help.setHorizontalAlignment(SwingConstants.CENTER);
			help.setOpaque(true);
			help.setText("Help");
			help.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Help h = new Help();
					h.setLocation(Main.this.getLocationOnScreen());
					h.setVisible(true);
				}
			});
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(165, 236, 236));
			jContentPane.add(getMapa(), null);
			jContentPane.add(getAmbulancias(), null);
			jContentPane.add(getSimular(), null);
			jContentPane.add(getSalir(), null);
			jContentPane.add(help, null);
			jContentPane.add(about, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes cargar_mapa	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMapa() {
		if (mapa == null) {
			try {
				mapa = new JButton();
				mapa.setToolTipText("Carga Los Mapas del Sistema");
				mapa.setPreferredSize(new Dimension(100, 40));
				mapa.setName("mapa");
				mapa.setBounds(new Rectangle(134, 21, 135, 40));
				mapa.setHorizontalTextPosition(SwingConstants.CENTER);
				mapa.setMnemonic(KeyEvent.VK_UNDEFINED);
				mapa.setText("Mapa");
				mapa.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Menu_Mapa mpa = new Menu_Mapa();
						mpa.setLocation(getLocationOnScreen());
						setVisible(false);
						mpa.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return mapa;
	}

	/**
	 * This method initializes ambulancias	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAmbulancias() {
		if (ambulancias == null) {
			try {
				ambulancias = new JButton();
				ambulancias.setToolTipText("Ingresa al Menu de Administracion de Ambulancias del Sistema");
				ambulancias.setPreferredSize(new Dimension(135, 40));
				ambulancias.setName("ambulancias");
				ambulancias.setBounds(new Rectangle(135, 120, 135, 40));
				ambulancias.setHorizontalTextPosition(SwingConstants.CENTER);
				ambulancias.setText("Hospital");
				ambulancias.addActionListener(new java.awt.event.ActionListener() {   
					public void actionPerformed(java.awt.event.ActionEvent e) {    
						Menu_Hospital amb = new Menu_Hospital();
						amb.setLocation(getLocationOnScreen());
						setVisible(false);
						amb.setVisible(true);
						dispose();
					}
				
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return ambulancias;
	}

	/**
	 * This method initializes simular	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSimular() {
		if (simular == null) {
			try {
				simular = new JButton();
				simular.setBounds(new Rectangle(136, 216, 134, 37));
				simular.setText("Simular");
				simular.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Sistema sys = Nucleo_Keeper.get_Nucleo();
						sys.iniciar_simul();
						Simulacion sim = new Simulacion();
						sim.setLocation(Main.this.getLocationOnScreen());
						IUser i = Interface_Keeper.get_Interfaz();
						i.setActual_Frame(sim);
						Main.this.setVisible(false);
						sim.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return simular;
	}

	/**
	 * This method initializes salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalir() {
		if (salir == null) {
			try {
				salir = new JButton();
				salir.setBounds(new Rectangle(332, 282, 47, 46));
				ImageIcon icon = new ImageIcon("Imagenes/exit.jpg");
			    Image img = icon.getImage();  
			    Image newimg = img.getScaledInstance(salir.getWidth(),salir.getHeight(),java.awt.Image.SCALE_SMOOTH);  
			    ImageIcon newIcon = new ImageIcon(newimg);  
				salir.setIcon(newIcon);
				salir.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(JOptionPane.showConfirmDialog(jContentPane,"Seguro desea salir?","Salir?",JOptionPane.YES_NO_OPTION)==0){
							Sistema sys = Nucleo_Keeper.get_Nucleo();
							sys.exit();
						}
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return salir;
	}
}