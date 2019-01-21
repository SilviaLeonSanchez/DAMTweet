/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.Serializable;

/**
 *
 * @author Annie
 */
public class TrendigTopicCabecera extends javax.swing.JPanel implements Serializable{

    private String idUsuario;
    private String numTweets;
    
    public TrendigTopicCabecera() {
        initComponents();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(String numTweets) {
        this.numTweets = numTweets;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelTrendingConCabecera = new javax.swing.JPanel();
        jLabelTendencias = new javax.swing.JLabel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelTotalTweets = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelTrendingConCabecera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTendencias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTendencias.setText("Tendencias para ti");

        jLabelIdUsuario.setText("Id Usuario");

        jLabelTotalTweets.setText("Total tweets");

        javax.swing.GroupLayout jPanelTrendingConCabeceraLayout = new javax.swing.GroupLayout(jPanelTrendingConCabecera);
        jPanelTrendingConCabecera.setLayout(jPanelTrendingConCabeceraLayout);
        jPanelTrendingConCabeceraLayout.setHorizontalGroup(
            jPanelTrendingConCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingConCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTrendingConCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTendencias)
                    .addGroup(jPanelTrendingConCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addGap(269, 269, 269))
        );
        jPanelTrendingConCabeceraLayout.setVerticalGroup(
            jPanelTrendingConCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingConCabeceraLayout.createSequentialGroup()
                .addComponent(jLabelTendencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIdUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalTweets)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTrendingConCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTrendingConCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTendencias;
    private javax.swing.JLabel jLabelTotalTweets;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTrendingConCabecera;
    // End of variables declaration//GEN-END:variables
}
