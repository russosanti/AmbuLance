package Interfaz.Swing;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import Sistema.Sistema;
import java.awt.Font;

/**Ventana para crear la calle
 * @author Santy */
public class Crear_Calle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel aviso = null;
	private JLabel eti_id = null;
	private JLabel eti_pto_ini = null;
	private JLabel eti_pto_fin = null;
	private JLabel eti_nombre = null;
	private JLabel eti_aini = null;
	private JLabel eti_afin = null;
	private JTextField id = null;
	private JTextField pto_ini = null;
	private JTextField pto_fin = null;
	private JTextField nombre = null;
	private JTextField nro_ini = null;
	private JTextField nro_fin = null;
	private JButton cancel = null;
	private JButton crear = null;
	
        /**This is the default constructor */
	public Crear_Calle() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(561, 372);
		this.setName("crear_calle");
		this.setContentPane(getJContentPane());
		this.setTitle("Formulario Para Crear Una Calle");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			eti_afin = new JLabel();
			eti_afin.setBounds(new Rectangle(275, 211, 101, 32));
			eti_afin.setHorizontalAlignment(SwingConstants.CENTER);
			eti_afin.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_afin.setText("Nro Final:");
			eti_aini = new JLabel();
			eti_aini.setBounds(new Rectangle(13, 211, 101, 32));
			eti_aini.setHorizontalAlignment(SwingConstants.CENTER);
			eti_aini.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_aini.setText("Nro Inicial: ");
			eti_nombre = new JLabel();
			eti_nombre.setBounds(new Rectangle(23, 157, 81, 32));
			eti_nombre.setHorizontalAlignment(SwingConstants.CENTER);
			eti_nombre.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_nombre.setText("Nombre: ");
			eti_pto_fin = new JLabel();
			eti_pto_fin.setBounds(new Rectangle(283, 97, 89, 32));
			eti_pto_fin.setHorizontalAlignment(SwingConstants.CENTER);
			eti_pto_fin.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_pto_fin.setText("* ID Punto Final:");
			eti_pto_ini = new JLabel();
			eti_pto_ini.setBounds(new Rectangle(10, 97, 104, 32));
			eti_pto_ini.setHorizontalAlignment(SwingConstants.CENTER);
			eti_pto_ini.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_pto_ini.setText("* ID Punto Inicial:");
			eti_id = new JLabel();
			eti_id.setBounds(new Rectangle(37, 50, 34, 28));
			eti_id.setHorizontalAlignment(SwingConstants.CENTER);
			eti_id.setHorizontalTextPosition(SwingConstants.CENTER);
			eti_id.setText("* ID: ");
			aviso = new JLabel();
			aviso.setBounds(new Rectangle(14, 7, 208, 25));
			aviso.setForeground(Color.red);
			aviso.setText("Los campos con * son Obligatorios");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(165, 236, 236));
			jContentPane.add(aviso, null);
			jContentPane.add(eti_id, null);
			jContentPane.add(eti_pto_ini, null);
			jContentPane.add(eti_pto_fin, null);
			jContentPane.add(eti_nombre, null);
			jContentPane.add(eti_aini, null);
			jContentPane.add(eti_afin, null);
			jContentPane.add(getId(), null);
			jContentPane.add(getPto_ini(), null);
			jContentPane.add(getPto_fin(), null);
			jContentPane.add(getNombre(), null);
			jContentPane.add(getNro_ini(), null);
			jContentPane.add(getNro_fin(), null);
			jContentPane.add(getCancel(), null);
			jContentPane.add(getCrear(), null);
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
				id.setBounds(new Rectangle(88, 50, 437, 26));
				id.setToolTipText("Ingrese el Id de la Calle Aqui");
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return id;
	}

	/**
	 * This method initializes pto_ini	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPto_ini() {
		if (pto_ini == null) {
			try {
				pto_ini = new JTextField();
				pto_ini.setBounds(new Rectangle(124, 100, 144, 26));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return pto_ini;
	}

	/**
	 * This method initializes pto_fin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPto_fin() {
		if (pto_fin == null) {
			try {
				pto_fin = new JTextField();
				pto_fin.setBounds(new Rectangle(386, 100, 137, 26));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return pto_fin;
	}

	/**
	 * This method initializes nombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombre() {
		if (nombre == null) {
			try {
				nombre = new JTextField();
				nombre.setBounds(new Rectangle(108, 161, 418, 26));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return nombre;
	}

	/**
	 * This method initializes nro_ini	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNro_ini() {
		if (nro_ini == null) {
			try {
				nro_ini = new JTextField();
				nro_ini.setBounds(new Rectangle(131, 213, 137, 26));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return nro_ini;
	}

	/**
	 * This method initializes nro_fin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNro_fin() {
		if (nro_fin == null) {
			try {
				nro_fin = new JTextField();
				nro_fin.setBounds(new Rectangle(385, 213, 140, 26));
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return nro_fin;
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
				cancel.setBounds(new Rectangle(306, 270, 172, 51));
				cancel.setToolTipText("Cancela la operacion.");
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
	 * This method initializes crear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCrear() {
		if (crear == null) {
			try {
				crear = new JButton();
				crear.setBounds(new Rectangle(67, 270, 172, 51));
				crear.setToolTipText("Crea el punto con los datos brindados");
				crear.setFont(new Font("Dialog", Font.BOLD, 36));
				crear.setText("Crear");
				crear.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						if(id.getText()==null || id.getText().trim().length()==0 || pto_ini.getText()==null || pto_ini.getText().trim().length()==0 || pto_fin.getText()==null || pto_fin.getText().trim().length()==0){
							new RuntimeException("Hay campos obligatorios vacios");
						}else{
							String aux = id.getText();
							aux = aux.trim();
							if(aux.length()<=0){
								new RuntimeException("El campo del ID esta vacio");
							}else{
								long cid = Long.parseLong(aux);
								aux = pto_ini.getText();
								aux = aux.trim();
								if(aux.length()<=0){
									new RuntimeException("El campo del ID Punto Inicial esta vacio");
								}else{
									long cpto_ini = Long.parseLong(aux);
									aux = pto_fin.getText();
									aux = aux.trim();
									if(aux.length()<=0){
										new RuntimeException("El campo del ID Punto Final esta vacio");
									}else{
										long cpto_fin = Long.parseLong(aux);
										if((nombre.getText()==null || nombre.getText().trim().length()==0) && (nro_ini.getText()==null || nro_ini.getText().trim().length()==0) && (nro_fin.getText()==null || nro_fin.getText().trim().length()==0)){
											Sistema sys = Nucleo_Keeper.get_Nucleo();
											sys.crear_calle(cid,cpto_ini,cpto_fin);
											setVisible(false);
											dispose();
										}else{
											if(nombre.getText()==null || nombre.getText().trim().length()==0){
												new RuntimeException("El campo del nombre esta vacio, puede estar vacio si Nro Inicial y Final Tambien lo estan");
											}else{
												aux = nombre.getText().trim();
												String cnombre = aux;
												int cnro_ini;
												if(nro_ini.getText()==null || nro_ini.getText().trim().length()==0){
													if(JOptionPane.showConfirmDialog(jContentPane,"El campo del NroInicial esta vacio, desea dejar su valor como 0?","ALERTA",JOptionPane.YES_NO_OPTION)==0){
														cnro_ini = 0;
													}else{
														JOptionPane.showMessageDialog(jContentPane,"Punto no creado, ingrese el valor del Numero Inicio","AVISO",JOptionPane.WARNING_MESSAGE);
														return;
													}
												}else{
													aux = nro_ini.getText().trim();
													cnro_ini = Integer.parseInt(aux);
												}
												int cnro_fin;
												if(nro_fin.getText()==null || nro_fin.getText().trim().length()==0){
													if(JOptionPane.showConfirmDialog(jContentPane,"El campo del Numero Final esta vacio, desea dejar su valor como 0?","ALERTA",JOptionPane.YES_NO_OPTION)==0){
														cnro_fin = 0;
													}else{
														JOptionPane.showMessageDialog(jContentPane,"Punto no creado, ingrese el valor del Numero Final","AVISO",JOptionPane.WARNING_MESSAGE);
														return;
													}
												}else{
													aux = nro_fin.getText().trim();
													cnro_fin = Integer.parseInt(aux);
												}
												Sistema sys = Nucleo_Keeper.get_Nucleo();
												sys.crear_calle(cid,cpto_ini,cpto_fin,cnombre,cnro_ini,cnro_fin);
												setVisible(false);
												dispose();
											}
										}
									}
								}
							}
						}
					}
				});
			}catch(RuntimeException e){
				JOptionPane.showMessageDialog(jContentPane,e.getMessage(),"AVISO!",JOptionPane.WARNING_MESSAGE);
			} catch (java.lang.Throwable e) {
				JOptionPane.showMessageDialog(jContentPane,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		return crear;
	}
}