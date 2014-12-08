package Interfaz;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;

public class Nombre1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JTextField nombre = null;
	private Main m;

	/**
	 * This is the default constructor
	 */
	public Nombre1(Main m) {
		super();
		initialize();
		this.m = m;
	}

	private void initialize() {
		this.setSize(389, 261);
		this.setContentPane(getJContentPane());
		this.setTitle("Nombre 1");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getNombre(), null);
		}
		return jContentPane;
	}

	private JButton getJButton() {
		if (jButton == null) {
			try {
				jButton = new JButton();
				jButton.setBounds(new Rectangle(123, 147, 125, 45));
				jButton.setText("Set Nombre");
				jButton.setName("OK");
				jButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						m.setNombre1(Nombre1.this.nombre.getText());
						setVisible(false);
						dispose();
					}
				});
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(null,"ERROR: "+e.getMessage(),"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return jButton;
	}

	private JTextField getNombre() {
		if (nombre == null) {
			try {
				nombre = new JTextField();
				nombre.setBounds(new Rectangle(57, 42, 264, 35));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(null,"ERROR: "+e.getMessage(),"WARNING! ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return nombre;
	}

}