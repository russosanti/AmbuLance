package Interfaz.Swing;

import Sistema.Sistema;
import Sistema.Tipos.Ambulancias.Ambulancia;
import java.util.Iterator;
import javax.swing.JOptionPane;

/** Ventana donde se compran las ambulancias
 * @author Santy */
public class Comprar_Ambulancias extends javax.swing.JFrame {
    
    private boolean en_sim;
    
    public Comprar_Ambulancias() {
        initComponents();
        this.en_sim = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox();
        comprar = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprar Ambulancias");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(166, 254, 255));

        jLabel1.setText("Cantidad:");

        cant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cant.setText("0");
        cant.setToolTipText("Ingrese aqui la cantidad de ambulancias que desea comprar.");

        jLabel2.setText("Tipo:");

        combobox.setToolTipText("Ingrese aqui el tipo de ambulancias que desea comprar");

        comprar.setFont(new java.awt.Font("Tahoma", 0, 24));
        comprar.setText("Comprar");
        comprar.setToolTipText("Presione para comprar las ambulancias.");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 0, 24));
        cancel.setText("Cancel");
        cancel.setToolTipText("Retornar al menu anterior sin comprar las ambulancias.");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cant))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(comprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(117, 117, 117)
                .addComponent(cancel)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprar)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancel, comprar});

        Iterator<Class<Ambulancia>> iter = Utils.Tipo_Utils.subclases_ambulancia().iterator();
        while(iter.hasNext()){
            combobox.addItem(iter.next());
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        if(!this.en_sim){
            Menu_Ambulancias amb = new Menu_Ambulancias();
            amb.setLocation(Comprar_Ambulancias.this.getLocationOnScreen());
            Comprar_Ambulancias.this.setVisible(false);
            amb.setVisible(true);
            dispose();
        }else{
            Comprar_Ambulancias.this.setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        Sistema sys = Nucleo_Keeper.get_Nucleo();
        try{
            Class<Ambulancia> tipo = (Class<Ambulancia>)combobox.getSelectedItem();
            int ca = Integer.parseInt(cant.getText());
            sys.crear_ambulancia(tipo,ca);
            if(!this.en_sim){
                Menu_Ambulancias amb = new Menu_Ambulancias();
                amb.setLocation(Comprar_Ambulancias.this.getLocationOnScreen());
                Comprar_Ambulancias.this.setVisible(false);
                amb.setVisible(true);
                dispose();
            }else{
                Comprar_Ambulancias.this.setVisible(false);
                dispose();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(Comprar_Ambulancias.this,"ERROR: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_comprarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(!this.en_sim){
            Main m = new Main();
            m.setLocation(Comprar_Ambulancias.this.getLocationOnScreen());
            Comprar_Ambulancias.this.setVisible(false);
            m.setVisible(true);
            dispose();
        }else{
            Comprar_Ambulancias.this.setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Comprar_Ambulancias().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField cant;
    private javax.swing.JComboBox combobox;
    private javax.swing.JButton comprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public void setEnSimulacion(boolean b){
        this.en_sim = b;
    }
}