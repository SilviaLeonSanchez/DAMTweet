/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.UsuarioAplicacion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import utils.bbdd.GestorBBDD_SQLite;

/**
 *
 * @author silvia
 */
public class ConexionTwitter {

    // ATRIBUTOS
    private Twitter twitter;
    private GestorBBDD_SQLite gestorDB = new GestorBBDD_SQLite("bbdd" + File.separator + "twitter.sqlite3");

    // METODOS
    // Para conectar con las credenciales de la aplicacion dada de alta en la cuenta developer de Twitter
    public ConexionTwitter(String apiKey, String apiKeySecret, String accessToken, String accessTokenSecret) {

        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        this.twitter = new TwitterFactory(config.build()).getInstance();
    }

    // Conexion de twiiter con las key y los token guardados en twitter4j.properties
    public ConexionTwitter(boolean logearseCuentaDeveloper) {
        this.twitter = TwitterFactory.getSingleton();

        if (logearseCuentaDeveloper) {
            // Nada ya que las credenciales estan en el archivo configuracion
        } else {
            twitter.setOAuthAccessToken(null);// Quitamos los de la cuenta developer
            this.autenticacionUsuario();
        }
    }

    // Conexion de twetter con una session guardada
    public ConexionTwitter(UsuarioAplicacion usuario) {
        this.twitter = TwitterFactory.getSingleton();
        String tokenDescifrado = null;
        try {
            tokenDescifrado = utils.EncryptUtils.descifra(usuario.getPrivateToken());
        } catch (Exception ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        AccessToken accessToken = new AccessToken(usuario.getToken(), tokenDescifrado);
        twitter.setOAuthAccessToken(accessToken);
    }

    //Para conectar con cualquier otra cuenta de Twitter
    public ConexionTwitter(String apiKey, String apiKeySecret) {
        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiKeySecret);

        this.twitter = new TwitterFactory(config.build()).getInstance();
        autenticacionUsuario();
    }

    public void autenticacionUsuario() {
        RequestToken requestToken = null;
        AccessToken accessToken = null;
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

        // Se guardan los tokens para futuras sesiones
       
        try {
            byte[] tokenEncriptado = null;
            String nombreUsuario = twitter.showUser(twitter.getId()).getScreenName();
            String nombre =  twitter.showUser(twitter.getId()).getName();
            tokenEncriptado = utils.EncryptUtils.cifra(accessToken.getTokenSecret().toString());
            gestorDB.insertarUsuario(twitter.getId(), nombre, nombreUsuario, accessToken.getToken().toString(), tokenEncriptado);
        } catch (Exception ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Twitter getTwitter() {
        return twitter;
    }

}
