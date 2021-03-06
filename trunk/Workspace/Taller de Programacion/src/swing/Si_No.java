package swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;


public class Si_No extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton hola = null;
	private JLabel estado = null;
	private JPanel jContentPane = null;
	
	
	public Si_No() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(462, 249);
		this.setContentPane(getJContentPane());
		this.setTitle("Test");
		estado = new JLabel();
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setHorizontalTextPosition(SwingConstants.CENTER);
		estado.setText("NO");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(getHola(), null);
		this.add(estado, null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private JPanel getJContentPane() {
    	if (jContentPane == null) {
    		jContentPane = new JPanel();
			estado = new JLabel();
			estado.setHorizontalAlignment(SwingConstants.CENTER);
			estado.setHorizontalTextPosition(SwingConstants.CENTER);
			estado.setText("NO");
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.add(getHola(), null);
			this.add(estado, null);
    	}
    	return jContentPane;
	}
				
	private JButton getHola() {
		if (hola == null) {
			try {
				hola = new JButton();
				hola.setText("hola");
				hola.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(estado.getText().equalsIgnoreCase("SI")){
							Si_No.this.estado.setText("NO");
						}else{
							Si_No.this.estado.setText("SI");
						}
						JOptionPane.showMessageDialog(jContentPane,"Gabi gill","Aviso",JOptionPane.ERROR_MESSAGE);
					}
				});
			}catch (java.lang.Throwable e) {
			}
		}
		return hola;
	}
}