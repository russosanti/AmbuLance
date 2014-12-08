package Interfaz.Swing;

import Sistema.Sistema;
import javax.swing.JOptionPane;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;

/**Ventana del menu del hospital
 * @author Santy */
public class Menu_Hospital extends javax.swing.JFrame {

    
    public Menu_Hospital() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        set_hosp = new javax.swing.JButton();
        ambulancias = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Hospital");

        jPanel1.setBackground(new java.awt.Color(75, 205, 255));

        set_hosp.setBackground(new java.awt.Color(254, 88, 88));
        set_hosp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        set_hosp.setText("Set Hospital");
        set_hosp.setToolTipText("Setear la Esquina indicada para el Hospital.");
        set_hosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                set_hospActionPerformed(evt);
            }
        });

        ambulancias.setBackground(new java.awt.Color(255, 71, 71));
        ambulancias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ambulancias.setText("Ambulancias");
        ambulancias.setToolTipText("Abre el menu para la administracion de Ambulancias");
        ambulancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambulanciasActionPerformed(evt);
            }
        });

        salir.setBounds(new Rectangle(332, 282, 47, 46));
        ImageIcon icon = new ImageIcon("Imagenes/anta.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(salir.getWidth(),salir.getHeight(),java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        salir.setIcon(newIcon);
        salir.setBackground(new java.awt.Color(250, 66, 66));
        salir.setToolTipText("Volver al Menu Principal");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ambulancias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(set_hosp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(set_hosp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(ambulancias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ambulanciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambulanciasActionPerformed
        Menu_Ambulancias amb = new Menu_Ambulancias();
        amb.setLocation(Menu_Hospital.this.getLocationOnScreen());
        Menu_Hospital.this.setVisible(false);
        amb.setVisible(true);
        dispose();
    }//GEN-LAST:event_ambulanciasActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        Main m = new Main();
        m.setLocation(getLocation());
        setVisible(false);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void set_hospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_set_hospActionPerformed
        String s = JOptionPane.showInputDialog("Ingrese el punto donde quiere setear el hospital.\n"
                + "Puede ser por id: numero o por punto: x;y");
        if(s!=null){
            s = s.trim();
            if(s.length()>0){
                int pc = s.indexOf(";");
                try{
                    if(pc<0){
                        Sistema sys = Nucleo_Keeper.get_Nucleo();
                        sys.config_hospital(Long.parseLong(s));
                    }else{
                        String auxy = s.substring(pc+1,s.length());
                        s = s.substring(0,pc);
                        float x = Float.parseFloat(s);
                        float y = Float.parseFloat(auxy);
                        Sistema sys = Nucleo_Keeper.get_Nucleo();
                        sys.config_hospital(x,y);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(Menu_Hospital.this,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(Menu_Hospital.this,"ERROR: Hospital no seteado xq no se ingresaron datos","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(Menu_Hospital.this,"ERROR: Hospital no seteado xq no se ingresaron datos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_set_hospActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Menu_Hospital().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ambulancias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    private javax.swing.JButton set_hosp;
    // End of variables declaration//GEN-END:variables
}