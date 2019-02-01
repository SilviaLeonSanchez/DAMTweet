package componentes;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.GestionTwitter;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author Annie
 */
public class NuevoTweet extends javax.swing.JPanel implements Serializable {

    private GestionTwitter twitter;

    public NuevoTweet() {
        initComponents();
    }
    
    public void inicializarComponente(GestionTwitter twitter){
        this.twitter = twitter;
        setFotoPerfil();
    }

    public Icon getFotoPerfil() {
        return this.jLabelFoto.getIcon();
    }
    
    public void setFotoPerfil(){
        try {
            User usuario = twitter.getUsuario();
            URL urlImagen = new URL(usuario.getProfileImageURL());
            ImageIcon imagen = new ImageIcon(urlImagen);
            jLabelFoto.setIcon(imagen);
        } catch (IllegalStateException | MalformedURLException ex) {
            Logger.getLogger(NuevoTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTextoTwittear() {
        return this.jTextFieldTexto.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEscribirTweet = new javax.swing.JPanel();
        jButtonAnhadirEmoji = new javax.swing.JButton();
        jButtonImagen = new javax.swing.JButton();
        jButtonGif = new javax.swing.JButton();
        jButtonEncuesta = new javax.swing.JButton();
        jButtonUbicacion = new javax.swing.JButton();
        jButtonMas_Anhadir = new javax.swing.JButton();
        jButtonTwittear = new javax.swing.JButton();
        jTextFieldTexto = new javax.swing.JTextField();
        jLabelFoto = new javax.swing.JLabel();

        jPanelEscribirTweet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAnhadirEmoji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cara.png"))); // NOI18N

        jButtonImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagen.png"))); // NOI18N

        jButtonGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gif.png"))); // NOI18N

        jButtonEncuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/encuesta.png"))); // NOI18N

        jButtonUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/localizador.png"))); // NOI18N

        jButtonMas_Anhadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas_anhadir.png"))); // NOI18N

        jButtonTwittear.setText("Twittear");
        jButtonTwittear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTwittearActionPerformed(evt);
            }
        });

        jTextFieldTexto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTexto.setText("¿Qué está pasando?");
        jTextFieldTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelFoto.setMaximumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setMinimumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setPreferredSize(new java.awt.Dimension(48, 48));

        javax.swing.GroupLayout jPanelEscribirTweetLayout = new javax.swing.GroupLayout(jPanelEscribirTweet);
        jPanelEscribirTweet.setLayout(jPanelEscribirTweetLayout);
        jPanelEscribirTweetLayout.setHorizontalGroup(
            jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                        .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnhadirEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                        .addComponent(jButtonImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonGif, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMas_Anhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonTwittear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );

        jPanelEscribirTweetLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonEncuesta, jButtonGif, jButtonImagen, jButtonMas_Anhadir, jButtonUbicacion});

        jPanelEscribirTweetLayout.setVerticalGroup(
            jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscribirTweetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAnhadirEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEscribirTweetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGif, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMas_Anhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTwittear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelEscribirTweetLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonEncuesta, jButtonGif, jButtonImagen, jButtonMas_Anhadir, jButtonUbicacion});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEscribirTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEscribirTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTwittearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTwittearActionPerformed
        String tweet = this.jTextFieldTexto.getText();
        twitter.enviarTweet(tweet);
        JOptionPane.showMessageDialog(this, "Tweet enviado: "+tweet);
    }//GEN-LAST:event_jButtonTwittearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadirEmoji;
    private javax.swing.JButton jButtonEncuesta;
    private javax.swing.JButton jButtonGif;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JButton jButtonMas_Anhadir;
    private javax.swing.JButton jButtonTwittear;
    private javax.swing.JButton jButtonUbicacion;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JPanel jPanelEscribirTweet;
    private javax.swing.JTextField jTextFieldTexto;
    // End of variables declaration//GEN-END:variables
}