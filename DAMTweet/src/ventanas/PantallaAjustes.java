/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import dto.Tweet;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import twitter4j.TwitterException;
import twitter4j.User;
import static ventanas.PantallaLogin.BBDD;
import static ventanas.PantallaLogin.gestionTwitter;
import static ventanas.PantallaLogin.padre;

/**
 *
 * @author sebas
 */
public class PantallaAjustes extends javax.swing.JDialog {

    Desktop desktop = null;
    private JFileChooser jfc;
    private JRDataSource dataSource;
    private boolean logout = false;

    /**
     * Creates new form PantallaAjustes
     */
    public PantallaAjustes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jfc = new JFileChooser();
        desktop = Desktop.getDesktop();
        this.setTitle("Informes");
        String[] lugaresTrendingTopic = BBDD.getLugaresTrendingTopic();
        this.jComboBoxCiudades.setModel(new DefaultComboBoxModel<String>(lugaresTrendingTopic));
        this.jComboBoxCiudades.setSelectedIndex(0);
        setLocationRelativeTo(null);
        //  desktop.open(new File("rutaPDF"));
    }

    public boolean isLogout() {
        return logout;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerB = new javax.swing.JSpinner();
        jSpinnerA = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jButtonInformeFechas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonFollowersFollowed = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonTweetsUsuario = new javax.swing.JButton();
        jLabelCiudades = new javax.swing.JLabel();
        jComboBoxCiudades = new javax.swing.JComboBox<>();
        jButtonCambiarCiudad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(600, 400));

        jButtonLogout.setBackground(new java.awt.Color(254, 95, 95));
        jButtonLogout.setForeground(new java.awt.Color(254, 254, 254));
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabel2.setText("BORRAR REGISTROS Y DESLOGEARSE");

        jLabel4.setText("Tweets publicados entre");

        jSpinnerB.setModel(new javax.swing.SpinnerDateModel());

        jSpinnerA.setModel(new javax.swing.SpinnerDateModel());

        jLabel1.setText("y");

        jButtonInformeFechas.setText("Generar Informe");
        jButtonInformeFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInformeFechasActionPerformed(evt);
            }
        });

        jLabel5.setText("Informe con seguidores y seguidos");

        jButtonFollowersFollowed.setText("Generar Informe");
        jButtonFollowersFollowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFollowersFollowedActionPerformed(evt);
            }
        });

        jLabel6.setText("Informe con los tweets de un usuario ");

        jTextFieldBuscar.setText("Buscar usuario...");

        jButtonTweetsUsuario.setText("Generar Informe");
        jButtonTweetsUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTweetsUsuarioActionPerformed(evt);
            }
        });

        jLabelCiudades.setText("Ciudad ");

        jButtonCambiarCiudad.setText("Cambiar ciudad");
        jButtonCambiarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCiudades)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonInformeFechas, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel6))
                                            .addGap(66, 66, 66))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jComboBoxCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(51, 51, 51)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldBuscar)
                                        .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonTweetsUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonFollowersFollowed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCambiarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInformeFechas)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonFollowersFollowed))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTweetsUsuario)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCambiarCiudad)
                    .addComponent(jComboBoxCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCiudades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogout)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String pedirRutaInforme() {
        int resultado = jfc.showSaveDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showConfirmDialog(this, "No se ha indicado donde guardar el archivo por lo tanto no se generará el informe.", "Sin ruta especificada", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    private void jButtonInformeFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInformeFechasActionPerformed

        try {
            String ruta = pedirRutaInforme();
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            for (Tweet tweet : gestionTwitter.getTweetsInforme(gestionTwitter.getUsuario())) {
                if (tweet.getFecha().after((Date) jSpinnerA.getValue())
                        & tweet.getFecha().before((Date) jSpinnerB.getValue())) {
                    tweets.add(tweet);
                    System.out.println(tweet.getTexto());
                }
            }
            this.dataSource = new JRBeanCollectionDataSource(tweets);
            JasperPrint print = JasperFillManager.fillReport("archivos_informes/InformeTwetsFehcas.jasper", new HashMap(), dataSource);
            JasperExportManager.exportReportToPdfFile(print, ruta);
            desktop.open(new File(ruta));
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al generar el informe", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(PantallaAjustes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonInformeFechasActionPerformed

    private void jButtonFollowersFollowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFollowersFollowedActionPerformed
        String ruta = pedirRutaInforme();
    }//GEN-LAST:event_jButtonFollowersFollowedActionPerformed

    private void jButtonTweetsUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTweetsUsuarioActionPerformed
        User usuario = gestionTwitter.buscarUsuarioPublico(this.jTextFieldBuscar.getText());
        if (usuario != null) {
            try {
                String ruta = pedirRutaInforme();
                ArrayList<Tweet> tweets = gestionTwitter.getTweetsInforme(usuario);
                this.dataSource = new JRBeanCollectionDataSource(tweets);
                JasperPrint print = JasperFillManager.fillReport("archivos_informes/InformeTweetsUsuario.jasper", new HashMap(), dataSource);
                JasperExportManager.exportReportToPdfFile(print, ruta);
                desktop.open(new File(ruta));
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al generar el informe", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(PantallaAjustes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(padre, "No se ha encontrado ningún usuario público con ese nombre");
        }
    }//GEN-LAST:event_jButtonTweetsUsuarioActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        try {
            long idUsuario = gestionTwitter.getTwitter().getId();
            BBDD.deleteUser(idUsuario);

        } catch (TwitterException | IllegalStateException ex) {
            Logger.getLogger(PantallaAjustes.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Desconectar de twiiter
        gestionTwitter.getTwitter().setOAuthAccessToken(null);
        this.logout = true;
        this.setVisible(false);

    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonCambiarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarCiudadActionPerformed
        String ciudad = this.jComboBoxCiudades.getSelectedItem().toString();
        BBDD.cambiarCiudadUsuario(ciudad);
        this.dispose();
    }//GEN-LAST:event_jButtonCambiarCiudadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambiarCiudad;
    private javax.swing.JButton jButtonFollowersFollowed;
    private javax.swing.JButton jButtonInformeFechas;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonTweetsUsuario;
    private javax.swing.JComboBox<String> jComboBoxCiudades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCiudades;
    private javax.swing.JSpinner jSpinnerA;
    private javax.swing.JSpinner jSpinnerB;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
