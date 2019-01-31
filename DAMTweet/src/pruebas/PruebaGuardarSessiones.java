/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import logica.GestionTwitter;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

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

        System.out.println("Este es mi id => " + twitter.getId());

        GestionTwitter gsTwitter = new GestionTwitter(twitter);

        gsTwitter.buscarTweets("#pozo");
 

    }

}
