/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author Annie
 */
public class TrendingTopicSinCabecera extends javax.swing.JPanel {

    private String numTweets;
    private String idUsuario;
    
    public TrendingTopicSinCabecera() {
        initComponents();
    }

    public String getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(String numTweets) {
        this.numTweets = numTweets;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTrendingSinCabecera = new javax.swing.JPanel();
        jLabelIdUsuario = new javax.swing.JLabel();
        jLabelTotalTweets = new javax.swing.JLabel();

        jPanelTrendingSinCabecera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelIdUsuario.setText("Id Usuario");

        jLabelTotalTweets.setText("Total tweets");

        javax.swing.GroupLayout jPanelTrendingSinCabeceraLayout = new javax.swing.GroupLayout(jPanelTrendingSinCabecera);
        jPanelTrendingSinCabecera.setLayout(jPanelTrendingSinCabeceraLayout);
        jPanelTrendingSinCabeceraLayout.setHorizontalGroup(
            jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingSinCabeceraLayout.createSequentialGroup()
                .addGroup(jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelIdUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTotalTweets, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(302, 302, 302))
        );
        jPanelTrendingSinCabeceraLayout.setVerticalGroup(
            jPanelTrendingSinCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingSinCabeceraLayout.createSequentialGroup()
                .addComponent(jLabelIdUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalTweets)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTrendingSinCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTrendingSinCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIdUsuario;
    private javax.swing.JLabel jLabelTotalTweets;
    private javax.swing.JPanel jPanelTrendingSinCabecera;
    // End of variables declaration//GEN-END:variables
}
