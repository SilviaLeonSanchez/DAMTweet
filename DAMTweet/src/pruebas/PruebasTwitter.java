/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ConexionTwitter;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author silvia
 */
public class PruebasTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ConexionTwitter conexion = new ConexionTwitter(true);
            
            Twitter twitter = conexion.getTwitter();
            
            /*
            trends.add(twitter.getPlaceTrends(764814));
            trends.add(twitter.getPlaceTrends(766273));
            trends.add(twitter.getPlaceTrends(766356));
            trends.add(twitter.getPlaceTrends(768026));
            trends.add(twitter.getPlaceTrends(769293));
            trends.add(twitter.getPlaceTrends(774508));
            trends.add(twitter.getPlaceTrends(776688));
            trends.add(twitter.getPlaceTrends(779063));
*/
            
            System.out.println("\nTRENDS DE ESPAÑA CODIGO: 753692");
            for (Trend trend : twitter.getPlaceTrends(753692).getTrends()) {
                System.out.println("\t" + trend.getName() + ": "+ trend.getTweetVolume() + " retweets");
            }
            System.out.println();
            
            
            System.out.println("\nTRENDS DE ESPAÑA CODIGO: 754542");
            for (Trend trend : twitter.getPlaceTrends(754542).getTrends()) {
                System.out.println("\t" + trend.getName() + ": "+ trend.getTweetVolume() + " retweets");
            }
            System.out.println();
            
            
            
            
            
            
            
            
            
            
        } catch (TwitterException ex) {
            Logger.getLogger(PruebasTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
