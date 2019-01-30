package componentes;

import java.awt.Component;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author Annie
 */
public class TweetsSinFoto extends javax.swing.JPanel implements Serializable, ListCellRenderer {

    private String nombreUsuario;
    private String idUsuario;
    private String textoTweet;
    
    
    public TweetsSinFoto() {
        initComponents();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.jLabelUsuario.setText(nombreUsuario);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        this.jLabelUsuario.setText(idUsuario);
    }

    public String getTextoTweet() {
        return textoTweet;
    }

    public void setTextoTweet(String textoTweet) {
        this.textoTweet = textoTweet;
        this.jLabelTweets.setText(textoTweet);
    }

    public Icon getFotoUsuario() {
        return this.jLabelFoto.getIcon();
    }
    
    public void setFotoUsuario(Twitter twitter){
        try {
            User usuario = twitter.showUser(twitter.getId());
            URL urlImagen = new URL(usuario.getProfileImageURL());
            ImageIcon imagen = new ImageIcon(urlImagen);
            jLabelFoto.setIcon(imagen);
        } catch (TwitterException | IllegalStateException | MalformedURLException ex) {
            Logger.getLogger(EscribirTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFecha(){
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTweetsSinFoto = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonContestar = new javax.swing.JButton();
        jButtonRetweet = new javax.swing.JButton();
        jButtonLike = new javax.swing.JButton();
        jButtonMensaje = new javax.swing.JButton();
        jLabelTweets = new javax.swing.JLabel();

        jPanelTweetsSinFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setText("Usuario");

        jLabelIdUsuario.setText("Id Usuario");

        jLabelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelFoto.setMaximumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setMinimumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabelFecha.setText("Fecha");

        javax.swing.GroupLayout jPanelTweetsSinFotoLayout = new javax.swing.GroupLayout(jPanelTweetsSinFoto);
        jPanelTweetsSinFoto.setLayout(jPanelTweetsSinFotoLayout);
        jPanelTweetsSinFotoLayout.setHorizontalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanelTweetsSinFotoLayout.setVerticalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButtonContestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/burbuja.png"))); // NOI18N

        jButtonRetweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retweet.png"))); // NOI18N

        jButtonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/like.png"))); // NOI18N

        jButtonMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mensaje.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabelTweets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTweets, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContestar;
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonMensaje;
    private javax.swing.JButton jButtonRetweet;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTweets;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTweetsSinFoto;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
      //CADA VEZ Q SALGA UN TWEET NUEVO, SALDRA LO SIGUIENTE
        Status status=(Status)value;
        //Id usuario
        jLabelIdUsuario.setText("@"+ status.getUser().getScreenName());
        //Nombre usuario
        jLabelUsuario.setText(status.getUser().getName());
        //Fecha
        jLabelFecha.setText(status.getCreatedAt()+ "");
        //Tweets texto
        jLabelTweets.setText(status.getText());
        //Foto Usuario        
        URL urlImagen = null;
        try {
            urlImagen = new URL(status.getUser().getProfileImageURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(TweetsSinFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon imagen = new ImageIcon(urlImagen);
        jLabelFoto.setIcon(imagen);
        
        return this;

    }
}
