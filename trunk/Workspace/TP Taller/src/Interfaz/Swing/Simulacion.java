package Interfaz.Swing;

import Interfaz.IUser;
import Interfaz.Interface_Keeper;
import Sistema.Sistema;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**Ventana para mostrar los resultados de la simulacion y la torre
 * @author Santy */
public class Simulacion extends javax.swing.JFrame {

    public Simulacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panhosp = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infohosp = new javax.swing.JTextArea();
        siguiente = new javax.swing.JButton();
        saltar = new javax.swing.JButton();
        stamps = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panetorre = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infotorre = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        dif = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulando...");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panhosp.setBackground(new java.awt.Color(0, 0, 0));
        panhosp.setToolTipText("Ventana donde se muestran los resultados del Hospital.");

        infohosp.setColumns(20);
        infohosp.setEditable(false);
        infohosp.setRows(5);
        jScrollPane1.setViewportView(infohosp);

        siguiente.setFont(new java.awt.Font("Tahoma", 0, 14));
        siguiente.setText("Siguiente");
        siguiente.setToolTipText("Pasa al siguiente tiempo.");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        saltar.setFont(new java.awt.Font("Tahoma", 0, 14));
        saltar.setText("Saltar");
        saltar.setToolTipText("Salta los tiempos especificados en el box de al lado.");
        saltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saltarActionPerformed(evt);
            }
        });

        stamps.setFont(new java.awt.Font("Tahoma", 0, 14));
        stamps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stamps.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informes del Hospital: ");

        javax.swing.GroupLayout panhospLayout = new javax.swing.GroupLayout(panhosp);
        panhosp.setLayout(panhospLayout);
        panhospLayout.setHorizontalGroup(
            panhospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panhospLayout.createSequentialGroup()
                .addGroup(panhospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panhospLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(saltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(stamps, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panhospLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panhospLayout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(304, 304, 304))
        );
        panhospLayout.setVerticalGroup(
            panhospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panhospLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panhospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stamps, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hospital", null, panhosp, "Abre el sector donde muestra la simulacion del Hospital");

        panetorre.setBackground(new java.awt.Color(0, 0, 0));
        panetorre.setToolTipText("Muestra los informes de la Torre de Transito.");

        infotorre.setColumns(20);
        infotorre.setEditable(false);
        infotorre.setRows(5);
        jScrollPane2.setViewportView(infotorre);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informes de la Torre:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jButton1.setText("Cambiar Todo");
        jButton1.setToolTipText("Cambia la dificultad de todas las calles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton2.setText("Cambiar Dificultad");
        jButton2.setToolTipText("Cambia la dificultad de la calle especificada al constado con la dificultad especificada.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Calle o Id de las Esquinas");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dificultad Nueva");

        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setText("id o x;y");
        id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idMouseClicked(evt);
            }
        });

        dif.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panetorreLayout = new javax.swing.GroupLayout(panetorre);
        panetorre.setLayout(panetorreLayout);
        panetorreLayout.setHorizontalGroup(
            panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panetorreLayout.createSequentialGroup()
                .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panetorreLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jLabel2))
                    .addGroup(panetorreLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panetorreLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(95, 95, 95)
                                .addComponent(jButton2)
                                .addGap(1, 1, 1)
                                .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panetorreLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel3))
                                    .addGroup(panetorreLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dif, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        panetorreLayout.setVerticalGroup(
            panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panetorreLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panetorreLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panetorreLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panetorreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Torre", null, panetorre, "Abre el centro de comandos de la torre.");

        ImageIcon newIcon = new ImageIcon("Imagenes/amb-ico.jpg");
        Image img = newIcon.getImage();
        Image newimg = img.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);

        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
        jTabbedPane1.setMnemonicAt(1, KeyEvent.VK_2);
        jTabbedPane1.setIconAt(0,icon);
        jTabbedPane1.setIconAt(1,icon);

        jMenu1.setText("Opciones");
        jMenu1.setToolTipText("Menu de Opciones");

        jMenuItem1.setText("Nuevo Pedido");
        jMenuItem1.setToolTipText("Abre la ventana para crear un nuevo pedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Comprar Ambulancias");
        jMenuItem2.setToolTipText("Abre la ventana para la compra de Ambulancias.");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Stop");
        jMenuItem3.setToolTipText("Sale al menu principal.");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Exit");
        jMenuItem4.setToolTipText("Cierra la aplicacion,");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.setToolTipText("Menu de la ayuda.");

        jMenuItem5.setText("Help");
        jMenuItem5.setToolTipText("Muestra la ayuda.");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("About");
        jMenuItem6.setToolTipText("Muestra el about.");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMouseClicked
        Simulacion.this.id.setText("");
    }//GEN-LAST:event_idMouseClicked

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        Sistema sys = Nucleo_Keeper.get_Nucleo();
        sys.continuar();
    }//GEN-LAST:event_siguienteActionPerformed

    private void saltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saltarActionPerformed
        try{
            long tiempo = Long.parseLong(Simulacion.this.stamps.getText());
            if(tiempo>=0){
                Sistema sys = Nucleo_Keeper.get_Nucleo();
                sys.adelantar(tiempo);
            }else{
                 JOptionPane.showMessageDialog(Simulacion.this,"ERROR: El tiempo debe ser positivo","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(Simulacion.this,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_saltarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Comprar_Ambulancias amb = new Comprar_Ambulancias();
        amb.setLocation(Simulacion.this.getLocationOnScreen());
        amb.setEnSimulacion(true);
        amb.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Main m = new Main();
        m.setLocation(Simulacion.this.getLocationOnScreen());
        IUser i = Interface_Keeper.get_Interfaz();
        i.setActual_Frame(m);
        Simulacion.this.setVisible(false);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Main m = new Main();
        Sistema sys = Nucleo_Keeper.get_Nucleo();
        sys.finalizar_sim();
        m.setLocation(Simulacion.this.getLocationOnScreen());
        IUser i = Interface_Keeper.get_Interfaz();
        i.setActual_Frame(m);
        Simulacion.this.setVisible(false);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Sistema sys = Nucleo_Keeper.get_Nucleo();
        sys.exit();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu_Pedido ped = new Menu_Pedido();
        ped.setLocation(Simulacion.this.getLocationOnScreen());
        ped.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sistema sys = Nucleo_Keeper.get_Nucleo();
        sys.modificar_dificultad_calle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String p = Simulacion.this.id.getText();
        if(p!=null){
            p = p.trim();
            if(p.length()>0){
                try{
                    int dif = Integer.parseInt(Simulacion.this.dif.getText());
                    if(dif<0||dif>10){
                         JOptionPane.showMessageDialog(Simulacion.this,"ERROR: La dificultad no puede ser menor que 0 ni mayor que 10.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }else{
                        int pc = p.indexOf(";");
                        if(pc<0){
                            Sistema sys = Nucleo_Keeper.get_Nucleo();
                            sys.modificar_dificultad_calle(Long.parseLong(p),dif);
                        }else{
                            String auxy = p.substring(pc+1,p.length());
                            p = p.substring(0,pc);
                            long x = Long.parseLong(p);
                            long y = Long.parseLong(auxy);
                            Sistema sys = Nucleo_Keeper.get_Nucleo();
                            sys.modificar_dificultad_calle(x,y,dif);
                        }
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(Simulacion.this,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(Simulacion.this,"ERROR: Hospital no seteado xq no se ingresaron datos","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(Simulacion.this,"ERROR: Hospital no seteado xq no se ingresaron datos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        About a = new About();
        a.setLocation(Simulacion.this.getLocationOnScreen());
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Help h = new Help();
        h.setLocation(Simulacion.this.getLocationOnScreen());
        h.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Simulacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dif;
    private javax.swing.JTextField id;
    private javax.swing.JTextArea infohosp;
    private javax.swing.JTextArea infotorre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panetorre;
    private javax.swing.JPanel panhosp;
    private javax.swing.JButton saltar;
    private javax.swing.JButton siguiente;
    private javax.swing.JTextField stamps;
    // End of variables declaration//GEN-END:variables

    public void set_ihosp(String s){
        this.infohosp.append(s);
    }
    
    public void set_itorre(String s){
        this.infotorre.append(s);
    }
}