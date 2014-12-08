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


/**Ventana para cargar un mapa de un archivo
 * @author Santy */
public class Carga_de_Archivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel label = null;
	private JTextField paquete = null;
	private JButton Cargar = null;
	private JButton cancel = null;

	
	public Carga_de_Archivo() {
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
			label.setText("Nombre del Paquete");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			jContentPane.setBackground(new Color(161, 219, 219));
			jContentPane.add(label, null);
			jContentPane.add(getPaquete(), null);
			jContentPane.add(getCargar(), null);
			jContentPane.add(getCancel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes paquete	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPaquete() {
		if (paquete == null) {
			try {
				paquete = new JTextField();
				paquete.setBounds(new Rectangle(177, 38, 372, 31));
				paquete.setText("Nombre de Paquete...");
				paquete.setName("nom_paquete");
				paquete.setToolTipText("Ingrese aqui el nombre del paquete");
				paquete.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						paquete.setText("");
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return paquete;
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
						Sistema sys = Nucleo_Keeper.get_Nucleo();
						sys.crear_ciudad(paquete.getText());
						setVisible(false);
						JOptionPane.showMessageDialog(jContentPane,"Paquete "+paquete.getText()+" cargado exitosamente."
								,"Aviso",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"Error cargando el paquete "+paquete.getText()+". Contactese con el Administrador"
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
				cancel.setBounds(new Rectangle(323, 104, 173, 56));
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