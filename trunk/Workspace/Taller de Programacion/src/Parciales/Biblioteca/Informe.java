package Parciales.Biblioteca;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.JScrollBar;

public class Informe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea texto = null;
	private JScrollPane scroll;
	/**
	 * This is the default constructor
	 */
	public Informe() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(618, 253);
		this.setContentPane(getJContentPane());
		this.setTitle("informe");
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
			jContentPane.add(getTexto(), null);
			scroll = new JScrollPane(texto);
			scroll.setBounds(new Rectangle(34, 7, 529, 198));
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jContentPane.add(scroll, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes texto	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTexto() {
		if (texto == null) {
			try {
				texto = new JTextArea();
				texto.setBounds(new Rectangle(33, 24, 533, 167));
				texto.setEditable(false);
			} catch (java.lang.Throwable e) {
			}
		}
		return texto;
	}
	
	public void clear(){
		this.texto.setText("");
	}
	
	public void set_Texto(String s){
		this.texto.append(s+"\n");
		this.texto.setCaretPosition(this.texto.getDocument().getLength());
	}
}
