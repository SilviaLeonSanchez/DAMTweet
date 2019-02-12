package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import twitter4j.Status;
import twitter4j.User;
import static ventanas.PantallaLogin.gestionTwitter;

/**
 *
 * @author Annie
 */
public class ComponenteTweet extends javax.swing.JPanel implements Serializable, ListCellRenderer {

    // ATRIBUTOS
    private String nombreUsuario;
    private String id;
    private String retweets;
    private String textoTweet;

    private SimpleDateFormat sdf;
    private Status tweet;

    // METODOS
    public ComponenteTweet() {
        initComponents();
        sdf = new SimpleDateFormat("dd-MM-yyyy");

    }

    public void inicializarComponente(Status tweet) {
        try {
            this.tweet = tweet;
            setFecha(tweet.getCreatedAt());
            setNombreUsuario(tweet.getUser().getName());
            setId("@" + tweet.getUser().getScreenName());
            setRetweets(Integer.toString(tweet.getRetweetCount()));
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.jLabelId.setText(id);
    }

    public String getRetweets() {
        return retweets;
    }

    public void setRetweets(String retwets) {
        this.retweets = retwets;
        this.jLabelRetweets.setText(retwets);
    }

    public String getTextoTweet() {
        return textoTweet;
    }

    public void setTextoTweet(String textoTweet) {
        String texto = dividirTexto(textoTweet);
        this.textoTweet = texto;
        this.jLabelTweet.setText(texto);
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

    private String dividirTexto(String textoTweet) {
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
        return texto;
    }

    // METODOS ESPECIFICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTweetsSinFoto = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelRetweets = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTweet = new javax.swing.JLabel();
        jButtonLike = new javax.swing.JButton();
        jButtonRetweet = new javax.swing.JButton();
        jLabelId = new javax.swing.JLabel();

        jPanelTweetsSinFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 196, 255)));

        jLabelUsuario.setText("Usuario");

        jLabelFoto.setMaximumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setMinimumSize(new java.awt.Dimension(48, 48));
        jLabelFoto.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabelFecha.setText("Fecha");

        jButtonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/corazon_blanco.png"))); // NOI18N
        jButtonLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLikeActionPerformed(evt);
            }
        });

        jButtonRetweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refrescar_blanco.png"))); // NOI18N
        jButtonRetweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetweetActionPerformed(evt);
            }
        });

        jLabelId.setText("Id");

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
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRetweets, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                                .addComponent(jLabelUsuario)
                                .addComponent(jLabelId)
                                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelRetweets)
                            .addComponent(jButtonRetweet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLike, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        jPanelTweetsSinFotoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelFecha, jLabelId, jLabelRetweets, jLabelUsuario});

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
        gestionTwitter.retwitearTweet(tweet);
        JOptionPane.showMessageDialog(this, "Se ha retuiteado correctamente");
    }//GEN-LAST:event_jButtonRetweetActionPerformed

    private void jButtonLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLikeActionPerformed

    }//GEN-LAST:event_jButtonLikeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLike;
    private javax.swing.JButton jButtonRetweet;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelRetweets;
    private javax.swing.JLabel jLabelTweet;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelTweetsSinFoto;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //CADA VEZ Q SALGA UN TWEET NUEVO, SALDRA LO SIGUIENTE
        Status status = (Status) value;
        //Id usuario
        jLabelRetweets.setText("@" + status.getUser().getScreenName());
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
            Logger.getLogger(ComponenteTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon imagen = new ImageIcon(urlImagen);
        jLabelFoto.setIcon(imagen);

        return this;

    }
}
