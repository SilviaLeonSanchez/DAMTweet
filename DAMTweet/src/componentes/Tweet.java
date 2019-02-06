package componentes;

import java.awt.Component;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import logica.GestionTwitter;
import twitter4j.Status;
import twitter4j.User;

/**
 *
 * @author Annie
 */
public class Tweet extends javax.swing.JPanel implements Serializable, ListCellRenderer {

    // ATRIBUTOS
    private String nombreUsuario;
    private String idUsuario;
    private String textoTweet;

    private SimpleDateFormat sdf;
    private GestionTwitter twitter;
    private Status tweet;

    // METODOS
    public Tweet() {
        initComponents();
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }

    public void inicializarComponente(GestionTwitter gestorTwitter, Status tweet) {
        try {
            this.tweet = tweet;
            this.twitter = gestorTwitter;
            setFecha(tweet.getCreatedAt());
            setNombreUsuario(tweet.getUser().getScreenName());
            //setIdUsuario(tweet.getUser().);
            setFotoUsuario();
            setTextoTweet(tweet.getText());
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // GETTER Y SETTER
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
        String[] palabras = textoTweet.split(" ");
        String texto = "";
        int letras = 0;

        for (String palabra : palabras) {
            letras += palabra.length();
            texto += palabra;
            if (letras >= 60) {
                texto += "\n";
                letras = 0;
            } else {
                texto += " ";
                letras++;
            }
        }
        System.out.println(texto);
        this.textoTweet = texto;
        this.jLabelTweet.setText(textoTweet);
    }

    public Icon getFotoUsuario() {
        return this.jLabelFoto.getIcon();
    }

    public void setFotoUsuario() {
        try {
            User usuario = tweet.getUser();
            URL urlImagen = new URL(usuario.getProfileImageURL());
            ImageIcon imagen = new ImageIcon(urlImagen);
            jLabelFoto.setIcon(imagen);
        } catch (IllegalStateException | MalformedURLException ex) {
            Logger.getLogger(NuevoTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFecha() {
        return null;
    }

    public void setFecha(Date fecha) {
        this.jLabelFecha.setText(sdf.format(fecha));
    }

    // METODOS ESPECIFICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTweetsSinFoto = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTweet = new javax.swing.JLabel();
        jButtonContestar = new javax.swing.JButton();
        jButtonLike = new javax.swing.JButton();
        jButtonRetweet = new javax.swing.JButton();

        jPanelTweetsSinFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setText("Usuario");

        jLabelIdUsuario.setText("Id Usuario");

        jLabelFoto.setMaximumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setMinimumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabelFecha.setText("Fecha");

        jButtonContestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/burbuja.png"))); // NOI18N

        jButtonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/like.png"))); // NOI18N
        jButtonLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLikeActionPerformed(evt);
            }
        });

        jButtonRetweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retweet.png"))); // NOI18N
        jButtonRetweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetweetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTweetsSinFotoLayout = new javax.swing.GroupLayout(jPanelTweetsSinFoto);
        jPanelTweetsSinFoto.setLayout(jPanelTweetsSinFotoLayout);
        jPanelTweetsSinFotoLayout.setHorizontalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addComponent(jLabelTweet, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanelTweetsSinFotoLayout.setVerticalGroup(
            jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTweetsSinFotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTweetsSinFotoLayout.createSequentialGroup()
                        .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTweetsSinFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelIdUsuario)
                                .addComponent(jLabelUsuario))
                            .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonContestar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        jPanelTweetsSinFotoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelFecha, jLabelIdUsuario, jLabelUsuario});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTweetsSinFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetweetActionPerformed
        twitter.retwitearTweet(tweet);
        JOptionPane.showMessageDialog(this, "Se ha retuiteado correctamente");
    }//GEN-LAST:event_jButtonRetweetActionPerformed

    private void jButtonLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLikeActionPerformed

    }//GEN-LAST:event_jButtonLikeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContestar;
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonRetweet;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTweet;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelTweetsSinFoto;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //CADA VEZ Q SALGA UN TWEET NUEVO, SALDRA LO SIGUIENTE
        Status status = (Status) value;
        //Id usuario
        jLabelIdUsuario.setText("@" + status.getUser().getScreenName());
        //Nombre usuario
        jLabelUsuario.setText(status.getUser().getName());
        //Fecha
        jLabelFecha.setText(status.getCreatedAt() + "");
        //Tweets texto
        jLabelTweet.setText(status.getText());
        //Foto Usuario        
        URL urlImagen = null;
        try {
            urlImagen = new URL(status.getUser().getProfileImageURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon imagen = new ImageIcon(urlImagen);
        jLabelFoto.setIcon(imagen);

        return this;

    }
}
