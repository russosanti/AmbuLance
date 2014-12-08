package Interfaz.Swing;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;

/**Ventana del menu para cargar el mapa
 * @author Santy */
public class Menu_Cargar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel menu_cargar = null;
	private JButton cargar_archivo = null;
	private JButton cargar_bd = null;
	private JButton back = null;
	
        
	public Menu_Cargar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(390, 318);
		this.setContentPane(getMenu_cargar());
		this.setTitle("Menu Carga");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				Main main = new Main();
				main.setLocation(getLocationOnScreen());
				dispose();
			}
		});
	}

	/**
	 * This method initializes menu_cargar
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMenu_cargar() {
		if (menu_cargar == null) {
			menu_cargar = new JPanel();
			menu_cargar.setLayout(null);
			menu_cargar.setToolTipText("Menu Para La Carga de Datos");
			menu_cargar.setName("Menu Cargar");
			menu_cargar.setBackground(new Color(165, 236, 236));
			menu_cargar.add(getCargar_archivo(), null);
			menu_cargar.add(getCargar_bd(), null);
			menu_cargar.add(getBack(), null);
		}
		return menu_cargar;
	}

	/**
	 * This method initializes cargar_archivo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCargar_archivo() {
		if (cargar_archivo == null) {
			try {
				cargar_archivo = new JButton();
				cargar_archivo.setBounds(new Rectangle(107, 39, 173, 47));
				cargar_archivo.setName("carga_archivo");
				cargar_archivo.setToolTipText("Guardar el Mapa Actual En La Base");
				cargar_archivo.setText("Cargar de Archivo");
				cargar_archivo.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Carga_de_Archivo archi = new Carga_de_Archivo();
						archi.setLocation(menu_cargar.getLocationOnScreen());
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_cargar,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return cargar_archivo;
	}

	/**
	 * This method initializes cargar_bd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCargar_bd() {
		if (cargar_bd == null) {
			try {
				cargar_bd = new JButton();
				cargar_bd.setBounds(new Rectangle(107, 148, 173, 47));
				cargar_bd.setToolTipText("Carga el Archivo de Una Base de Datos");
				cargar_bd.setName("cargar_bd");
				cargar_bd.setText("Cargar de BD");
				cargar_bd.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Carga_de_BD base = new Carga_de_BD();
						base.setLocation(menu_cargar.getLocationOnScreen());
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_cargar,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return cargar_bd;
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
				back.setLocation(new Point(15, 215));
				back.setSize(new Dimension(76, 54));
				ImageIcon icon = new ImageIcon("Imagenes/anta.png");
			    Image img = icon.getImage();  
			    Image newimg = img.getScaledInstance(back.getWidth(),back.getHeight(),java.awt.Image.SCALE_SMOOTH);  
			    ImageIcon newIcon = new ImageIcon(newimg);  
				back.setIcon(newIcon);
				back.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Menu_Mapa mapa = new Menu_Mapa();
						mapa.setLocation(getLocationOnScreen());
						setVisible(false);
						mapa.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_cargar,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return back;
	}
}