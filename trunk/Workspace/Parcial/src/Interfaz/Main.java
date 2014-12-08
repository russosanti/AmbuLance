package Interfaz;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton ingreso_nombre = null;
	private JButton comenzar_partida = null;
	private String nombre1;
	private String nombre2;
	private JButton nombrej2 = null;
	/**
	 * This is the default constructor
	 */
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
		this.setSize(476, 325);
		this.setContentPane(getJContentPane());
		this.setTitle("Menu");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getIngreso_nombre(), null);
			jContentPane.add(getComenzar_partida(), null);
			jContentPane.add(getNombrej2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes ingreso_nombre	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getIngreso_nombre() {
		if (ingreso_nombre == null) {
			try {
				ingreso_nombre = new JButton();
				ingreso_nombre.setBounds(new Rectangle(12, 14, 195, 59));
				ingreso_nombre.setText("Ingreso de Nombre 1");
				ingreso_nombre.setName("ingreso_nombre");
				ingreso_nombre.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Nombre1 nom = new Nombre1(Main.this);
						nom.setLocation(getLocationOnScreen());
						nom.setVisible(true);
					}
				});
			} catch (java.lang.Throwable e) {

			}
		}
		return ingreso_nombre;
	}

	/**
	 * This method initializes comenzar_partida	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getComenzar_partida() {
		if (comenzar_partida == null) {
			try {
				comenzar_partida = new JButton();
				comenzar_partida.setBounds(new Rectangle(138, 129, 179, 56));
				comenzar_partida.setText("Inicio Partida");
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(null,"ERROR: "+e.getMessage(),"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return comenzar_partida;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getNombre2() {
		return nombre2;
	}

	/**
	 * This method initializes nombrej2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getNombrej2() {
		if (nombrej2 == null) {
			try {
				nombrej2 = new JButton();
				nombrej2.setBounds(new Rectangle(260, 11, 171, 60));
				nombrej2.setText("Ingreso de Nombre 2");
			} catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return nombrej2;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
