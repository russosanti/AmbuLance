package Interfaz.Swing;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import Sistema.Sistema;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;

/**Ventana del menu para crear cosas
 * @author Santy */
public class Menu_Crear extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel menu_crear = null;
	private JButton crear_mapa = null;
	private JButton crear_punto = null;
	private JButton crear_calle = null;
	private JButton back = null;

	
	public Menu_Crear() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 338);
		this.setName("menu_crear");
		this.setLocation(new Point(0,0));
		this.setContentPane(getMenu_Crear());
		this.setTitle("Menu Crear");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				Main main = new Main();
				main.setLocation(getLocationOnScreen());
				dispose();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMenu_Crear(){
		if (menu_crear == null) {
			menu_crear = new JPanel();
			menu_crear.setLayout(null);
			menu_crear.setBackground(new Color(165, 236, 236));
			menu_crear.add(getCrear_mapa(), null);
			menu_crear.add(getCrear_punto(), null);
			menu_crear.add(getCrear_calle(), null);
			menu_crear.add(getBack(), null);
		}
		return menu_crear;
	}

	/**
	 * This method initializes crear_mapa	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCrear_mapa() {
		if (crear_mapa == null) {
			try {
				crear_mapa = new JButton();
				crear_mapa.setText("Crear Mapa");
				crear_mapa.setSize(new Dimension(136, 46));
				crear_mapa.setLocation(new Point(75, 24));
				crear_mapa.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						try{
							Sistema sys = Nucleo_Keeper.get_Nucleo();
							sys.crear_ciudad();
							JOptionPane.showMessageDialog(menu_crear,"Ciudad Creada Satisfactoriamente. Tenga en cuenta que la ciudad se encuentra vacia."
									,"Aviso",JOptionPane.INFORMATION_MESSAGE);
						}catch(RuntimeException exc){
							JOptionPane.showMessageDialog(menu_crear,"ERROR creando la ciudad: "+exc.getMessage(),
									"ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_crear,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return crear_mapa;
	}

	/**
	 * This method initializes crear_punto	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCrear_punto() {
		if (crear_punto == null) {
			try {
				crear_punto = new JButton();
				crear_punto.setText("Crear Punto");
				crear_punto.setSize(new Dimension(136, 46));
				crear_punto.setLocation(new Point(76, 94));
				crear_punto.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						String s = JOptionPane.showInputDialog("Ingrese el punto a crear (ID,x,y)");
						if(s != null){
							long id = 0;
							float x = 0;
							float y = 0;
							String aux;
							int a=0;
							try{ //parseo la linea y convierto las cosas
								s = s.trim();
								a = s.indexOf(',');
								aux = s.substring(0,a);
								aux = aux.trim();
								if(aux.length()==0){
									new java.lang.StringIndexOutOfBoundsException("No se encuentra el id");
								}else{
									id = Long.parseLong(aux);
									int b = s.indexOf(',',a+1);
									aux = s.substring(a+1,b);
									aux = aux.trim();
									if(aux.length()==0){
										new java.lang.StringIndexOutOfBoundsException("No se encuentra la coordenada x");
									}else{
										x = Float.parseFloat(aux);
										aux = s.substring(b+1,s.length());
										aux = aux.trim();
										if(aux.length()==0){
											new java.lang.StringIndexOutOfBoundsException("No se encuentra la coordenada y");
										}else{
											y = Float.parseFloat(aux);
											Sistema sys = Nucleo_Keeper.get_Nucleo();
											sys.crear_pto(id,x,y);
										}
									}
								}
							}catch(RuntimeException ex){
								JOptionPane.showMessageDialog(menu_crear,"ERROR creando el punto: "+ex.getMessage(),
										"ERROR",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_crear,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return crear_punto;
	}

	/**
	 * This method initializes crear_calle	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCrear_calle() {
		if (crear_calle == null) {
			try {
				crear_calle = new JButton();
				crear_calle.setText("Crear Calle");
				crear_calle.setSize(new Dimension(136, 46));
				crear_calle.setLocation(new Point(75, 164));
				crear_calle.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Crear_Calle cre_clle = new Crear_Calle();
						cre_clle.setLocation(menu_crear.getLocationOnScreen());
						cre_clle.setVisible(true);
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(menu_crear,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return crear_calle;
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
				back.setBounds(new Rectangle(16, 241, 76, 54));
				back.setHorizontalTextPosition(SwingConstants.CENTER);
				ImageIcon icon = new ImageIcon("Imagenes/anta.png");
			    Image img = icon.getImage();  
			    Image newimg = img.getScaledInstance(back.getWidth(),back.getHeight(),java.awt.Image.SCALE_SMOOTH);  
			    ImageIcon newIcon = new ImageIcon(newimg);  
				back.setIcon(newIcon);
				back.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Menu_Mapa mpa = new Menu_Mapa();
						mpa.setLocation(getLocationOnScreen());
						setVisible(false);
						mpa.setVisible(true);
						dispose();
					}
				});
			} catch (java.lang.Throwable e){
				JOptionPane.showMessageDialog(menu_crear,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return back;
	}
}