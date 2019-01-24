/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.ConexionTwitter;
import logica.DBHelper;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import utils.bbdd.GestorBBDD_SQLite;

/**
 *
 * @author sebas
 */
public class PruebaGuardarSessiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        AccessToken accessToken = null;
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthAccessToken(null);
        String directorioCarpetaPath = System.getProperty("user.home") + File.separator + ".clienteTwitter";
        String dbname = "prueba20.db";
        File directorioCarpeta = new File(directorioCarpetaPath);
        directorioCarpeta.mkdir();

        try {
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthAccessToken(null);

            DBHelper dBHelper = new DBHelper(directorioCarpetaPath, dbname);
            GestorBBDD_SQLite gestorDB = new GestorBBDD_SQLite(directorioCarpetaPath, dbname);
            ResultSet rs = gestorDB.ejecutarSELECT("SELECT * FROM USERS;");

            List<Usuario> usuariosLogeados = new ArrayList();

            while (rs.next()) {
                long id = rs.getLong("id");
                String token = rs.getString("token");
                byte[] secret_toekn = rs.getBytes("secret_token");
                usuariosLogeados.add(new Usuario(id, token, secret_toekn));
            }
            // Si no se ha logeado nadie 
            if (usuariosLogeados.size() == 0) {
                RequestToken requestToken = null;

                do {
                    try {
                        // Pedir el token para la autenticacion del usuario
                        requestToken = twitter.getOAuthRequestToken();

                        // Abrir en el navegador la URL donde se logueara y le daran el PIN
                        String url = requestToken.getAuthorizationURL();
                        Desktop.getDesktop().browse((new URL(url)).toURI());

                        //Pedirle el PIN
                        String pin = JOptionPane.showInputDialog("Introduce el PIN");
                        if (pin.length() > 0) {
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }

                    } catch (TwitterException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IOException ex) {
                        Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (accessToken == null);
                byte[] tokenEncriptado = utils.EncryptUtils.cifra(accessToken.getTokenSecret().toString());
                dBHelper.insertarUsuario(twitter.getId(), "nombre", "nombreusuaruio", accessToken.getToken().toString(), tokenEncriptado);
                System.out.println("TE HAS LOGEADO POR PRIMERA VEZ");
            } else {

                String tokenDescifrado = utils.EncryptUtils.descifra(usuariosLogeados.get(0).getPrivateToken());
                accessToken = new AccessToken(usuariosLogeados.get(0).getToken(), tokenDescifrado);
                twitter.setOAuthAccessToken(accessToken);
                System.out.println(twitter.getId());
                System.out.println("TE HABIAS LOGEADO ANTERIORMENTE");

            }

            System.out.println("Este es mi id => " + twitter.getId());

         } catch (SQLException ex) {
            Logger.getLogger(PruebaGuardarSessiones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TwitterException ex) {
            Logger.getLogger(PruebaGuardarSessiones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PruebaGuardarSessiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class Usuario {

    long id;
    String token;
    byte[] privateToken;

    public Usuario(long id, String token, byte[] privateToken) {
        this.id = id;
        this.token = token;
        this.privateToken = privateToken;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public byte[] getPrivateToken() {
        return privateToken;
    }

    public void setPrivateToken(byte[] privateToken) {
        this.privateToken = privateToken;
    }

}
