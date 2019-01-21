
package componentes;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Annie
 */
public class TweetsConFoto extends javax.swing.JPanel implements Serializable {

private String nombreUsuario;
private String idUsuario;
private String textoTweet;
private File fotoUsuario;
private File foto_video;
  
    public TweetsConFoto() {
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

    public File getFoto_video() {
        return foto_video;
    }

    public void setFoto_video(File foto_video) {
        this.foto_video = foto_video;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTweetsConFoto = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelFotoVideo = new javax.swing.JLabel();
        jButtonContestar = new javax.swing.JButton();
        jButtonMensaje = new javax.swing.JButton();
        jButtonLike = new javax.swing.JButton();
        jButtonRetweet = new javax.swing.JButton();
        jLabelTweets = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(690, 520));

        jPanelTweetsConFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setText("Usuario");

        jLabelIdUsuario.setText("Id Usuario");

        jLabelFotoVideo.setText("FOTO O VIDEO");
        jLabelFotoVideo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonContestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/burbuja.png"))); // NOI18N

        jButtonMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mensaje.png"))); // NOI18N

        jButtonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/like.png"))); // NOI18N

        jButtonRetweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retweet.png"))); // NOI18N

        jLabelTweets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelTweetsConFotoLayout = new javax.swing.GroupLayout(jPanelTweetsConFoto);
        jPanelTweetsConFoto.setLayout(jPanelTweetsConFotoLayout);
        jPanelTweetsConFotoLayout.setHorizontalGroup(
            jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                .addGroup(jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                                .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelFotoVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTweetsConFotoLayout.setVerticalGroup(
            jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsConFotoLayout.createSequentialGroup()
                .addGroup(jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelIdUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTweets, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFotoVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTweetsConFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanelTweetsConFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTweetsConFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContestar;
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonMensaje;
    private javax.swing.JButton jButtonRetweet;
    private javax.swing.JLabel jLabelFotoVideo;
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTweets;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelTweetsConFoto;
    // End of variables declaration//GEN-END:variables
}
