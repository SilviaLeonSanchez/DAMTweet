/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.PagableResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author silvia
 */
public class ConexionTwitter {

    // ATRIBUTOS
    private Twitter twitter;

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

    //Para conectar con cualquier otra cuenta de Twitter
    public ConexionTwitter(String apiKey, String apiKeySecret) {
        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiKeySecret);

        this.twitter = new TwitterFactory(config.build()).getInstance();
        autenticacionUsuario();
    }

    private void autenticacionUsuario() {
        AccessToken accessToken = null;
        RequestToken requestToken = null;

        do {
            try {
                // Obtener el token para poder pedir acceso a la cuenta del usuario
                requestToken = twitter.getOAuthRequestToken();
                System.out.println("Request Token obtenido con éxito.");

                // Tiene una URL que es donde el usuario se autentica
                String url = requestToken.getAuthorizationURL();
                Desktop.getDesktop().browse((new URL(url)).toURI());

                // Pedir el pin que le han dado al usuario al autenticarse            
                JOptionPane panel = new JOptionPane("Introduce el PIN", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                String pin = panel.getMessage().toString();

                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
                }

                Thread.sleep(100);

            } catch (TwitterException ex) {
                System.out.println(ex.getMessage());
            } catch (MalformedURLException ex) {
                System.out.println(ex.getMessage());
            } catch (URISyntaxException | IOException | InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        } while (accessToken == null);
    }

    public User getUsuario() {
        try {
            return this.twitter.showUser(twitter.getScreenName());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verInfoUsuario(User usuario) {
        System.out.println("Nombre: " + usuario.getName());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Descripcion: " + usuario.getDescription());
        System.out.println("Fecha de creacion: " + new SimpleDateFormat("dd-MM-yyyy").format(usuario.getCreatedAt()) + "\n");
    }

    public List<Status> getTweetsUsuario() {
        try {

            return this.twitter.getUserTimeline();

        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Status> getUltimosTweetsUsuariosSeguidos() {
        try {

            return this.twitter.getHomeTimeline();

        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void enviarTweet(String textoTweet) {
        try {
            Status tweet = twitter.updateStatus(textoTweet);
            System.out.println("Successfully updated the status to [" + tweet.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void retwitearTweet(Status tweet) {
        try {
            Status retwittedTweet = twitter.retweetStatus(tweet.getId());
            System.out.println("Successfully retweeted [" + retwittedTweet.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getSeguidores() {
        PagableResponseList<User> seguidores = null;

        try {
            seguidores = twitter.getFollowersList(getUsuario().getId(), -1);
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seguidores;
    }

}
