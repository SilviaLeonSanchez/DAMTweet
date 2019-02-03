/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import informes.Tweet;
import informes.TwitterDataSource;
import informes.Usuario;
import java.util.List;

/**
 *
 * @author silvia
 */
public class PruebaDataSources {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // VER TWEETS
        List<Tweet> tweets = TwitterDataSource.getTweets();
        
        System.out.println("TWEETS:");
        for (Tweet tweet : tweets) {
            System.out.println(tweet.toString());
        }
        
        // VER SEGUIDORES
        List<Usuario> seguidores = TwitterDataSource.getSeguidores();
        
        System.out.println("SEGUIDORES");
        for (Usuario seguidor : seguidores) {
            System.out.println(seguidor.toString());
        }
        
        // VER SEGUIDOS
        List<Usuario> seguidos = TwitterDataSource.getSeguidos();
        
        System.out.println("SEGUIDOS");
        for (Usuario seguido : seguidos) {
            System.out.println(seguido.toString());
        }
        
    }
    
}
