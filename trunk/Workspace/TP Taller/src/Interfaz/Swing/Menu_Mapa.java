package Interfaz.Swing;

import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

/**Ventana del menu del mapa
 * @author Santy */
public class Menu_Mapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Panel = null;
	private JButton Cargar = null;
	private JButton Crear = null;
	private JButton guardar = null;
	private JButton back = null;

        
	public Menu_Mapa() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 376);
		this.setContentPane(getPanel());
		this.setTitle("Menu Mapa");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				Main main = new Main();
				main.setLocation(getLocationOnScreen());
				dispose();
			}
		});
	}

	/**
	 * This method initializes Panel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanel() {
		if (Panel == null) {
			Panel = new JPanel();
			Panel.setLayout(null);
			Panel.setName("menu_mapa");
			Panel.setToolTipText("Menu Para El Manejo de Mapas");
			Panel.setBackground(new Color(165, 236, 236));
			Panel.add(getCargar(), null);
			Panel.add(getCrear(), null);
			Panel.add(getGuardar(), null);
			Panel.add(getBack(), null);
		}
		return Panel;
	}

	/**
	 * This method initializes Cargar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCargar() {
		if (Cargar == null) {
			try {
				Cargar = new JButton();
				Cargar.setBounds(new Rectangle(84, 36, 136, 46));
				Cargar.setToolTipText("Carga El Mapa");
				Cargar.setName("cargar");
				Cargar.setText("Cargar");
				Cargar.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Menu_Cargar carg = new Menu_Cargar();
						carg.setLocation(getLocationOnScreen());
						setVisible(false);
						carg.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(Panel,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return Cargar;
	}

	/**
	 * This method initializes Crear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCrear() {
		if (Crear == null) {
			try {
				Crear = new JButton();
				Crear.setBounds(new Rectangle(84, 116, 136, 46));
				Crear.setText("Crear");
				Crear.setToolTipText("Opciones Para Crear Objetos en el Mapa");
				Crear.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Menu_Crear crea = new Menu_Crear();
						crea.setLocation(getLocationOnScreen());
						setVisible(false);
						crea.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(Panel,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return Crear;
	}

	/**
	 * This method initializes guardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getGuardar() {
		if (guardar == null) {
			try {
				guardar = new JButton();
				guardar.setBounds(new Rectangle(84, 198, 136, 46));
				guardar.setText("Guardar Mapa");
				guardar.setName("guardar");
				guardar.setToolTipText("Guarda El Mapa Actual en la BD");
				guardar.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Guardar_Mapa gmap = new Guardar_Mapa();
						gmap.setLocation(Panel.getLocationOnScreen());
						gmap.setVisible(true);
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(Panel,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return guardar;
	}

	/**
	 * This method initializes back	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBack() {
		if (back == null) {
			try {
				back = new JButton();
				back.setBounds(new Rectangle(24, 275, 76, 54));
				back.setHorizontalTextPosition(SwingConstants.CENTER);
				ImageIcon icon = new ImageIcon("Imagenes/anta.png");
                                Image img = icon.getImage();  
                                Image newimg = img.getScaledInstance(back.getWidth(),back.getHeight(),java.awt.Image.SCALE_SMOOTH);  
                                ImageIcon newIcon = new ImageIcon(newimg);  
				back.setIcon(newIcon);
				back.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Main main = new Main();
						main.setLocation(getLocationOnScreen());
						setVisible(false);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(Panel,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return back;
	}
}