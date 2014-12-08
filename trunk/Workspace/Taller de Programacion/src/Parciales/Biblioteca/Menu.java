package Parciales.Biblioteca;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton boton = null;
	private JLabel eti = null;

	/**
	 * This is the default constructor
	 */
	public Menu() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(351, 265);
		this.setContentPane(getJContentPane());
		this.setTitle("Menu");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				Runtime.getRuntime().exit(0);
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
			eti = new JLabel();
			eti.setBounds(new Rectangle(135, 44, 63, 26));
			eti.setHorizontalAlignment(SwingConstants.CENTER);
			eti.setHorizontalTextPosition(SwingConstants.CENTER);
			eti.setText("0");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBoton(), null);
			jContentPane.add(eti, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes boton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton() {
		if (boton == null) {
			try {
				boton = new JButton();
				boton.setBounds(new Rectangle(119, 134, 102, 47));
				boton.setText("Accion");
				boton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						Biblioteca b = Nucleo.getNucleo();
						Menu.this.eti.setText(Integer.toString(b.cant_ocupados()));
						b.mostrar_estado();
					}
				});
			} catch (java.lang.Throwable e) {
				
			}
		}
		return boton;
	}

}