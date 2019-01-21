
package componentes;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Annie
 */
public class TweetsSinFoto extends javax.swing.JPanel implements Serializable{
   
private String nombreUsuario;
private String idUsuario;
private String textoTweet;
private File fotoUsuario;



    public TweetsSinFoto() {
        initComponents();
       }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTextoTweet() {
        return textoTweet;
    }

    public void setTextoTweet(String textoTweet) {
        this.textoTweet = textoTweet;
    }

    public File getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(File fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTweetsSinFoto = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jButtonContestar = new javax.swing.JButton();
        jButtonRetweet = new javax.swing.JButton();
        jButtonLike = new javax.swing.JButton();
        jButtonMensaje = new javax.swing.JButton();
        jLabelTweets = new javax.swing.JLabel();

        jPanelTweetsSinFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setText("Usuario");

        jLabelIdUsuario.setText("Id Usuario");

        jButtonContestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/burbuja.png"))); // NOI18N

        jButtonRetweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retweet.png"))); // NOI18N

        jButtonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/like.png"))); // NOI18N

        jButtonMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mensaje.png"))); // NOI18N

        jLabelTweets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelTweetsSinFotoLayout = new javax.swing.GroupLayout(jPanelTweetsSinFoto);
        jPanelTweetsSinFoto.setLayout(jPanelTweetsSinFotoLayout);
        jPanelTweetsSinFotoLayout.setHorizontalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTweetsSinFotoLayout.setVerticalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelIdUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTweets, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContestar;
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonMensaje;
    private javax.swing.JButton jButtonRetweet;
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTweets;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelTweetsSinFoto;
    // End of variables declaration//GEN-END:variables
}
