/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.util.ArrayList;
import java.util.List;
import logica.ConexionTwitter;
import logica.GestionTwitter;
import twitter4j.Status;
import twitter4j.User;
import static ventanas.PantallaLogin.gestionTwitter;

/**
 *
 * @author silvia       
 */
public class TwitterDataSource {
    
    GestionTwitter gestionTwitter;

    // Falta indicar como parametro el usuario del que se quieren conseguir los tweets
    // De momento esta puesto para los del usuario logueado
    public static List<Tweet> getTweets() {
        // SOLO PARA PRUEBAS
        ConexionTwitter conexionTwitter = new ConexionTwitter(true);
        GestionTwitter gestionTwitter = new GestionTwitter(conexionTwitter.getTwitter());
        
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (Status tweet : gestionTwitter.getTweetsUsuario()) {
            tweets.add(new Tweet(tweet));
        }
        return tweets;
    }

    public static List<Usuario> getSeguidores() {
        // SOLO PARA PRUEBAS
        ConexionTwitter conexionTwitter = new ConexionTwitter(true);
        GestionTwitter gestionTwitter = new GestionTwitter(conexionTwitter.getTwitter());
        
        ArrayList<Usuario> seguidores = new ArrayList<>();
        for (User seguidor : gestionTwitter.getSeguidores()) {
            seguidores.add(new Usuario(seguidor));
        }
        return seguidores;
    }

    public static List<Usuario> getSeguidos() {
        // SOLO PARA PRUEBAS
        ConexionTwitter conexionTwitter = new ConexionTwitter(true);
        GestionTwitter gestionTwitter = new GestionTwitter(conexionTwitter.getTwitter());
        
        ArrayList<Usuario> seguidos = new ArrayList<>();
        for (User seguido : gestionTwitter.getSeguidos()) {
            seguidos.add(new Usuario(seguido));
        }
        return seguidos;
    }
    
    

}