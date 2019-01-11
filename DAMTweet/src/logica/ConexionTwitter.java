/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author silvia
 */
public class ConexionTwitter {

    // ATRIBUTOS
    private Twitter twitter;

    // METODOS
    public ConexionTwitter(String apiKey, String apiKeySecret, String accessToken, String accessTokenSecret) {

        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        this.twitter = new TwitterFactory(config.build()).getInstance();
    }

    public User getUsuario() {
        try {
            return this.twitter.showUser(twitter.getScreenName());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void verInfoUsuario(User usuario){
        System.out.println("Nombre: "+usuario.getName());
        System.out.println("Email: "+usuario.getEmail());
        System.out.println("Descripcion: "+usuario.getDescription());
        System.out.println("Fecha de creacion: "+ new SimpleDateFormat("dd-MM-yyyy").format(usuario.getCreatedAt())+"\n");
    }

    public List<Status> getTweetsUsuario() {

        List<Status> tweets = null;

        try {

            tweets = this.twitter.getUserTimeline();

        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return tweets;
    }

    public void enviarTweet(String tweet) {
        try {
            Status status = twitter.updateStatus(tweet);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
