package componentes;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import logica.GestionTwitter;
import twitter4j.Status;
import utils.Listeners;
import ventanas.PantallaTweetsBuscados;
import ventanas.PantallaLogin;

/**
 *
 * @author Annie
 */
public class Buscar extends javax.swing.JPanel implements Serializable {

    private GestionTwitter twitter;
    private Listeners listener;
    

    public Buscar() {
        initComponents();
        listener = new Listeners();
        aplicarListenerBotones();
    }

    public void inicializarComponente(GestionTwitter twitter) {
        this.twitter = twitter;
    }

    public String getTextoBuscar() {
        
        return this.jTextFieldTexto.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBuscar = new javax.swing.JButton();
        jTextFieldTexto = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(640, 64));
        setPreferredSize(new java.awt.Dimension(640, 62));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa_blanco.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextFieldTexto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldTexto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTexto.setText("Buscar...");
        jTextFieldTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTexto))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        PantallaTweetsBuscados ventana = new PantallaTweetsBuscados(PantallaLogin.padre, true);
        ArrayList<Status> tweetsBuscados = (ArrayList<Status>) twitter.buscarTweets(this.getTextoBuscar());
        ventana.setTweetsBuscados(tweetsBuscados);
        ventana.setVisible(true);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void aplicarListenerBotones() {
        final Color azulOscuro = new Color(29, 161, 242);
        final Color azulClaro = new Color(128, 216, 255);
        final Color rojo = new Color(255, 0, 0);

        listener.cambiarColorAlPasarPorEncima(jButtonBuscar, azulClaro, azulOscuro);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JTextField jTextFieldTexto;
    // End of variables declaration//GEN-END:variables
}
