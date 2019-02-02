/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.User;
import static ventanas.PantallaLogin.gestionTwitter;

/**
 *
 * @author silvia        for (User seguidor : gestionTwitter.getSeguidores()) {
 */
public class TwitterDataSource {

    
    public static List<Tweet> getTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (Status tweet : gestionTwitter.getTweetsUsuario()) {
            tweets.add(new Tweet(tweet));
        }
        return tweets;
    }

    public static List<Usuario> getSeguidores() {
        ArrayList<Usuario> seguidores = new ArrayList<>();
        for (User seguidor : gestionTwitter.getSeguidores()) {
            seguidores.add(new Usuario(seguidor));
        }
        return seguidores;
    }

    // Falta enlazar con los usuarios seguidos, 
    // esta con los seguidores para que se pueda usar en pruebas
    public static List<Usuario> getSeguidos() {
        ArrayList<Usuario> seguidos = new ArrayList<>();
        for (User seguido : gestionTwitter.getSeguidores()) {
            seguidos.add(new Usuario(seguido));
        }
        return seguidos;
    }

}
