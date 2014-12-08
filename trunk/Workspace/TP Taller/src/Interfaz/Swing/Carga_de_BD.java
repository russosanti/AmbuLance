package Interfaz.Swing;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import Sistema.Sistema;
import java.awt.Font;
import java.awt.Color;

/**Ventana para cargar un mapa de una base de datos
 * @author Santy */
public class Carga_de_BD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel label = null;
	private JTextField id = null;
	private JButton Cargar = null;
	private JButton cancel = null;

	/**
	 * This is the default constructor
	 */
	public Carga_de_BD() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(587, 221);
		this.setName("cargar_paquete");
		this.setContentPane(getJContentPane());
		this.setTitle("Cargar Paquete");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			label = new JLabel();
			label.setBounds(new Rectangle(22, 38, 123, 27));
			label.setName("nom_paquete");
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setText("ID del Mapa");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			jContentPane.setBackground(new Color(161, 219, 219));
			jContentPane.add(label, null);
			jContentPane.add(getId(), null);
			jContentPane.add(getCargar(), null);
			jContentPane.add(getCancel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes id	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getId() {
		if (id == null) {
			try {
				id = new JTextField();
				id.setBounds(new Rectangle(177, 38, 372, 31));
				id.setText("Id del mapa...");
				id.setName("id_paquete");
				id.setToolTipText("Ingrese aqui el Id del mapa que quiere cargar de la BD");
				id.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						id.setText("");
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return id;
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
				Cargar.setBounds(new Rectangle(75, 105, 173, 56));
				Cargar.setText("Cargar");
				Cargar.setName("cargar");
				Cargar.setFont(new Font("Dialog", Font.BOLD, 36));
				Cargar.setToolTipText("Cargar el Paquete");
				Cargar.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(id.getText()==null){
							JOptionPane.showMessageDialog(jContentPane,"El Nombre del mapa esta vacio!","WARNING",JOptionPane.WARNING_MESSAGE);
						}else{
							String s = id.getText().trim();
							if(s.length()<=0){
								JOptionPane.showMessageDialog(jContentPane,"El Nombre del mapa debe contener por lo menos un caracter","WARNING",JOptionPane.WARNING_MESSAGE);
							}else{
								Sistema sys = Nucleo_Keeper.get_Nucleo();
								sys.cargar_mapa(s);
								setVisible(false);
								dispose();
							}
						}
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"Error cargando el paquete "+id.getText()+". Contactese con el Administrador"
						,"Aviso",JOptionPane.WARNING_MESSAGE);
			}
		}
		return Cargar;
	}

	/**
	 * This method initializes cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancel() {
		if (cancel == null) {
			try {
				cancel = new JButton();
				cancel.setBounds(new Rectangle(323, 105, 173, 56));
				cancel.setText("Cancel");
				cancel.setName("cancel");
				cancel.setFont(new Font("Dialog", Font.BOLD, 36));
				cancel.setToolTipText("Cancelar");
				cancel.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return cancel;
	}
}