package Interfaz.Swing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import Sistema.Sistema;
import java.awt.Font;

/**Ventana para guardar el mapa
 * @author Santy */
public class Guardar_Mapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lnombre_mapa = null;
	private JTextField nombre_mapa = null;
	private JButton cancel = null;
	private JButton Guardar = null;

	
	public Guardar_Mapa() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(527, 182);
		this.setName("guardar_mapa");
		this.setContentPane(getJContentPane());
		this.setTitle("Guardar Mapa");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lnombre_mapa = new JLabel();
			lnombre_mapa.setBounds(new Rectangle(24, 26, 119, 26));
			lnombre_mapa.setHorizontalAlignment(SwingConstants.CENTER);
			lnombre_mapa.setHorizontalTextPosition(SwingConstants.CENTER);
			lnombre_mapa.setText("Nombre del Mapa:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lnombre_mapa, null);
			jContentPane.add(getNombre_mapa(), null);
			jContentPane.add(getCancel(), null);
			jContentPane.add(getGuardar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes nombre_mapa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombre_mapa() {
		if (nombre_mapa == null) {
			try {
				nombre_mapa = new JTextField();
				nombre_mapa.setBounds(new Rectangle(153, 27, 345, 27));
				nombre_mapa.setToolTipText("Ingrese aqui el id con el cual quiere guardar el mapa");
				nombre_mapa.setText("ID del Mapa a Guardar");
				nombre_mapa.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						nombre_mapa.setText("");
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return nombre_mapa;
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
				cancel.setBounds(new Rectangle(280, 78, 178, 46));
				cancel.setToolTipText("Salir al Menu Anterior");
				cancel.setName("cancel");
				cancel.setFont(new Font("Dialog", Font.BOLD, 36));
				cancel.setText("Cancel");
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

	/**
	 * This method initializes Guardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getGuardar() {
		if (Guardar == null) {
			try {
				Guardar = new JButton();
				Guardar.setBounds(new Rectangle(51, 78, 178, 46));
				Guardar.setToolTipText("Guarda el Mapa en la Base");
				Guardar.setFont(new Font("Dialog", Font.BOLD, 36));
				Guardar.setText("Guardar");
				Guardar.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(nombre_mapa.getText()==null){
							JOptionPane.showMessageDialog(jContentPane,"El Nombre del mapa esta vacio!","WARNING",JOptionPane.WARNING_MESSAGE);
						}else{
							String s = nombre_mapa.getText().trim();
							if(s.length()<=0){
								JOptionPane.showMessageDialog(jContentPane,"El Nombre del mapa debe contener por lo menos un caracter","WARNING",JOptionPane.WARNING_MESSAGE);
							}else{
								Sistema sys = Nucleo_Keeper.get_Nucleo();
								sys.guardar_mapa(s);
								setVisible(false);
								dispose();
							}
						}
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return Guardar;
	}
}