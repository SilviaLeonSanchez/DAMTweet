/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import logica.ConexionTwitter;
import logica.GestionTwitter;
import dto.UsuarioAplicacion;
import java.awt.Frame;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import utils.bbdd.GestorBBDD_SQLite;

/**
 *
 * @author alumnop
 */
public class PantallaLogin extends javax.swing.JFrame {

    // private static final String RUTA_LOGO = File.separator + "img" + File.separator + "Twitter_Logo_Blue240.png";
    public static String RUTA_BBDD = null;
    public static GestorBBDD_SQLite BBDD;
    public static GestionTwitter gestionTwitter;
    public static Frame padre;

    public PantallaLogin() {
        initComponents();
        padre = this;
        setLocationRelativeTo(null);
        ponLaAyuda();
        //jLabelLogo.setIcon(new ImageIcon(getClass().getResource(RUTA_LOGO)));

        File paquete_bbdd = new File("bbdd" + File.separator + "twitter.sqlite3");
        RUTA_BBDD = paquete_bbdd.getAbsolutePath();

        if (!paquete_bbdd.exists()) {
            new File(File.separator + "bbdd").mkdir();
        }

        System.out.println(RUTA_BBDD);
        BBDD = new GestorBBDD_SQLite(RUTA_BBDD);
        BBDD.crearTablas();
        BBDD.inicializarCiudad();
        configureWindowAndComponents();
        rellenarComoBoxUsuarios(getUsuariosLogeados());

    }

    public void rellenarComoBoxUsuarios(List<UsuarioAplicacion> usuarios) {
        if (usuarios.size() < 1) {
            this.jComboBoxUsuarios.setVisible(false);
            this.jButtonIniciar.setVisible(false);
        } else {
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            for (UsuarioAplicacion usuario : usuarios) {
                dcm.addElement(usuario.getUsername());
            }
            jComboBoxUsuarios.setModel(dcm);
        }

    }

    public List<UsuarioAplicacion> getUsuariosLogeados() {

        ResultSet rs = BBDD.ejecutarSELECT("SELECT * FROM USERS;");

        List<UsuarioAplicacion> usuariosLogeados = new ArrayList();

        try {
            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("name");
                String nombreUsuario = rs.getString("user_name");
                String token = rs.getString("token");
                byte[] secret_toekn = rs.getBytes("secret_token");
                usuariosLogeados.add(new UsuarioAplicacion(id, nombre, nombreUsuario, token, secret_toekn));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuariosLogeados;
    }

    public void configureWindowAndComponents() {

        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        /* Configuracion de los colores de las aplicaciones, habria que crear una
        clase para el manejo de los colores, las fuentes tipograficas y que quede todo igual.*/
        //jButtonIniciar.setBorder(new LineBorder(MaterialColors.LIGHT_BLUE_A400));
        jButtonIniciar.setForeground(MaterialColors.LIGHT_BLUE_A400);
        jButtonIniciar.setBackground(MaterialColors.WHITE);
        jButtonRegistro.setBackground(MaterialColors.LIGHT_BLUE_A400);
        jComboBoxUsuarios.removeAllItems();

        /* 
        Clase que viene con la libreria para que al pasar el raton por encima
        cambie el color
         */
        MaterialUIMovement.add(jButtonIniciar, MaterialColors.LIGHT_BLUE_100, WIDTH, ERROR);
        MaterialUIMovement.add(jButtonRegistro, MaterialColors.BLUE_100, 5, 100 / 30);

    }

    public void lanzarPantallaPrincipal() {
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(this, true);
        pantallaPrincipal.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jComboBoxUsuarios = new javax.swing.JComboBox<>();
        jButtonIniciar = new javax.swing.JButton();
        jButtonRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(890, 720));
        setMinimumSize(new java.awt.Dimension(890, 720));
        setPreferredSize(new java.awt.Dimension(890, 720));
        setResizable(false);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Twitter_Logo_Blue240.png"))); // NOI18N
        jLabelLogo.setText("jLabel1");
        jLabelLogo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonIniciar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonRegistro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonRegistro.setText("REGISTRARSE");
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jComboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        ConexionTwitter conexionTwitter = new ConexionTwitter(false);
        gestionTwitter = new GestionTwitter(conexionTwitter.getTwitter());
        this.setVisible(false);
        lanzarPantallaPrincipal();
        this.setVisible(true);
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed

        UsuarioAplicacion usuario = BBDD.getUserData((String) jComboBoxUsuarios.getSelectedItem());
        ConexionTwitter conexionTwitter = new ConexionTwitter(usuario);
        gestionTwitter = new GestionTwitter(conexionTwitter.getTwitter());
        this.setVisible(false);
        lanzarPantallaPrincipal();
        this.setVisible(true);
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PantallaLogin().setVisible(true);
            }
        });
    }

    private void ponLaAyuda() {
        try {

            File fichero = new File("help" + File.separator + "help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();//

            hb.enableHelpKey(getRootPane(), "pantallalogin", helpset);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JComboBox<String> jComboBoxUsuarios;
    private javax.swing.JLabel jLabelLogo;
    // End of variables declaration//GEN-END:variables
}
