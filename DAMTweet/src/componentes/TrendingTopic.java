/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.Serializable;
import twitter4j.Trend;

/**
 *
 * @author Annie
 */
public class TrendingTopic extends javax.swing.JPanel implements Serializable {

    private String numTweets;
    private String trend;
    
    public TrendingTopic() {
        initComponents();
    }
    
    public void inicializarComponente(Trend trendingTopic){
        String nombre = trendingTopic.getName();
        if (!nombre.startsWith("#")){
            nombre = "#"+nombre;
        }
        setIdUsuario(nombre);
        int tweets = trendingTopic.getTweetVolume();
        setNumTweets(((tweets != -1)? tweets+"" : ""));
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTrendingSinCabecera = new javax.swing.JPanel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelTotalTweets = new javax.swing.JLabel();

        jPanelTrendingSinCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 196, 255)));

        jLabelIdUsuario.setText("Id Usuario");

        jLabelTotalTweets.setText("Total tweets");

        javax.swing.GroupLayout jPanelTrendingSinCabeceraLayout = new javax.swing.GroupLayout(jPanelTrendingSinCabecera);
        jPanelTrendingSinCabecera.setLayout(jPanelTrendingSinCabeceraLayout);
        jPanelTrendingSinCabeceraLayout.setHorizontalGroup(
            jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingSinCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrendingSinCabeceraLayout.setVerticalGroup(
            jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTrendingSinCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTrendingSinCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTotalTweets;
    private javax.swing.JPanel jPanelTrendingSinCabecera;
    // End of variables declaration//GEN-END:variables
}
