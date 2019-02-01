package componentes;

import java.io.Serializable;
import logica.GestionTwitter;

/**
 *
 * @author Annie
 */
public class Buscar extends javax.swing.JPanel implements Serializable {

    private GestionTwitter twitter;

    public Buscar() {
        initComponents();
    }
    
    public void inicializarComponente(GestionTwitter twitter){
        this.twitter = twitter;
    }


    public String getTextoBuscar() {
        return this.jTextFieldTexto.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBuscar = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldTexto = new javax.swing.JTextField();

        jPanelBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldTexto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTexto.setText("Buscar...");
        jTextFieldTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JTextField jTextFieldTexto;
    // End of variables declaration//GEN-END:variables
}
