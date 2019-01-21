
package componentes;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Annie
 */
public class EscribirTweet extends javax.swing.JPanel implements Serializable {

    private File fotoPerfil;
    private String textoTwittear;
    
    
    
    public EscribirTweet() {
        initComponents();
    }

    public File getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(File fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTextoTwittear() {
        return textoTwittear;
    }

    public void setTextoTwittear(String textoTwittear) {
        this.textoTwittear = textoTwittear;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEscribirTweet = new javax.swing.JPanel();
        jTextFieldTexto = new javax.swing.JTextField();
        jButtonAnhadirEmoji = new javax.swing.JButton();
        jButtonImagen = new javax.swing.JButton();
        jButtonGif = new javax.swing.JButton();
        jButtonEncuesta = new javax.swing.JButton();
        jButtonUbicacion = new javax.swing.JButton();
        jButtonMas_Anhadir = new javax.swing.JButton();
        jButtonTwittear = new javax.swing.JButton();

        jPanelEscribirTweet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldTexto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTexto.setText("¿Qué está pasando?");
        jTextFieldTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonAnhadirEmoji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cara.png"))); // NOI18N

        jButtonImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagen.png"))); // NOI18N

        jButtonGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gif.png"))); // NOI18N
        jButtonGif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGifActionPerformed(evt);
            }
        });

        jButtonEncuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/encuesta.png"))); // NOI18N

        jButtonUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/localizador.png"))); // NOI18N

        jButtonMas_Anhadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas_anhadir.png"))); // NOI18N

        jButtonTwittear.setText("Twittear");

        javax.swing.GroupLayout jPanelEscribirTweetLayout = new javax.swing.GroupLayout(jPanelEscribirTweet);
        jPanelEscribirTweet.setLayout(jPanelEscribirTweetLayout);
        jPanelEscribirTweetLayout.setHorizontalGroup(
            jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                        .addComponent(jButtonImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonGif, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jButtonMas_Anhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonTwittear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAnhadirEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEscribirTweetLayout.setVerticalGroup(
            jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButtonAnhadirEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGif, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButtonEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButtonUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButtonMas_Anhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButtonImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButtonTwittear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEscribirTweet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEscribirTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGifActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadirEmoji;
    private javax.swing.JButton jButtonEncuesta;
    private javax.swing.JButton jButtonGif;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JButton jButtonMas_Anhadir;
    private javax.swing.JButton jButtonTwittear;
    private javax.swing.JButton jButtonUbicacion;
    private javax.swing.JPanel jPanelEscribirTweet;
    private javax.swing.JTextField jTextFieldTexto;
    // End of variables declaration//GEN-END:variables
}
