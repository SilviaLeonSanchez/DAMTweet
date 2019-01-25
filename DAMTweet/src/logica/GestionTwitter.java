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
import twitter4j.PagableResponseList;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author silvia
 */
public class GestionTwitter {

    private Twitter twitter;

    public GestionTwitter(Twitter twitter) {
        this.twitter = twitter;
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

    /**
     * Realiza una busqueda standar tanto de texto como de hastags
     * @param stringQuery
     * @return lista de tweets
     */
    public List<Status> buscarTweets(String stringQuery) {
        try {
            Query busqueda = new Query(stringQuery);
            QueryResult result;
            result = twitter.search(busqueda);
            List<Status> tweets = result.getTweets();

            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

            return tweets;
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Fallo al buscar tweets: " + te.getMessage());
            System.exit(-1);
        }
        return null;
    }
    
    public Trend[] getTrendingTopics(int woeid){
        Trend[] tt = null;
        try {
            tt = twitter.getPlaceTrends(woeid).getTrends();
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }
    
    public String getLugarTrendingTopic(int woeid){
        String lugar = null;
        try {
            lugar = twitter.getPlaceTrends(woeid).getLocation().getName();
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lugar;
    }
    
    public int getTotalRetweetTT(Trend t){
        return t.getTweetVolume();
    }
    
    public String getTrendingTopic(Trend t){
        return t.getName();
    }

}
