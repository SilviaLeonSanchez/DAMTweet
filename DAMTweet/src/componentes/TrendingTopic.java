/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.Trend;
import utils.Listeners;
import static utils.Listeners.azulClaro;
import static utils.Listeners.azulOscuro;
import static utils.Listeners.rojo;
import static ventanas.PantallaLogin.gestionTwitter;
import static ventanas.PantallaLogin.padre;
import ventanas.PantallaTweetsBuscados;

/**
 *
 * @author Annie
 */
public class TrendingTopic extends javax.swing.JPanel implements Serializable {

    private String numTweets;
    private String trend;
    private Listeners listener;

    public TrendingTopic() {
        initComponents();
        listener = new Listeners();
        aplicarListenerJPanel();
    }

    public void inicializarComponente(Trend trendingTopic) {
        String nombre = trendingTopic.getName();
        if (!nombre.startsWith("#")) {
            nombre = "#" + nombre;
        }
        setIdUsuario(nombre);
        int tweets = trendingTopic.getTweetVolume();
        setNumTweets(((tweets != -1) ? tweets + "" : ""));
    }

    public String getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(String numTweets) {
        this.numTweets = numTweets;
        this.jLabelTotalTweets.setText(numTweets);
    }

    public String getIdUsuario() {
        return trend;
    }

    public void setIdUsuario(String idUsuario) {
        this.trend = idUsuario;
        this.jLabelIdUsuario.setText(idUsuario);
    }

    public void aplicarListenerJPanel() {
        listener.cambiarColorAlPasarPorEncima(jPanelTrending, this.getBackground(), azulClaro);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTrending = new javax.swing.JPanel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelTotalTweets = new javax.swing.JLabel();

        jPanelTrending.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 196, 255)));
        jPanelTrending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelTrendingMouseClicked(evt);
            }
        });

        jLabelIdUsuario.setText("Id Usuario");

        jLabelTotalTweets.setText("Total tweets");

        javax.swing.GroupLayout jPanelTrendingLayout = new javax.swing.GroupLayout(jPanelTrending);
        jPanelTrending.setLayout(jPanelTrendingLayout);
        jPanelTrendingLayout.setHorizontalGroup(
            jPanelTrendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrendingLayout.setVerticalGroup(
            jPanelTrendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTrending, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTrending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelTrendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTrendingMouseClicked
        List<Status> tweetsBuscados = gestionTwitter.buscarTweets(this.trend);
        if (tweetsBuscados != null) {
            PantallaTweetsBuscados ventana = new PantallaTweetsBuscados(padre, true, tweetsBuscados);
            ventana.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(padre, "La lista de tweets buscados es nula");
        }
    }//GEN-LAST:event_jPanelTrendingMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTotalTweets;
    private javax.swing.JPanel jPanelTrending;
    // End of variables declaration//GEN-END:variables
}
